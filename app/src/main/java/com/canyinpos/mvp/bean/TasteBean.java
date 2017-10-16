package com.canyinpos.mvp.bean;

import java.io.Serializable;

/**
 * 作者：Hao on 2017/9/8 11:33
 * 邮箱：shengxuan@izjjf.n
 */

public class TasteBean extends WrapBaseBean implements Serializable{

    private int id;

    /**
     * 口味类型 0.加价 1.减价 2.价格为0,例如买一送一 3.折扣 例如第二杯半价
     */
    private int tasteType;
    /**
     * 加价或减价的金额
     */
    private double tastePrice;
    /**
     * 折扣率
     */
    private double discountRate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTasteType() {
        return tasteType;
    }

    public void setTasteType(int tasteType) {
        this.tasteType = tasteType;
    }

    public double getTastePrice() {
        return tastePrice;
    }

    public void setTastePrice(double tastePrice) {
        this.tastePrice = tastePrice;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }
}
