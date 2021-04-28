package com.example.news;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    Button bLogin;
    EditText user,password;
    TextView register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        bLogin=(Button)findViewById(R.id.bl);
        user=(EditText)findViewById(R.id.usr);
        password=(EditText)findViewById(R.id.psw);
        register=findViewById(R.id.rh);
        bLogin.setOnClickListener(this);
        register.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bl:


            break;
            case R.id.rh:
                startActivity(new Intent(this,Registeration.class));


            break;

        }
    }
}