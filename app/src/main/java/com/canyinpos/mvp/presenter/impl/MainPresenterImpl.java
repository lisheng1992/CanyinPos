package com.canyinpos.mvp.presenter.impl;

import com.canyinpos.mvp.bean.ClassifyBean;
import com.canyinpos.mvp.presenter.MainPresenter;
import com.canyinpos.mvp.presenter.base.BasePresenterImpl;
import com.canyinpos.mvp.view.MainView;

import org.litepal.crud.DataSupport;

import java.util.List;

/**
 * 作者：Hao on 2017/8/22 18:16
 * 邮箱：shengxuan@izjjf.cn
 */

public class MainPresenterImpl extends BasePresenterImpl<MainView,List<ClassifyBean>> implements MainPresenter{

    @Override
    public void getClassifyListFromDb() {
        List<ClassifyBean> classifyList = DataSupport.findAll(ClassifyBean.class);
        mView.initClassify(classifyList);
    }
}
