package com.example.newsaggregator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsaggregator.model.Articles;
import com.squareup.picasso.Picasso;

import org.ocpsoft.prettytime.PrettyTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class FavAdapter extends RecyclerView.Adapter<FavAdapter.FavViewHolder> {

    String tv_titele,tv_source;
    Context context;

    public FavAdapter(String tv_titele, String tv_source, Context context) {

        this.tv_titele = tv_titele;
        this.tv_source = tv_source;
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
        holder.tv2.setText(tv_source);



    }



    @Override
    public int getItemCount() {

        return 3;
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

