package com.example.yjj.yijinjing.common.myactivity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.yjj.yijinjing.R;
import com.example.yjj.yijinjing.adapter.RecycleViewAdapter;
import com.example.yjj.yijinjing.base.BaseViewActivity;
import com.example.yjj.yijinjing.common.util.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tx on 2017/11/17.
 */

public class RecycleViewActivity extends BaseViewActivity {

    private RecyclerView recyclerView;
    private RecycleViewAdapter mAdapter;

    private List<String> mDatas = new ArrayList<>();//recycleview中填充的数据

    @Override
    public int getLayoutId() {
        return R.layout.activity_recycleview;
    }

    @Override
    public void initViewFromXml() {
        recyclerView = (RecyclerView) findViewById(R.id.re_lv);
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {
        initDatas();//初始化数据
    }

    /**
     * 初始化数据
     */
    private void initDatas() {
        for (int i = 0; i < 30; i++){
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
}
