package com.zh.demo.ui.test;

import android.view.View;

import com.zh.demo.R;
import com.zh.demo.common.MyActivity;

/**
 * ———— author : 郑皓
 * ———— time : 2021/01/28   Thursday
 * ———— desc :
 */
public class TestPageActivity extends MyActivity {
    @Override
    protected int getLayoutId() {
        return R.layout.test_page_activity;
    }

    @Override
    protected void initView() {

        setOnClickListener(R.id.btn_1,R.id.btn_2);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_1:
                startActivity(TestAActivity.class);
                break;
            case R.id.btn_2:
                TestBActivity.start(getActivity(),getString(R.string.test_page_info));
                break;
        }
    }
}
