package com.canyinpos.mvp.ui.dialog;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.ViewGroup;

import com.canyinpos.R;
import com.canyinpos.listener.StringCallBack;
import com.canyinpos.mvp.adapter.ClassifyListHolder;
import com.canyinpos.mvp.bean.ClassifyBean;
import com.canyinpos.utils.UIUtils;

import java.util.List;

import easyrecyclerview.EasyRecyclerView;
import easyrecyclerview.adapter.BaseViewHolder;
import easyrecyclerview.adapter.RecyclerArrayAdapter;
import easyrecyclerview.decoration.DividerDecoration;

/**
 * 作者：Hao on 2017/8/31 10:16
 * 邮箱：shengxuan@izjjf.cn
 */

public class ClassifyListPop extends BasePopupWindowForListView<ClassifyBean> {
    private EasyRecyclerView mRecyclerView;
    private RecyclerArrayAdapter<ClassifyBean> mArrayAdapter;
    private StringCallBack mCallBack;
    public ClassifyListPop(View contentView, int width, int height, boolean focusable, StringCallBack callBack) {
        super(contentView, width, height, focusable);
        this.mCallBack = callBack;
    }

    @Override
    protected void beforeInitWeNeedSomeParams(Object... params) {

    }

    @Override
    public void initViews() {
        mRecyclerView = (EasyRecyclerView) findViewById(R.id.classify_list_erv);
        DividerDecoration itemDecoration = new DividerDecoration(mContext.getResources().getColor(R.color.color_dddddd),
                UIUtils.dip2px(mContext, 0.5f), 0, 0);
        itemDecoration.setDrawLastItem(false);
        mRecyclerView.addItemDecoration(itemDecoration);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mArrayAdapter = new RecyclerArrayAdapter<ClassifyBean>(mContext) {
            @Override
            public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
                return new ClassifyListHolder(parent,R.layout.item_classify_list);
            }
        };
        mRecyclerView.setAdapter(mArrayAdapter);
        mArrayAdapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                if (mCallBack != null) {
                    mCallBack.stringCallBack(mArrayAdapter.getItem(position).getClassifyName());
                    dismiss();
                }
            }
        });
    }

    @Override
    public void initEvents() {

    }

    @Override
    public void init() {

    }

    public void setData(List<ClassifyBean> classifyList){
        mArrayAdapter.clear();
        mArrayAdapter.addAll(classifyList);
    }
}
