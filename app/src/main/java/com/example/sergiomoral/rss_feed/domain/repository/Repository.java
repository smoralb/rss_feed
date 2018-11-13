package com.example.sergiomoral.rss_feed.domain.repository;

import android.util.Log;

import com.example.sergiomoral.rss_feed.domain.entities.Wrapper;
import com.example.sergiomoral.rss_feed.domain.repository.datasource.NetworkDataSource;
import com.google.gson.Gson;

import javax.inject.Inject;


public class Repository {

    private static final String TAG = "Repository";
    private NetworkDataSource mNetworkDataSource;
    private Gson mGson;

    @Inject
    public Repository(NetworkDataSource networkDataSource, Gson gson) {
        this.mNetworkDataSource = networkDataSource;
        this.mGson = gson;
    }

    public Wrapper getNews(String rssFeed) {
        Wrapper wrapper;
        try {
            wrapper = mNetworkDataSource.getNews(rssFeed);
        } catch (Exception exception) {
            Log.d(TAG, "getNews: Error");
            throw exception;
        }
        return wrapper;
    }
}
