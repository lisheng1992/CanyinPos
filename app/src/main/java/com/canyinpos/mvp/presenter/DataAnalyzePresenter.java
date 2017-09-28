package com.canyinpos.mvp.presenter;

import com.github.mikephil.charting.charts.LineChart;

import java.util.ArrayList;

/**
 * 作者：Hao on 2017/9/28 10:06
 * 邮箱：shengxuan@izjjf.cn
 */

public interface DataAnalyzePresenter {
    /**
     * 获取前一个月的日期集合
     * @return
     */
    ArrayList<String> getMonthList();

    /**
     * 设置一个月的销售数据
     */
    void setMonthData(LineChart lineChart);
}
