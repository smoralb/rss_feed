package com.example.sergiomoral.rss_feed.presentation.di.modules;

import android.os.Handler;
import android.os.Looper;

import com.example.sergiomoral.rss_feed.domain.executor.InteractorExecutor;
import com.example.sergiomoral.rss_feed.domain.executor.MainThreadExecutor;
import com.example.sergiomoral.rss_feed.presentation.executor.InteractorExecutorImp;
import com.example.sergiomoral.rss_feed.presentation.executor.MainThreadExecutorImp;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ExecutorModule {

    @Provides
    @Singleton
    public InteractorExecutor providesInteractroExecutor(InteractorExecutorImp interactorExecutorImp) {
        return interactorExecutorImp;
    }

    @Provides
    @Singleton
    public MainThreadExecutor providesPostExecutionThread(MainThreadExecutorImp mainThreadImp) {
        return mainThreadImp;
    }

    @Provides
    public Handler provideHandler(){
        return new Handler(Looper.getMainLooper());
    }

}
