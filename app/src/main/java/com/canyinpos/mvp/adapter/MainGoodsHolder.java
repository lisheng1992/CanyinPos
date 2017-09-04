package com.canyinpos.mvp.adapter;

import android.support.annotation.LayoutRes;
import android.view.ViewGroup;

import com.canyinpos.R;
import com.canyinpos.mvp.bean.GoodsBean;

import easyrecyclerview.adapter.BaseViewHolder;

/**
 * 作者：Hao on 2017/8/23 17:00
 * 邮箱：shengxuan@izjjf.cn
 */

public class MainGoodsHolder extends BaseViewHolder<GoodsBean> {
    public MainGoodsHolder(ViewGroup parent, @LayoutRes int res) {
        super(parent, res);
    }

    @Override
    public void setData(GoodsBean data, int position) {
        super.setData(data, position);
        setText(R.id.goods_tv,data.getGoodsName());
        setText(R.id.goods_price_tv,"¥ "+data.getSellingPrice());
    }
}
