package com.example.sergiomoral.rss_feed.presentation.di.componentes;


import android.app.Application;
import com.example.sergiomoral.rss_feed.domain.executor.InteractorExecutor;
import com.example.sergiomoral.rss_feed.domain.executor.MainThreadExecutor;
import com.example.sergiomoral.rss_feed.domain.repository.Repository;
import com.example.sergiomoral.rss_feed.domain.repository.datasource.NetworkDataSource;
import com.example.sergiomoral.rss_feed.presentation.di.modules.ActivityModule;
import com.example.sergiomoral.rss_feed.presentation.di.modules.ApiModule;
import com.example.sergiomoral.rss_feed.presentation.di.modules.AppModule;
import com.example.sergiomoral.rss_feed.presentation.di.modules.DataModule;
import com.example.sergiomoral.rss_feed.presentation.di.modules.ExecutorModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, ActivityModule.class, ApiModule.class, ExecutorModule.class, DataModule.class})
public interface AppComponent {

    Application app();

    NetworkDataSource networkDataSource();

    InteractorExecutor interactorExecutor();

    MainThreadExecutor mainThreadExecutor();

    Repository repository();
}
