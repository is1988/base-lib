package com.zh.demo.ui.test;

import com.zh.demo.R;
import com.zh.demo.common.MyFragment;

/**
 * ———— author : 郑皓
 * ———— time : 2021/01/26   Tuesday
 * ———— desc :
 */
public class Test3Fragment extends MyFragment<TestHomeActivity> {
    @Override
    protected int getLayoutId() {
        return R.layout.test3_fragment;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    public boolean isStatusBarEnabled() {
        // 使用沉浸式状态栏
        return !super.isStatusBarEnabled();
    }
}
