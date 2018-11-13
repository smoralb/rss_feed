package com.example.sergiomoral.rss_feed.data.network.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ApiWrapper {

    @SerializedName("status")
    private String status;
    @SerializedName("feed")
    private ApiFeed feed;
    @SerializedName("items")
    private List<ApiItems> items;

    private ApiWrapper(Builder builder) {
        status = builder.status;
        feed = builder.feed;
        items = builder.items;
    }


    public static final class Builder {
        private String status;
        private ApiFeed feed;
        private List<ApiItems> items;

        public Builder() {
        }

        public Builder status(String val) {
            status = val;
            return this;
        }

        public Builder feed(ApiFeed val) {
            feed = val;
            return this;
        }

        public Builder items(List<ApiItems> val) {
            items = val;
            return this;
        }

        public ApiWrapper build() {
            return new ApiWrapper(this);
        }
    }

    public String getStatus() {
        return status;
    }

    public ApiFeed getFeed() {
        return feed;
    }

    public List<ApiItems> getItems() {
        return items;
    }
}
