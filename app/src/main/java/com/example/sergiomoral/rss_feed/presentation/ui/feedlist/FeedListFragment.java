package com.example.sergiomoral.rss_feed.presentation.ui.feedlist;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.example.sergiomoral.rss_feed.R;
import com.example.sergiomoral.rss_feed.domain.entities.Item;
import com.example.sergiomoral.rss_feed.presentation.base.BaseFragment;
import com.example.sergiomoral.rss_feed.utils.Constants;

import java.util.ArrayList;

public class FeedListFragment extends BaseFragment implements FeedListView {


    public static FeedListFragment newInstance(@NonNull ArrayList<Item> items) {

        Bundle args = new Bundle();
        args.putParcelableArrayList(Constants.ITEMS, items);
        FeedListFragment fragment = new FeedListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void initInjector() {
        DaggerActivityComponent.builder()
                .appComponent(getAppComponent())
                .activityModule(getActivityModule())
                .build().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_feed_list;
    }

    @Override
    protected void initUI() {
// TODO: 13/11/2018 Init Adapter
    }

    @Override
    protected void attachViewToPresenter() {

    }

    @Override
    public int getFragmentTitleRes() {
        return R.string.feed_list;
    }
}
