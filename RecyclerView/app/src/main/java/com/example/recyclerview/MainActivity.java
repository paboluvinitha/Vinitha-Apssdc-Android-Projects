package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    RecyclerView rec;
    String names[];
    String location[];
    int poster[];
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rec=findViewById(R.id.rv);
        names=getResources().getStringArray(R.array.titles);
        location=getResources().getStringArray(R.array.subtitles);
        poster=new int[]{
                R.drawable.again,
                R.drawable.crash,
                R.drawable.extra,
                R.drawable.beauty,
                R.drawable.mr,
                R.drawable.vin,
                R.drawable.dot,
                R.drawable.the};
        adapter=new MyAdapter(this,names,location,poster);
        rec.setLayoutManager(new LinearLayoutManager(this));
        rec.setAdapter(adapter);

    }
}