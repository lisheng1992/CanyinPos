package com.canyinpos.mvp.view;

import com.canyinpos.mvp.bean.ClassifyBean;

import java.util.List;

/**
 * 作者：Hao on 2017/8/22 18:18
 * 邮箱：shengxuan@izjjf.cn
 */

public interface MainView extends BaseView {
    void  initClassify(List<ClassifyBean> mClassifyList);
}
