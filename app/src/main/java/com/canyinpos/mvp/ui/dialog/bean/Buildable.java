package com.canyinpos.mvp.ui.dialog.bean;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import com.canyinpos.mvp.ui.dialog.config.DialogConfig;

/**
 * 作者：Hao on 2017/10/13 16:15
 * 邮箱：shengxuan@izjjf.cn
 */

public class Buildable {

    protected BuildBean buildByType(BuildBean bean) {
        switch (bean.dialogType){
            case DialogConfig.TYPE_MD_ALERT:
                buildMdAlert(bean);
                break;
            case DialogConfig.TYPE_SINGLE_CHOOSE:
                buildSingleChoose(bean);
                break;
            case DialogConfig.TYPE_MD_MULTI_CHOOSE:
                buildMdMultiChoose(bean);
                break;
        }
        return bean;
    }

    protected BuildBean buildMdAlert(final BuildBean bean){
        AlertDialog.Builder builder = new AlertDialog.Builder(bean.mContext);
        builder.setTitle(bean.title)
                .setMessage(bean.message)
                .setPositiveButton(bean.sure, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        bean.mUIListener.onPositive();
                        dialog.dismiss();
                    }
                })
                .setNegativeButton(bean.cancle, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        bean.mUIListener.onNegative();
                        dialog.dismiss();
                    }
                })
                .setNegativeButton(bean.neutral, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        bean.mUIListener.onNeutral();
                        dialog.dismiss();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                bean.mUIListener.onCancle();
            }
        });
        bean.mAlertDialog = dialog;
        return bean;
    }

    protected BuildBean buildSingleChoose(final BuildBean bean) {
        AlertDialog.Builder builder = new AlertDialog.Builder(bean.mContext);
        builder.setTitle(bean.title)
                .setSingleChoiceItems(bean.wordsMd, bean.defaultChosen, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (bean.mUIItemListener != null) {
                            bean.mUIItemListener.onItemClick(bean.wordsMd[which],which);
                        }
                        if (bean.mUIListener == null) {
                            dialog.dismiss();
                        }
                    }
                });
        AlertDialog dialog = builder.create();
        bean.mAlertDialog = dialog;
        return bean;
    }

    protected BuildBean buildMdMultiChoose(final BuildBean bean){
        AlertDialog.Builder builder = new AlertDialog.Builder(bean.mContext);
        builder.setTitle(bean.title)
                .setMultiChoiceItems(bean.wordsMd, bean.checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {

                    }
                })
                .setNegativeButton(bean.cancle, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (bean.mUIListener != null) {
                            dialog.dismiss();
                            bean.mUIListener.onNegative();
                        }
                    }
                })
                .setPositiveButton(bean.sure, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (bean.mUIListener != null) {
                            dialog.dismiss();
                            bean.mUIListener.onPositive();
                            bean.mUIListener.onGetChoose(bean.checkedItems);
                        }
                    }
                });
        AlertDialog alertDialog = builder.create();
        bean.mAlertDialog = alertDialog;
        return bean;
    }

}
