/*
 * Copyright (c) 2016 咖枯 <kaku201313@163.com | 3772304@qq.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.canyinpos.mvp.ui.fragments.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.canyinpos.R;
import com.canyinpos.application.ZmhApplication;
import com.canyinpos.mvp.presenter.base.BasePresenter;
import com.canyinpos.utils.UIUtils;
import com.squareup.leakcanary.RefWatcher;

import butterknife.ButterKnife;
import easyrecyclerview.EasyRecyclerView;
import easyrecyclerview.decoration.DividerDecoration;

/**
 * 作者：Hao on 2017/8/22 11:38
 * 邮箱：shengxuan@izjjf.cn
 */
public abstract class BaseFragment<T extends BasePresenter> extends Fragment {

    protected T mPresenter;

    private View mFragmentView;

    public abstract void initViews(View view);

    public abstract int getLayoutId();

    private ProgressDialog mProgressDialog;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mFragmentView == null) {
            mFragmentView = inflater.inflate(getLayoutId(), container, false);
            ButterKnife.bind(this, mFragmentView);
            initViews(mFragmentView);
        }
        return mFragmentView;
    }

    public void showProgressDialog() {
        try {
            if (mProgressDialog == null ) {
                mProgressDialog = new ProgressDialog(getActivity());
                mProgressDialog.show();
            } else if (!mProgressDialog.isShowing()) {
                mProgressDialog.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void dismissProgressDialog() {
        try {
            if (mProgressDialog != null && mProgressDialog.isShowing()) {
                mProgressDialog.dismiss();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void initRecyclerView(EasyRecyclerView recyclerView) {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        /*DividerDecoration itemDecoration = new DividerDecoration(getResources().getColor(R.color.color_dddddd),
                UIUtils.dip2px(getActivity(), 0.5f), 0, 0);
        itemDecoration.setDrawLastItem(false);
        recyclerView.addItemDecoration(itemDecoration);*/
        recyclerView.setRefreshingColorResources(R.color.color_0099cc, R.color.color_ff8800, R.color.color_669900);
    }

    protected void initRecyclerViewWithDecoratio(EasyRecyclerView recyclerView) {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        DividerDecoration itemDecoration = new DividerDecoration(getResources().getColor(R.color.color_dddddd),
                UIUtils.dip2px(getActivity(), 0.5f), 0, 0);
        itemDecoration.setDrawLastItem(false);
        recyclerView.addItemDecoration(itemDecoration);
        recyclerView.setRefreshingColorResources(R.color.color_0099cc, R.color.color_ff8800, R.color.color_669900);
    }

    protected void initRecyclerView(EasyRecyclerView recyclerView,int num) {
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),num));
//        DividerDecoration itemDecoration = new DividerDecoration(getResources().getColor(R.color.color_e5e5e5), dip2px(mContext, 0.5f), 0, 0);
//        itemDecoration.setDrawLastItem(true);
//        recyclerView.addItemDecoration(itemDecoration);
        recyclerView.setRefreshingColorResources(R.color.color_0099cc, R.color.color_ff8800, R.color.color_669900);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        RefWatcher refWatcher = ZmhApplication.getRefWatcher(getActivity());
        refWatcher.watch(this);

        if (mPresenter != null) {
            mPresenter.onDestroy();
        }
    }
}
