package com.example.sergiomoral.rss_feed.domain.interactor;

import com.example.sergiomoral.rss_feed.domain.entities.Wrapper;
import com.example.sergiomoral.rss_feed.domain.executor.InteractorExecutor;
import com.example.sergiomoral.rss_feed.domain.executor.MainThreadExecutor;
import com.example.sergiomoral.rss_feed.domain.repository.Repository;
import com.example.sergiomoral.rss_feed.utils.Constants;

import javax.inject.Inject;

public class GetNewsInteractor extends BaseInteractor{

    private Repository mRepository;
    private Callback<Wrapper> mCallBack;

    @Inject
    public GetNewsInteractor(InteractorExecutor mInteractorExecutor, MainThreadExecutor mMainThreadExecutor, Repository repository) {
        super(mInteractorExecutor, mMainThreadExecutor);
        this.mRepository = repository;
    }

    public void execute(Callback<Wrapper> callback) {

        mCallBack = callback;

        executeInBackground();
    }

    @Override
    public void run() {
        try {
            Wrapper publicRepositories = mRepository.getNews(Constants.RSS_FEED);
            notifySuccess(publicRepositories);
        } catch (Exception e) {
            notifyError(e);
        }
    }

    private void notifySuccess(final Wrapper wrapper) {

        executeInMainThread(new Runnable() {
            @Override
            public void run() {
                if (mCallBack != null) {
                    mCallBack.onSuccess(wrapper);
                }
            }
        });
    }

    private void notifyError(final Exception exception) {

        executeInMainThread(new Runnable() {
            @Override
            public void run() {
                if (mCallBack != null) {
                    mCallBack.onError(exception);
                }
            }
        });
    }
}
