package com.example.yjj.yijinjing.common.myactivity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.yjj.yijinjing.R;
import com.example.yjj.yijinjing.adapter.RecycleViewAdapter;
import com.example.yjj.yijinjing.base.BaseViewActivity;
import com.example.yjj.yijinjing.common.util.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tx on 2017/11/17.
 */

public class RecycleViewActivity extends BaseViewActivity implements View.OnClickListener{

    private RecyclerView recyclerView;
    private RecycleViewAdapter mAdapter;

    private TextView tvLoadMore;//加载更多

    private List<String> mDatas = new ArrayList<>();//recycleview中填充的数据

    @Override
    public int getLayoutId() {
        return R.layout.activity_recycleview;
    }

    @Override
    public void initViewFromXml() {
        recyclerView = (RecyclerView) findViewById(R.id.re_lv);
        tvLoadMore = (TextView) findViewById(R.id.tv_load_more);
    }

    @Override
    public void initListener() {
        tvLoadMore.setOnClickListener(this);
    }

    @Override
    public void initData() {
        initDatas();//初始化数据
    }

    /**
     * 初始化数据
     */
    private void initDatas() {
        for (int i = 0; i < 10; i++){
            mDatas.add(i + "");
        }
    }

    @Override
    public void fillView() {
        mAdapter = new RecycleViewAdapter(this, mDatas);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        recyclerView.setAdapter(mAdapter);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_load_more:
                loadMoreData();
                break;
        }
    }

    /**
     * 获得更多数据
     */
    private void loadMoreData() {
        for (int i = 10; i < 20; i++){
            mDatas.add(i + "");
        }
        mAdapter.notifyDataSetChanged();
    }
}
