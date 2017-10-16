package com.canyinpos.mvp.bean;

import org.litepal.crud.DataSupport;

/**
 * 作者：Hao on 2017/10/12 10:41
 * 邮箱：shengxuan@izjjf.cn
 */

public class WrapBaseBean extends DataSupport {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
