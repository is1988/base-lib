package com.zh.demo.ui.test;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

import com.zh.demo.R;
import com.zh.demo.common.MyActivity;
import com.zh.demo.other.IntentKey;

public class TestBActivity extends MyActivity {

    private androidx.appcompat.widget.AppCompatTextView mTv;

    public static void start(Context context, String text) {
        if (TextUtils.isEmpty(text)) {
            return;
        }
        Intent intent = new Intent(context, TestBActivity.class);
        intent.putExtra(IntentKey.TEST_PAGE_INFO, text);
        context.startActivity(intent);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.test_b_activity;
    }

    @Override
    protected void initView() {

        mTv = findViewById(R.id.tv);
    }

    @Override
    protected void initData() {

        String text = getString(IntentKey.TEST_PAGE_INFO);
        mTv.setText(text);

    }
}
