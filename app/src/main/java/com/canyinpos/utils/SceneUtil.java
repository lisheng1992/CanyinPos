package com.canyinpos.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.canyinpos.R;
import com.canyinpos.mvp.ui.activities.base.BaseActivity;

/**
 * 作者：Hao on 2017/8/24 20:09
 * 邮箱：shengxuan@izjjf.cn
 */

public class SceneUtil {
    /**
     * 场景切换
     * @param context
     * @param target
     * @param data
     */
    public static void toScene(Context context, Class<? extends Activity> target, Bundle data) {
        Intent intent = new Intent();
        intent.setClass(context, target);
        if (data != null) {
            intent.putExtras(data);
        }
        context.startActivity(intent);
        if (context instanceof BaseActivity) {
            ((Activity) context).overridePendingTransition(R.anim.b_enter_anim, R.anim.translate_out);
        }
    }

    /**
     * 返回场景切换数据
     * @param activity
     * @param target
     * @param data
     * @param requestCode
     */
    public static void toSceneForResult(Activity activity, Class<? extends Activity> target, Bundle data, int requestCode) {
        Intent intent = new Intent();
        intent.setClass(activity, target);
        if (data != null) {
            intent.putExtras(data);
        }
        activity.startActivityForResult(intent, requestCode);
        if (activity instanceof BaseActivity) {
            activity.overridePendingTransition(R.anim.b_enter_anim, R.anim.translate_out);
        }
    }
}
