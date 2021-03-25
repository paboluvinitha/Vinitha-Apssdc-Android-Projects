package com.example.hellotoast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.security.Key;

public class MainActivity extends AppCompatActivity {
    TextView text;
    int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text=findViewById(R.id.D8);
        if(savedInstanceState!=null&&savedInstanceState.containsKey("anykey")) {
            count=savedInstanceState.getInt("anyKey");
            text.setText(String.valueOf(count));
        }


    }

    public void showToast(View view) {
        /*Syntax for toast*
         */
        Toast.makeText(this, "this is our own app", Toast.LENGTH_SHORT).show();
    }

    public void ShowCount(View view) {
        count++;
        text.setText(String.valueOf(count));
    }
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("anyKey",count);
    }
}