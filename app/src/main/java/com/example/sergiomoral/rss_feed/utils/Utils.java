package com.example.sergiomoral.rss_feed.utils;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class Utils {

    public static String getDescriptionFormatted(String description) {

        String separator = ">";
        String[] desc = description.split(separator);
        return desc[1].trim();
    }

    public static int getDrawerVisibility(int visibility) {
        switch (visibility) {
            case View.VISIBLE:
                return View.GONE;
            default:
                return View.VISIBLE;
        }
    }

    public static void closeKeyboard(Activity activity) {
        if (activity != null) {
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(activity.getWindow().getDecorView().getWindowToken(), 0);
        }
    }
}
