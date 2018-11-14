package com.example.sergiomoral.rss_feed.presentation.di.componentes;

import android.app.Activity;
import android.content.Context;

import com.example.sergiomoral.rss_feed.presentation.di.modules.ActivityModule;
import com.example.sergiomoral.rss_feed.presentation.di.qualifiers.PerActivity;
import com.example.sergiomoral.rss_feed.presentation.ui.main.MainActivity;
import com.example.sergiomoral.rss_feed.presentation.ui.splash.SplashActivity;

import dagger.Component;

@PerActivity
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    Activity activity();

    Context context();

    void inject(SplashActivity splashActivity);

    void inject(MainActivity mainActivity);

}
