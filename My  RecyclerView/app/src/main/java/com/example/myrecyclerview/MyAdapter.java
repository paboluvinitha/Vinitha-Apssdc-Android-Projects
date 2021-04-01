package com.example.myrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    Context cxt;
    String title[];
    String sub_title[];
    int postr[];

    public MyAdapter(Context cxt,String[] title,String[]sub_title,int[]postr) {
        this.cxt = cxt;
        this.title=title;
        this.sub_title=sub_title;
        this.postr=postr;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(cxt).inflate(R.layout.row_design,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.t.setText(title[position]);
        holder.st.setText(sub_title[position]);
        holder.img.setImageResource(postr[position]);

    }

    @Override
    public int getItemCount() {
        return title.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView t,st;
        ImageView img;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            t=itemView.findViewById(R.id.tv_subtitle);
            st=itemView.findViewById(R.id.tv_title);
            img=itemView.findViewById(R.id.iv);
        }
    }
}
