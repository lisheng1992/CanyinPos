package com.canyinpos.mvp.ui.dialog.bean;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.view.View;

import com.canyinpos.mvp.ui.dialog.config.DialogConfig;
import com.canyinpos.mvp.ui.dialog.listener.DialogUIItemListener;
import com.canyinpos.mvp.ui.dialog.listener.DialogUIListener;

/**
 * 作者：Hao on 2017/10/13 15:08
 * 邮箱：shengxuan@izjjf.cn
 */

public class BuildBean extends Buildable{
    public Context mContext;
    /**
     * dialog类型
     */
    public int dialogType;

    public View coustomView;
    public int viewHeight;
    public int gravity;

    public CharSequence title;
    public CharSequence message;
    public CharSequence cancle = DialogConfig.DIALOG_CANCLE;
    public CharSequence sure = DialogConfig.DIALOG_SURE;
    public CharSequence neutral;
    public CharSequence otherText;
    public CharSequence hint1;
    public CharSequence hint2;

    public DialogUIListener mUIListener;
    public DialogUIItemListener mUIItemListener;

    /**
     * 是否是白色背景
     */
    public boolean isWhiteBg = true;
    /**
     * 是否可以取消
     */
    public boolean cancelable = true;
    /**
     * 面板外是否可以点击
     */
    public boolean outsideTouchable = true;

    public Dialog mDialog;
    public AlertDialog mAlertDialog;

    //列表文字
    public CharSequence[] wordsMd;
    public int defaultChosen;
    public boolean[] checkedItems;

    public Dialog show() {
        buildByType(this);
        if (mAlertDialog != null && !mAlertDialog.isShowing()) {
            try {
                mAlertDialog.show();
            } catch (Exception e){
                e.printStackTrace();
            }
            return mAlertDialog;
        }
        return null;
    }
}
