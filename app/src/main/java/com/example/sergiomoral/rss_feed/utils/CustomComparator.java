package com.example.sergiomoral.rss_feed.utils;

import com.example.sergiomoral.rss_feed.domain.entities.Item;

import java.util.Comparator;

public class CustomComparator implements Comparator<Item> {
    @Override
    public int compare(Item o1, Item o2) {
        return o1.getDate().compareTo(o2.getDate());
    }
}
