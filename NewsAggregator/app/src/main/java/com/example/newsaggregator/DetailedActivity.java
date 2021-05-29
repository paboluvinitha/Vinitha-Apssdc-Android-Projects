package com.example.newsaggregator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.newsaggregator.Database.FavDbHelper;
import com.monstertechno.adblocker.AdBlockerWebView;
import com.monstertechno.adblocker.util.AdBlocker;
import com.squareup.picasso.Picasso;

public class DetailedActivity extends AppCompatActivity {
    TextView tvTitle,tvSource,tvTime,tvDesc;
    ImageView imageView;
    WebView webView;
    ProgressBar loader;
    CheckBox checkBox;
    String title,source;
    FavDbHelper favDbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);
        tvTitle = findViewById(R.id.tvTitle);
        tvSource = findViewById(R.id.tvSource);
        tvTime = findViewById(R.id.tvDate);
        tvDesc = findViewById(R.id.tvDesc);
        checkBox = findViewById(R.id.fav1btn);
        imageView = findViewById(R.id.imageView);
        webView = findViewById(R.id.webView);
        loader = findViewById(R.id.webViewLoader);
        loader.setVisibility(View.VISIBLE);
        favDbHelper=new FavDbHelper(this);

        Intent intent = getIntent();
         title = intent.getStringExtra("title");
        source = intent.getStringExtra("source");
        String time = intent.getStringExtra("time");
        String desc = intent.getStringExtra("desc");
        String imageUrl = intent.getStringExtra("imageUrl");
        String url = intent.getStringExtra("url");
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean  isChecked) {
                if(isChecked){
                    ContentValues cv=new ContentValues();
                    cv.put(favDbHelper.col_1,title);
                    cv.put(favDbHelper.col_2,source);
                    long l=favDbHelper.insertValues(cv);
                    Toast.makeText(DetailedActivity.this,"Added to Favourites",Toast.LENGTH_SHORT).show();


                }

            }
        });


        tvTitle.setText(title);
        tvSource.setText(source);
        tvTime.setText(time);
        tvDesc.setText(desc);

        Picasso.with(DetailedActivity.this).load(imageUrl).into(imageView);
        new AdBlockerWebView.init(this).initializeWebView(webView);
        webView.setWebViewClient(new Browser_home());
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(url);
        if (webView.isShown()){
            loader.setVisibility(View.INVISIBLE);
        }

    }
    private class Browser_home extends WebViewClient {

        Browser_home() {}

        @SuppressWarnings("deprecation")
        @Override
        public WebResourceResponse shouldInterceptRequest(WebView view, String url) {

            return AdBlockerWebView.blockAds(view,url) ? AdBlocker.createEmptyResource() :
                    super.shouldInterceptRequest(view, url);

        }

    }
}


