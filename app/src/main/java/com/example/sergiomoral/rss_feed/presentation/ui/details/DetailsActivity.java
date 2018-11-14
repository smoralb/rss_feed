package com.example.sergiomoral.rss_feed.presentation.ui.details;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.sergiomoral.rss_feed.R;
import com.example.sergiomoral.rss_feed.domain.entities.Item;
import com.example.sergiomoral.rss_feed.presentation.base.BaseActivity;
import com.example.sergiomoral.rss_feed.presentation.di.componentes.DaggerActivityComponent;
import com.example.sergiomoral.rss_feed.presentation.presenter.details.DetailsPresenter;
import com.example.sergiomoral.rss_feed.utils.Constants;
import com.example.sergiomoral.rss_feed.utils.Utils;


import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

public class DetailsActivity extends BaseActivity implements DetailsView {

    private static final String TAG = "DetailsActivity";

    @Inject
    DetailsPresenter mPresenter;

    @BindView(R.id.tv_author_details)
    TextView mAuthor;
    @BindView(R.id.tv_description_details)
    TextView mDescription;
    @BindView(R.id.tv_title_details)
    TextView mTitle;
    @BindView(R.id.iv_thumbnail_details)
    CircleImageView mThumbnail;
    @BindView(R.id.tv_date_details)
    TextView mDate;
    @BindView(R.id.tv_categories_details)
    TextView mCategories;
    @BindView(R.id.iv_search)
    ImageView mSearch;

    private int viewVisibility = 0;

    private Item mItem;
    private ArrayList<String> mCategoriesArrayList;

    public static void open(Context context, Item item) {
        Log.d(TAG, "open: DetailsActivity");
        Intent intent = new Intent(context, DetailsActivity.class);
        intent.putExtra(Constants.ITEM, item);
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

    @Override
    protected void initUI() {
        initParams();
        initVisibility();
    }

    private void initVisibility() {
        mPresenter.viewVisibility(mSearch.getVisibility());
        mSearch.setVisibility(viewVisibility);
    }

    private void initParams() {
        mCategoriesArrayList = new ArrayList<>();
        mItem = getData();
        mAuthor.setText(mItem.getAuthor());
        mDescription.setText(Utils.getDescriptionFormatted(mItem.getDescription()));
        mTitle.setText(mItem.getTitle());
        Glide.with(this)
                .load(mItem.getThubnail())
                .into(mThumbnail);
        mDate.setText(mItem.getDate());
        mCategoriesArrayList.addAll(mItem.getCategories());
        mPresenter.loadCategories(mCategoriesArrayList);
    }

    @OnClick(R.id.iv_link_details)
    public void gotToWebsite() {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(mItem.getLink())));
    }


    @Override
    public int getLayoutId() {
        return R.layout.activity_details;
    }

    private Item getData() {
        return getIntent().getParcelableExtra(Constants.ITEM);
    }

    @Override
    public void showCategories(String categories) {
        mCategories.setText(categories);
    }

    @Override
    public void setVisibility(int drawerVisibility) {
        viewVisibility = drawerVisibility;
    }

    @OnClick(R.id.iv_back)
    public void goBack(){
        finish();
    }
}
