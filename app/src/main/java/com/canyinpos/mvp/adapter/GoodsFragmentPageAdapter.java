package com.canyinpos.mvp.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：Hao on 2017/8/22 15:08
 * 邮箱：shengxuan@izjjf.cn
 */

public class GoodsFragmentPageAdapter extends FragmentPagerAdapter {
    private final List<String> mTitles;
    private List<Fragment> mGoodsFragmentList = new ArrayList<>();
    public GoodsFragmentPageAdapter(FragmentManager fm,List<String> titles,List<Fragment> goodsFragmentList) {
        super(fm);
        this.mTitles = titles;
        this.mGoodsFragmentList = goodsFragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return mGoodsFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mGoodsFragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles.get(position);
    }
}
