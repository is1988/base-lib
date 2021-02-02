package com.zh.demo.ui.test;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zh.base.BaseAdapter;
import com.zh.demo.R;
import com.zh.demo.common.MyActivity;
import com.zh.demo.ui.adapter.StatusAdapter;
import com.zh.widget.layout.WrapRecyclerView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;
import java.util.List;

/**
 * ———— author : 郑皓
 * ———— time : 2021/01/28   Thursday
 * ———— desc :
 */
public class TestListActivity extends MyActivity implements OnRefreshLoadMoreListener,
        BaseAdapter.OnItemClickListener {

    private SmartRefreshLayout mRlStatusRefresh;
    private WrapRecyclerView mRvStatusList;

    private StatusAdapter mAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.test_list_activity;
    }

    @Override
    protected void initView() {

        mRlStatusRefresh = findViewById(R.id.rl_status_refresh);
        mRvStatusList = findViewById(R.id.rv_status_list);

        mAdapter = new StatusAdapter(this);
        mAdapter.setOnItemClickListener(this);
        mRvStatusList.setAdapter(mAdapter);


        mRlStatusRefresh.setOnRefreshLoadMoreListener(this);

    }

    @Override
    protected void initData() {
        mAdapter.setData(analogData());
    }

    /**
     * 模拟数据
     */
    private List<String> analogData() {
        List<String> data = new ArrayList<>();
        for (int i = mAdapter.getItemCount(); i < mAdapter.getItemCount() + 20; i++) {
            data.add("我是第" + i + "条目");
        }
        return data;
    }

    @Override
    public void onItemClick(RecyclerView recyclerView, View itemView, int position) {
        toast(mAdapter.getItem(position));
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        postDelayed(() -> {
            mAdapter.clearData();
            mAdapter.setData(analogData());
            mRlStatusRefresh.finishRefresh();
            toast("刷新完成");
        }, 1000);
    }

    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        postDelayed(() -> {
            mAdapter.addData(analogData());
            mRlStatusRefresh.finishLoadMore();
            toast("加载完成");
        }, 1000);
    }
}
