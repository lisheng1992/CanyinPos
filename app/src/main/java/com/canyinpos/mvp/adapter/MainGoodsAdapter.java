package com.canyinpos.mvp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.canyinpos.R;
import com.canyinpos.listener.ItemTouchHelperAdapter;
import com.canyinpos.mvp.bean.GoodsBean;

import java.util.Collections;

import easyrecyclerview.adapter.BaseViewHolder;
import easyrecyclerview.adapter.RecyclerArrayAdapter;

/**
 * 作者：Hao on 2017/8/23 18:18
 * 邮箱：shengxuan@izjjf.cn
 */

public class MainGoodsAdapter extends RecyclerArrayAdapter<GoodsBean> implements ItemTouchHelperAdapter{
    public MainGoodsAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new MainGoodsHolder(parent, R.layout.item_goods_list);
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
    public void onItemSelect(RecyclerView.ViewHolder viewHolder) {
        //当拖拽选中时放大选中的view
        viewHolder.itemView.setScaleX(1.2f);
        viewHolder.itemView.setScaleY(1.2f);
    }

    @Override
    public void onItemClear(RecyclerView.ViewHolder viewHolder) {
        //拖拽结束后恢复view的状态
        viewHolder.itemView.setScaleX(1.0f);
        viewHolder.itemView.setScaleY(1.0f);
    }
}
