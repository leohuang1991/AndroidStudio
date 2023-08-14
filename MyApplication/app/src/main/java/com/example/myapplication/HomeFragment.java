package com.example.myapplication;

//import static androidx.core.app.AppOpsManagerCompat.Api29Impl.getSystemService;

import android.content.Context;
import android.graphics.Canvas;
import android.media.SoundPool;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class HomeFragment extends Fragment {

    TextView textView;
    TV2view tv2view;
    FragmentTransaction fragmentTransaction;
    public HomeFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView=view.findViewById(R.id.texthome);
        textView.setText("左右");
        tv2view=view.findViewById(R.id.tv2);
        tv2view.ddx=250;
        fragmentTransaction=getActivity().getSupportFragmentManager().beginTransaction();
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tv2view.morex+=tv2view.ddx;
                tv2view.soundPool.play(tv2view.sound1,tv2view.voice,tv2view.voice
                        ,0,0,1);
                //tv2view.setBan();
                tv2view.okban=true;
                if(tv2view.morex<0||tv2view.morex>tv2view.getWidth()){
                    tv2view.ddx*=-1;
                }
                if(tv2view.morex<0) {
                    tv2view.morex = 0;
                    tv2view.soundPool.play(tv2view.sound2,tv2view.voice,tv2view.voice
                            ,0,0,1);

                }
                if(tv2view.morex>tv2view.getWidth()){
                    tv2view.morex=tv2view.getWidth();
                    tv2view.soundPool.play(tv2view.sound2,tv2view.voice,tv2view.voice
                            ,0,0,1);
                }
//                tv2view.ranx = tv2view.random.nextInt(50) ;
//                if(tv2view.banlist.get(tv2view.ranx)>=tv2view.list.get(tv2view.ranx)){
//                    tv2view.score+=10;
//                }

                if(tv2view.score>=100){
                    fragmentTransaction.replace(R.id.frame1,new Home2Fragment()).commit();
                }
                tv2view.invalidate();

            }

        });

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        tv2view.mediaPlayer.release();
        tv2view.mediaPlayer=null;
        tv2view.soundPool.release();
        tv2view.soundPool=null;
        tv2view.invalidate();
    }
}