package com.canyinpos.mvp.adapter;

import android.support.annotation.LayoutRes;
import android.view.ViewGroup;

import com.canyinpos.R;
import com.canyinpos.common.Constant;
import com.canyinpos.mvp.bean.GoodsBean;

import easyrecyclerview.adapter.BaseViewHolder;

/**
 * 作者：Hao on 2017/9/1 17:41
 * 邮箱：shengxuan@izjjf.cn
 */

public class AllGoodsAdapter extends BaseViewHolder<GoodsBean> {
    public AllGoodsAdapter(ViewGroup parent, @LayoutRes int res) {
        super(parent, res);
    }

    @Override
    public void setData(GoodsBean data, int position) {
        super.setData(data, position);
        setText(R.id.goods_name_tv,data.getGoodsName());
        setText(R.id.barcode_tv,data.getBarCode());
        setText(R.id.classify_tv,data.getClassifyName());
        setText(R.id.price_tv, Constant.RMB+data.getSellingPrice());
        setText(R.id.inventory_tv,String.valueOf(data.getInventory()));
    }
}
