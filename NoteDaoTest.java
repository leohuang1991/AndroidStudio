package com.example.myroomdatabasetest;

import static org.junit.Assert.*;

import android.app.Application;
import android.appwidget.AppWidgetProviderInfo;

import androidx.room.Room;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

@RunWith(JUnit4.class)
public class NoteDaoTest {
    NoteDatabase noteDatabase;
    NoteDao dao;

    @Before
    void setup(){
        noteDatabase= Room.inMemoryDatabaseBuilder(
                new Application(),NoteDatabase.class
        ).allowMainThreadQueries().build();
        dao=noteDatabase.getdao();
    }

    @After
    void teardown(){
        noteDatabase.close();
    }

    @Test
    void InsertnoteTest(){
        Note note=new Note(0,"boy");
        dao.Insertnote(note);
        List<Note> list=dao.Getnote();
         assert(list.get(0)==note);
    }
}