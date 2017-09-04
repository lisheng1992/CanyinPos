package com.canyinpos.mvp.ui.activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.canyinpos.R;
import com.canyinpos.common.Constant;
import com.canyinpos.listener.StringCallBack;
import com.canyinpos.mvp.adapter.GoodsFragmentPageAdapter;
import com.canyinpos.mvp.bean.ClassifyBean;
import com.canyinpos.mvp.presenter.impl.MainPresenterImpl;
import com.canyinpos.mvp.ui.activities.base.BaseActivity;
import com.canyinpos.mvp.ui.dialog.AllFunctionDialog;
import com.canyinpos.mvp.ui.dialog.ClassifyDialog;
import com.canyinpos.mvp.ui.fragments.GoodsFragment;
import com.canyinpos.mvp.view.MainView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity<MainPresenterImpl> implements MainView,StringCallBack {

    @BindView(R.id.classify_tl)
    TabLayout mClassifyTl;
    @BindView(R.id.add_classify_iv)
    ImageView mAddClassifyIv;
    @BindView(R.id.goods_pager)
    ViewPager mGoodsPager;

    private List<Fragment> mGoodsFragments = new ArrayList<>();
    private List<String> mTitles;
    private ClassifyDialog mClassifyDialog;
    private String mCurrentViewPagerName;

    private AllFunctionDialog mFunctionDialog;
    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initData() {
        mPresenter = new MainPresenterImpl();
        mPresenter.attachView(this);
        mPresenter.getClassifyListFromDb();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void showDialog() {

    }

    @Override
    public void dismissDialog() {

    }

    @Override
    public void initClassify(List<ClassifyBean> mClassifyList) {
        final List<String> titles = new ArrayList<>();
        if (mClassifyList != null) {
            setGoodsList(mClassifyList,titles);
            setViewPage(titles);
        }
    }

    private void setGoodsList(List<ClassifyBean> classifyList, List<String> titles) {
        mGoodsFragments.clear();
        for (ClassifyBean classifyBean:classifyList) {
            GoodsFragment goodsFragment = new GoodsFragment();
            Bundle bundle = new Bundle();
            bundle.putString(Constant.CLASSIFY_NAME,classifyBean.getClassifyName());
            goodsFragment.setArguments(bundle);
            mGoodsFragments.add(goodsFragment);
            titles.add(classifyBean.getClassifyName());
        }
    }

    public void setViewPage(List<String> titles) {
        GoodsFragmentPageAdapter goodsFragmentPageAdapter = new GoodsFragmentPageAdapter(
                getSupportFragmentManager(),titles,mGoodsFragments);
        mGoodsPager.setAdapter(goodsFragmentPageAdapter);
        mClassifyTl.setupWithViewPager(mGoodsPager);
        setPageChangeListener();
        mTitles = titles;
        int currentViewPagerPosition = getCurrentViewPagerPosition();
        mGoodsPager.setCurrentItem(currentViewPagerPosition, false);
    }

    private int getCurrentViewPagerPosition() {
        int position = 0;
        if (mCurrentViewPagerName != null) {
            for (int i = 0; i < mTitles.size(); i++) {
                if (mCurrentViewPagerName.equals(mTitles.get(i))) {
                    position = i;
                }
            }
        }
        return position;
    }

    private void setPageChangeListener() {
        mGoodsPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
                mCurrentViewPagerName = mTitles.get(position);
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    @Override
    public void stringCallBack(String text) {
        ClassifyBean classifyBean = new ClassifyBean();
        classifyBean.setClassifyName(text);
        classifyBean.save();
        mPresenter.getClassifyListFromDb();
    }

    /**
     * 点击事件处理
     */
    @OnClick({R.id.add_classify_iv,R.id.all_function_tv})
    public void click(View v) {
        switch (v.getId()){
            case R.id.add_classify_iv:
                if (mClassifyDialog == null) {
                    mClassifyDialog = new ClassifyDialog();
                    mClassifyDialog.setStringCallBack(this);
                }
                mClassifyDialog.show(getSupportFragmentManager(),"classify");
                break;
            case R.id.all_function_tv:
                if (mFunctionDialog == null) {
                    mFunctionDialog = new AllFunctionDialog();
                }
                mFunctionDialog.show(getSupportFragmentManager(),"function");
                break;
        }
    }

}
