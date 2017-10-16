package com.canyinpos.mvp.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.canyinpos.R;
import com.canyinpos.mvp.bean.GoodsBean;
import com.canyinpos.mvp.bean.WrapBaseBean;
import com.canyinpos.mvp.ui.activities.base.BaseActivity;
import com.canyinpos.utils.DateUtils;
import com.canyinpos.utils.ToastUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 作者：Hao on 2017/9/4 16:29
 * 邮箱：shengxuan@izjjf.cn
 */

public class AddGoodsActivity extends BaseActivity {

    @BindView(R.id.back_tv)
    TextView mBackTv;
    @BindView(R.id.head_right_bt)
    Button mHeadRightBt;
    @BindView(R.id.goods_name_et)
    EditText mGoodsNameEt;
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
    @BindView(R.id.recipe_tv)
    TextView mRecipeTv;
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
    private AlertDialog mAlertDialog;
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
        mGoodsNameEt.setText(mGoodsBean.getGoodsName());
        mGoodsBarcodeEt.setText(mGoodsBean.getBarCode());
        mGoodsStockEt.setText(mGoodsBean.getInventory());
        mGoodsTypeTv.setText(mGoodsBean.getClassifyName());
        setWrapText(mGoodsBean.getSpecs(), mSpecTv);
        setWrapText(mGoodsBean.getRecipes(), mRecipeTv);
        setWrapText(mGoodsBean.getFlavours(),mFlavourTv);
        setWrapText(mGoodsBean.getTastes(),mTasteTv);
        mSalePriceEt.setText(DateUtils.getTwoDoubles(mGoodsBean.getSellingPrice()));
        mMemberPriceEt.setText(DateUtils.getTwoDoubles(mGoodsBean.getVipPrice()));
        mProfitEt.setText(DateUtils.getTwoDoubles(mGoodsBean.getProfit()));
        mWhetherScanSt.setChecked(mGoodsBean.isScanOrder());
    }

    /**
     * 填充规格,口味,加料,做法
     */
    private void setWrapText(List<? extends WrapBaseBean> list, TextView textView) {
        if (list != null && list.size() > 0) {
            String tempStr = "";
            for (WrapBaseBean bean : list) {
                tempStr += bean.getName() + ",";
            }
            textView.setText(tempStr);
        }
    }

    /********点击事件区域start*******/

    /**
     * 生成条码
     */
    @OnClick(R.id.create_barcode_bt)
    public void createBarCode() {
       mGoodsBarcodeEt.setText(String.valueOf(System.currentTimeMillis()));
    }

    /**
     * 选择类别,规格,加料,做法,口味
     */
    @OnClick({R.id.goods_classify_ll,R.id.spec_ll,R.id.flavour_ll,R.id.recipe_ll,R.id.taste_ll})
    public void selectAttribute(View view) {
        switch (view.getId()){
            case R.id.goods_classify_ll:
                break;
            case R.id.spec_ll:

                break;
            case R.id.flavour_ll:

                break;
            case R.id.recipe_ll:

                break;
            case R.id.taste_ll:

                break;
        }
    }

    /**
     * 保存并新增
     */
    @OnClick(R.id.save_add_bt)
    public void saveAndAdd() {
        String goodsName = mGoodsNameEt.getText().toString();
        String barCode = mGoodsBarcodeEt.getText().toString();
        int stock = TextUtils.isEmpty(mGoodsStockEt.getText().toString()) ? 0:
                Integer.parseInt(mGoodsStockEt.getText().toString());
        String goodsClassify = mGoodsTypeTv.getText().toString();
        String sellPrice = mSalePriceEt.getText().toString();
        String vipPrice = mMemberPriceEt.getText().toString();
        String profit = mProfitEt.getText().toString();
        if (checkEmpty(goodsName,barCode,goodsClassify,sellPrice,vipPrice)) {

        }
    }

    /*********点击事件区域end*******/

    private boolean checkEmpty(String goodsName,String barCode,String goodsClassify,String sellPrice,String vipPrice) {
        if (TextUtils.isEmpty(goodsName)) {
            ToastUtils.showShortToast(this,"请输入商品名称!");
            return false;
        }
        if (TextUtils.isEmpty(barCode)) {
            ToastUtils.showShortToast(this,"请输入商品条码或按生成按钮!");
            return false;
        }
        if (barCode.length() < 6 || barCode.length() > 13) {
            ToastUtils.showShortToast(this,"请输入6位到13位之内的数字!");
        }
        if ("请选择".equals(goodsClassify)) {
            ToastUtils.showShortToast(this,"请选择商品类别!");
            return false;
        }
        if (TextUtils.isEmpty(sellPrice)) {
            ToastUtils.showShortToast(this,"请输入销售价!");
            return false;
        }
        if (Double.parseDouble(sellPrice) < 0) {
            ToastUtils.showShortToast(this,"销售价不能小于0!");
            return false;
        }
        if (TextUtils.isEmpty(vipPrice)) {
            ToastUtils.showShortToast(this,"请输入会员价!");
            return false;
        }
        if (Double.parseDouble(sellPrice) < 0) {
            ToastUtils.showShortToast(this,"会员价不能小于0!");
            return false;
        }
        return true;
    }
}
