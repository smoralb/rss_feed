package com.example.sergiomoral.rss_feed.presentation.ui.main.manager;


import javax.inject.Inject;

public class MainManager implements Manager<ManagerView> {

    private ManagerView mView;

    @Inject
    public MainManager() {
    }

    @Override
    public void attachView(ManagerView view) {
        mView = view;
    }

    public void userEnter() {
        mView.loadFeedList();
    }

    public void onBackButton(int option) {

    }

    public void nextState(int option) {

    }
}
