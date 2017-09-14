package com.canyinpos.mvp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.canyinpos.R;
import com.canyinpos.listener.ItemTouchHelperAdapter;
import com.canyinpos.mvp.bean.GoodsSpecBean;

import java.util.Collections;
import java.util.List;

import easyrecyclerview.adapter.BaseViewHolder;
import easyrecyclerview.adapter.RecyclerArrayAdapter;

/**
 * 作者：Hao on 2017/9/9 16:42
 * 邮箱：shengxuan@izjjf.cn
 */

public class GoodsSpecAdapter extends RecyclerArrayAdapter<GoodsSpecBean> implements ItemTouchHelperAdapter {
    public GoodsSpecAdapter(Context context, List<GoodsSpecBean> objects) {
        super(context, objects);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new SpecHolder(parent, R.layout.item_flavor);
    }

    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        if (fromPosition < getAllData().size() && toPosition < getAllData().size()) {
            //交换数据位置
            Collections.swap(getAllData(), fromPosition, toPosition);
            //刷新位置交换
            notifyItemMoved(fromPosition, toPosition);
        }
    }

    @Override
    public void onItemDissmiss(RecyclerView.ViewHolder source) {

    }

    @Override
    public void onItemSelect(RecyclerView.ViewHolder source) {
        //当拖拽选中时放大选中的view
        source.itemView.setScaleX(1.2f);
        source.itemView.setScaleY(1.2f);
    }

    @Override
    public void onItemClear(RecyclerView.ViewHolder source) {
        //当拖拽选中时放大选中的view
        source.itemView.setScaleX(1.0f);
        source.itemView.setScaleY(1.0f);
    }
}
