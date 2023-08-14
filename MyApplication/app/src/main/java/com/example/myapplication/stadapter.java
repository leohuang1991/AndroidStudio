package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class stadapter extends RecyclerView.Adapter<stadapter.myview> {

    List<St> lis;

    public stadapter(List<St> lis){
        this.lis=lis;
    }
    @NonNull
    @Override
    public stadapter.myview onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.rec,parent,false);
        return new myview(view);
    }

    @Override
    public void onBindViewHolder(@NonNull stadapter.myview holder, int position) {
            String name=lis.get(position).getFg();
            holder.tx1.setText(position+"");
            holder.tx2.setText(name);
    }

    @Override
    public int getItemCount() {
        return lis.size();
    }

    public class myview extends RecyclerView.ViewHolder{
        TextView tx1,tx2;
        public myview(@NonNull View itemView) {
            super(itemView);
            tx1=itemView.findViewById(R.id.textView2);
            tx2=itemView.findViewById(R.id.textView3);
        }
    }
}
