package com.example.sergiomoral.rss_feed.presentation.presenter.main;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;

import com.example.sergiomoral.rss_feed.domain.entities.Item;
import com.example.sergiomoral.rss_feed.presentation.presenter.Presenter;
import com.example.sergiomoral.rss_feed.presentation.ui.main.MainView;
import com.example.sergiomoral.rss_feed.utils.Utils;

import java.util.ArrayList;

import javax.inject.Inject;

public class MainPresenter implements Presenter<MainView> {

    private MainView mView;

    @Inject
    public MainPresenter() {
    }

    @Override
    public void attachView(MainView view) {
        mView = view;
    }

    public void viewVisibility(int visibility) {
        mView.setVisibility(Utils.getDrawerVisibility(visibility));
    }

    public void filterData(EditText filter) {
        filter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mView.filterList(s.toString());
            }
        });
    }

    public void filterText(ArrayList<Item> itemsArrayList, String data) {

        ArrayList<Item> itemList = new ArrayList<>();

        for (Item item : itemsArrayList) {
            if (item.getTitle().toLowerCase().contains(data)) {
                itemList.add(item);
            }
        }
        mView.updataData(itemList);
    }

    public void keyBoardListener(EditText filterButton) {
        filterButton.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER) {
                    mView.hideKeyboard();
                    return true;
                }
                return false;
            }
        });
    }
}
