package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;

import androidx.annotation.Nullable;

public class TVSview extends View {
    WindowManager windowManager;
    MyViewG myViewG;
    View view;
    Context context;
    boolean ok;
    WindowManager.LayoutParams layoutParams;
    public TVSview(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        //windowManager=(WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        //myViewG=new MyViewG(context);
        this.context=context;
        //view=View.inflate(context,R.layout.test,myViewG);
        //Orin(context);
       // view=View.inflate(context,R.layout.test,myViewG);
        //Create();
       // windowManager.addView(myViewG,layoutParams);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(!ok){
            ok=true;
            Activity activity=(Activity) context;
            activity.startService(new Intent(activity,MyService.class));
        }
    }

//    private void Orin(Context context) {
//        windowManager=(WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
//        myViewG=new MyViewG(context);
//    }
//
//    private void Create() {
//        layoutParams=new WindowManager.LayoutParams();
//        layoutParams.width=WindowManager.LayoutParams.WRAP_CONTENT;
//        layoutParams.height=WindowManager.LayoutParams.WRAP_CONTENT;
//        layoutParams.gravity= Gravity.CENTER;
//        layoutParams.type=WindowManager.LayoutParams.TYPE_PHONE;
//        layoutParams.flags=WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS;
//    }
}
