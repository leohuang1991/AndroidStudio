package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    Button image,im2 ;
    TextView textView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        image = findViewById(R.id.button2);
        im2=findViewById(R.id.button3);
        textView=findViewById(R.id.tex4);
        StringBuilder sb=new StringBuilder();
        sb.append("下一頁有每頁都有音樂請打開音量").append("\n")
                .append("而且有三頁第一射擊遊戲第二頁上網第三頁串接網頁資料").append("\n")
                        .append("網頁好像不存在但可以看我程式碼");
        textView.setText(sb.toString());
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity2.this,MainActivity.class);
                startActivity(intent);
            }
        });
        im2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity2.this,MainActivity3.class);
                startActivity(intent);
            }
        });
    }
}