package com.canyinpos.mvp.ui.activities.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.canyinpos.application.ZmhApplication;
import com.canyinpos.mvp.presenter.base.BasePresenter;
import com.squareup.leakcanary.RefWatcher;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 作者：Hao on 2017/8/22 11:38
 * 邮箱：shengxuan@izjjf.cn
 */

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity {
    public abstract int getLayoutId();

    public abstract void initData();

    public T mPresenter;

    private Unbinder unbinder;

    protected InputMethodManager methodManager;
    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int layoutId = getLayoutId();
        setContentView(layoutId);
        unbinder = ButterKnife.bind(this);
        initData();
        //初始化键盘输入法
        methodManager = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        RefWatcher refWatcher = ZmhApplication.getRefWatcher(this);
        refWatcher.watch(this);
        if(unbinder != null){
            //解除注解绑定
            unbinder.unbind();
            //从栈中移除activity
            //ActManager.getInstances().removeActivity(this);
        }
        if (mPresenter != null) {
            mPresenter.onDestroy();
        }
    }

    public void showProgressDialog() {
        try {
            if (mProgressDialog == null ) {
                mProgressDialog = new ProgressDialog(this);
                mProgressDialog.show();
            } else if (!mProgressDialog.isShowing()) {
                mProgressDialog.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void dismissProgressDialog() {
        try {
            if (mProgressDialog != null && mProgressDialog.isShowing()) {
                mProgressDialog.dismiss();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //隐藏键盘, 并且不再使用
    public void hideInputMethodNeverUse() {
        methodManager.hideSoftInputFromWindow(getWindow().peekDecorView().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }

    //隐藏输入法
    public void hideInputMethod(View v) {
        methodManager.hideSoftInputFromWindow(v.getApplicationWindowToken(), InputMethodManager.RESULT_UNCHANGED_SHOWN);
    }
}
