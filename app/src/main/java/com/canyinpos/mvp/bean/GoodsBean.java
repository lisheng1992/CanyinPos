package com.canyinpos.mvp.bean;

import org.litepal.crud.DataSupport;

import java.math.BigDecimal;

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
    private BigDecimal purchasePrice;
    /**
     * 销售价
     */
    private BigDecimal sellingPrice;
    /**
     * 会员价
     */
    private BigDecimal vipPrice;
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
    private String spec;
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

    public GoodsBean(String name,BigDecimal sellPrice) {
        this.goodsName = name;
        this.sellingPrice = sellPrice;
    }

    public GoodsBean(String name,BigDecimal sellPrice,String classifyName,String spec,String barCode,int inventory) {
        this.goodsName = name;
        this.sellingPrice = sellPrice;
        this.classifyName = classifyName;
        this.spec = spec;
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

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public BigDecimal getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(BigDecimal sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public BigDecimal getVipPrice() {
        return vipPrice;
    }

    public void setVipPrice(BigDecimal vipPrice) {
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

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
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
}
