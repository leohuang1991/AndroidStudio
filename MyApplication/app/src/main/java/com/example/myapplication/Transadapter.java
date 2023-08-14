package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Transadapter extends RecyclerView.Adapter<Transadapter.Transview> {
    List<Trans> list;
    Transadapter(List<Trans> list){
        this.list=list;
    }
    @NonNull
    @Override
    public Transadapter.Transview onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.transrec,parent,false);
        return new Transview(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Transadapter.Transview holder, int position) {
        holder.date.setText(list.get(position).getDate());
        holder.amount.setText(list.get(position).getAmount()+"");
        holder.type.setText(list.get(position).getType()+"");
    }

    @Override
    public int getItemCount() {
        return this.list.size();
    }
    class Transview extends RecyclerView.ViewHolder {
        TextView date,amount,type;

        public Transview(@NonNull View itemView) {
            super(itemView);
            date=itemView.findViewById(R.id.item1);
            amount=itemView.findViewById(R.id.item2);
            type=itemView.findViewById(R.id.item3);
        }
    }

    }
