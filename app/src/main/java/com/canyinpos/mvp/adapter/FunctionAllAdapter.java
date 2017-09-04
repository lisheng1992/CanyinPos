package com.canyinpos.mvp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.canyinpos.R;
import com.canyinpos.listener.ItemTouchHelperAdapter;
import com.canyinpos.mvp.bean.FunctionBean;

import java.util.Collections;
import java.util.List;

import easyrecyclerview.adapter.BaseViewHolder;
import easyrecyclerview.adapter.RecyclerArrayAdapter;

/**
 * 作者：Hao on 2017/8/24 16:04
 * 邮箱：shengxuan@izjjf.cn
 */

public class FunctionAllAdapter extends RecyclerArrayAdapter<FunctionBean> implements ItemTouchHelperAdapter {


    public FunctionAllAdapter(Context context, List<FunctionBean> objects) {
        super(context, objects);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new FunctionAllHolder(parent, R.layout.item_all_function);
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
