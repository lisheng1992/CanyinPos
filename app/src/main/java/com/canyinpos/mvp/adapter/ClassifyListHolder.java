package com.canyinpos.mvp.adapter;

import android.support.annotation.LayoutRes;
import android.view.ViewGroup;

import com.canyinpos.R;
import com.canyinpos.mvp.bean.ClassifyBean;

import easyrecyclerview.adapter.BaseViewHolder;

/**
 * 作者：Hao on 2017/8/31 10:36
 * 邮箱：shengxuan@izjjf.cn
 */

public class ClassifyListHolder extends BaseViewHolder<ClassifyBean> {
    public ClassifyListHolder(ViewGroup parent, @LayoutRes int res) {
        super(parent, res);
    }

    @Override
    public void setData(ClassifyBean data, int position) {
        super.setData(data, position);
        setText(R.id.classify_tv,data.getClassifyName());
    }
}
