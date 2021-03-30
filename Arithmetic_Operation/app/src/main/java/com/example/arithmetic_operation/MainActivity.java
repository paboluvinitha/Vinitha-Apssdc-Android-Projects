package com.example.arithmetic_operation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import javax.xml.transform.Result;

public class MainActivity extends AppCompatActivity {
    TextView text;
    Spinner sp;
    Button bt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Spinner sp=(Spinner)findViewById(R.id.spin);
                EditText e1=(EditText)findViewById(R.id.e1);
                EditText e2=(EditText)findViewById(R.id.e2);
                TextView tv=(TextView)findViewById(R.id.text);
                String Math=sp.getSelectedItem().toString();
                if(Math.trim().equals("+")){
                    float result = Float.parseFloat(e1.getText().toString())  + Float.parseFloat(e2.getText().toString());tv.setText(Float.toString(result));
                }else if(Math.trim().equals("-")){
                    float result = Float.parseFloat(e1.getText().toString())  - Float.parseFloat(e2.getText().toString());tv.setText(Float.toString(result));
                }else if(Math.trim().equals("x")){
                    float result = Float.parseFloat(e1.getText().toString())  * Float.parseFloat(e2.getText().toString());tv.setText(Float.toString(result));
                }else if(Math.trim().equals("/")){
                    float result = Float.parseFloat(e1.getText().toString())  / Float.parseFloat(e2.getText().toString());tv.setText(Float.toString(result));
                }
            }



        };
        Button bt= (Button) findViewById(R.id.showbutton);
        bt.setOnClickListener(listener);


    }
}