package com.canyinpos.mvp.ui.activities;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.canyinpos.R;
import com.canyinpos.mvp.adapter.FragmentAdapter;
import com.canyinpos.mvp.ui.activities.base.BaseActivity;
import com.canyinpos.mvp.ui.fragments.AllGoodsFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import library.ntb.NavigationTabBar;

/**
 * 作者：Hao on 2017/8/24 17:57
 * 邮箱：shengxuan@izjjf.cn
 */

public class GoodsManageActivity extends BaseActivity {

    @BindView(R.id.goods_manage_tb)
    NavigationTabBar mGoodsManageTb;
    @BindView(R.id.goods_manage_vp)
    ViewPager mGoodsManageVp;

    private List<Fragment> mFragments;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_goods_manage;
    }

    @Override
    public void initData() {
        initView();
    }

    private void initView() {
        initViewPage();
        initNavigationTabModel();
    }

    private void initNavigationTabModel() {
        final ArrayList<NavigationTabBar.Model> models = new ArrayList<>();
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.all_goods),
                        getResources().getColor(R.color.little_red))
                        .title("全部商品")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.goods_combo),
                        getResources().getColor(R.color.little_red))
                        .title("套餐")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.goods_flavor),
                        getResources().getColor(R.color.little_red))
                        .title("口味")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.goods_spec),
                        getResources().getColor(R.color.little_red))
                        .title("规格")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.jialiao),
                        getResources().getColor(R.color.little_red))
                        .title("加料")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.zuofa),
                        getResources().getColor(R.color.little_red))
                        .title("做法")
                        .build()
        );
        mGoodsManageTb.setModels(models);
        mGoodsManageTb.setViewPager(mGoodsManageVp, 0);
    }

    private void initViewPage() {
        mFragments = new ArrayList<>();
        mFragments.add(new AllGoodsFragment());
        mFragments.add(new AllGoodsFragment());
        mFragments.add(new AllGoodsFragment());
        mFragments.add(new AllGoodsFragment());
        mFragments.add(new AllGoodsFragment());
        mFragments.add(new AllGoodsFragment());
        mGoodsManageVp.setAdapter(new FragmentAdapter(getSupportFragmentManager(),mFragments));
    }
}
