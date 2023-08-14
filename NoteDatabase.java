package com.example.myroomdatabasetest;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

//@Database(entities = {Note.class},version = 1)
public abstract class NoteDatabase extends RoomDatabase{
    abstract NoteDao getdao();
    public static NoteDatabase getInstance(Context context){
        synchronized (NoteDatabase.class){
            return Room.databaseBuilder(context.getApplicationContext()
            ,NoteDatabase.class,"Note_db").fallbackToDestructiveMigration()
                    .build();
        }
    }
}
