package com.example.sergiomoral.rss_feed.presentation.ui.details;

import com.example.sergiomoral.rss_feed.presentation.base.BaseActivity;
import com.example.sergiomoral.rss_feed.presentation.di.componentes.DaggerActivityComponent;
import com.example.sergiomoral.rss_feed.presentation.presenter.details.DetailsPresenter;

import javax.inject.Inject;

public class DetailsActivity extends BaseActivity implements DetailsView {

    @Inject
    DetailsPresenter mPresenter;

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
        return 0;
    }
}
