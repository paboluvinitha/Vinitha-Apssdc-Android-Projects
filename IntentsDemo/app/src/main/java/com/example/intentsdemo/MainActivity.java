package com.example.intentsdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button bt;
    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt=findViewById(R.id.d8);
        et=findViewById(R.id.tv);


        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(MainActivity.this,SecondActivity.class);
                startActivity(i1);

            }
        });


        }

    public void browser(View view) {
        Uri uri=Uri.parse("https://www.google.com");
        Intent i2=new Intent(Intent.ACTION_VIEW,uri);
        startActivity(i2);
    }

    public void msgdata(View view) {
       String m= et.getText().toString();
       Intent i=new Intent(MainActivity.this,SecondActivity.class);
       i.putExtra("AITS",m);
       startActivity(i);

    }
}