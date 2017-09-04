package com.canyinpos.listener;

import com.canyinpos.mvp.bean.BaseResponse;

/**
 * 作者：Hao on 2017/8/22 11:58
 * 邮箱：shengxuan@izjjf.cn
 */

public interface RequestCallBack<T> {
    void onStart();

    void onCompleted();

    void onError(Throwable e);

    void onSuccess(T response);

    void onFail(BaseResponse baseResponse);
}
