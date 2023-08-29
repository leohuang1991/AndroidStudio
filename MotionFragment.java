package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class MotionFragment extends Fragment {
    ConstraintLayout constraintLayout;
    View view1;
    TVview tv0,tv1;
    public MotionFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_motion, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        constraintLayout=view.findViewById(R.id.co1);
        view1=LayoutInflater.from(getActivity()).inflate(R.layout.test,constraintLayout,false);
        constraintLayout.addView(view1);
        constraintLayout.setVisibility(constraintLayout.getVisibility()==View.VISIBLE?View.INVISIBLE:View.VISIBLE);
        tv1=view1.findViewById(R.id.tv1);
        tv0=view.findViewById(R.id.view123);
        tv0.setVisibility(View.INVISIBLE);
        //ConstraintSet con=new ConstraintSet();
       // con.clone(constraintLayout);
        //con.clear(R.id.co1,ConstraintSet.RIGHT);
        constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                constraintLayout.removeView(view1);
                tv0.setVisibility(View.VISIBLE);
                //constraintLayout.setVisibility(View.INVISIBLE);
                //getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame1,new QRCodeFragment()).commit();
            }
        });
        tv0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //constraintLayout.removeView(view1);
                //tv0.setEnabled(true);
                //getActivity().startActivity(new Intent(getActivity(),MainActivity2.class));
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame1,new QRCodeFragment("")).commit();
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }
}