package com.canyinpos.mvp.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatDialog;

import com.canyinpos.mvp.ui.dialog.bean.BuildBean;
import com.canyinpos.mvp.ui.dialog.listener.DialogAssigner;
import com.canyinpos.mvp.ui.dialog.listener.DialogUIItemListener;
import com.canyinpos.mvp.ui.dialog.listener.DialogUIListener;

/**
 * 作者：Hao on 2017/10/16 16:34
 * 邮箱：shengxuan@izjjf.cn
 * dialog工具类
 */

public class DialogUIUtils {

    /**
     * 关闭弹出框
     */
    public static void dismiss(DialogInterface... dialogs) {
        if (dialogs != null && dialogs.length > 0) {
            for (DialogInterface dialog:dialogs) {
                if (dialog instanceof Dialog) {
                    Dialog dialog1 = (Dialog)dialog;
                    if (dialog1.isShowing()) {
                        dialog1.dismiss();
                    }
                } else if (dialog instanceof AppCompatDialog) {
                    Dialog dialog2 = (AppCompatDialog)dialog;
                    if (dialog2.isShowing()) {
                        dialog2.dismiss();
                    }
                }
            }
        }
    }

    /**
     * 关闭弹出框
     */
    public static void dismiss(BuildBean buildBean){
        if (buildBean != null) {
            if (buildBean.mAlertDialog != null && buildBean.mAlertDialog.isShowing()) {
                buildBean.mAlertDialog.dismiss();
            }
            if (buildBean.mDialog != null && buildBean.mDialog.isShowing()) {
                buildBean.mDialog.dismiss();
            }
        }
    }

    /**
     *
     * @param context
     * @param title
     * @param message
     * @param listener
     * @return
     */
    public static BuildBean showMdAlert(Context context, CharSequence title, CharSequence message, DialogUIListener listener) {
        return showMdAlert(context,title,message,true,true,listener);
    }

    /**
     *
     * @param context
     * @param title
     * @param message
     * @param cancelable
     * @param outsideTouchable
     * @param listener
     * @return
     */
    public static BuildBean showMdAlert(Context context, CharSequence title,CharSequence message,boolean cancelable,
                                        boolean outsideTouchable,DialogUIListener listener){
        return DialogAssigner.getInstance().assignMdAlert(context,title,message,cancelable,outsideTouchable,listener);
    }

    /**
     * @param context
     * @param title
     * @param words
     * @param defaultChosen
     * @param cancleable
     * @param outsideTouchable
     * @param listener
     * @return
     */
    public static BuildBean showSingleChoose(Context context, CharSequence title, CharSequence[] words, int defaultChosen,
                                             boolean cancelable, boolean outsideTouchable, DialogUIItemListener listener){
        return DialogAssigner.getInstance().assignSingleChoose(context,title,defaultChosen,words,cancelable,outsideTouchable,listener);
    }

    public static BuildBean showSingleChoose(Context context,CharSequence title,int defaultChosen,CharSequence[] words,
                                             DialogUIItemListener listener){
        return showSingleChoose(context,title,words,defaultChosen,true,true,listener);
    }

    /**
     *
     * @param context
     * @param title
     * @param words
     * @param checkedItems
     * @param cancelable
     * @param outsideTouchable
     * @param listener
     * @return
     */
    public static BuildBean showMdMultiChoose(Context context,CharSequence title,CharSequence[] words,boolean[] checkedItems,
                                              boolean cancelable,boolean outsideTouchable,DialogUIListener listener) {
        return DialogAssigner.getInstance().assignMdMultiChoose(context,title,words,checkedItems,cancelable,outsideTouchable,listener);
    }

    public static BuildBean showMdMultiChoose(Context context,CharSequence title,CharSequence[] words,boolean[] checkedItems,
                                              DialogUIListener listener) {
        return showMdMultiChoose(context,title,words,checkedItems,true,true,listener);
    }
}
