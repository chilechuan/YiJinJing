package com.example.yjj.yijinjing.common.myactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.yjj.yijinjing.R;
import com.example.yjj.yijinjing.base.BaseViewActivity;

/**
 * Created by tx on 2017/11/16.
 */

public class TestActivity extends BaseViewActivity implements View.OnClickListener{

    /* 界面view */
    private TextView tvCountDown;//倒计时
    private TextView tvRecyclerView;//RecyclerView

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_test;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_count_down://倒计时
                startActivitys(CountDownActivity.class);
                break;
            case R.id.tv_recycler_view://RecyclerView
                startActivitys(RecycleViewActivity.class);
                break;
        }
    }

    /**
     * 启动相关activity
     * @param activityClass 目的activity
     */
    private void startActivitys(Class activityClass) {
        Intent testIntent = new Intent(TestActivity.this, activityClass);
        startActivity(testIntent);
    }

    @Override
    public void initViewFromXml() {
        tvCountDown = (TextView) findViewById(R.id.tv_count_down);
        tvRecyclerView = (TextView) findViewById(R.id.tv_recycler_view);
    }

    @Override
    public void initListener() {
        tvCountDown.setOnClickListener(this);
        tvRecyclerView.setOnClickListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void fillView() {

    }
}
