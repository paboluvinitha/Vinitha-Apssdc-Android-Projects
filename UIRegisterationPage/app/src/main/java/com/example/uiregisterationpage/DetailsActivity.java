package com.example.uiregisterationpage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.uiregisterationpage.databinding.ActivityDetailsBinding;

public class DetailsActivity extends AppCompatActivity {
    ActivityDetailsBinding detailsBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        detailsBinding= DataBindingUtil.setContentView(this,R.layout.activity_details);
        detailsBinding.tv.setVisibility(View.VISIBLE);
        Intent i=getIntent();
        String n=i.getStringExtra("myname");
        String e=i.getStringExtra("myemail");
        String m=i.getStringExtra("mynumber");
        String p=i.getStringExtra("mypassword");
        String a=i.getStringExtra("myaddress");
        String g=i.getStringExtra("mygender");
        String r=i.getStringExtra("myRating");
        detailsBinding.tv.append("Name : "+n+
                "Password : "+p+"\n"+
                "Email : "+e+"\n"+
                "Number : "+m+"\n"+
                "Password : "+p+"\n"+
                "Address : "+a+"\n"+
                "Rating is : "+r+"\n"+
                "Gender : "+g+"\n");
    }
}