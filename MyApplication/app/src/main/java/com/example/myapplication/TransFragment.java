package com.example.myapplication;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttp;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class TransFragment extends Fragment {
    String string="https://atm201605.appspot.com/h";
    RecyclerView recyclerView;
    List<Trans> transList;
    MediaPlayer mediaPlayer;
    public TransFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_trans, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mediaPlayer=MediaPlayer.create(view.getContext(),R.raw.wine);
        mediaPlayer.start();
        recyclerView=view.findViewById(R.id.recc);
        OkHttpClient okHttpClient=new OkHttpClient();
        Request request=new Request.Builder().url(string).build();
        transList=new ArrayList<>();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {

            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                final  String repon=response.body().string();
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        parsejson(repon,view);
                    }
                });
            }

        });

    }


    private void parsejson(String repon,View view) {
        try {
            JSONArray jsonArray=new JSONArray(repon);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject=jsonArray.getJSONObject(i);
                Trans trans=new Trans(jsonObject);
                transList.add(trans);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        Transadapter transadapter=new Transadapter(transList);
        recyclerView.setAdapter(transadapter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mediaPlayer.release();
        mediaPlayer=null;
    }
}