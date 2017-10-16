package com.canyinpos.mvp.bean;

/**
 * 作者：Hao on 2017/9/9 15:47
 * 邮箱：shengxuan@izjjf.cn
 */

public class GoodsSpecBean extends WrapBaseBean {
    private int id;
    /**
     * 倍率
     */
    private double specRate;

    /**
     * 规格类型 0.倍率,1.加价 2.减价
     */
    private int specType;
    /**
     * 价格
     */
    private double specPrice;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSpecRate() {
        return specRate;
    }

    public void setSpecRate(double specRate) {
        this.specRate = specRate;
    }

    public int getSpecType() {
        return specType;
    }

    public void setSpecType(int specType) {
        this.specType = specType;
    }

    public double getSpecPrice() {
        return specPrice;
    }

    public void setSpecPrice(double specPrice) {
        this.specPrice = specPrice;
    }
}
