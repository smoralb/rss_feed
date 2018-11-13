package com.example.sergiomoral.rss_feed.domain.entities;

import android.os.Parcel;
import android.os.Parcelable;

public class Feed implements Parcelable {

    private String author;
    private String description;
    private String image;

    private Feed(Builder builder) {
        setAuthor(builder.author);
        setDescription(builder.description);
        setImage(builder.image);
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.author);
        dest.writeString(this.description);
        dest.writeString(this.image);
    }

    public Feed() {
    }

    protected Feed(Parcel in) {
        this.author = in.readString();
        this.description = in.readString();
        this.image = in.readString();
    }

    public static final Creator<Feed> CREATOR = new Creator<Feed>() {
        @Override
        public Feed createFromParcel(Parcel source) {
            return new Feed(source);
        }

        @Override
        public Feed[] newArray(int size) {
            return new Feed[size];
        }
    };

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

        public Feed build() {
            return new Feed(this);
        }
    }
}
