package com.example.sergiomoral.rss_feed.data.network;

import android.app.Application;
import android.util.Log;

import com.example.sergiomoral.rss_feed.data.network.mapper.ApiWrapperMapper;
import com.example.sergiomoral.rss_feed.data.network.models.ApiWrapper;
import com.example.sergiomoral.rss_feed.domain.entities.Wrapper;
import com.example.sergiomoral.rss_feed.domain.repository.datasource.NetworkDataSource;
import com.google.gson.Gson;

import javax.inject.Inject;


public class NetworkDataSourceImp implements NetworkDataSource {

    private static final String TAG = "NetworkDataSourceImp";
    private Application mContext;
    private ApiService mApiService;
    private Gson gson;
    private ApiWrapperMapper mWrapperMapper;

    @Inject
    public NetworkDataSourceImp(Application mContext, ApiService mApiService, Gson gson, ApiWrapperMapper mWrapperMapper) {
        this.mContext = mContext;
        this.mApiService = mApiService;
        this.gson = gson;
        this.mWrapperMapper = mWrapperMapper;
    }

    @Override
    public Wrapper getNews(String rssFeed) {
        try {
            ApiWrapper wrapper = mApiService.getNews(rssFeed).execute().body();
            return mWrapperMapper.map(wrapper);
        } catch (Exception exception) {
            Log.d(TAG, "getNews: Error");
            throw new IllegalArgumentException(exception.getMessage());
        }
    }
}
