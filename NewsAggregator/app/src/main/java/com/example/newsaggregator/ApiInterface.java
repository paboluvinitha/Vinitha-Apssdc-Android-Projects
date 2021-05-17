package com.example.newsaggregator;

import com.example.newsaggregator.model.News;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("top-headlines")
    Call<News> getHeadlines(
            @Query("country") String country,
            @Query("apiKey") String apiKey
    );

    @GET("everything")
    Call<News> getSpecificData(
            @Query("q") String query,
            @Query("apiKey") String apiKey
    );
}
