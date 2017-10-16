package com.canyinpos.mvp.adapter;

import android.support.annotation.LayoutRes;
import android.view.ViewGroup;

import com.canyinpos.R;
import com.canyinpos.common.Constant;
import com.canyinpos.mvp.bean.TasteBean;
import com.canyinpos.utils.DateUtils;

import easyrecyclerview.adapter.BaseViewHolder;

/**
 * 作者：Hao on 2017/9/8 11:29
 * 邮箱：shengxuan@izjjf.cn
 */

public class FlavorHolder extends BaseViewHolder<TasteBean> {
    public FlavorHolder(ViewGroup parent, @LayoutRes int res) {
        super(parent, res);
    }

    @Override
    public void setData(TasteBean data, int position) {
        super.setData(data, position);
        setText(R.id.flavor_name_tv,data.getName());
        switch (data.getTasteType()){
            case 0:
                setText(R.id.flavor_price_tv,"+ "+ Constant.RMB + DateUtils.getTwoDoubles(data.getTastePrice()));
                break;
            case 1:
                setText(R.id.flavor_price_tv,"- "+ Constant.RMB + DateUtils.getTwoDoubles(data.getTastePrice()));
                break;
            case 2:
                setText(R.id.flavor_price_tv,Constant.RMB+"0.00");
                break;
            case 3:
                setText(R.id.flavor_price_tv,DateUtils.getTwoDoubles(data.getDiscountRate())+"%");
                break;
        }
    }
}
