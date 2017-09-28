package com.canyinpos.mvp.interactor.impl;

import com.canyinpos.mvp.interactor.OperateChartInteractor;
import com.socks.library.KLog;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * 作者：Hao on 2017/9/27 19:31
 * 邮箱：shengxuan@izjjf.cn
 * 图表数据操作
 */

public class OperateChartInteractorImpl implements OperateChartInteractor {

    @Override
    public ArrayList<String> getMonthList() {
        ArrayList<String> month = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
        for (int i = 0;i > -31;i--) {
            calendar.setTime(new Date());
            calendar.add(Calendar.DATE,i);
            Date date = calendar.getTime();
            month.add(sdf.format(date));
        }
        KLog.i(month.toString());
        return month;
    }
}
