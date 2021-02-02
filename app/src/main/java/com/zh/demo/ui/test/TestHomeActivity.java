package com.zh.demo.ui.test;

import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.zh.base.BaseFragmentAdapter;
import com.zh.demo.R;
import com.zh.demo.common.MyActivity;
import com.zh.demo.common.MyFragment;

public class TestHomeActivity extends MyActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private ViewPager mViewPager;
    private BottomNavigationView mBottomNavigationView;
    private BaseFragmentAdapter<MyFragment> mPagerAdapter;

    public TestHomeActivity() {
    }

    @Override
    protected int getLayoutId() {
        return R.layout.test_home_activity;
    }

    @Override
    protected void initView() {
        mViewPager = findViewById(R.id.vp_home_pager);
        mBottomNavigationView = findViewById(R.id.bv_home_navigation);

        mBottomNavigationView.setItemIconTintList(null);
        mBottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    @Override
    protected void initData() {

        Log.e("test",getLocalClassName());

        mPagerAdapter = new BaseFragmentAdapter<>(this);
        mPagerAdapter.addFragment(new Test1Fragment());
        mPagerAdapter.addFragment(new Test2Fragment());
        mPagerAdapter.addFragment(new Test3Fragment());
        mPagerAdapter.addFragment(new Test4Fragment());
        // 设置成懒加载模式
        mPagerAdapter.setLazyMode(true);
        mViewPager.setAdapter(mPagerAdapter);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_home:
                mViewPager.setCurrentItem(0);
                return true;
            case R.id.home_found:
                mViewPager.setCurrentItem(1);
                return true;
            case R.id.home_message:
                mViewPager.setCurrentItem(2);
                return true;
            case R.id.home_me:
                mViewPager.setCurrentItem(3);
                return true;
            default:
                break;
        }
        return false;
    }
}
