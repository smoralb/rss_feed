package com.example.sergiomoral.rss_feed.utils;

public class Utils {

    public static String getDescriptionFormatted(String description) {

        String separator = ">";
        String[] desc = description.split(separator);
        return desc[1].trim();
    }
}
