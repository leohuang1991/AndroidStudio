package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{
    TextView textview;
    TVview tvview;
    Button image;
    RecyclerView re;
    List<St> list;
    TVview tVview;
    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textview=findViewById(R.id.textView);
        textview.setText("這是第一頁");
        Intent intent=new Intent(MainActivity.this ,MainActivity2.class);
        list=new ArrayList<>();
        image=findViewById(R.id.button);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textview.setText("這是第二頁");
                startActivity(intent);
            }
        });
        re=findViewById(R.id.recyclerview);
        Stname();
        Adapter1();
        tVview=findViewById(R.id.view);
    }

    private void Adapter1() {
        stadapter stadapter=new stadapter(list);
        re.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        re.setAdapter(stadapter);
    }

    private void Stname() {
        list.add(new St("ben"));
        list.add(new St("minggo"));
        list.add(new St("lisa"));
        list.add(new St("tony"));
        list.add(new St("sherry"));
        list.add(new St("king"));
        list.add(new St("queen"));
        list.add(new St("jack"));
    }

    @Override
    protected void onStop() {
        super.onStop();
        tVview.mediaPlayer.release();
        tVview.mediaPlayer=null;
    }
}