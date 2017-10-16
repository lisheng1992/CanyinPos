package com.canyinpos.mvp.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.canyinpos.R;
import com.canyinpos.listener.StringCallBack;
import com.canyinpos.mvp.adapter.AllGoodsAdapter;
import com.canyinpos.mvp.bean.ClassifyBean;
import com.canyinpos.mvp.bean.GoodsBean;
import com.canyinpos.mvp.ui.activities.AddGoodsActivity;
import com.canyinpos.mvp.ui.dialog.ClassifyDialog;
import com.canyinpos.mvp.ui.dialog.ClassifyListPop;
import com.canyinpos.mvp.ui.fragments.base.BaseFragment;
import com.canyinpos.utils.SceneUtil;
import com.canyinpos.utils.ToastUtils;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import easyrecyclerview.EasyRecyclerView;
import easyrecyclerview.adapter.BaseViewHolder;
import easyrecyclerview.adapter.RecyclerArrayAdapter;

/**
 * 作者：Hao on 2017/8/30 19:49
 * 邮箱：shengxuan@izjjf.cn
 */

public class AllGoodsFragment extends BaseFragment implements StringCallBack {
    @BindView(R.id.classify_name_et)
    EditText mClassifyNameEt;
    @BindView(R.id.find_goods_cd)
    CardView mFindGoodsCd;
    @BindView(R.id.what_classify_tv)
    TextView mWhatClassifyTv;
    @BindView(R.id.classify_ll)
    LinearLayout mClassifyLl;
    @BindView(R.id.add_classify_bt)
    Button mAddClassifyBt;
    @BindView(R.id.add_goods_bt)
    Button mAddGoodsBt;
    @BindView(R.id.all_goods_erv)
    EasyRecyclerView mRecyclerView;

    private ClassifyListPop mClassifyListPop;
    private RecyclerArrayAdapter<GoodsBean> mArrayAdapter;
    private ClassifyDialog mClassifyDialog;

    @Override
    public void initViews(View view) {
        initPopupWindow();
        initData();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_all_goods;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    private void initPopupWindow() {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_classify_list,null);
        mClassifyListPop = new ClassifyListPop(view, LinearLayoutCompat.LayoutParams.WRAP_CONTENT,
                LinearLayoutCompat.LayoutParams.WRAP_CONTENT, true, new StringCallBack() {
            @Override
            public void stringCallBack(String text) {
                mWhatClassifyTv.setText(text);
            }
        });
        mClassifyListPop.setAnimationStyle(R.style.PopupAnim);
    }

    private void initData() {
        mArrayAdapter = new RecyclerArrayAdapter<GoodsBean>(getActivity()) {
            @Override
            public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
                return new AllGoodsAdapter(parent,R.layout.item_all_goods);
            }
        };
        initRecyclerViewWithDecoratio(mRecyclerView);
        mRecyclerView.setAdapter(mArrayAdapter);
        List<GoodsBean> goodsList = new ArrayList<>();
        /*for (int i = 0; i < 10; i++) {
            GoodsBean goodsBean = new GoodsBean("哈哈哈",88,"哈哈哈","哈哈哈","哈哈哈",80);
            goodsList.add(goodsBean);
        }*/
        mArrayAdapter.addAll(goodsList);
    }

    @Override
    public void stringCallBack(String text) {
        ClassifyBean classifyBean = new ClassifyBean();
        classifyBean.setClassifyName(text);
        classifyBean.save();
    }
    /**
     * 选择类别
     */
    @OnClick(R.id.classify_ll)
    public void clickClassify() {
        List<ClassifyBean> classifyList = DataSupport.findAll(ClassifyBean.class,false);
        if (classifyList.size() == 0) {
            ToastUtils.showShortToast(getActivity(),"请先添加类别!");
        } else {
            if (mClassifyListPop != null) {
                mClassifyListPop.setData(classifyList);
                mClassifyListPop.showAsDropDown(mClassifyLl,0,1);
            }
        }
    }

    /**
     * 添加类别
     */
     @OnClick(R.id.add_classify_bt)
     public void addClassify() {
         if (mClassifyDialog == null) {
             mClassifyDialog = new ClassifyDialog();
             mClassifyDialog.setStringCallBack(this);
         }
         mClassifyDialog.show(getActivity().getSupportFragmentManager(),"classify");
     }

    /**
     * 添加商品
     */
    @OnClick(R.id.add_goods_bt)
    public void addGoods() {
        SceneUtil.toSceneForResult(getActivity(),AddGoodsActivity.class,null,100);
    }
}
