package com.canyinpos.mvp.bean;

import org.litepal.crud.DataSupport;

/**
 * 作者：Hao on 2017/8/24 15:55
 * 邮箱：shengxuan@izjjf.cn
 */

public class FunctionBean extends DataSupport{
    private String functionName;
    private int functionImg;

    public FunctionBean() {
    }

    public FunctionBean(String functionName, int functionImg) {
        this.functionName = functionName;
        this.functionImg = functionImg;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public int getFunctionImg() {
        return functionImg;
    }

    public void setFunctionImg(int functionImg) {
        this.functionImg = functionImg;
    }
}
