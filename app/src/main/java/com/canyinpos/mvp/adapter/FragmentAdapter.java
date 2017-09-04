package com.canyinpos.mvp.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * 作者：Hao on 2017/8/30 19:45
 * 邮箱：shengxuan@izjjf.cn
 */

public class FragmentAdapter extends FragmentPagerAdapter {
    private List<Fragment> mFragments;
    public FragmentAdapter(FragmentManager fm,List<Fragment> fragments) {
        super(fm);
        this.mFragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }
}
