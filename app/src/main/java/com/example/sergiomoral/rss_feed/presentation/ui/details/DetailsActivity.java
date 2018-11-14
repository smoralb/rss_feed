package com.example.sergiomoral.rss_feed.presentation.ui.details;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.example.sergiomoral.rss_feed.R;
import com.example.sergiomoral.rss_feed.domain.entities.Item;
import com.example.sergiomoral.rss_feed.presentation.base.BaseActivity;
import com.example.sergiomoral.rss_feed.presentation.di.componentes.DaggerActivityComponent;
import com.example.sergiomoral.rss_feed.presentation.presenter.details.DetailsPresenter;
import com.example.sergiomoral.rss_feed.presentation.ui.main.MainActivity;
import com.example.sergiomoral.rss_feed.utils.Constants;


import javax.inject.Inject;

public class DetailsActivity extends BaseActivity implements DetailsView {

    private static final String TAG = "DetailsActivity";

    @Inject
    DetailsPresenter mPresenter;

    public static void open(Context context, Item item) {
        Log.d(TAG, "open: DetailsActivity");
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra(Constants.ITEM, item);
        context.startActivity(intent);
    }

    @Override
    protected void attachViewToPresenter() {
        mPresenter.attachView(this);
    }

    @Override
    protected void initInjector() {
        DaggerActivityComponent.builder()
                .appComponent(getAppComponent())
                .activityModule(getActivityModule())
                .build().inject(this);
    }

    @Override
    protected void initUI() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_details;
    }

    private Item getData() {
        return getIntent().getParcelableExtra(Constants.ITEM);
    }

}
