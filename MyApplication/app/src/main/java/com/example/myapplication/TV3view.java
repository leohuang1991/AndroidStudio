package com.example.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.media.MediaPlayer;
import android.view.View;

public class TV3view extends View {
    MediaPlayer mediaPlayer;
    public TV3view(Context context) {
        super(context);
        mediaPlayer=MediaPlayer.create(context,R.raw.wine);
        mediaPlayer.start();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

    }
}
