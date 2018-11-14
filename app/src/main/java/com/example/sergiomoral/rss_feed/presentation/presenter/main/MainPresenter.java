package com.example.sergiomoral.rss_feed.presentation.presenter.main;

import com.example.sergiomoral.rss_feed.presentation.presenter.Presenter;
import com.example.sergiomoral.rss_feed.presentation.ui.main.MainView;

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
}
