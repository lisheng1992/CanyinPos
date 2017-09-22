package com.canyinpos.mvp.ui.dialog;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.canyinpos.R;
import com.canyinpos.listener.ItemDragHelperCallback;
import com.canyinpos.mvp.adapter.FunctionAllAdapter;
import com.canyinpos.mvp.adapter.GridSpacingItemDecoration;
import com.canyinpos.mvp.bean.FunctionBean;
import com.canyinpos.mvp.ui.activities.DiscountManageActivity;
import com.canyinpos.mvp.ui.activities.GoodsManageActivity;
import com.canyinpos.mvp.ui.activities.PrintAndPeripheralActivity;
import com.canyinpos.mvp.ui.activities.SetAdvertisementActivity;
import com.canyinpos.utils.SceneUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import easyrecyclerview.EasyRecyclerView;
import easyrecyclerview.adapter.RecyclerArrayAdapter;

/**
 * 作者：Hao on 2017/8/24 14:38
 * 邮箱：shengxuan@izjjf.cn
 */

public class AllFunctionDialog extends DialogFragment implements RecyclerArrayAdapter.OnItemClickListener{

    @BindView(R.id.cancle_fl)
    FrameLayout mCancleFl;
    @BindView(R.id.all_function_erv)
    EasyRecyclerView mAllFunctionErv;
    private FunctionAllAdapter mFunctionAllAdapter;
    private static final String[] FUNCTION_NAME = new String[]{"打开钱箱","数据报表","商品管理","扫码点餐","收银设置","打印与外设"
    ,"退款","权限管理","交接班","广告设置","数据同步","注销登录","关于我们"};
    private static final int[] FUNCTION_IC = new int[]{R.drawable.open_cash,R.drawable.data_report,R.drawable.goods_manage
    ,R.drawable.scan_order,R.drawable.cash_set,R.drawable.print_usb,R.drawable.refund_bg,R.drawable.quanxian_manege
    ,R.drawable.change_class, R.drawable.ad_set,R.drawable.data_synchronize,R.drawable.log_out,R.drawable.about_us};
    private List<FunctionBean> mFunctionList;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        getDialog().getWindow().setWindowAnimations(R.style.TopDialogAnim);
        View view = inflater.inflate(R.layout.dialog_all_function, container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        final DisplayMetrics dm = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
        final WindowManager.LayoutParams layoutParams = getDialog().getWindow().getAttributes();
        layoutParams.width = dm.widthPixels/3*2;
        layoutParams.gravity = Gravity.TOP;
        getDialog().getWindow().setAttributes(layoutParams);
    }

    private void initView(){
        initData();
        mAllFunctionErv.setLayoutManager(new GridLayoutManager(getActivity(), 5));
        mAllFunctionErv.addItemDecoration(new GridSpacingItemDecoration(5, 20, false));
        mFunctionAllAdapter = new FunctionAllAdapter(getActivity(),mFunctionList);
        mFunctionAllAdapter.setOnItemClickListener(this);
        mAllFunctionErv.setAdapter(mFunctionAllAdapter);
        ItemTouchHelper.Callback callback = new ItemDragHelperCallback(mFunctionAllAdapter);
        //用Callback构造ItemtouchHelper
        ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
        //调用ItemTouchHelper的attachToRecyclerView方法建立联系
        touchHelper.attachToRecyclerView(mAllFunctionErv.getRecyclerView());
    }

    private void initData() {
        mFunctionList = new ArrayList<>();
        for (int i = 0;i < FUNCTION_NAME.length;i++){
            mFunctionList.add(new FunctionBean(FUNCTION_NAME[i],FUNCTION_IC[i]));
        }
    }

    @Override
    public void onItemClick(int position) {
        if (position == 2) {
            SceneUtil.toScene(getActivity(), GoodsManageActivity.class,null);
        } else if (position == 4) {
            SceneUtil.toScene(getActivity(), DiscountManageActivity.class,null);
        } else if (position == 5) {
            SceneUtil.toScene(getActivity(), PrintAndPeripheralActivity.class,null);
        } else if (position == 9) {
            SceneUtil.toScene(getActivity(), SetAdvertisementActivity.class,null);
        }
        dismiss();
    }
}
