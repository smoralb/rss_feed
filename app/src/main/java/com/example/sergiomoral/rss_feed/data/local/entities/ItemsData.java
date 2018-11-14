package com.example.sergiomoral.rss_feed.data.local.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class ItemsData {

    @NonNull
    @PrimaryKey
    private String itemId;
}
