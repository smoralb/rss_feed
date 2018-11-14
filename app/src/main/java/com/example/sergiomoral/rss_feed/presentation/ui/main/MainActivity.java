package com.example.sergiomoral.rss_feed.presentation.ui.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import com.example.sergiomoral.rss_feed.utils.Utils;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements MainView, ItemsAdapter.OnItemListener {

    @Inject
    MainPresenter mPresenter;

    @BindView(R.id.tv_title_name)
    TextView mTootlbarTitle;
    @BindView(R.id.rv_items_list)
    RecyclerView mRecyclerView;
    @BindView(R.id.iv_back)
    ImageView mBack;
    @BindView(R.id.tb_filter)
    LinearLayout mSearchToolbar;
    @BindView(R.id.et_filter)
    EditText mFilter;

    private static final String TAG = "MainActivity";
    private ArrayList<Item> itemsArrayList;
    private Wrapper wrapper;
    private ItemsAdapter mAdapter;
    LinearLayoutManager mLayoutManager;
    private int viewVisibility = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initParams();
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
        initVisibility();
        initFilter();
        initListener();
    }

    private void initParams() {
        itemsArrayList = new ArrayList<>();
        wrapper = getData();
        itemsArrayList.addAll(wrapper.getItems());
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        initData();
    }

    private void initVisibility() {
        mPresenter.viewVisibility(mBack.getVisibility());
        mBack.setVisibility(viewVisibility);
    }

    private void initData() {
        mAdapter = new ItemsAdapter(itemsArrayList, MainActivity.this, this);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void initFilter() {
        mPresenter.filterData(mFilter);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void showDetails(Item item) {
        DetailsActivity.open(this, item);
    }

    @Override
    public void setVisibility(int drawerVisibility) {
        viewVisibility = drawerVisibility;
    }

    @Override
    public void filterList(String data) {
        mPresenter.filterText(itemsArrayList, data);
    }

    @Override
    public void updataData(ArrayList<Item> itemList) {
        mAdapter.filterList(itemList);
    }

    @Override
    public void hideKeyboard() {
        Utils.closeKeyboard(this);
    }

    @OnClick(R.id.iv_search)
    public void filterData() {
        mPresenter.viewVisibility(mSearchToolbar.getVisibility());
        mSearchToolbar.setVisibility(viewVisibility);
    }

    private void initListener() {
        mPresenter.keyBoardListener(mFilter);
    }
}
