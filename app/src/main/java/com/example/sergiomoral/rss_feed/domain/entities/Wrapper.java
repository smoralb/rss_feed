package com.example.sergiomoral.rss_feed.domain.entities;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class Wrapper implements Parcelable {

    private String status;
    private Feed feed;
    private List<Item> items;

    private Wrapper(Builder builder) {
        setStatus(builder.status);
        setFeed(builder.feed);
        setItems(builder.items);
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.status);
        dest.writeParcelable(this.feed, flags);
        dest.writeTypedList(this.items);
    }

    public Wrapper() {
    }

    protected Wrapper(Parcel in) {
        this.status = in.readString();
        this.feed = in.readParcelable(Feed.class.getClassLoader());
        this.items = in.createTypedArrayList(Item.CREATOR);
    }

    public static final Creator<Wrapper> CREATOR = new Creator<Wrapper>() {
        @Override
        public Wrapper createFromParcel(Parcel source) {
            return new Wrapper(source);
        }

        @Override
        public Wrapper[] newArray(int size) {
            return new Wrapper[size];
        }
    };

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Feed getFeed() {
        return feed;
    }

    public void setFeed(Feed feed) {
        this.feed = feed;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }


    public static final class Builder {
        private String status;
        private Feed feed;
        private List<Item> items;

        public Builder() {
        }

        public Builder status(String val) {
            status = val;
            return this;
        }

        public Builder feed(Feed val) {
            feed = val;
            return this;
        }

        public Builder items(List<Item> val) {
            items = val;
            return this;
        }

        public Wrapper build() {
            return new Wrapper(this);
        }
    }
}
