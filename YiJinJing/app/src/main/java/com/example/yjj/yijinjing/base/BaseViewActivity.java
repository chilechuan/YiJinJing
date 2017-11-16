package com.example.yjj.yijinjing.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.yjj.yijinjing.inter.ViewInit;

/**
 * Created by tx on 2017/11/16.
 */

public abstract class BaseViewActivity extends AppCompatActivity implements ViewInit{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /* 加载页面布局 */
        setContentView(getLayoutId());
        /* 初始化用户界面数据 */
        initUserUI();
    }

    public abstract int getLayoutId();

    /**
     * 初始化用户主页面数据
     */
    public void initUserUI() {

        initData();//初始化数据
        initViewFromXml();//初始化布局
        fillView();//布局填充数据
        initListener();//初始化监听。

    }

}
