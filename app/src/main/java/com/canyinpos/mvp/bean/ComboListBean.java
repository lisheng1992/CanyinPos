package com.canyinpos.mvp.bean;

import org.litepal.crud.DataSupport;

import java.math.BigDecimal;
import java.util.List;

/**
 * 作者：Hao on 2017/9/5 18:02
 * 邮箱：shengxuan@izjjf.cn
 */

public class ComboListBean extends DataSupport {

    /**
     * 套餐名称
     */
    private String comboName;

    /**
     * 套餐价格
     */
    private BigDecimal comboPrice;

    /**
     * 套餐会员价
     */
    private BigDecimal comboVipPrice;

    /**
     * 套餐模式
     * 0表示固定套餐,1表示自选套餐
     */
    private int comboType;

    private List<ComboBean> mComboBeanList;

    public String getComboName() {
        return comboName;
    }

    public void setComboName(String comboName) {
        this.comboName = comboName;
    }

    public BigDecimal getComboPrice() {
        return comboPrice;
    }

    public void setComboPrice(BigDecimal comboPrice) {
        this.comboPrice = comboPrice;
    }

    public BigDecimal getComboVipPrice() {
        return comboVipPrice;
    }

    public void setComboVipPrice(BigDecimal comboVipPrice) {
        this.comboVipPrice = comboVipPrice;
    }

    public int getComboType() {
        return comboType;
    }

    public void setComboType(int comboType) {
        this.comboType = comboType;
    }

    public List<ComboBean> getComboBeanList() {
        return DataSupport.findAll(ComboBean.class,true);
    }

    public void setComboBeanList(List<ComboBean> comboBeanList) {
        mComboBeanList = comboBeanList;
    }
}
