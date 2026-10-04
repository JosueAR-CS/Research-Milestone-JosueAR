package com.example.stride;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import java.util.concurrent.Executors;

public class CreateEventActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);

        EditText etName = findViewById(R.id.etName);
        EditText etDate = findViewById(R.id.etDate);
        EditText etRoute = findViewById(R.id.etRoute);
        Button btnSubmit = findViewById(R.id.btnSubmit);
        
        AppDatabase db = AppDatabase.getInstance(this);

        btnSubmit.setOnClickListener(v -> {
            String name = etName.getText().toString();
            String date = etDate.getText().toString();
            String route = etRoute.getText().toString();

            Executors.newSingleThreadExecutor().execute(() -> {
                db.eventDao().insert(new EventEntity(name, date, route));
                runOnUiThread(this::finish);
            });
        });
    }
}
