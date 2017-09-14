package com.canyinpos.mvp.ui.dialog;

import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
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
import android.widget.LinearLayout;
import android.widget.TextView;

import com.canyinpos.R;
import com.canyinpos.listener.ObjectCallBack;
import com.canyinpos.mvp.bean.FlavorBean;
import com.canyinpos.utils.DateUtils;
import com.canyinpos.utils.ToastUtils;

import org.litepal.crud.DataSupport;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.canyinpos.R.id.flavor_type_tv;


/**
 * 作者：Hao on 2017/9/8 14:46
 * 邮箱：shengxuan@izjjf.cn
 */

public class AddFlavorDialog extends DialogFragment {

    @BindView(R.id.flavor_name_et)
    TextInputEditText mFlavorNameEt;
    @BindView(flavor_type_tv)
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
    @BindView(R.id.confirm_bt)
    Button mConfirmBt;
    private InputMethodManager mInputMethodManager;
    private AlertDialog mAlertDialog;
    private int clickIndex;
    private static final String[] FLAVOR_TYPE = new String[]{"加价 (例如口味)","减价 (例如满10元减2元)"
    ,"价格为0 (例如买一送一)","折扣 (例如第二杯半价)"};
    private ObjectCallBack<FlavorBean> mCallBack;
    private int mPosition;
    private int flavorId;//用来update
    public void setCallBack(ObjectCallBack<FlavorBean> callBack,int position) {
        this.mCallBack = callBack;
        this.mPosition = position;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mInputMethodManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
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
        initArguments();
        return view;
    }

    private void initArguments() {
        if (getArguments() != null) {
            Bundle bundle = getArguments();
            FlavorBean flavorBean = (FlavorBean) bundle.getSerializable("FlavorBean");
            flavorId = flavorBean.getId();
            judgeIndex(flavorBean.getFlavorType(),flavorBean);
        } else {
            mFlavorTypeTv.setText("加价");
            mTypeNameTv.setText("加价");
            mFlavorTypeTil.setHint("请输入加价金额");
        }
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

    @OnClick(flavor_type_tv)
    public void flavorType() {
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(getActivity());
        alertBuilder.setTitle("类型选择");
        alertBuilder.setSingleChoiceItems(FLAVOR_TYPE, clickIndex, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                clickIndex = which;
            }
        });
        alertBuilder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                judgeIndex(clickIndex,null);
               /*switch (clickIndex) {
                   case 0:
                       mFlavorTypeTv.setText("加价");
                       mTypeNameTv.setText("加价");
                       mFlavorTypeTil.setHint("请输入加价金额");
                       if (mFlavorTypeLl.getVisibility() == View.INVISIBLE) {
                           mFlavorTypeLl.setVisibility(View.VISIBLE);
                       }
                       break;
                   case 1:
                       mFlavorTypeTv.setText("减价");
                       mTypeNameTv.setText("减价");
                       mFlavorTypeTil.setHint("请输入减价金额");
                       if (mFlavorTypeLl.getVisibility() == View.INVISIBLE) {
                           mFlavorTypeLl.setVisibility(View.VISIBLE);
                       }
                       break;
                   case 2:
                       mFlavorTypeTv.setText("价格为零");
                       mFlavorTypeLl.setVisibility(View.INVISIBLE);
                       break;
                   case 3:
                       mFlavorTypeTv.setText("折扣");
                       mTypeNameTv.setText("折扣");
                       mFlavorTypeTil.setHint("请输入折扣率,单位为%");
                       mFlavorPriceEt.setText("50");
                       if (mFlavorTypeLl.getVisibility() == View.INVISIBLE) {
                           mFlavorTypeLl.setVisibility(View.VISIBLE);
                       }
                       break;
               }*/
            }
        });
        alertBuilder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mAlertDialog.dismiss();
            }
        });
        mAlertDialog = alertBuilder.create();
        mAlertDialog.show();
    }


    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        mFlavorNameEt.setText("");
        mFlavorPriceEt.setText("");
    }


    @OnClick({R.id.cancel_bt, R.id.confirm_bt})
    public void cancelOrConfirm(View v) {
        if (v.getId() == R.id.cancel_bt) {
            dismiss();
            mInputMethodManager.hideSoftInputFromWindow(mConfirmBt.getWindowToken(),0);
        } else if (v.getId() == R.id.confirm_bt) {
            String flavorName = mFlavorNameEt.getText().toString();
            if (TextUtils.isEmpty(flavorName)) {
                ToastUtils.showShortToast(getActivity(),"请输入口味名称!");
                return;
            }
            FlavorBean flavorBean = new FlavorBean();
            flavorBean.setFlavorName(flavorName);
            flavorBean.setFlavorType(clickIndex);
            switch (clickIndex){
                case 0:
                case 1:
                    String priceStr = TextUtils.isEmpty(mFlavorPriceEt.getText()) ? "0.00":
                            mFlavorPriceEt.getText().toString();
                    flavorBean.setFlavorPrice(Double.parseDouble(priceStr));
                    break;
                case 2:
                    flavorBean.setFlavorPrice(Double.parseDouble("0.00"));
                    flavorBean.setDiscountRate(0);
                    break;
                case 3:
                    String discountRate = TextUtils.isEmpty(mFlavorPriceEt.getText()) ? "0.00":
                            mFlavorPriceEt.getText().toString();
                    flavorBean.setDiscountRate(Double.parseDouble(discountRate));
                    break;
            }
            if (mCallBack != null) {
                if (mPosition == -1) {
                    flavorBean.save();
                    mCallBack.callback(flavorBean);
                } else {
                    ContentValues values = new ContentValues();
                    values.put("flavorName", flavorName);
                    values.put("flavorType",clickIndex);
                    values.put("flavorPrice",flavorBean.getFlavorPrice());
                    values.put("discountRate",flavorBean.getDiscountRate());
                    DataSupport.update(FlavorBean.class, values, flavorId);
                    mCallBack.callbackWithPosition(flavorBean,mPosition);
                }
            }
            dismiss();
            mInputMethodManager.hideSoftInputFromWindow(mConfirmBt.getWindowToken(),0);
        }
    }

    private void judgeIndex(int index,FlavorBean flavorBean) {
        switch (index){
            case 0:
                mFlavorTypeTv.setText("加价");
                mTypeNameTv.setText("加价");
                mFlavorTypeTil.setHint("请输入加价金额");
                if (flavorBean != null) {
                    mFlavorPriceEt.setText(DateUtils.getTwoDoubles(flavorBean.getFlavorPrice()));
                }
                if (mFlavorTypeLl.getVisibility() == View.INVISIBLE) {
                    mFlavorTypeLl.setVisibility(View.VISIBLE);
                }
                break;
            case 1:
                mFlavorTypeTv.setText("减价");
                mTypeNameTv.setText("减价");
                mFlavorTypeTil.setHint("请输入减价金额");
                if (flavorBean != null) {
                    mFlavorPriceEt.setText(DateUtils.getTwoDoubles(flavorBean.getFlavorPrice()));
                }
                if (mFlavorTypeLl.getVisibility() == View.INVISIBLE) {
                    mFlavorTypeLl.setVisibility(View.VISIBLE);
                }
                break;
            case 2:
                mFlavorTypeTv.setText("价格为零");
                mFlavorTypeLl.setVisibility(View.INVISIBLE);
                break;
            case 3:
                mFlavorTypeTv.setText("折扣");
                mTypeNameTv.setText("折扣");
                mFlavorTypeTil.setHint("请输入折扣率,单位为%");
                mFlavorPriceEt.setText("50");
                if (flavorBean != null) {
                    mFlavorPriceEt.setText(DateUtils.getTwoDoubles(flavorBean.getDiscountRate()));
                }
                if (mFlavorTypeLl.getVisibility() == View.INVISIBLE) {
                    mFlavorTypeLl.setVisibility(View.VISIBLE);
                }
                break;
        }
        if (flavorBean != null) {
            mFlavorNameEt.setText(flavorBean.getFlavorName());
            mFlavorNameEt.selectAll();
            clickIndex = flavorBean.getFlavorType();
        }
    }
}
