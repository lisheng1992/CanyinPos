package com.canyinpos.mvp.ui.activities;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.TextView;

import com.canyinpos.R;
import com.canyinpos.mvp.adapter.FragmentAdapter;
import com.canyinpos.mvp.ui.activities.base.BaseActivity;
import com.canyinpos.mvp.ui.fragments.ClassifyDiscountFragment;
import com.canyinpos.mvp.ui.fragments.RandomDiscountFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import library.ntb.NavigationTabBar;

/**
 * 作者：Hao on 2017/9/21 19:33
 * 邮箱：shengxuan@izjjf.cn
 */

public class DiscountManageActivity extends BaseActivity {
    @BindView(R.id.back_tv)
    TextView mBackTv;
    @BindView(R.id.discount_manage_tb)
    NavigationTabBar mDiscountManageTb;
    @BindView(R.id.discount_manage_vp)
    ViewPager mDiscountManageVp;

    private List<Fragment> mFragments;
    @Override
    public int getLayoutId() {
        return R.layout.activity_discount_manage;
    }

    @Override
    public void initData() {
        initViewPage();
        initNavigationTabModel();
    }


    private void initNavigationTabModel(){
        final ArrayList<NavigationTabBar.Model> models = new ArrayList<>();
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.zhekou),
                        getResources().getColor(R.color.little_red))
                        .title("分类折扣")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.lijian),
                        getResources().getColor(R.color.little_red))
                        .title("随机立减")
                        .build()
        );
        /*models.add(
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
        );*/
        mDiscountManageTb.setModels(models);
        mDiscountManageTb.setViewPager(mDiscountManageVp, 0);
    }

    private void initViewPage() {
        mFragments = new ArrayList<>();
        mFragments.add(new ClassifyDiscountFragment());
        mFragments.add(new RandomDiscountFragment());
        mDiscountManageVp.setAdapter(new FragmentAdapter(getSupportFragmentManager(),mFragments));
    }
}
