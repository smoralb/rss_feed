package com.example.sergiomoral.rss_feed.presentation.presenter.splash;

import android.util.Log;

import com.example.sergiomoral.rss_feed.domain.entities.Wrapper;
import com.example.sergiomoral.rss_feed.domain.interactor.BaseInteractor;
import com.example.sergiomoral.rss_feed.domain.interactor.GetNewsInteractor;
import com.example.sergiomoral.rss_feed.presentation.dialogs.DialogManager;
import com.example.sergiomoral.rss_feed.presentation.presenter.Presenter;
import com.example.sergiomoral.rss_feed.presentation.ui.splash.SplashView;

import javax.inject.Inject;

public class SplashPresenter implements Presenter<SplashView> {

    @Inject
    DialogManager mDialogManager;

    private SplashView mView;
    private GetNewsInteractor mInteractor;
    private static final String TAG = "SplashPresenter";

    @Inject
    public SplashPresenter(GetNewsInteractor mInteractor) {
        Log.d(TAG, "SplashPresenter: ");
        this.mInteractor = mInteractor;
    }

    @Override
    public void attachView(SplashView view) {
        this.mView = view;
    }

    public void getNews() {
        Log.d(TAG, "getNews: ");
        mInteractor.execute(new BaseInteractor.Callback<Wrapper>() {
            @Override
            public void onSuccess(Wrapper response) {
                mView.showFeed(response);
            }

            @Override
            public void onError(Exception exception) {
                // TODO: 13/11/2018 Mostrar error
                //mDialogManager.showErrorMessage();
            }
        });
    }
}
