package com.canyinpos.mvp.adapter;

import android.support.annotation.LayoutRes;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.ViewGroup;

import com.canyinpos.R;
import com.canyinpos.common.Constant;
import com.canyinpos.mvp.bean.ComboGoodsBean;
import com.canyinpos.mvp.bean.ComboListBean;
import com.canyinpos.utils.DateUtils;

import java.util.ArrayList;
import java.util.List;

import easyrecyclerview.EasyRecyclerView;
import easyrecyclerview.adapter.BaseViewHolder;
import easyrecyclerview.adapter.RecyclerArrayAdapter;

/**
 * 作者：Hao on 2017/9/6 10:58
 * 邮箱：shengxuan@izjjf.cn
 */

public class ComboListHolder extends BaseViewHolder<ComboListBean>{

    private EasyRecyclerView mRecyclerView;
    private RecyclerArrayAdapter<ComboGoodsBean> mArrayAdapter;
    private List<ComboGoodsBean> mComboGoodsList;
    public ComboListHolder(ViewGroup parent, @LayoutRes int res) {
        super(parent, res);
        mRecyclerView = $(R.id.combo_goods_erv);
    }

    @Override
    public void setData(ComboListBean data, int position) {
        super.setData(data, position);
        setText(R.id.combo_name_tv,data.getComboName());
        if (data.getComboType() == 0) {
            setText(R.id.combo_pattern_tv,"固定套餐");
        } else {
            setText(R.id.combo_pattern_tv,"自选套餐");
        }
        setText(R.id.sell_price_tv, Constant.RMB+ DateUtils.getTwoDecimals(data.getComboPrice()));
        setText(R.id.vip_price_tv, Constant.RMB+ DateUtils.getTwoDecimals(data.getComboVipPrice()));
        initRecyclerView(data);
        setOnClickLisenter(R.id.combo_edit_iv,new View.OnClickListener(){
            @Override
            public void onClick(View v) {

            }
        });
        setOnClickLisenter(R.id.combo_delete_iv, new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void initRecyclerView(ComboListBean data) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mArrayAdapter = new RecyclerArrayAdapter<ComboGoodsBean>(getContext()) {
            @Override
            public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
                return new ComboGoodsHolder(parent,R.layout.item_combo_goods);
            }
        };
        mRecyclerView.setAdapter(mArrayAdapter);
        mComboGoodsList = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            ComboGoodsBean comboGoods = new ComboGoodsBean();
            comboGoods.setGoodsName("红烧猪蹄肉");
            if (i % 3 == 0) {
                comboGoods.setLastGoods(true);
                comboGoods.setAllNum(5);
                comboGoods.setSelectNum(3);
            }
            mComboGoodsList.add(comboGoods);
        }
        mArrayAdapter.addAll(mComboGoodsList);
    }
}
