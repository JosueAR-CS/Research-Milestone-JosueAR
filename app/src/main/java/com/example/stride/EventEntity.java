package com.example.stride;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "events")
public class EventEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String eventName;
    public String eventDate;
    public String eventRoute;

    public EventEntity(String eventName, String eventDate, String eventRoute) {
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventRoute = eventRoute;
    }
}
