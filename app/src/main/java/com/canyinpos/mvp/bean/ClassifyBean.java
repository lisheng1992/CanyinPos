package com.canyinpos.mvp.bean;

import org.litepal.crud.DataSupport;

import java.util.List;

/**
 * 作者：Hao on 2017/8/22 17:17
 * 邮箱：shengxuan@izjjf.cn
 * 类别表,关联类别下的商品
 */

public class ClassifyBean extends DataSupport{
    /**
     * 类别名称
     */
    private String classifyName;
    /**
     * 类别折扣
     */
    private int classifyDiscount;
    /**
     * 关联的商品
     */
    private List<GoodsBean> mGoodsList;

    public String getClassifyName() {
        return classifyName;
    }

    public void setClassifyName(String classifyName) {
        this.classifyName = classifyName;
    }

    public List<GoodsBean> getGoodsList() {
        return mGoodsList;
    }

    public void setGoodsList(List<GoodsBean> goodsList) {
        mGoodsList = goodsList;
    }

    public int getClassifyDiscount() {
        return classifyDiscount;
    }

    public void setClassifyDiscount(int classifyDiscount) {
        this.classifyDiscount = classifyDiscount;
    }
}
