package com.example.sergiomoral.rss_feed.presentation.base;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.MenuRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sergiomoral.rss_feed.presentation.RssApp;
import com.example.sergiomoral.rss_feed.presentation.di.componentes.AppComponent;
import com.example.sergiomoral.rss_feed.presentation.di.modules.ActivityModule;
import com.example.sergiomoral.rss_feed.presentation.dialogs.DialogManager;

import javax.inject.Inject;

import butterknife.ButterKnife;

public abstract class BaseFragment extends Fragment implements BaseView {

    @Inject
    DialogManager mDialogManager;

    private static final String TAG = "BaseFragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);

        if (getLayoutId() != 0) {
            view = inflater.inflate(getLayoutId(), container, false);
            ButterKnife.bind(this, view);
        }

        initInjector();
        attachViewToPresenter();
        initUI();
        return view;
    }

    protected abstract void initInjector();

    protected abstract int getLayoutId();

    protected abstract void initUI();

    protected abstract void attachViewToPresenter();

    public abstract int getFragmentTitleRes();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void showLoading() {
        //mDialogManager.showLoading();
    }

    @Override
    public void hideLoading() {
        //mDialogManager.hideLoading();
    }


    protected AppComponent getAppComponent() {
        return ((RssApp) getActivity().getApplication()).getAppComponent();
    }

    protected ActivityModule getActivityModule() {
        return new ActivityModule(getActivity());
    }

    public interface OnFragmentViewListener {
        void onFragmentViewCreated(BaseFragment fragment);
    }
}
