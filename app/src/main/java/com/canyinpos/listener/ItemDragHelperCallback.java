package com.canyinpos.listener;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.helper.ItemTouchHelper;

/**
 * 作者：Hao on 2017/8/23 18:28
 * 邮箱：shengxuan@izjjf.cn
 */

public class ItemDragHelperCallback extends ItemTouchHelper.Callback {

    private ItemTouchHelperAdapter mItemTouchHelperAdapter;
    private boolean mIsLongPressEnabled;
    public void setLongPressEnabled(boolean longPressEnabled) {
        mIsLongPressEnabled = longPressEnabled;
    }

    public ItemDragHelperCallback(ItemTouchHelperAdapter itemTouchHelperAdapter) {
        this.mItemTouchHelperAdapter = itemTouchHelperAdapter;
    }

    public boolean isLongPressEnabled() {
        return mIsLongPressEnabled;
    }

    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        int dragFlags = setDragFlags(recyclerView);
        int swipeFlags = 0;
        return makeMovementFlags(dragFlags, swipeFlags);
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        mItemTouchHelperAdapter.onItemMove(viewHolder.getAdapterPosition(),target.getAdapterPosition());
        return true;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

    }

    @Override
    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
        super.onSelectedChanged(viewHolder, actionState);
        if (actionState != ItemTouchHelper.ACTION_STATE_IDLE) {
            //当滑动或者拖拽view的时候通过接口返回该ViewHolder
            mItemTouchHelperAdapter.onItemSelect(viewHolder);
        }
    }

    @Override
    public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        super.clearView(recyclerView, viewHolder);
        if (!recyclerView.isComputingLayout()) {
            //当需要清除之前在onSelectedChanged或者onChildDraw,onChildDrawOver设置的状态或者动画时通过接口返回该ViewHolder
            mItemTouchHelperAdapter.onItemClear(viewHolder);
        }
    }

    private int setDragFlags(RecyclerView recyclerView) {
        int dragFlags;
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager || layoutManager instanceof StaggeredGridLayoutManager) {
            dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN | ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
        } else {
            dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
        }
        return dragFlags;
    }
}
