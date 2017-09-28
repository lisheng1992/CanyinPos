package com.canyinpos.mvp.ui.fragments;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.Button;

import com.canyinpos.R;
import com.canyinpos.listener.ItemDragHelperCallback;
import com.canyinpos.listener.ObjectCallBack;
import com.canyinpos.mvp.adapter.FlavorAdapter;
import com.canyinpos.mvp.adapter.GridSpacingItemDecoration;
import com.canyinpos.mvp.bean.FlavorBean;
import com.canyinpos.mvp.ui.dialog.AddFlavorDialog;
import com.canyinpos.mvp.ui.fragments.base.BaseFragment;

import org.litepal.crud.DataSupport;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import easyrecyclerview.EasyRecyclerView;
import easyrecyclerview.adapter.RecyclerArrayAdapter;

/**
 * 作者：Hao on 2017/9/8 10:27
 * 邮箱：shengxuan@izjjf.cn
 * 口味
 */

public class FlavorFragment extends BaseFragment implements ObjectCallBack<FlavorBean>,RecyclerArrayAdapter.OnItemClickListener{
    @BindView(R.id.add_flavor_bt)
    Button mAddFlavorBt;
    @BindView(R.id.flavor_list_erv)
    EasyRecyclerView mFlavorListErv;

    private AddFlavorDialog mAddFlavorDialog;
    private FlavorAdapter mFlavorAdapter;
    @Override
    public void initViews(View view) {
        List<FlavorBean> mFlavorList = DataSupport.findAll(FlavorBean.class);
        mFlavorAdapter = new FlavorAdapter(getActivity(),mFlavorList);
        mFlavorListErv.setLayoutManager(new GridLayoutManager(getActivity(), 6));
        mFlavorListErv.addItemDecoration(new GridSpacingItemDecoration(6, 20, false));
        mFlavorListErv.setAdapter(mFlavorAdapter);
        mFlavorAdapter.setOnItemClickListener(this);
        ItemTouchHelper.Callback callback = new ItemDragHelperCallback(mFlavorAdapter);
        //用Callback构造ItemtouchHelper
        ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
        //调用ItemTouchHelper的attachToRecyclerView方法建立联系
        touchHelper.attachToRecyclerView(mFlavorListErv.getRecyclerView());
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_flavor;
    }

    @Override
    public void initPresenter() {

    }

    @OnClick(R.id.add_flavor_bt)
    public void addFlavor() {
        mAddFlavorDialog = new AddFlavorDialog();
        mAddFlavorDialog.setCallBack(this,-1);
        mAddFlavorDialog.show(getActivity().getSupportFragmentManager(),"addFlavor");
     }

    @Override
    public void callback(FlavorBean flavorBean) {
        mFlavorAdapter.add(flavorBean);
    }

    @Override
    public void callbackWithPosition(FlavorBean flavorBean, int position) {
        mFlavorAdapter.update(flavorBean,position);
    }

    @Override
    public void onItemClick(int position) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("FlavorBean",mFlavorAdapter.getItem(position));
        mAddFlavorDialog = new AddFlavorDialog();
        mAddFlavorDialog.setCallBack(this,position);
        mAddFlavorDialog.setArguments(bundle);
        mAddFlavorDialog.show(getActivity().getSupportFragmentManager(),"editFlavor");
    }
}
