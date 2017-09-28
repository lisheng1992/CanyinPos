package com.canyinpos.mvp.ui.fragments;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.canyinpos.R;
import com.canyinpos.mvp.adapter.ComboListHolder;
import com.canyinpos.mvp.bean.ComboListBean;
import com.canyinpos.mvp.ui.fragments.base.BaseFragment;
import com.canyinpos.utils.UIUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import easyrecyclerview.EasyRecyclerView;
import easyrecyclerview.adapter.BaseViewHolder;
import easyrecyclerview.adapter.RecyclerArrayAdapter;
import easyrecyclerview.decoration.DividerDecoration;

/**
 * 作者：Hao on 2017/9/5 14:04
 * 邮箱：shengxuan@izjjf.cn
 */

public class ComboGoodsFragment extends BaseFragment {
    @BindView(R.id.add_combo_bt)
    Button mAddComboBt;
    @BindView(R.id.combo_list_erv)
    EasyRecyclerView mComboListErv;

    private RecyclerArrayAdapter<ComboListBean> mArrayAdapter;
    private List<ComboListBean> mComboList;
    @Override
    public void initViews(View view) {
        mComboListErv.setLayoutManager(new LinearLayoutManager(getActivity()));
        DividerDecoration itemDecoration = new DividerDecoration(0,
                UIUtils.dip2px(getActivity(), 10));
        itemDecoration.setDrawLastItem(false);
        mComboListErv.addItemDecoration(itemDecoration);
        mArrayAdapter = new RecyclerArrayAdapter<ComboListBean>(getActivity()) {
            @Override
            public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
                return new ComboListHolder(parent,R.layout.item_combo_list);
            }
        };
        mComboListErv.setAdapter(mArrayAdapter);
        initData();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_combo_goods;
    }

    @Override
    public void initPresenter() {

    }

    public void initData() {
        mComboList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ComboListBean comboListBean = new ComboListBean();
            comboListBean.setComboName("红烧排骨加鸡汤");
            comboListBean.setComboType(0);
            comboListBean.setComboPrice(new BigDecimal(60));
            comboListBean.setComboVipPrice(new BigDecimal(55));
            mComboList.add(comboListBean);
        }
        mArrayAdapter.addAll(mComboList);
    }
}
