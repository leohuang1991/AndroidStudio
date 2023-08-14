package com.example.myroomdatabasetest;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "note_table")
public class Note {

    @PrimaryKey(autoGenerate = true)
    int id;
    String name;

    public Note(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Note(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
