package com.example.sergiomoral.rss_feed.presentation.presenter.details;

import com.example.sergiomoral.rss_feed.presentation.presenter.Presenter;
import com.example.sergiomoral.rss_feed.presentation.ui.details.DetailsView;

import javax.inject.Inject;

public class DetailsPresenter implements Presenter<DetailsView> {

    private DetailsView mView;

    @Inject
    public DetailsPresenter() {
    }

    @Override
    public void attachView(DetailsView view) {
        mView = view;
    }
}
