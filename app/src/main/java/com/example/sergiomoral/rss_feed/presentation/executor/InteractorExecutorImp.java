package com.example.sergiomoral.rss_feed.presentation.executor;

import android.support.annotation.NonNull;

import com.arasthel.asyncjob.AsyncJob;
import com.example.sergiomoral.rss_feed.domain.executor.InteractorExecutor;
import com.example.sergiomoral.rss_feed.domain.interactor.BaseInteractor;

import java.io.Serializable;

import javax.inject.Inject;

public class InteractorExecutorImp implements InteractorExecutor, Serializable {

    @Inject
    public InteractorExecutorImp() {

    }

    @Override
    public void execute(@NonNull final BaseInteractor baseInteractor) {
        AsyncJob.doInBackground(new AsyncJob.OnBackgroundJob() {
            @Override
            public void doOnBackground() {
                baseInteractor.run();
            }
        });
    }
}
