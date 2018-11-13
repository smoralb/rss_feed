package com.example.sergiomoral.rss_feed.domain.interactor;

import com.example.sergiomoral.rss_feed.domain.executor.InteractorExecutor;
import com.example.sergiomoral.rss_feed.domain.executor.MainThreadExecutor;

public abstract class BaseInteractor {

    private final InteractorExecutor mInteractorExecutor;
    private final MainThreadExecutor mMainThreadExecutor;

    public BaseInteractor(InteractorExecutor mInteractorExecutor, MainThreadExecutor mMainThreadExecutor) {
        this.mInteractorExecutor = mInteractorExecutor;
        this.mMainThreadExecutor = mMainThreadExecutor;
    }

    protected void executeInBackground() {
        mInteractorExecutor.execute(this);
    }

    protected void executeInMainThread(Runnable runnable) {
        mMainThreadExecutor.execute(runnable);
    }

    public abstract void run();

    public interface Callback<T> {

        void onSuccess(T response);

        void onError(Exception exception);

    }

}
