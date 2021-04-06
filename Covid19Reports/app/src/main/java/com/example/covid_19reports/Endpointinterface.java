package com.example.covid_19reports;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Endpointinterface {
    /*diving single url into multiple urls*/
    @GET("dayone/country/IN")
    Call<String> getData();
}
