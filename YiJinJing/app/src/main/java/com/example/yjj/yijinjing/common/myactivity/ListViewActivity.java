package com.example.yjj.yijinjing.common.myactivity;

import android.widget.ListView;

import com.example.yjj.yijinjing.R;
import com.example.yjj.yijinjing.adapter.ListViewAdapter;
import com.example.yjj.yijinjing.base.BaseViewActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tx on 2017/11/22.
 */

public class ListViewActivity extends BaseViewActivity{

    private ListView listView;
    private ListViewAdapter mAdapter;
    private List<String> mDatas = new ArrayList<>();

    @Override
    public int getLayoutId() {
        return R.layout.activity_listview;
    }

    @Override
    public void initViewFromXml() {
        listView = (ListView) findViewById(R.id.lv);
    }

    @Override
    public void initListener() {
    }

    @Override
    public void initData() {
        initDatas();//初始化listview数据
    }

    @Override
    public void fillView() {

    }

    /**
     * 初始化listview数据
     */
    private void initDatas() {
        for (int i = 0; i < 40; i++){
            mDatas.add(i + "");
        }
        mAdapter = new ListViewAdapter(this, mDatas);
        listView.setAdapter(mAdapter);
    }
}
