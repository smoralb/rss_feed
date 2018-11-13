package com.example.sergiomoral.rss_feed.data.network.mapper;

import com.example.sergiomoral.rss_feed.data.network.models.ApiFeed;
import com.example.sergiomoral.rss_feed.data.network.models.ApiItems;
import com.example.sergiomoral.rss_feed.data.network.models.ApiWrapper;
import com.example.sergiomoral.rss_feed.domain.entities.Feed;
import com.example.sergiomoral.rss_feed.domain.entities.Item;
import com.example.sergiomoral.rss_feed.domain.entities.Wrapper;
import com.example.sergiomoral.rss_feed.domain.mapper.ListMapper;
import com.example.sergiomoral.rss_feed.domain.mapper.Mapper;


public class ApiWrapperMapper implements Mapper<ApiWrapper, Wrapper> {

    Mapper<ApiFeed, Feed> apiFeedMapper;
    ListMapper<ApiItems, Item> apiITemMapper;

    @Override
    public Wrapper map(ApiWrapper model) {
        if (model == null) {
            return null;
        }

        return new Wrapper.Builder()
                .feed(apiFeedMapper.map(model.getFeed()))
                .items(apiITemMapper.map(model.getItems()))
                .status(model.getStatus())
                .build();

    }

    @Override
    public ApiWrapper inverseMap(Wrapper model) {
        if (model == null) {
            return null;
        }

        return new ApiWrapper.Builder()
                .feed(apiFeedMapper.inverseMap(model.getFeed()))
                .items(apiITemMapper.inverseMap(model.getItems()))
                .status(model.getStatus())
                .build();
    }
}
