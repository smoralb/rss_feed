package com.example.sergiomoral.rss_feed.presentation.ui.main;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.TextView;

import com.example.sergiomoral.rss_feed.R;
import com.example.sergiomoral.rss_feed.domain.entities.Wrapper;
import com.example.sergiomoral.rss_feed.presentation.base.BaseActivity;
import com.example.sergiomoral.rss_feed.presentation.base.BaseFragment;
import com.example.sergiomoral.rss_feed.presentation.ui.feedlist.FeedListFragment;
import com.example.sergiomoral.rss_feed.presentation.ui.main.manager.ManagerView;
import com.example.sergiomoral.rss_feed.utils.Constants;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements MainView, ManagerView, BaseFragment.OnFragmentViewListener {

    @BindView(R.id.tv_title_name)
    TextView mTootlbarTitle;

    private static final String TAG = "MainActivity";

    public static void open(Context context, Wrapper response) {
        Log.d(TAG, "open: MainActivity");
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra(Constants.NEWS, response);
        context.startActivity(intent);
    }

    @Override
    protected void attachViewToPresenter() {

    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected void initUI() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void loadFeedList() {
        // TODO: 13/11/2018 Seteo el fragment inicial
        FeedListFragment feedListFragment;
    }


    @Override
    public void onFragmentViewCreated(BaseFragment fragment) {
        int fragmentTitle = fragment.getFragmentTitleRes();
        if (fragmentTitle != 0) {
            mTootlbarTitle.setText(fragmentTitle);
        }
    }
}
