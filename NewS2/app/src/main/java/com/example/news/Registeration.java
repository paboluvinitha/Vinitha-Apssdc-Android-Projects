package com.example.news;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registeration extends AppCompatActivity implements View.OnClickListener {
    Button bReg;
    EditText name,phone,pass,cnp;
    static SharedPreferences sp;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeration);
        bReg=(Button)findViewById(R.id.br);
        name=(EditText)findViewById(R.id.usr1);
        phone=(EditText)findViewById(R.id.psw1);
        pass=(EditText)findViewById(R.id.pwd);
        cnp=(EditText)findViewById(R.id.p);
        bReg.setOnClickListener(Registeration.this);

    }


    @Override
    public void onClick(View v) {
        startActivity(new Intent(Registeration.this,LoginActivity.class));
        Toast.makeText(Registeration.this,"You Have Successfully Registered",Toast.LENGTH_SHORT).show();
            switch (v.getId()){
                case R.id.bl:


                    break;
            }
    }
}