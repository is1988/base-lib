package com.zh.demo.ui.test;

import android.view.View;

import androidx.appcompat.widget.AppCompatTextView;

import com.zh.demo.R;
import com.zh.demo.common.MyFragment;

/**
 * ———— author : 郑皓
 * ———— time : 2021/01/26   Tuesday
 * ———— desc :
 */
public class Test1Fragment extends MyFragment<TestHomeActivity> {


    private AppCompatTextView mTvPage;
    private AppCompatTextView mTvImg;
    private AppCompatTextView mTvDialog;
    private AppCompatTextView mTvMod;
    private AppCompatTextView mTvList;
    private AppCompatTextView mTvHttp;

    @Override
    protected int getLayoutId() {
        return R.layout.test1_fragment;
    }

    @Override
    protected void initView() {

        mTvPage = findViewById(R.id.tv_page);
        mTvImg = findViewById(R.id.tv_img);
        mTvDialog = findViewById(R.id.tv_dialog);
        mTvMod = findViewById(R.id.tv_mod);
        mTvList = findViewById(R.id.tv_list);
        mTvHttp = findViewById(R.id.tv_http);

        setOnClickListener(R.id.tv_page, R.id.tv_img, R.id.tv_dialog, R.id.tv_mod, R.id.tv_list, R.id.tv_http);

    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_page:
                startActivity(TestPageActivity.class);
                break;
            case R.id.tv_img:
                startActivity(TestImgActivity.class);
                break;
            case R.id.tv_dialog:
                startActivity(TestDialogActivity.class);
                break;
            case R.id.tv_mod:
                startActivity(TestModActivity.class);
                break;
            case R.id.tv_list:
                startActivity(TestListActivity.class);
                break;
            case R.id.tv_http:
                startActivity(TestHttpActivity.class);
                break;
        }
    }

    @Override
    public boolean isStatusBarEnabled() {
        // 使用沉浸式状态栏
        return !super.isStatusBarEnabled();
    }
}
