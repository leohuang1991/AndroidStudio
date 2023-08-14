package com.example.myapplication;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.Timer;
import java.util.TimerTask;


public class TVview extends View {
    Bitmap home;
    Resources resources;
    int homex,homey,dx=10,dy=10;
    float morew,moreh;
    boolean ok;
    Timer timer;
    MediaPlayer mediaPlayer;
    public TVview(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        resources = context.getResources();
        home = BitmapFactory.decodeResource(resources, R.drawable.ball);
        homex=10;homey=10;
        timer=new Timer();
        mediaPlayer=MediaPlayer.create(context,R.raw.op6);
        mediaPlayer.start();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(!ok) init();
        if(!mediaPlayer.isPlaying()){
            mediaPlayer.start();
        }
        postInvalidate();
        canvas.drawBitmap(home,homex,homey,null);

    }

    private void init() {
        morew=getWidth()/8f;moreh=morew;
        Matrix matrix=new Matrix();
        matrix.postScale(morew/home.getWidth(),moreh/home.getHeight());
        home=Bitmap.createBitmap(home,0,0,home.getWidth()
                ,home.getHeight(),matrix,false);
        timer.schedule(new balltask(),1000,10);
        ok=true;
    }

    private  class balltask extends TimerTask{
        @Override
        public void run() {
            if(homex<0||homex>getWidth()){
                dx*=-1;
            }
            if(homey<0||homey>getHeight()){
                dy*=-1;
            }
            homex+=dx;
            homey+=dy;
            //postInvalidate();
        }
    }
}
