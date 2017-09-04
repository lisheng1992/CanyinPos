package com.canyinpos.listener;

import android.support.v7.widget.RecyclerView;

/**
 * 作者：Hao on 2017/8/23 18:24
 * 邮箱：shengxuan@izjjf.cn
 */

public interface ItemTouchHelperAdapter {
    //数据交换
    void onItemMove(int fromPosition, int toPosition);

    //数据删除
    void onItemDissmiss(RecyclerView.ViewHolder source);

    //drag或者swipe选中
    void onItemSelect(RecyclerView.ViewHolder source);

    //状态清除
    void onItemClear(RecyclerView.ViewHolder source);
}
