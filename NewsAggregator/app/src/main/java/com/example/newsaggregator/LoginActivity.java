package com.example.newsaggregator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText umail,upws;
    Button login,register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login = (Button) findViewById(R.id.bl);
        register = (Button) findViewById(R.id.rh);
        umail = (EditText) findViewById(R.id.usr);
        upws = (EditText) findViewById(R.id.psw);
        String useremail1=umail.getText().toString();
        String userpws1=upws.getText().toString();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homepage=new Intent(getBaseContext(),HomePageActivity.class);
                startActivity(homepage);
            }
        });
    }

        /*String useremail1=umail.getText().toString();
        String userpws1=upws.getText().toString();*/
        /*String s=RegistrationActivity.sp.getString("mail","");
        String p=RegistrationActivity.sp.getString("password","");
        if ((useremail1.equals(s) )&& (userpws1.equals(p)))
            if (useremail1.isEmpty() || useremail1.length()<7){
                showError(umail,"your user email is not valid");
            }
            else if (userpws1.isEmpty() || userpws1.length()<7 ){
                showError(upws,"invalid password");
            }

            else if ((useremail1.equals(s) )&& (userpws1.equals(p))) {
                Toast.makeText(this, "Login success", Toast.LENGTH_SHORT).show();

            }

    }

    private void showError(EditText input, String s) {
        input.setError(s);
        input.requestFocus();

    }*/



    public void register(View view) {
        Intent intent=new Intent(getBaseContext(),RegistrationActivity.class);
        startActivity(intent);
    }
    }