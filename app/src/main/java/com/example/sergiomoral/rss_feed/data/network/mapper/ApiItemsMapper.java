package com.example.sergiomoral.rss_feed.data.network.mapper;

import com.example.sergiomoral.rss_feed.data.network.models.ApiItems;
import com.example.sergiomoral.rss_feed.domain.entities.Item;
import com.example.sergiomoral.rss_feed.domain.mapper.Mapper;

import javax.inject.Inject;

public class ApiItemsMapper implements Mapper<ApiItems, Item> {

    @Inject
    public ApiItemsMapper() {
    }

    @Override
    public Item map(ApiItems model) {
        if (model == null) {
            return null;
        }

        return new Item.Builder()
                .author(model.getAuthor())
                .categories(model.getCategories())
                .date(model.getDate())
                .description(model.getDescription())
                .link(model.getLink())
                .thubnail(model.getThubnail())
                .title(model.getTitle())
                .build();
    }

    @Override
    public ApiItems inverseMap(Item model) {
        if (model == null) {
            return null;
        }

        return new ApiItems.Builder()
                .author(model.getAuthor())
                .categories(model.getCategories())
                .date(model.getDate())
                .description(model.getDescription())
                .link(model.getLink())
                .thubnail(model.getThubnail())
                .title(model.getTitle())
                .build();
    }
}
