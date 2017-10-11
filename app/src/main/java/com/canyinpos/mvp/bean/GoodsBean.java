package com.canyinpos.mvp.bean;

import org.litepal.crud.DataSupport;

import java.util.List;

/**
 * 作者：Hao on 2017/8/22 17:24
 * 邮箱：shengxuan@izjjf.cn
 * 商品表,关联类别
 */

public class GoodsBean extends DataSupport{
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 商品小图片
     */
    private String smallImgUrl;
    /**
     * 商品大图片
     */
    private String bigImgUrl;
    /**
     * 商品id
     */
    private String goodsId;

    /**
     * 采购价
     */
    private double purchasePrice;
    /**
     * 销售价
     */
    private double sellingPrice;
    /**
     * 会员价
     */
    private double vipPrice;
    /**
     * 是否可称重
     */
    private boolean isWeigh;
    /**
     * 所属类别名称
     */
    private String classifyName;
    /**
     * 规格
     */
    private List<GoodsSpecBean> mSpecs;
    /**
     * 口味
     */
    private List<FlavorBean> mFlavors;
    /**
     * 做法
     */
    private List<ZuofaBean> mZuofas;
    /**
     * 加料
     */
    private List<JialiaoBean> mJialiaos;
    /**
     * 条码
     */
    private String barCode;
    /**
     * 是否可扫码点餐
     */
    private boolean isScanOrder;
    /**
     * 关联的类别
     */
    private ClassifyBean mClassifyBean;

    /**
     * 库存
     */
    private int inventory;

    public GoodsBean(String name,double sellPrice) {
        this.goodsName = name;
        this.sellingPrice = sellPrice;
    }

    public GoodsBean(String name,double sellPrice,String classifyName,String barCode,int inventory) {
        this.goodsName = name;
        this.sellingPrice = sellPrice;
        this.classifyName = classifyName;
        this.barCode = barCode;
        this.inventory = inventory;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getSmallImgUrl() {
        return smallImgUrl;
    }

    public void setSmallImgUrl(String smallImgUrl) {
        this.smallImgUrl = smallImgUrl;
    }

    public String getBigImgUrl() {
        return bigImgUrl;
    }

    public void setBigImgUrl(String bigImgUrl) {
        this.bigImgUrl = bigImgUrl;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public double getVipPrice() {
        return vipPrice;
    }

    public void setVipPrice(double vipPrice) {
        this.vipPrice = vipPrice;
    }

    public boolean isWeigh() {
        return isWeigh;
    }

    public void setWeigh(boolean weigh) {
        isWeigh = weigh;
    }

    public String getClassifyName() {
        return classifyName;
    }

    public void setClassifyName(String classifyName) {
        this.classifyName = classifyName;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public boolean isScanOrder() {
        return isScanOrder;
    }

    public void setScanOrder(boolean scanOrder) {
        isScanOrder = scanOrder;
    }

    public ClassifyBean getClassifyBean() {
        return mClassifyBean;
    }

    public void setClassifyBean(ClassifyBean classifyBean) {
        mClassifyBean = classifyBean;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public List<GoodsSpecBean> getSpecs() {
        return mSpecs;
    }

    public void setSpecs(List<GoodsSpecBean> specs) {
        mSpecs = specs;
    }

    public List<FlavorBean> getFlavors() {
        return mFlavors;
    }

    public void setFlavors(List<FlavorBean> flavors) {
        mFlavors = flavors;
    }

    public List<ZuofaBean> getZuofas() {
        return mZuofas;
    }

    public void setZuofas(List<ZuofaBean> zuofas) {
        mZuofas = zuofas;
    }

    public List<JialiaoBean> getJialiaos() {
        return mJialiaos;
    }

    public void setJialiaos(List<JialiaoBean> jialiaos) {
        mJialiaos = jialiaos;
    }
}
