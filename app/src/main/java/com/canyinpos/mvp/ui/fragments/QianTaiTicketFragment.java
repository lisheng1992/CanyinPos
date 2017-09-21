package com.canyinpos.mvp.ui.fragments;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.canyinpos.R;
import com.canyinpos.mvp.ui.fragments.base.BaseFragment;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 作者：Hao on 2017/9/13 11:14
 * 邮箱：shengxuan@izjjf.cn
 * 前台小票
 */

public class QianTaiTicketFragment extends BaseFragment {
    @BindView(R.id.save_ticket_bt)
    Button mSaveTicketBt;
    @BindView(R.id.page_attack_tv)
    TextView mPageAttackTv;
    @BindView(R.id.page_attack_et)
    EditText mPageAttackEt;
    @BindView(R.id.page_attack_iv)
    ImageView mPageAttackIv;
    private boolean pageAttack;
    @Override
    public void initViews(View view) {
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_qiantai_ticket;
    }

    @OnClick(R.id.page_attack_iv)
    public void setPageAttack() {
        if (pageAttack) {
            mPageAttackEt.setVisibility(View.GONE);
            mPageAttackTv.setVisibility(View.VISIBLE);
            mPageAttackTv.setText(mPageAttackEt.getText());
        } else {
            mPageAttackEt.setVisibility(View.VISIBLE);
            mPageAttackEt.setText(mPageAttackTv.getText().toString());
            mPageAttackEt.selectAll();
            mPageAttackEt.requestFocus();
            mPageAttackTv.setVisibility(View.GONE);
        }
        pageAttack = !pageAttack;
    }
}
