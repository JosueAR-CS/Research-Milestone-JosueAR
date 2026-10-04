package com.example.stride;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "STRIDE")
public class ActivityEntity {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String activityName;
    public String location;

    public ActivityEntity(String activityName, String location) {
        this.activityName = activityName;
        this.location = location;
    }
}