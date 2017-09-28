package com.canyinpos.mvp.ui.fragments;

import android.view.View;

import com.canyinpos.R;
import com.canyinpos.mvp.presenter.impl.DataAnalyzePresenterImpl;
import com.canyinpos.mvp.ui.fragments.base.BaseFragment;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * 作者：Hao on 2017/9/26 17:51
 * 邮箱：shengxuan@izjjf.cn
 * 运营分析
 */

public class OperateAnalyzeFragemnt extends BaseFragment<DataAnalyzePresenterImpl> {

    @BindView(R.id.sales_line_chart)
    LineChart mSalesLineChart;
    @BindView(R.id.number_line_chart)
    LineChart mNumLineChart;

    @Override
    public void initViews(View view) {
        initLineChart(mSalesLineChart);
        initLineChart(mNumLineChart);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_operate_analyze;
    }

    @Override
    public void initPresenter() {
        mPresenter = new DataAnalyzePresenterImpl(getActivity());
    }

    private void initSalesLineChart() {
        mSalesLineChart.getDescription().setEnabled(true);
        /*MarkerView markerView = new MarkerView(getActivity(), R.layout.custom_mark_view);
        markerView.setChartView(mSalesLineChart);
        mSalesLineChart.setMarker(markerView);*/

        XAxis xAxis = mSalesLineChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.enableGridDashedLine(10f, 10f, 0f);
        final ArrayList<String> month = mPresenter.getMonthList();
        xAxis.setLabelCount(30);
        xAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return String.valueOf(month.get((int) value));
            }
        });

        YAxis leftAxis = mSalesLineChart.getAxisLeft();
        leftAxis.removeAllLimitLines();
        leftAxis.enableGridDashedLine(10f, 10f, 0f);
        leftAxis.setDrawZeroLine(false);

        mPresenter.setMonthData(mSalesLineChart);
        mSalesLineChart.animateX(2000);
        Legend l = mSalesLineChart.getLegend();
        l.setForm(Legend.LegendForm.LINE);
    }

    private void initNumLineChart() {
        mNumLineChart.getDescription().setEnabled(false);
        XAxis xAxis = mNumLineChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.enableGridDashedLine(10f, 10f, 0f);
        final ArrayList<String> month = mPresenter.getMonthList();
        xAxis.setLabelCount(30);
        xAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return String.valueOf(month.get((int) value));
            }
        });
    }

    private void initLineChart(LineChart lineChart) {
        lineChart.getDescription().setEnabled(true);
        /*MarkerView markerView = new MarkerView(getActivity(), R.layout.custom_mark_view);
        markerView.setChartView(mSalesLineChart);
        mSalesLineChart.setMarker(markerView);*/

        XAxis xAxis = lineChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.enableGridDashedLine(10f, 10f, 0f);
        final ArrayList<String> month = mPresenter.getMonthList();
        xAxis.setLabelCount(30);
        xAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return String.valueOf(month.get((int) value));
            }
        });

        YAxis leftAxis = lineChart.getAxisLeft();
        leftAxis.removeAllLimitLines();
        leftAxis.enableGridDashedLine(10f, 10f, 0f);
        leftAxis.setDrawZeroLine(false);

        mPresenter.setMonthData(lineChart);
        lineChart.animateX(2000);
        Legend l = lineChart.getLegend();
        l.setForm(Legend.LegendForm.LINE);
    }
}
