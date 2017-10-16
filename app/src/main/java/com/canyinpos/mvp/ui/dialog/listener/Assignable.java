package com.canyinpos.mvp.ui.dialog.listener;

import android.content.Context;

import com.canyinpos.mvp.ui.dialog.bean.BuildBean;

/**
 * 作者：Hao on 2017/10/16 14:53
 * 邮箱：shengxuan@izjjf.cn
 */

public interface Assignable {

    /**
     * 文字提示框
     */
    BuildBean assignMdAlert(Context context,CharSequence title,CharSequence msg,boolean cancelable,
                            boolean outsideTouchable,final DialogUIListener uiListener);

    /**
     * 单选框
     */
    BuildBean assignSingleChoose(Context context,CharSequence title,final int defaultChoose,final CharSequence[] words,
                                 boolean cancelable,boolean outsideTouchable,final DialogUIItemListener uiItemListener);

    /**
     * 多选框
     */
    BuildBean assignMdMultiChoose(Context context,CharSequence title,final CharSequence[] words,final boolean[] checkedItems,
                                  boolean cancelable,boolean outsideTouchable,final DialogUIListener uiListener);
}
