package com.canyinpos.mvp.bean;

import org.litepal.crud.DataSupport;

import java.util.List;

/**
 * 作者：Hao on 2017/9/5 18:20
 * 邮箱：shengxuan@izjjf.cn
 */

public class ComboBean extends DataSupport {

    private int selectNum;

    private List<GoodsBean> mGoodsList;

    public int getSelectNum() {
        return selectNum;
    }

    public void setSelectNum(int selectNum) {
        this.selectNum = selectNum;
    }

    public List<GoodsBean> getGoodsList() {
        return mGoodsList;
    }

    public void setGoodsList(List<GoodsBean> goodsList) {
        mGoodsList = goodsList;
    }
}
