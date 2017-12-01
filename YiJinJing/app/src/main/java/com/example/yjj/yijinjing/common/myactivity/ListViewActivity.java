package com.example.yjj.yijinjing.common.myactivity;

import android.os.Handler;
import android.widget.ListView;

import com.example.yjj.yijinjing.R;
import com.example.yjj.yijinjing.adapter.ListViewAdapter;
import com.example.yjj.yijinjing.base.BaseViewActivity;
import com.example.yjj.yijinjing.base.MyListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tx on 2017/11/22.
 */

public class ListViewActivity extends BaseViewActivity implements MyListView.ILoadListener{

    private MyListView listView;
    private ListViewAdapter mAdapter;
    private List<String> mDatas = new ArrayList<>();

    @Override
    public int getLayoutId() {
        return R.layout.activity_listview;
    }

    @Override
    public void initViewFromXml() {
        listView = (MyListView) findViewById(R.id.lv);
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
        setData();//填充数据
    }

    private void setData() {
        listView.setInterface(this);
        listView.setAdapter(mAdapter);
    }

    /**
     * 初始化listview数据
     */
    private void initDatas() {
        for (int i = 0; i < 20; i++){
            mDatas.add(i + "");
        }
        mAdapter = new ListViewAdapter(this, mDatas);
    }

    @Override
    public void onLoad() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                getLoadData();//获取更多数据 
                listView.loadComplete();//通知listview加载完毕 
            }
        }, 5000);
    }

    private void getLoadData() {
        if (mDatas.size() > 38){
            listView.loadOver();//没有更多数据了
            return;
        }
        for (int i = 20; i < 40; i++){
            mDatas.add(i + "");
        }
        mAdapter.notifyDataSetChanged();
    }
}
