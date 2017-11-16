package com.example.yjj.yijinjing.inter;

/**
 * Created by dell-3020 on 2017/11/16.
 */

public interface ViewInit {

    /**
     * 初始化view
     */
    void initViewFromXml();

    /**
     * 设置监听
     */
    void initListener();

    /**
     * 初始化数据
     */
    void initData();

    /**
     * 填充数据
     */
    void fillView();
}
