package com.canyinpos.mvp.presenter.base;

import android.support.annotation.NonNull;

import com.canyinpos.listener.RequestCallBack;
import com.canyinpos.mvp.bean.BaseResponse;
import com.canyinpos.mvp.view.BaseView;

/**
 * 作者：Hao on 2017/8/22 11:56
 * 邮箱：shengxuan@izjjf.cn
 */

public class BasePresenterImpl<T extends BaseView,E> implements BasePresenter,RequestCallBack<E> {
    protected T mView;
    public boolean isShowDialog = true;
    @Override
    public void onCreate() {

    }

    @Override
    public void attachView(@NonNull BaseView view) {

        mView = (T) view;
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onStart() {
        if (isShowDialog) {
            mView.showDialog();
        }
    }

    @Override
    public void onCompleted() {
        if (isShowDialog) {
            mView.dismissDialog();
        }
    }

    @Override
    public void onError(Throwable e) {
        if (isShowDialog) {
            mView.dismissDialog();
        }
    }

    @Override
    public void onSuccess(E response) {

    }

    @Override
    public void onFail(BaseResponse baseResponse) {

    }
}
