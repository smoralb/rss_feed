package com.example.sergiomoral.rss_feed.presentation.di.modules;

import com.example.sergiomoral.rss_feed.data.network.ApiService;
import com.example.sergiomoral.rss_feed.domain.repository.datasource.NetworkDataSource;
import com.example.sergiomoral.rss_feed.presentation.di.qualifiers.EndPoint;
import com.example.sergiomoral.rss_feed.utils.Constants;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApiModule {

    private static final int TIMEOUT = 120;

    @Provides
    @Singleton
    public NetworkDataSource providesNetworkDataSource(NetworkDataSourceImp networkDataSourceImp) {
        return networkDataSourceImp;
    }

    @Provides
    @Singleton
    public ApiService provideApiService(@EndPoint String endpoint,
                                        GsonConverterFactory gsonConverterFactory,
                                        OkHttpClient okClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(endpoint)
                .client(okClient)
                .addConverterFactory(gsonConverterFactory)
                .build();
        return retrofit.create(ApiService.class);
    }

    @Provides
    @Singleton
    public OkHttpClient provideClient() {
        OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder()
                .writeTimeout(TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(TIMEOUT, TimeUnit.SECONDS)
                .connectTimeout(TIMEOUT, TimeUnit.SECONDS);
        return okHttpBuilder.build();
    }


    @Provides
    @Singleton
    public GsonConverterFactory provideGsonConverterFactory() {
        return GsonConverterFactory.create();
    }

    @Provides
    @Singleton
    public Gson provideGsonParser() {
        return new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
    }

    @Provides
    @Singleton
    @EndPoint
    public String provideEndpoint() {
        return Constants.ENDPOINT;
    }
}
