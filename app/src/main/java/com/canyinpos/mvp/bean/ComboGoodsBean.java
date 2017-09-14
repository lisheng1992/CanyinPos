package com.canyinpos.mvp.bean;

import org.litepal.crud.DataSupport;

import java.math.BigDecimal;

/**
 * 作者：Hao on 2017/9/6 20:38
 * 邮箱：shengxuan@izjjf.cn
 * 套餐商品表
 */

public class ComboGoodsBean extends DataSupport {
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
     * 库存
     */
    private int inventory;

    /**
     * 多选中的最后一个商品
     */
    private boolean lastGoods;

    /**
     * 多选总数量
     */
    private int selectNum;

    /**
     * 总数量
     */
    private int allNum;

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

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public boolean isLastGoods() {
        return lastGoods;
    }

    public void setLastGoods(boolean lastGoods) {
        this.lastGoods = lastGoods;
    }

    public int getSelectNum() {
        return selectNum;
    }

    public void setSelectNum(int selectNum) {
        this.selectNum = selectNum;
    }

    public int getAllNum() {
        return allNum;
    }

    public void setAllNum(int allNum) {
        this.allNum = allNum;
    }
}
