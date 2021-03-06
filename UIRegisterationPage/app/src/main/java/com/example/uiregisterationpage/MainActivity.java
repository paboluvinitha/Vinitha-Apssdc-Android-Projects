package com.example.uiregisterationpage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Toast;

import com.example.uiregisterationpage.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    String gender,knowNCourses,userRating,userProgress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);

        binding.tb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(MainActivity.this, "Your button is on State", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "your button is Off State", Toast.LENGTH_SHORT).show();
                }
            }
        });

        binding.rb.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                binding.tvResult.setText("Rating is :"+rating);
            }
        });



        binding.sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                binding.tvResult.setText("Your progress :"+progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    public void ShowData(View view) {
        /*MainAcivity.this
         * or
         * this
         * or
         * context
         * or
         * getApplicationContext()
         * or getContext()*/
        String name=binding.etUsername.getText().toString();
        String email=binding.etUsermail.getText().toString();
        String mobile=binding.etUserMobileNumber.getText().toString();
        String password;
        password = binding.etUserpassword.getText().toString();
        String address=binding.etAddress.getText().toString();

        if (binding.Female.isChecked()){
            gender="FeMale";
        }else if(binding.Male.isChecked()){
            gender="male";
        }

        Intent intentObj=new Intent(this,DetailsActivity.class);
        intentObj.putExtra("myname",name);
        intentObj.putExtra("myemail",email);
        intentObj.putExtra("myNumber",mobile);
        intentObj.putExtra("mypassword",password);
        intentObj.putExtra("myaddress",address);
        intentObj.putExtra("mygender",gender);
        startActivity(intentObj);
    }
}