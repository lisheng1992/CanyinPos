package com.canyinpos.mvp.presenter.base;

import android.support.annotation.NonNull;

import com.canyinpos.mvp.view.BaseView;

/**
 * 作者：Hao on 2017/8/22 11:53
 * 邮箱：shengxuan@izjjf.cn
 */

public interface BasePresenter {
    void onCreate();

    void attachView(@NonNull BaseView view);

    void onDestroy();
}
