package com.canyinpos.mvp.ui.activities;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.TextView;

import com.canyinpos.R;
import com.canyinpos.mvp.adapter.FragmentAdapter;
import com.canyinpos.mvp.ui.activities.base.BaseActivity;
import com.canyinpos.mvp.ui.fragments.AllSalesFragment;
import com.canyinpos.mvp.ui.fragments.FlavorFragment;
import com.canyinpos.mvp.ui.fragments.OperateAnalyzeFragemnt;
import com.canyinpos.mvp.ui.fragments.SalesRankFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import library.ntb.NavigationTabBar;

/**
 * 作者：Hao on 2017/10/9 14:51
 * 邮箱：shengxuan@izjjf.cn
 * 数据分析
 */

public class DataAnalysisActivity extends BaseActivity {
    @BindView(R.id.back_tv)
    TextView mBackTv;
    @BindView(R.id.data_print_iv)
    ImageView mDataPrintIv;
    @BindView(R.id.data_analysis_tb)
    NavigationTabBar mDataAnalysisTb;
    @BindView(R.id.data_analysis_vp)
    ViewPager mDataAnalysisVp;

    private List<Fragment> mFragments;

    @Override
    public int getLayoutId() {
        return R.layout.activity_data_analysis;
    }

    @Override
    public void initData() {
        initNavigationTabModel();
        initViewPage();
    }

    @Override
    public void initPresenter() {

    }

    private void initNavigationTabModel() {
        final ArrayList<NavigationTabBar.Model> models = new ArrayList<>();
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.all_goods),
                        getResources().getColor(R.color.little_red))
                        .title("收银汇总")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.goods_combo),
                        getResources().getColor(R.color.little_red))
                        .title("运营分析")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.goods_flavor),
                        getResources().getColor(R.color.little_red))
                        .title("销售排行")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.goods_spec),
                        getResources().getColor(R.color.little_red))
                        .title("销售记录")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.jialiao),
                        getResources().getColor(R.color.little_red))
                        .title("退货记录")
                        .build()
        );
        mDataAnalysisTb.setModels(models);
        mDataAnalysisTb.setViewPager(mDataAnalysisVp, 0);
    }

    private void initViewPage() {
        mFragments = new ArrayList<>();
        mFragments.add(new AllSalesFragment());
        mFragments.add(new OperateAnalyzeFragemnt());
        mFragments.add(new SalesRankFragment());
        mFragments.add(new FlavorFragment());
        mFragments.add(new FlavorFragment());
        mDataAnalysisVp.setAdapter(new FragmentAdapter(getSupportFragmentManager(),mFragments));
    }

}
