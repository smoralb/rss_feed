package com.example.sergiomoral.rss_feed.data.network.models;

import com.google.gson.annotations.SerializedName;

public class ApiFeed {

    @SerializedName("author")
    private String author;
    @SerializedName("description")
    private String description;
    @SerializedName("image")
    private String image;

    private ApiFeed(Builder builder) {
        author = builder.author;
        description = builder.description;
        image = builder.image;
    }

    public static final class Builder {
        private String author;
        private String description;
        private String image;

        public Builder() {
        }

        public Builder author(String val) {
            author = val;
            return this;
        }

        public Builder description(String val) {
            description = val;
            return this;
        }

        public Builder image(String val) {
            image = val;
            return this;
        }

        public ApiFeed build() {
            return new ApiFeed(this);
        }
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }
}
