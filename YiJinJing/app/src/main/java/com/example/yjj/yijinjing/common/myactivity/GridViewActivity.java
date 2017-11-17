package com.example.yjj.yijinjing.common.myactivity;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.yjj.yijinjing.R;
import com.example.yjj.yijinjing.adapter.GridViewAdapter;
import com.example.yjj.yijinjing.base.BaseViewActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tx on 2017/11/17.
 */

public class GridViewActivity extends BaseViewActivity {

    private RecyclerView rlvGrid;
    private GridViewAdapter mAdapter;

    List<String> mDataList = new ArrayList<>();
    private String[] mDatas;

    @Override
    public int getLayoutId() {
        return R.layout.activity_grid;
    }

    @Override
    public void initViewFromXml() {
        rlvGrid = (RecyclerView) findViewById(R.id.rlv_grid);
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {
        initDatas();//初始化item数据
    }

    /**
     * 初始化item数据
     */
    private void initDatas() {
        mDatas = new String[]{"高山","大河","长江","黄河","流水","落花","秋叶","冬雪","夏雷","汉赋","宋词","唐诗","野草","牛羊","白云","商丘","女娲","伏羲","混沌","盘古","飞天","奔马","悯农","三国","水浒","西游","金瓶"};
        for (int i = 0; i < mDatas.length; i++){
            mDataList.add(mDatas[i]);
        }
    }

    @Override
    public void fillView() {
        mAdapter = new GridViewAdapter(this, mDataList);
        rlvGrid.setLayoutManager(new GridLayoutManager(this, 4));
        rlvGrid.setAdapter(mAdapter);
    }
}
