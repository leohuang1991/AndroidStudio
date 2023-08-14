package com.example.myroomdatabasetest;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface NoteDao {

    @Insert
    public void Insertnote(Note note);

    @Update
    public void Updatenote(Note note);

    @Delete
    public void Deletenote(Note note);

    @Query("SELECT * FROM note_table")
    public List<Note> Getnote();
}
