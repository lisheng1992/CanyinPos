package com.canyinpos.mvp.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import com.canyinpos.R;
import com.canyinpos.common.Constant;
import com.canyinpos.listener.ItemDragHelperCallback;
import com.canyinpos.mvp.adapter.GridSpacingItemDecoration;
import com.canyinpos.mvp.adapter.MainGoodsAdapter;
import com.canyinpos.mvp.bean.GoodsBean;
import com.canyinpos.mvp.ui.fragments.base.BaseFragment;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import easyrecyclerview.EasyRecyclerView;
import easyrecyclerview.adapter.RecyclerArrayAdapter;

/**
 * 作者：Hao on 2017/8/22 15:26
 * 邮箱：shengxuan@izjjf.cn
 */

public class GoodsFragment extends BaseFragment implements RecyclerArrayAdapter.OnItemClickListener{
    @BindView(R.id.goods_rv)
    EasyRecyclerView mGoodsRv;
    @BindView(R.id.goods_fab)
    FloatingActionButton mGoodsFab;

    private String classifyName;
    private MainGoodsAdapter mMainGoodsAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            classifyName = getArguments().getString(Constant.CLASSIFY_NAME);
        }
    }

    @Override
    public void initViews(View view) {
        mGoodsRv.setLayoutManager(new GridLayoutManager(getActivity(), 4));
        mGoodsRv.addItemDecoration(new GridSpacingItemDecoration(4, 20, false));
        mGoodsRv.setRefreshingColorResources(R.color.color_0099cc, R.color.color_ff8800, R.color.color_669900);
        mMainGoodsAdapter = new MainGoodsAdapter(getActivity());
        mGoodsRv.setAdapterWithProgress(mMainGoodsAdapter);
        List<GoodsBean> mGoodsList = new ArrayList<>();
        for(int i= 0;i< 10;i++) {
            GoodsBean goodsBean = new GoodsBean("红烧猪蹄椒盐虾",new BigDecimal(22.00));
            mGoodsList.add(goodsBean);
        }
        mMainGoodsAdapter.addAll(mGoodsList);
        mMainGoodsAdapter.setOnItemClickListener(this);
        ItemTouchHelper.Callback callback = new ItemDragHelperCallback(mMainGoodsAdapter);
        //用Callback构造ItemtouchHelper
        ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
        //调用ItemTouchHelper的attachToRecyclerView方法建立联系
        touchHelper.attachToRecyclerView(mGoodsRv.getRecyclerView());
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_goods_list;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void onItemClick(int position) {

    }
}
