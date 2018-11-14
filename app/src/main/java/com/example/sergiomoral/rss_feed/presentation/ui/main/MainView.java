package com.example.sergiomoral.rss_feed.presentation.ui.main;

import com.example.sergiomoral.rss_feed.domain.entities.Item;

import java.util.ArrayList;

public interface MainView {

    void setVisibility(int drawerVisibility);

    void filterList(String s);

    void updataData(ArrayList<Item> itemList);

    void hideKeyboard();

}
