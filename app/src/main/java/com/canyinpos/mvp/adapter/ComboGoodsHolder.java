package com.canyinpos.mvp.adapter;

import android.support.annotation.LayoutRes;
import android.support.v7.widget.PopupMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.canyinpos.R;
import com.canyinpos.mvp.bean.ComboGoodsBean;

import easyrecyclerview.adapter.BaseViewHolder;

/**
 * 作者：Hao on 2017/9/6 20:15
 * 邮箱：shengxuan@izjjf.cn
 */

public class ComboGoodsHolder extends BaseViewHolder<ComboGoodsBean> {

    private ImageView combo_goods_click_iv;

    public ComboGoodsHolder(ViewGroup parent, @LayoutRes int res) {
        super(parent, res);
        combo_goods_click_iv = $(R.id.combo_goods_click_iv);
    }

    @Override
    public void setData(ComboGoodsBean data, int position) {
        super.setData(data, position);
        //setImageUrl(R.id.combo_goods_iv,data.getSmallImgUrl());
        setText(R.id.combo_goods_name_tv,data.getGoodsName());
        if (data.isLastGoods()) {
            setVisible(R.id.number_rl,true);
            setText(R.id.number_tv,data.getAllNum()+"选"+data.getSelectNum());
        } else {
            setVisible(R.id.number_rl,false);
        }
        combo_goods_click_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(getContext(), combo_goods_click_iv);
                popup.getMenuInflater()
                        .inflate(R.menu.combo_goods_menu, popup.getMenu());
                popup.show();
            }
        });
    }
}
