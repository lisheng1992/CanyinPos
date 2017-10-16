package com.canyinpos.mvp.ui.dialog.listener;

import android.content.Context;
import android.view.Gravity;

import com.canyinpos.mvp.ui.dialog.bean.BuildBean;
import com.canyinpos.mvp.ui.dialog.config.DialogConfig;

/**
 * 作者：Hao on 2017/10/16 15:09
 * 邮箱：shengxuan@izjjf.cn
 */

public class DialogAssigner implements Assignable {

    private static DialogAssigner mDialogAssigner;

    private DialogAssigner(){}

    public static DialogAssigner getInstance() {
        if (mDialogAssigner == null) {
            synchronized (DialogAssigner.class){
                if (mDialogAssigner == null) {
                    mDialogAssigner = new DialogAssigner();
                }
            }
        }
        return mDialogAssigner;
    }

    @Override
    public BuildBean assignMdAlert(Context context, CharSequence title, CharSequence msg, boolean cancelable, boolean outsideTouchable, DialogUIListener uiListener) {
        BuildBean buildBean = new BuildBean();
        buildBean.mContext = context;
        buildBean.title = title;
        buildBean.message = msg;
        buildBean.gravity = Gravity.CENTER;
        buildBean.cancelable = cancelable;
        buildBean.outsideTouchable = outsideTouchable;
        buildBean.mUIListener = uiListener;
        buildBean.dialogType = DialogConfig.TYPE_MD_ALERT;
        return buildBean;
    }

    @Override
    public BuildBean assignSingleChoose(Context context, CharSequence title, int defaultChoose, CharSequence[] words, boolean cancelable, boolean outsideTouchable, DialogUIItemListener uiItemListener) {
        BuildBean buildBean = new BuildBean();
        buildBean.title = title;
        buildBean.defaultChosen = defaultChoose;
        buildBean.gravity = Gravity.CENTER;
        buildBean.wordsMd = words;
        buildBean.cancelable = cancelable;
        buildBean.outsideTouchable = outsideTouchable;
        buildBean.mUIItemListener = uiItemListener;
        buildBean.dialogType = DialogConfig.TYPE_SINGLE_CHOOSE;
        return buildBean;
    }

    @Override
    public BuildBean assignMdMultiChoose(Context context, CharSequence title, CharSequence[] words, boolean[] checkedItems, boolean cancelable, boolean outsideTouchable, DialogUIListener uiListener) {
        BuildBean buildBean = new BuildBean();
        buildBean.title = title;
        buildBean.wordsMd = words;
        buildBean.checkedItems = checkedItems;
        buildBean.gravity = Gravity.CENTER;
        buildBean.cancelable = cancelable;
        buildBean.outsideTouchable = outsideTouchable;
        buildBean.mUIListener = uiListener;
        buildBean.dialogType = DialogConfig.TYPE_MD_MULTI_CHOOSE;
        return buildBean;
    }
}
