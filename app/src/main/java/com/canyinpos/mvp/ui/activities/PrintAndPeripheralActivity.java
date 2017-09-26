package com.canyinpos.mvp.ui.activities;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.canyinpos.R;
import com.canyinpos.mvp.adapter.FragmentAdapter;
import com.canyinpos.mvp.ui.activities.base.BaseActivity;
import com.canyinpos.mvp.ui.fragments.AllSalesFragment;
import com.canyinpos.mvp.ui.fragments.QianTaiTicketFragment;
import com.canyinpos.mvp.ui.fragments.SetPrinterFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import library.ntb.NavigationTabBar;

/**
 * 作者：Hao on 2017/9/21 20:05
 * 邮箱：shengxuan@izjjf.cn
 * 打印与外设管理
 */

public class PrintAndPeripheralActivity extends BaseActivity {
    @BindView(R.id.print_peripheral_tb)
    NavigationTabBar mPrintPeripheralTb;
    @BindView(R.id.print_peripheral_vp)
    ViewPager mPrintPeripheralVp;

    private List<Fragment> mFragments;
    @Override
    public int getLayoutId() {
        return R.layout.activity_print_peripheral;
    }

    @Override
    public void initData() {
        initViewPage();
        initNavigationTabModel();
    }

    private void initNavigationTabModel() {
        final ArrayList<NavigationTabBar.Model> models = new ArrayList<>();
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.print_usb),
                        getResources().getColor(R.color.little_red))
                        .title("打印机")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.qiantai_ticket),
                        getResources().getColor(R.color.little_red))
                        .title("前台小票")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.houchu_ticket),
                        getResources().getColor(R.color.little_red))
                        .title("后厨小票")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.houchu_ticket),
                        getResources().getColor(R.color.little_red))
                        .title("标价签")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.qiantai_ticket),
                        getResources().getColor(R.color.little_red))
                        .title("会员充值")
                        .build()
        );
        mPrintPeripheralTb.setModels(models);
        mPrintPeripheralTb.setViewPager(mPrintPeripheralVp, 0);
    }

    private void initViewPage() {
        mFragments = new ArrayList<>();
        mFragments.add(new SetPrinterFragment());
        mFragments.add(new QianTaiTicketFragment());
        mFragments.add(new AllSalesFragment());
        mFragments.add(new QianTaiTicketFragment());
        mFragments.add(new QianTaiTicketFragment());
        mPrintPeripheralVp.setAdapter(new FragmentAdapter(getSupportFragmentManager(),mFragments));
    }
}
