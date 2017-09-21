package com.canyinpos.mvp.ui.fragments;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.canyinpos.R;
import com.canyinpos.mvp.ui.fragments.base.BaseFragment;

import butterknife.BindView;
import easyrecyclerview.EasyRecyclerView;

/**
 * 作者：Hao on 2017/9/20 16:38
 * 邮箱：shengxuan@izjjf.cn
 * 设置副屏广告或视频
 */

public class SetAdvertisementFragment extends BaseFragment {
    @BindView(R.id.ad_toolbar_layout)
    CollapsingToolbarLayout mAdToolbarLayout;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.app_bar)
    AppBarLayout mAppBar;
    @BindView(R.id.picture_erv)
    EasyRecyclerView mPictureErv;
    @BindView(R.id.fab)
    FloatingActionButton mFab;

    @Override
    public void initViews(View view) {
        ((AppCompatActivity) getActivity()).setSupportActionBar(mToolbar);
        mAdToolbarLayout.setTitle("预览广告");
        mAdToolbarLayout.setExpandedTitleColor(ContextCompat.getColor(getActivity(), R.color.little_red));
        mAdToolbarLayout.setCollapsedTitleTextColor(ContextCompat.getColor(getActivity(), R.color.white));
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_set_advertisement;
    }
}
