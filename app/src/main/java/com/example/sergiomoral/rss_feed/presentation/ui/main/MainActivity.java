package com.example.sergiomoral.rss_feed.presentation.ui.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.example.sergiomoral.rss_feed.R;
import com.example.sergiomoral.rss_feed.domain.entities.Item;
import com.example.sergiomoral.rss_feed.domain.entities.Wrapper;
import com.example.sergiomoral.rss_feed.presentation.base.BaseActivity;
import com.example.sergiomoral.rss_feed.presentation.di.componentes.DaggerActivityComponent;
import com.example.sergiomoral.rss_feed.presentation.presenter.main.MainPresenter;
import com.example.sergiomoral.rss_feed.presentation.ui.details.DetailsActivity;
import com.example.sergiomoral.rss_feed.presentation.ui.main.adapter.ItemsAdapter;
import com.example.sergiomoral.rss_feed.utils.Constants;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements MainView, ItemsAdapter.OnItemListener {

    @Inject
    MainPresenter mPresenter;

    @BindView(R.id.tv_title_name)
    TextView mTootlbarTitle;
    @BindView(R.id.rv_items_list)
    RecyclerView mRecyclerView;

    private static final String TAG = "MainActivity";
    private ArrayList<Item> itemsArrayList;
    private Wrapper wrapper;
    private ItemsAdapter mAdapter;
    LinearLayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public static void open(Context context, Wrapper response) {
        Log.d(TAG, "open: MainActivity");
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra(Constants.NEWS, response);
        context.startActivity(intent);
    }

    @Override
    protected void attachViewToPresenter() {
        mPresenter.attachView(this);
    }

    @Override
    protected void initInjector() {
        DaggerActivityComponent.builder()
                .appComponent(getAppComponent())
                .activityModule(getActivityModule())
                .build().inject(this);
    }

    private Wrapper getData() {
        return getIntent().getParcelableExtra(Constants.NEWS);
    }

    @Override
    protected void initUI() {
        initData();
    }

    private void initData() {
        itemsArrayList = new ArrayList<>();
        wrapper = getData();
        itemsArrayList.addAll(wrapper.getItems());
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new ItemsAdapter(itemsArrayList, MainActivity.this, this);
        mRecyclerView.setAdapter(mAdapter);

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }


    @Override
    public void showDetails(Item item) {
        DetailsActivity.open(this, item);
    }
}
