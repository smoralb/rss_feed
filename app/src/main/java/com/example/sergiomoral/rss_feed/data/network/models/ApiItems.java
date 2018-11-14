package com.example.sergiomoral.rss_feed.data.network.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ApiItems {

    @SerializedName("title")
    private String title;
    @SerializedName("pubDate")
    private String date;
    @SerializedName("link")
    private String link;
    @SerializedName("author")
    private String author;
    @SerializedName("thumbnail")
    private String thubnail;
    @SerializedName("description")
    private String description;
    @SerializedName("categories")
    private List<String> categories;
    @SerializedName("guid")
    private String id;

    private ApiItems(Builder builder) {
        title = builder.title;
        date = builder.date;
        link = builder.link;
        author = builder.author;
        thubnail = builder.thubnail;
        description = builder.description;
        categories = builder.categories;
        id = builder.id;
    }


    public static final class Builder {
        private String title;
        private String date;
        private String link;
        private String author;
        private String thubnail;
        private String description;
        private List<String> categories;
        private String id;

        public Builder() {
        }

        public Builder title(String val) {
            title = val;
            return this;
        }

        public Builder date(String val) {
            date = val;
            return this;
        }

        public Builder link(String val) {
            link = val;
            return this;
        }

        public Builder author(String val) {
            author = val;
            return this;
        }

        public Builder thubnail(String val) {
            thubnail = val;
            return this;
        }

        public Builder description(String val) {
            description = val;
            return this;
        }

        public Builder categories(List<String> val) {
            categories = val;
            return this;
        }

        public Builder id(String val) {
            id = val;
            return this;
        }

        public ApiItems build() {
            return new ApiItems(this);
        }
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getLink() {
        return link;
    }

    public String getAuthor() {
        return author;
    }

    public String getThubnail() {
        return thubnail;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getCategories() {
        return categories;
    }

    public String getId() {
        return id;
    }
}
