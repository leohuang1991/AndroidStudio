package com.example.myapplication;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Home2Fragment extends Fragment {
    TVview tVview;
    FragmentTransaction fragmentTransaction;
    public Home2Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home2, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tVview=view.findViewById(R.id.tvview11);
        tVview.mediaPlayer.release();
        tVview.mediaPlayer= MediaPlayer.create(getActivity(),R.raw.wine);
        tVview.mediaPlayer.start();
        fragmentTransaction=getActivity().getSupportFragmentManager().beginTransaction();
        tVview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //fragmentTransaction.replace(R.id.frame1,new HomeFragment()).commit();
                fragmentTransaction.replace(R.id.frame1,new MotionFragment()).commit();
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        tVview.mediaPlayer.release();
        tVview.mediaPlayer=null;
    }
}