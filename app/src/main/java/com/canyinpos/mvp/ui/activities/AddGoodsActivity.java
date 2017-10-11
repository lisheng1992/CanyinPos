package com.canyinpos.mvp.ui.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.canyinpos.R;
import com.canyinpos.mvp.bean.GoodsBean;
import com.canyinpos.mvp.ui.activities.base.BaseActivity;

import butterknife.BindView;

/**
 * 作者：Hao on 2017/9/4 16:29
 * 邮箱：shengxuan@izjjf.cn
 */

public class AddGoodsActivity extends BaseActivity {
    @BindView(R.id.back_tv)
    TextView mBackTv;
    @BindView(R.id.head_right_bt)
    Button mHeadRightBt;
    @BindView(R.id.tv_goods_bar_code)
    TextView mTvGoodsBarCode;
    @BindView(R.id.goods_name_tv)
    EditText mGoodsNameTv;
    @BindView(R.id.goods_barcode_et)
    EditText mGoodsBarcodeEt;
    @BindView(R.id.create_barcode_bt)
    Button mCreateBarcodeBt;
    @BindView(R.id.goods_stock_et)
    EditText mGoodsStockEt;
    @BindView(R.id.goods_type_tv)
    TextView mGoodsTypeTv;
    @BindView(R.id.spec_tv)
    TextView mSpecTv;
    @BindView(R.id.flavour_tv)
    TextView mFlavourTv;
    @BindView(R.id.zuofa_tv)
    TextView mZuofaTv;
    @BindView(R.id.taste_tv)
    TextView mTasteTv;
    @BindView(R.id.goods_img_iv)
    ImageView mGoodsImgIv;
    @BindView(R.id.goods_img_rl)
    RelativeLayout mGoodsImgRl;
    @BindView(R.id.sale_price_et)
    EditText mSalePriceEt;
    @BindView(R.id.member_price_et)
    EditText mMemberPriceEt;
    @BindView(R.id.profit_et)
    EditText mProfitEt;
    @BindView(R.id.whether_scan_st)
    Switch mWhetherScanSt;
    @BindView(R.id.cancel_bt)
    Button mCancelBt;
    @BindView(R.id.save_add_bt)
    Button mSaveAddBt;
    @BindView(R.id.save_return_bt)
    Button mSaveReturnBt;

    private GoodsBean mGoodsBean;
    @Override
    public int getLayoutId() {
        return R.layout.activity_add_goods;
    }

    @Override
    public void initData() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            mBackTv.setText("编辑商品");
            mGoodsBean = (GoodsBean) bundle.getSerializable("GoodsBean");
            initGoodsBean();
        } else {
            mBackTv.setText("添加商品");
        }
    }
    @Override
    public void initPresenter() {

    }
    /**
     * 编辑商品时填充商品数据
     */
    private void initGoodsBean() {
        mGoodsNameTv.setText(mGoodsBean.getGoodsName());
        mGoodsBarcodeEt.setText(mGoodsBean.getBarCode());
        mGoodsStockEt.setText(mGoodsBean.getInventory());
        mGoodsTypeTv.setText(mGoodsBean.getClassifyName());
        if (mGoodsBean.getSpecs() != null && mGoodsBean.getSpecs().size() > 0) {

        }
    }
}
