package com.example.myapplication;

import static android.content.Context.AUDIO_SERVICE;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.AnimationDrawable;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class TV2view extends View {
    Bitmap more,man,land,moun,ban,ban1;
    Resources resources;
    int morex,morey,ddx=10,ddy=10;
    float morew,moreh;
    Random random;
    int ranx,rany;
    int banx,bany;
    boolean ok,ok1;
    int score=10;
    Paint paint;
    Timer timer;
    int landy,mouny=-1500;
    public List<Integer> list,list1;
    List<Integer> banlist,banlist1;
    SoundPool soundPool;
    MediaPlayer mediaPlayer;
    int sound1,sound2;
    float voice;
    boolean okban;
    int banbany;
    List<Integer> boulist,boulist1;
    List<Bitmap> go,go1;
    public TV2view(Context context, @Nullable AttributeSet attrs) throws IOException {
        super(context, attrs);
        resources = context.getResources();
        more= BitmapFactory.decodeResource(resources, R.drawable.oni);
        morex=5;morey=1300;
        random=new Random();
        man=BitmapFactory.decodeResource(resources, R.drawable.santon);
        land=BitmapFactory.decodeResource(resources, R.drawable.land);
        moun=BitmapFactory.decodeResource(resources, R.drawable.moun);
        ban=BitmapFactory.decodeResource(resources, R.drawable.ban);
        ban1=BitmapFactory.decodeResource(resources, R.drawable.ban1);
        list= new ArrayList<>();
        list1= new ArrayList<>();
        banlist=new ArrayList<>();
        banlist1=new ArrayList<>();
        boulist=new ArrayList<>();
        boulist1=new ArrayList<>();
        go=new ArrayList<>();
        go1=new ArrayList<>();
        timer=new Timer();
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
            AudioAttributes audioAttributes=new  AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build();
            soundPool=new SoundPool.Builder()
                    .setMaxStreams(2).setAudioAttributes(audioAttributes)
                    .build();
        }else {
            soundPool = new SoundPool(2, AudioManager.STREAM_MUSIC,
                    0);
        }
        sound1=soundPool.load(context,R.raw.cannon1,1);
        sound2=soundPool.load(context,R.raw.atomic,1);
        mediaPlayer = new MediaPlayer();
//        mediaPlayer.setAudioAttributes(
//                new AudioAttributes.Builder()
//                        .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
//                        .setUsage(AudioAttributes.USAGE_MEDIA)
//                        .build()
//        );
//        mediaPlayer.setDataSource("https://www.youtube.com/watch?v=UnYG23de_Ek");
        //mediaPlayer.prepare();
        mediaPlayer=MediaPlayer.create(context,R.raw.east);
        mediaPlayer.start();
        AudioManager audioManager=(AudioManager) context.getSystemService(AUDIO_SERVICE);
        int mv=audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int cv= audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        voice=cv/(float)mv;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(!ok){
            init();
        }
        if(!mediaPlayer.isPlaying()){
            mediaPlayer.start();
        }
        if(!ok1){
            for (int i = 0; i < 50; i++) {
                ranx = random.nextInt(1000) + 1;
                rany = random.nextInt(1200) + 1+100;
                while (rany>=1100){
                    rany = random.nextInt(1200) + 1+100;
                }
                list.add(ranx);
                list1.add(rany);
                go1.add(man);
            }
            setBan();
            ok1=true;
        }

        canvas.drawBitmap(land,0,landy,null);
        canvas.drawBitmap(moun,0,mouny,null);
        if(okban){

              boulist.add(morex);
              boulist1.add(morey+banbany);
              go.add(ban);
              score+=10;
              okban=false;
        }
        for(int i=0;i<boulist.size();i++){
            canvas.drawBitmap(go.get(i),boulist.get(i),boulist1.get(i)+banbany,null);
        }

        for (int i = 0; i < 50; i++) {
            if(morex>=list.get(i)){
                go1.set(i,ban1);
                canvas.drawBitmap(go1.get(i),list.get(i),list1.get(i),null);
            }
            //else {
                canvas.drawBitmap(go1.get(i),list.get(i),list1.get(i),null);
            //}
        }
        if(banbany==-900){
            go=null;
            boulist=null;
            boulist1=null;
            go=new ArrayList<>();
            boulist=new ArrayList<>();
            boulist1=new ArrayList<>();
            banbany=0;
        }
       if(morex==0||morex==getWidth()){
           list=null;
           list1=null;
           go1=null;
           banlist=null;
           banlist1=null;
           banlist=new ArrayList<>();
           banlist1=new ArrayList<>();
           list= new ArrayList<>();
           list1= new ArrayList<>();
           go1=new ArrayList<>();
           ok1=false;
        }

        canvas.drawBitmap(more,morex,morey,null);
        canvas.drawText("Score:"+score,50,100,paint);
    }

    private void init() {
        paint=new Paint();
        paint.setColor(Color.YELLOW);
        paint.setTextSize(100);
        morew=getWidth()/8f;moreh=morew;
        Matrix matrix=new Matrix();
        matrix.postScale(morew/more.getWidth(),moreh/more.getHeight());
        more=Bitmap.createBitmap(more,0,0,more.getWidth()
                ,more.getHeight(),matrix,false);
        Matrix matrix1=new Matrix();
        matrix1.postScale(morew/man.getWidth(),moreh/man.getHeight());
        man=Bitmap.createBitmap(man,0,0,man.getWidth()
                ,man.getHeight(),matrix1,false);
        Matrix matrix2=new Matrix();
        matrix2.postScale(morew/ban.getWidth(),moreh/ban.getHeight());
        ban=Bitmap.createBitmap(ban,0,0,ban.getWidth()
                ,ban.getHeight(),matrix2,false);
        timer.schedule(new landtask(),1000,1000);
        ok=true;
    }
    public void setBan(){
        for (int i = 0; i < 50; i++) {
            banx = random.nextInt(1000) + 1;
            bany = random.nextInt(1200) + 1+100;
            while (rany>=1100){
                rany = random.nextInt(1200) + 1+100;
            }
            banlist.add(banx);
            banlist1.add(bany);

        }

    }
    private  class landtask extends TimerTask {
        @Override
        public void run() {
            landy+=100;
            mouny+=100;
            banbany-=100;
            //if(banbany==-1300) banbany=0;
            if(landy==1000){
                landy=0;
            }
            if(mouny==200){
                mouny=-900;
            }
            postInvalidate();
        }
    }
}
