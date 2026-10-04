package com.example.stride;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

public class DashboardActivity extends AppCompatActivity {
    private ListView listView;
    private AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        db = AppDatabase.getInstance(this);
        listView = findViewById(R.id.listView);
        
        Button btnNew = findViewById(R.id.btnSponsorNew);
        btnNew.setOnClickListener(v -> {
            Intent intent = new Intent(DashboardActivity.this, CreateEventActivity.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadEvents();
    }

    private void loadEvents() {
        Executors.newSingleThreadExecutor().execute(() -> {
            List<EventEntity> events = db.eventDao().getAllEvents();
            List<String> displayList = new ArrayList<>();
            for (EventEntity e : events) {
                displayList.add(e.eventName + "\n" + e.eventDate + " | " + e.eventRoute);
            }
            
            runOnUiThread(() -> {
                ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, displayList);
                listView.setAdapter(adapter);
            });
        });
    }
}
