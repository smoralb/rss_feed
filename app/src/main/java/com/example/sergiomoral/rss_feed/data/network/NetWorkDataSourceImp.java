package com.example.sergiomoral.rss_feed.data.network;

import android.app.Application;
import android.util.Log;
import com.example.sergiomoral.rss_feed.data.network.mapper.ApiWrapperMapper;
import com.example.sergiomoral.rss_feed.data.network.models.ApiWrapper;
import com.example.sergiomoral.rss_feed.domain.entities.Wrapper;
import com.example.sergiomoral.rss_feed.domain.repository.datasource.NetworkDataSource;
import com.google.gson.Gson;


public class NetWorkDataSourceImp implements NetworkDataSource {

    private static final String TAG = "NetWorkDataSourceImp";
    private Application mContext;
    private ApiService mApiService;
    private Gson gson;

    private ApiWrapperMapper mWrapperMapper;

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
