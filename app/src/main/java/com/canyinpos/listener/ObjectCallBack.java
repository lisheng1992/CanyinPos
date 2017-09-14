package com.canyinpos.listener;

/**
 * 作者：Hao on 2017/9/8 17:54
 * 邮箱：shengxuan@izjjf.cn
 */

public interface ObjectCallBack<T> {
    void callback(T t);
    void callbackWithPosition(T t,int position);
}
