package com.canyinpos.mvp.ui.fragments;

import android.graphics.Color;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;

import com.canyinpos.R;
import com.canyinpos.mvp.ui.fragments.base.BaseFragment;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.MPPointF;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * 作者：Hao on 2017/9/25 15:14
 * 邮箱：shengxuan@izjjf.cn
 * 收银汇总
 */

public class AllSalesFragment extends BaseFragment{

    @BindView(R.id.sales_pie_chart)
    PieChart mSalesPieChart;
    @BindView(R.id.number_pie_chart)
    PieChart mNumSalesPieChart;

    private ArrayList<Integer> colors = new ArrayList<>();
    @Override
    public void initViews(View view) {
        initSalesPieChart();
        initNumPieChart();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_all_sales;
    }

    @Override
    public void initPresenter() {

    }

    private void initSalesPieChart() {
        mSalesPieChart.setUsePercentValues(true);
        mSalesPieChart.setExtraOffsets(20,20,20,20);
        mSalesPieChart.setDragDecelerationFrictionCoef(0.95f);
        mSalesPieChart.setCenterText(salesCenterSpannableText());
        mSalesPieChart.setDrawCenterText(true);
        mSalesPieChart.setDrawHoleEnabled(true);
        mSalesPieChart.setHoleColor(Color.WHITE);
        mSalesPieChart.setTransparentCircleColor(Color.WHITE);
        mSalesPieChart.setTransparentCircleAlpha(110);
        mSalesPieChart.setRotationAngle(0);
        // enable rotation of the chart by touch
        mSalesPieChart.setRotationEnabled(true);
        mSalesPieChart.setHighlightPerTapEnabled(true);

        ArrayList<PieEntry> pieEntries = new ArrayList<>();
        pieEntries.add(new PieEntry(25f,"现金 ¥88.88"));
        pieEntries.add(new PieEntry(25f,"微信 ¥88.88"));
        pieEntries.add(new PieEntry(25f,"支付宝 ¥88.88"));
        pieEntries.add(new PieEntry(25f,"会员 ¥88.88"));

        invalidate(pieEntries,mSalesPieChart);
        mSalesPieChart.animateY(1000, Easing.EasingOption.EaseInOutQuad);
        Legend l = mSalesPieChart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        l.setOrientation(Legend.LegendOrientation.VERTICAL);
        l.setDrawInside(false);
        l.setXEntrySpace(7f);
        l.setYEntrySpace(0f);
        l.setYOffset(0f);

        // entry label styling
        mSalesPieChart.setEntryLabelColor(Color.WHITE);
        mSalesPieChart.setEntryLabelTextSize(12f);
    }

    private void initNumPieChart() {
        mNumSalesPieChart.setUsePercentValues(true);
        mNumSalesPieChart.setExtraOffsets(20,20,20,20);
        mNumSalesPieChart.setDragDecelerationFrictionCoef(0.95f);
        mNumSalesPieChart.setCenterText(numberCenterSpannableText());
        mNumSalesPieChart.setDrawCenterText(true);
        mNumSalesPieChart.setDrawHoleEnabled(true);
        mNumSalesPieChart.setHoleColor(Color.WHITE);
        mNumSalesPieChart.setTransparentCircleColor(Color.WHITE);
        mNumSalesPieChart.setTransparentCircleAlpha(110);
        mNumSalesPieChart.setRotationAngle(0);
        // enable rotation of the chart by touch
        mNumSalesPieChart.setRotationEnabled(true);
        mNumSalesPieChart.setHighlightPerTapEnabled(true);

        ArrayList<PieEntry> pieEntries = new ArrayList<>();
        pieEntries.add(new PieEntry(25f,"现金 88单"));
        pieEntries.add(new PieEntry(25f,"微信 88单"));
        pieEntries.add(new PieEntry(25f,"支付宝 88单"));
        pieEntries.add(new PieEntry(25f,"会员 88单"));

        invalidate(pieEntries,mNumSalesPieChart);
        mNumSalesPieChart.animateY(1000, Easing.EasingOption.EaseInOutQuad);
        Legend l = mNumSalesPieChart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        l.setOrientation(Legend.LegendOrientation.VERTICAL);
        l.setDrawInside(false);
        l.setXEntrySpace(7f);
        l.setYEntrySpace(0f);
        l.setYOffset(0f);

        // entry label styling
        mNumSalesPieChart.setEntryLabelColor(Color.WHITE);
        mNumSalesPieChart.setEntryLabelTextSize(12f);

    }

    private SpannableString salesCenterSpannableText() {
        SpannableString s = new SpannableString("营业额\n支付方式比例图");
        s.setSpan(new AbsoluteSizeSpan(30,false), 0, 3, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //s.setSpan(new StyleSpan(Typeface.NORMAL), 14, s.length() - 15, 0);
        //s.setSpan(new ForegroundColorSpan(Color.GRAY), 14, s.length() - 15, 0);
        //s.setSpan(new RelativeSizeSpan(.8f), 14, s.length() - 15, 0);
        s.setSpan(new StyleSpan(Typeface.ITALIC), s.length() - 3, s.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        s.setSpan(new ForegroundColorSpan(ColorTemplate.getHoloBlue()), s.length() - 3, s.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return s;
    }

    private SpannableString numberCenterSpannableText() {
        SpannableString s = new SpannableString("订单总额\n支付方式比例图");
        s.setSpan(new AbsoluteSizeSpan(30,false), 0, 4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //s.setSpan(new StyleSpan(Typeface.NORMAL), 14, s.length() - 15, 0);
        //s.setSpan(new ForegroundColorSpan(Color.GRAY), 14, s.length() - 15, 0);
        //s.setSpan(new RelativeSizeSpan(.8f), 14, s.length() - 15, 0);
        s.setSpan(new StyleSpan(Typeface.ITALIC), s.length() - 4, s.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        s.setSpan(new ForegroundColorSpan(ColorTemplate.getHoloBlue()), s.length() - 4, s.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return s;
    }

    private void invalidate(ArrayList<PieEntry> pieEntries,PieChart pieChart) {
        PieDataSet dataSet = new PieDataSet(pieEntries,"支付方式");
        dataSet.setDrawIcons(false);
        dataSet.setSliceSpace(3f);
        dataSet.setIconsOffset(new MPPointF(0, 40));
        dataSet.setSelectionShift(5f);

        colors.add(Color.parseColor("#ff764a"));
        colors.add(Color.parseColor("#0F9D58"));
        colors.add(Color.parseColor("#1B82D2"));
        colors.add(Color.parseColor("#4e4743"));
        dataSet.setColors(colors);

        PieData data = new PieData(dataSet);
        data.setValueFormatter(new PercentFormatter());
        data.setValueTextSize(11f);
        data.setValueTextColor(Color.WHITE);
        pieChart.setData(data);

        // undo all highlights
        pieChart.highlightValues(null);

        pieChart.invalidate();
    }
}
