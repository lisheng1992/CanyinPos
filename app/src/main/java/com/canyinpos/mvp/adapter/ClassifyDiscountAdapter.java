package com.canyinpos.mvp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.canyinpos.R;
import com.canyinpos.mvp.bean.ClassifyBean;

import java.util.List;

/**
 * 作者：Hao on 2017/9/21 17:43
 * 邮箱：shengxuan@izjjf.cn
 */

public class ClassifyDiscountAdapter extends RecyclerView.Adapter<ClassifyDiscountAdapter.ClassifyDiscountHolder> {

    private List<ClassifyBean> mClassifyList;
    private Context mContext;

    public ClassifyDiscountAdapter(List<ClassifyBean> classifyList, Context context){
        this.mClassifyList = classifyList;
        this.mContext = context;
    }

    @Override
    public ClassifyDiscountHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ClassifyDiscountHolder(LayoutInflater.from(mContext).inflate(R.layout.item_classify_discount,
                parent,false));
    }

    @Override
    public void onBindViewHolder(ClassifyDiscountHolder holder, int position) {
        final ClassifyBean classifyBean = mClassifyList.get(position);
        holder.classifyName.setText(classifyBean.getClassifyName());

        if (holder.mEditText.getTag() instanceof TextWatcher) {
            holder.mEditText.removeTextChangedListener((TextWatcher)holder.mEditText.getTag());
        }
        holder.mEditText.setText(classifyBean.getClassifyDiscount()+"");
        TextWatcher watcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int discount = TextUtils.isEmpty(s.toString()) ? 0:Integer.parseInt(s.toString());
                classifyBean.setClassifyDiscount(discount);
            }
        };
        holder.mEditText.addTextChangedListener(watcher);
        holder.mEditText.setTag(watcher);
    }

    @Override
    public int getItemCount() {
        return mClassifyList == null ? 0 :mClassifyList.size();
    }

    final class ClassifyDiscountHolder extends RecyclerView.ViewHolder{

        TextView classifyName;
        EditText mEditText;
        ClassifyDiscountHolder(View itemView) {
            super(itemView);
            classifyName = (TextView) itemView.findViewById(R.id.classify_name_tv);
            mEditText = (EditText) itemView.findViewById(R.id.classify_discount_et);
        }
    }
}
