package com.example.sergiomoral.rss_feed.presentation.di.modules;

import com.example.sergiomoral.rss_feed.data.network.mapper.ApiFeedMapper;
import com.example.sergiomoral.rss_feed.data.network.mapper.ApiItemsMapper;
import com.example.sergiomoral.rss_feed.data.network.mapper.ApiWrapperMapper;
import com.example.sergiomoral.rss_feed.data.network.models.ApiFeed;
import com.example.sergiomoral.rss_feed.data.network.models.ApiItems;
import com.example.sergiomoral.rss_feed.data.network.models.ApiWrapper;
import com.example.sergiomoral.rss_feed.domain.entities.Feed;
import com.example.sergiomoral.rss_feed.domain.entities.Item;
import com.example.sergiomoral.rss_feed.domain.entities.Wrapper;
import com.example.sergiomoral.rss_feed.domain.mapper.ListMapper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DataModule {

    @Provides
    @Singleton
    ListMapper<ApiFeed, Feed> providesApiContributorMapper(ApiFeedMapper apiFeedMapper) {
        return new ListMapper<>(apiFeedMapper);
    }

    @Provides
    @Singleton
    ListMapper<ApiItems, Item> providesApiForkMapper(ApiItemsMapper apiItemsMapper) {
        return new ListMapper<>(apiItemsMapper);
    }

    @Provides
    @Singleton
    ListMapper<ApiWrapper, Wrapper> providesApiIssueMapper(ApiWrapperMapper apiWrapperMapper) {
        return new ListMapper<>(apiWrapperMapper);
    }
}
