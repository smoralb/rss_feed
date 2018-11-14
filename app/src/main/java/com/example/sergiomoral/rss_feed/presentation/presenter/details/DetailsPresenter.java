package com.example.sergiomoral.rss_feed.presentation.presenter.details;

import com.example.sergiomoral.rss_feed.presentation.presenter.Presenter;
import com.example.sergiomoral.rss_feed.presentation.ui.details.DetailsView;
import com.example.sergiomoral.rss_feed.utils.Utils;

import java.util.ArrayList;

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

    public void loadCategories(ArrayList<String> categoriesArrayList) {
        String categories = "";
        for (int i = 0; i < categoriesArrayList.size(); i++) {
            categories.concat("#" + categoriesArrayList.get(i) + ", ");
        }
        mView.showCategories(categories);
    }

    public void viewVisibility(int visibility) {
        mView.setVisibility(Utils.getDrawerVisibility(visibility));
    }

}
