package com.example.sergiomoral.rss_feed.data.network;

import com.example.sergiomoral.rss_feed.data.network.models.ApiWrapper;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("/v1/api.json")
    Call<ApiWrapper> getNews(@Query("rss_url") String rssFeed);
}
