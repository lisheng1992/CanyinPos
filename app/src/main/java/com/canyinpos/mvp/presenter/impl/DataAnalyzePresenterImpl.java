package com.canyinpos.mvp.presenter.impl;

import android.content.Context;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.content.ContextCompat;

import com.canyinpos.R;
import com.canyinpos.mvp.interactor.OperateChartInteractor;
import com.canyinpos.mvp.interactor.impl.OperateChartInteractorImpl;
import com.canyinpos.mvp.presenter.DataAnalyzePresenter;
import com.canyinpos.mvp.presenter.base.BasePresenterImpl;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;

/**
 * 作者：Hao on 2017/9/28 10:07
 * 邮箱：shengxuan@izjjf.cn
 */

public class DataAnalyzePresenterImpl extends BasePresenterImpl implements DataAnalyzePresenter {

    private OperateChartInteractor mChartInteractor;
    private Context mContext;
    public DataAnalyzePresenterImpl(Context context) {
        this.mChartInteractor = new OperateChartInteractorImpl();
        this.mContext = context;
    }

    @Override
    public ArrayList<String> getMonthList() {
        return mChartInteractor.getMonthList();
    }

    @Override
    public void setMonthData(LineChart lineChart ) {
        ArrayList<Entry> entries = new ArrayList<>();
        entries.add(new Entry(0, 2000));
        entries.add(new Entry(1, 3000));
        entries.add(new Entry(2, 2986));
        entries.add(new Entry(3, 2500));
        entries.add(new Entry(4, 3125));
        entries.add(new Entry(5, 5698));
        entries.add(new Entry(6, 4010));
        entries.add(new Entry(7, 3200));
        entries.add(new Entry(8, 2935));
        entries.add(new Entry(9, 5600));
        entries.add(new Entry(10, 4800));
        entries.add(new Entry(11, 4896));
        entries.add(new Entry(12, 4520));
        entries.add(new Entry(13, 3520));
        entries.add(new Entry(14, 3416));
        entries.add(new Entry(15, 2980));
        entries.add(new Entry(16, 3999));
        entries.add(new Entry(17, 4999));
        entries.add(new Entry(18, 4500));
        entries.add(new Entry(19, 3000));
        entries.add(new Entry(20, 6200));
        entries.add(new Entry(21, 4500));
        entries.add(new Entry(22, 3999));
        entries.add(new Entry(23, 4999));
        entries.add(new Entry(24, 4500));
        entries.add(new Entry(25, 3000));
        entries.add(new Entry(26, 6200));
        entries.add(new Entry(27, 4500));
        entries.add(new Entry(28, 3000));
        entries.add(new Entry(29, 6200));
        LineDataSet lineDataSet;
        if (lineChart.getData() != null && lineChart.getData().getDataSetCount() > 0) {
            lineDataSet = (LineDataSet)lineChart.getData().getDataSetByIndex(0);
            lineDataSet.setValues(entries);
            lineChart.getData().notifyDataChanged();
            lineChart.notifyDataSetChanged();
        } else {
            lineDataSet = new LineDataSet(entries,"月销售额走势图");
            lineDataSet.setDrawIcons(false);
            lineDataSet.enableDashedLine(10f, 5f, 0f);
            lineDataSet.enableDashedHighlightLine(10f, 5f, 0f);
            lineDataSet.setColor(Color.BLACK);
            lineDataSet.setCircleColor(Color.BLACK);
            lineDataSet.setLineWidth(1f);
            lineDataSet.setCircleRadius(3f);
            lineDataSet.setDrawCircleHole(false);
            lineDataSet.setValueTextSize(9f);
            lineDataSet.setDrawFilled(true);
            lineDataSet.setFormLineWidth(1f);
            lineDataSet.setFormLineDashEffect(new DashPathEffect(new float[]{10f, 5f}, 0f));
            lineDataSet.setFormSize(15.f);

            if (Build.VERSION.SDK_INT >= 18) {
                Drawable drawable = ContextCompat.getDrawable(mContext, R.drawable.fade_red);
                lineDataSet.setFillDrawable(drawable);
            } else {
                lineDataSet.setFillColor(Color.GREEN);
            }
            ArrayList<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();
            //添加数据集
            dataSets.add(lineDataSet);
            //创建一个数据集的数据对象
            LineData data = new LineData(dataSets);
            //谁知数据
            lineChart.setData(data);
        }
    }
}
