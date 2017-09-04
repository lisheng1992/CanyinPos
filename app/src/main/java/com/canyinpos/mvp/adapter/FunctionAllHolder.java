package com.canyinpos.mvp.adapter;

import android.support.annotation.LayoutRes;
import android.view.ViewGroup;

import com.canyinpos.R;
import com.canyinpos.mvp.bean.FunctionBean;

import easyrecyclerview.adapter.BaseViewHolder;

/**
 * 作者：Hao on 2017/8/24 15:30
 * 邮箱：shengxuan@izjjf.cn
 */

public class FunctionAllHolder extends BaseViewHolder<FunctionBean> {
    public FunctionAllHolder(ViewGroup parent, @LayoutRes int res) {
        super(parent, res);
    }

    @Override
    public void setData(FunctionBean data, int position) {
        super.setData(data, position);
        setText(R.id.function_tv,data.getFunctionName());
        setImageResource(R.id.function_iv,data.getFunctionImg());
    }
}
