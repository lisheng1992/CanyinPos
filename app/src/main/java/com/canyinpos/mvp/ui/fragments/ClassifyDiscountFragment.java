package com.canyinpos.mvp.ui.fragments;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.EditText;

import com.canyinpos.R;
import com.canyinpos.mvp.adapter.ClassifyDiscountAdapter;
import com.canyinpos.mvp.bean.ClassifyBean;
import com.canyinpos.mvp.ui.fragments.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 作者：Hao on 2017/9/21 09:48
 * 邮箱：shengxuan@izjjf.cn
 */

public class ClassifyDiscountFragment extends BaseFragment {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.active_et)
    EditText mActiveEt;
    @BindView(R.id.classify_discount_erv)
    RecyclerView mClassifyDiscountErv;

    private ClassifyDiscountAdapter mArrayAdapter;
    private List<ClassifyBean> mClassifyList;
    @Override
    public void initViews(View view) {
        ((AppCompatActivity) getActivity()).setSupportActionBar(mToolbar);
        setHasOptionsMenu(true);
        mClassifyDiscountErv.setLayoutManager(new LinearLayoutManager(getActivity()));
        mClassifyList = new ArrayList<>();
        for (int i = 0;i < 20;i++) {
            ClassifyBean classifyBean = new ClassifyBean();
            classifyBean.setClassifyName("测试"+i);
            classifyBean.setClassifyDiscount(100-i);
            mClassifyList.add(classifyBean);
        }
        mArrayAdapter = new ClassifyDiscountAdapter(mClassifyList,getActivity());
        mClassifyDiscountErv.setAdapter(mArrayAdapter);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_classify_discount;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.save_menu, menu);
    }
}
