package com.canyinpos.mvp.ui.dialog.listener;

/**
 * 作者：Hao on 2017/10/13 16:26
 * 邮箱：shengxuan@izjjf.cn
 */

public abstract class DialogUIListener {
    /**
     * 确定
     */
    public abstract void onPositive();

    /**
     * 否定
     */
    public abstract void onNegative();

    /**
     * 中立
     */
    public void onNeutral() {
    }

    /**
     * 取消
     */
    public void onCancle() {
    }

    /**
     * 获取输入内容
     */
    public void onGetInput(CharSequence input1, CharSequence input2) {
    }

    /**
     * 获取选择集合
     */
    public void onGetChoose(boolean[] states) {

    }
}
