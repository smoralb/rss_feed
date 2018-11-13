package com.example.sergiomoral.rss_feed.presentation;

import android.app.Application;

import com.example.sergiomoral.rss_feed.presentation.di.componentes.AppComponent;
import com.example.sergiomoral.rss_feed.presentation.di.modules.AppModule;

public class RssApp extends Application {

    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        initInjector();
    }

    private void initInjector() {
        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }

}
