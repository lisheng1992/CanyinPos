package com.canyinpos.mvp.ui.activities;

import android.view.View;
import android.widget.Button;

import com.canyinpos.R;
import com.canyinpos.mvp.ui.fragments.base.BaseFragment;

import butterknife.BindView;
import butterknife.OnClick;
import easyrecyclerview.EasyRecyclerView;

/**
 * 作者：Hao on 2017/9/9 15:36
 * 邮箱：shengxuan@izjjf.cn
 */

public class SpecFragment extends BaseFragment {
    @BindView(R.id.add_flavor_bt)
    Button mAddFlavorBt;
    @BindView(R.id.flavor_list_erv)
    EasyRecyclerView mFlavorListErv;

    @Override
    public void initViews(View view) {
        mAddFlavorBt.setText("添加规格");
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_flavor;
    }

    @OnClick(R.id.add_flavor_bt)
    public void addSpec() {

    }
}
