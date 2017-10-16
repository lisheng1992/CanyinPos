package com.canyinpos.mvp.ui.dialog.listener;

/**
 * 作者：Hao on 2017/10/13 16:27
 * 邮箱：shengxuan@izjjf.cn
 */

public abstract class DialogUIItemListener {
    /**
     * item点击事件
     */
    public abstract void onItemClick(CharSequence text, int position);

    /**
     * 底部点击事件
     */
    public void onBottomBtnClick() {
    }
}
