package com.zh.demo.ui.test;

import android.view.View;
import android.widget.ImageView;

import com.zh.demo.R;
import com.zh.demo.aop.SingleClick;
import com.zh.demo.common.MyActivity;
import com.zh.demo.http.glide.GlideApp;
import com.zh.widget.view.CountdownView;
import com.zh.widget.view.SwitchButton;

/**
 * ———— author : 郑皓
 * ———— time : 2021/01/28   Thursday
 * ———— desc :
 */
public class TestModActivity extends MyActivity implements SwitchButton.OnCheckedChangeListener{

    private ImageView mCircleView;
    private SwitchButton mSwitchButton;
    private CountdownView mCountdownView;

    @Override
    protected int getLayoutId() {
        return R.layout.test_mod_activity;
    }

    @Override
    protected void initView() {

        mCircleView = findViewById(R.id.iv_find_circle);
        mSwitchButton = findViewById(R.id.sb_find_switch);
        mCountdownView = findViewById(R.id.cv_find_countdown);
        setOnClickListener(mCountdownView);

        mSwitchButton.setOnCheckedChangeListener(this);

    }

    @Override
    protected void initData() {
        GlideApp.with(this)
                .load(R.drawable.example_bg)
                .circleCrop()
                .into(mCircleView);
    }


    @SingleClick
    @Override
    public void onClick(View v) {
        if (v == mCountdownView) {
            toast(R.string.common_code_send_hint);
            mCountdownView.start();
        }
    }


    @Override
    public void onCheckedChanged(SwitchButton button, boolean isChecked) {
        toast(isChecked);
    }
}
