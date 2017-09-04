package com.canyinpos.mvp.ui.dialog;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupWindow;

import java.util.List;

/**
 * 作者：Hao on 2017/8/31 09:38
 * 邮箱：shengxuan@izjjf.cn
 */

public abstract class BasePopupWindowForListView<T> extends PopupWindow {
    /**
     * 布局文件的最外层View
     */
    protected View mContentView;
    protected Context mContext;
    /**
     * ListView的数据集
     */
    protected List<T> mDatas;

    public BasePopupWindowForListView(View contentView, int width, int height, boolean focusable) {
        this(contentView, width, height, focusable, null);
    }

    public BasePopupWindowForListView(View contentView, int width, int height, boolean focusable, List<T> mDatas) {
        this(contentView, width, height, focusable, mDatas, new Object[0]);

    }

    public BasePopupWindowForListView(View contentView, int width, int height,
                                      boolean focusable, List<T> mDatas, Object... params){
        super(contentView, width, height, focusable);
        this.mContentView = contentView;
        this.mContext = mContentView.getContext();
        this.mDatas = mDatas;
        if (params != null && params.length > 0) {
            beforeInitWeNeedSomeParams(params);
        }
        setBackgroundDrawable(new BitmapDrawable());
        setTouchable(true);
        setOutsideTouchable(true);
        setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_OUTSIDE)
                {
                    dismiss();
                    return true;
                }
                return false;
            }
        });
        initViews();
        initEvents();
        init();
    }
    protected abstract void beforeInitWeNeedSomeParams(Object... params);

    public abstract void initViews();

    public abstract void initEvents();

    public abstract void init();

    public View findViewById(int id) {
        return mContentView.findViewById(id);
    }
}
