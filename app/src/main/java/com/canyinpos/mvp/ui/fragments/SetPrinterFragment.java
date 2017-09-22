package com.canyinpos.mvp.ui.fragments;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;

import com.canyinpos.R;
import com.canyinpos.mvp.ui.customview.RadarView;
import com.canyinpos.mvp.ui.fragments.base.BaseFragment;
import com.canyinpos.utils.ToastUtils;

import butterknife.BindView;
import butterknife.OnClick;
import easyrecyclerview.EasyRecyclerView;

/**
 * 作者：Hao on 2017/9/18 14:47
 * 邮箱：shengxuan@izjjf.cn
 */

public class SetPrinterFragment extends BaseFragment {
    @BindView(R.id.radar_view)
    RadarView mRadarView;
    @BindView(R.id.auto_search_cv)
    CardView mAutoSearchCv;
    @BindView(R.id.be_using_tv)
    TextView mBeUsingTv;
    @BindView(R.id.printer_list_erv)
    EasyRecyclerView mPrinterListErv;

    private BluetoothAdapter mBluetoothAdapter;
    private BluetoothGatt mBluetoothGatt;

    private final BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (BluetoothDevice.ACTION_FOUND.equals(action)) {
                BluetoothDevice bluetoothDevice = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
            }
        }
    };

    @Override
    public void initViews(View view) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_printer;
    }

    @OnClick(R.id.auto_search_cv)
    public void autoSearch() {
        mRadarView.addPoint();
        mRadarView.addPoint();
        mRadarView.setSearching(true);
    }

    private void testBluetooth() {
        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (mBluetoothAdapter == null) {
            ToastUtils.showShortToast(getActivity(),"此设备不支持蓝牙设备!");
            return;
        }
        if (!mBluetoothAdapter.isEnabled()) {
            mBluetoothAdapter.enable();
        }
    }
}
