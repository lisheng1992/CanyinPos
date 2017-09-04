package com.canyinpos.utils;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * 作者：Hao on 2017/8/23 14:22
 * 邮箱：shengxuan@izjjf.cn
 */

public class KeyboardUtil {
    private Context context;

    public KeyboardUtil(Context context) {
        super();
        this.context = context;
    }
    /**
     * @param readOnly
     * @param objs
     */
    public void dismissKeyboardReadonly(boolean readOnly,View... objs) {
        InputMethodManager manager = (InputMethodManager)context.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (objs != null) {
            for (View view : objs) {
                manager.hideSoftInputFromWindow(view.getWindowToken(), 0);
                if (readOnly) {
                    view.setEnabled(false);
                }
            }
        }
    }

    public void dissmissKeyboard(View... objs) {
        dismissKeyboardReadonly(false, objs);
    }

    /**
     * @param objs
     */
    public void clearfocusKeyboard(View... objs) {
        if (objs != null) {
            for (View view : objs) {
                view.clearFocus();
            }
        }
    }
}
