package com.example.newsaggregator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;

import com.example.newsaggregator.Database.FavDbHelper;
import com.example.newsaggregator.model.Articles;

import java.util.ArrayList;
import java.util.List;

public class FavouriteActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    FavAdapter favAdapter;
    FavDbHelper favDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_favourite);
        recyclerView=findViewById(R.id.recycler_view_favourite);
        favDbHelper=new FavDbHelper(this);
        Cursor cursor=favDbHelper.retrieveValues();
        /* StringBuilder sb=new StringBuilder();*/
        while (cursor.moveToNext()){

            String sb=cursor.getString(1);
            String s=cursor.getString(2);
            favAdapter=new FavAdapter(sb,s,this);


        }
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(favAdapter);


    }
}
