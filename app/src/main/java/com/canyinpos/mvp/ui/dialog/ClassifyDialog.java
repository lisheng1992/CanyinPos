package com.canyinpos.mvp.ui.dialog;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.DialogFragment;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;

import com.canyinpos.R;
import com.canyinpos.listener.StringCallBack;
import com.canyinpos.mvp.bean.ClassifyBean;
import com.canyinpos.utils.ToastUtils;

import org.litepal.crud.DataSupport;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.canyinpos.R.id.confirm_bt;

/**
 * 作者：Hao on 2017/8/22 19:31
 * 邮箱：shengxuan@izjjf.cn
 */

public class ClassifyDialog extends DialogFragment {
    @BindView(R.id.classify_name_et)
    TextInputEditText mClassifyNameEt;
    @BindView(R.id.cancel_bt)
    Button mCancelBt;
    @BindView(confirm_bt)
    Button mConfirmBt;
    private StringCallBack mStringCallBack;
    private InputMethodManager mInputMethodManager;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mInputMethodManager = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        getDialog().getWindow().setWindowAnimations(R.style.TopDialogAnim);
        getDialog().setCanceledOnTouchOutside(false);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        View view = inflater.inflate(R.layout.dialog_classify, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        final DisplayMetrics dm = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
        final WindowManager.LayoutParams layoutParams = getDialog().getWindow().getAttributes();
        layoutParams.width = dm.widthPixels;
        layoutParams.gravity = Gravity.TOP;
        getDialog().getWindow().setAttributes(layoutParams);
        mInputMethodManager.toggleSoftInput(InputMethodManager.SHOW_IMPLICIT, InputMethodManager.HIDE_NOT_ALWAYS);
    }

    @OnClick({R.id.cancel_bt, confirm_bt})
    public void click(View v) {
        switch (v.getId()){
            case confirm_bt:
                List<ClassifyBean> mClassifyList = DataSupport.findAll(ClassifyBean.class,false);
                String classifyName = mClassifyNameEt.getText().toString();
                if (!TextUtils.isEmpty(classifyName)) {
                    boolean isExit = false;
                    for (ClassifyBean classifyBean:mClassifyList) {
                        if (classifyName.equals(classifyBean.getClassifyName())) {
                            isExit = true;
                            ToastUtils.showShortToast(getActivity(),"该类别已经存在!");
                            break;
                        } else {
                            isExit = false;
                        }
                    }
                    if (!isExit) {
                        if (mStringCallBack != null) {
                            mStringCallBack.stringCallBack(classifyName);
                            mClassifyNameEt.setText("");
                            mInputMethodManager.hideSoftInputFromWindow(mConfirmBt.getWindowToken(),0);
                            dismiss();
                        }
                    }
                }
                break;
            case R.id.cancel_bt:
                mClassifyNameEt.setText("");
                mInputMethodManager.hideSoftInputFromWindow(mConfirmBt.getWindowToken(),0);
                dismiss();
                break;
        }
    }

    public void setStringCallBack(StringCallBack stringCallBack) {
        this.mStringCallBack = stringCallBack;
    }
}
