package com.example.sergiomoral.rss_feed.data.network.mapper;

import com.example.sergiomoral.rss_feed.data.network.models.ApiFeed;
import com.example.sergiomoral.rss_feed.domain.entities.Feed;
import com.example.sergiomoral.rss_feed.domain.mapper.Mapper;

import javax.inject.Inject;

public class ApiFeedMapper implements Mapper<ApiFeed, Feed> {

    @Inject
    public ApiFeedMapper() {
    }

    @Override
    public Feed map(ApiFeed model) {
        if (model == null) {
            return null;
        }

        return new Feed.Builder()
                .author(model.getAuthor())
                .description(model.getDescription())
                .image(model.getImage())
                .build();
    }

    @Override
    public ApiFeed inverseMap(Feed model) {
        if (model == null) {
            return null;
        }

        return new ApiFeed.Builder()
                .author(model.getAuthor())
                .description(model.getDescription())
                .image(model.getImage())
                .build();
    }
}
