package com.canyinpos.mvp.bean;

import org.litepal.crud.DataSupport;

import java.io.Serializable;

/**
 * 作者：Hao on 2017/9/8 11:33
 * 邮箱：shengxuan@izjjf.n
 */

public class FlavorBean extends DataSupport implements Serializable{

    private int id;
    /**
     * 口味名称
     */
    private String flavorName;
    /**
     * 口味类型 0.加价 1.减价 2.价格为0,例如买一送一 3.折扣 例如第二杯半价
     */
    private int flavorType;
    /**
     * 加价或减价的金额
     */
    private double flavorPrice;
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

    public String getFlavorName() {
        return flavorName;
    }

    public void setFlavorName(String flavorName) {
        this.flavorName = flavorName;
    }

    public int getFlavorType() {
        return flavorType;
    }

    public void setFlavorType(int flavorType) {
        this.flavorType = flavorType;
    }

    public double getFlavorPrice() {
        return flavorPrice;
    }

    public void setFlavorPrice(double flavorPrice) {
        this.flavorPrice = flavorPrice;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }
}
