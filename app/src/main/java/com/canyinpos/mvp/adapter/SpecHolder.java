package com.canyinpos.mvp.adapter;

import android.support.annotation.LayoutRes;
import android.view.ViewGroup;

import com.canyinpos.R;
import com.canyinpos.common.Constant;
import com.canyinpos.mvp.bean.GoodsSpecBean;
import com.canyinpos.utils.DateUtils;

import easyrecyclerview.adapter.BaseViewHolder;

/**
 * 作者：Hao on 2017/9/9 15:46
 * 邮箱：shengxuan@izjjf.cn
 */

public class SpecHolder extends BaseViewHolder<GoodsSpecBean> {
    public SpecHolder(ViewGroup parent, @LayoutRes int res) {
        super(parent, res);
    }

    @Override
    public void setData(GoodsSpecBean data, int position) {
        super.setData(data, position);
        setText(R.id.flavor_name_tv,data.getName());
        switch (data.getSpecType()){
            case 0:
                setText(R.id.flavor_price_tv,"x"+ DateUtils.getTwoDoubles(data.getSpecRate()));
                break;
            case 1:
                setText(R.id.flavor_price_tv,"+ "+ Constant.RMB+DateUtils.getTwoDoubles(data.getSpecPrice()));
                break;
            case 2:
                setText(R.id.flavor_price_tv,"- "+ Constant.RMB+DateUtils.getTwoDoubles(data.getSpecPrice()));
                break;
        }
    }
}
