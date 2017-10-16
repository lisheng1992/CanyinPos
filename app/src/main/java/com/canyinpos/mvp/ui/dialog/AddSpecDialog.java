package com.canyinpos.mvp.ui.dialog;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.canyinpos.R;
import com.canyinpos.mvp.bean.GoodsSpecBean;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 作者：Hao on 2017/9/9 16:52
 * 邮箱：shengxuan@izjjf.cn
 */

public class AddSpecDialog extends DialogFragment {

    @BindView(R.id.dialog_title_tv)
    TextView mDialogTitleTv;
    @BindView(R.id.flavor_name_et)
    TextInputEditText mFlavorNameEt;
    @BindView(R.id.flavor_type_tv)
    TextView mFlavorTypeTv;
    @BindView(R.id.type_name_tv)
    TextView mTypeNameTv;
    @BindView(R.id.flavor_price_et)
    TextInputEditText mFlavorPriceEt;
    @BindView(R.id.flavor_type_til)
    TextInputLayout mFlavorTypeTil;
    @BindView(R.id.flavor_type_ll)
    LinearLayout mFlavorTypeLl;
    @BindView(R.id.cancel_bt)
    Button mCancelBt;
    @BindView(R.id.delete_bt)
    Button mDeleteBt;
    @BindView(R.id.confirm_bt)
    Button mConfirmBt;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        getDialog().getWindow().setWindowAnimations(R.style.TopDialogAnim);
        getDialog().setCanceledOnTouchOutside(false);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        View view = inflater.inflate(R.layout.dialog_add_flavor, container, false);
        ButterKnife.bind(this, view);
        mDialogTitleTv.setText("新建规格");
        initArguments();
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    private void initArguments() {
        if (getArguments() != null) {
            Bundle bundle = getArguments();
            GoodsSpecBean specBean = (GoodsSpecBean) bundle.getSerializable("GoodsSpecBean");
            mFlavorNameEt.setText(specBean.getName());
        } else {

        }
    }

}
