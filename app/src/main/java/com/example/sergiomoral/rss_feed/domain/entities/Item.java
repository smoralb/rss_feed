package com.example.sergiomoral.rss_feed.domain.entities;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class Item implements Parcelable {

    private String title;
    private String date;
    private String link;
    private String author;
    private String thubnail;
    private String description;
    private List<String> categories;

    private Item(Builder builder) {
        setTitle(builder.title);
        setDate(builder.date);
        setLink(builder.link);
        setAuthor(builder.author);
        setThubnail(builder.thubnail);
        setDescription(builder.description);
        setCategories(builder.categories);
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.date);
        dest.writeString(this.link);
        dest.writeString(this.author);
        dest.writeString(this.thubnail);
        dest.writeString(this.description);
        dest.writeStringList(this.categories);
    }

    public Item() {
    }

    protected Item(Parcel in) {
        this.title = in.readString();
        this.date = in.readString();
        this.link = in.readString();
        this.author = in.readString();
        this.thubnail = in.readString();
        this.description = in.readString();
        this.categories = in.createStringArrayList();
    }

    public static final Creator<Item> CREATOR = new Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel source) {
            return new Item(source);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getThubnail() {
        return thubnail;
    }

    public void setThubnail(String thubnail) {
        this.thubnail = thubnail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }


    public static final class Builder {
        private String title;
        private String date;
        private String link;
        private String author;
        private String thubnail;
        private String description;
        private List<String> categories;

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

        public Item build() {
            return new Item(this);
        }
    }
}
