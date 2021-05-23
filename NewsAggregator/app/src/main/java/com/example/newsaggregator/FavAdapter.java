package com.example.newsaggregator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FavAdapter extends RecyclerView.Adapter<FavAdapter.FavViewHolder> {
    String tv_titele,tv_desc;
    Context context;

    public FavAdapter(String tv_titele, String tv_desc, Context context) {
        this.tv_titele = tv_titele;
        this.tv_desc = tv_desc;
        this.context = context;
    }

    @NonNull
    @Override
    public FavViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FavViewHolder(LayoutInflater.from(context).inflate(R.layout.item_favourite,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull FavViewHolder holder, int position) {
        holder.tv1.setText(tv_titele);
        holder.tv2.setText(tv_desc);

    }

    @Override
    public int getItemCount() {
        return tv_titele.length();
    }

    public class FavViewHolder extends RecyclerView.ViewHolder {
        TextView tv1,tv2;

        public FavViewHolder(@NonNull View itemView) {

            super(itemView);
            tv1=itemView.findViewById(R.id.tvTitle1);
            tv2=itemView.findViewById(R.id.tvDesc1);
        }
    }
}