package com.example.sergiomoral.rss_feed.presentation.ui.splash;

import android.os.Bundle;

import com.example.sergiomoral.rss_feed.R;
import com.example.sergiomoral.rss_feed.domain.entities.Wrapper;
import com.example.sergiomoral.rss_feed.presentation.base.BaseActivity;
import com.example.sergiomoral.rss_feed.presentation.di.componentes.DaggerActivityComponent;
import com.example.sergiomoral.rss_feed.presentation.presenter.splash.SplashPresenter;
import com.example.sergiomoral.rss_feed.presentation.ui.main.MainActivity;

import javax.inject.Inject;


public class SplashActivity extends BaseActivity implements SplashView {

    @Inject
    SplashPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        mPresenter.getNews();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    public void showFeed(Wrapper response) {
        MainActivity.open(this, response);
        finish();
    }
}
