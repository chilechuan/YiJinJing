package com.example.yjj.yijinjing.common.myactivity;

import com.example.yjj.yijinjing.R;
import com.example.yjj.yijinjing.base.BaseViewActivity;
import com.example.yjj.yijinjing.model.JsonBean;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tx on 2017/11/23.
 */

public class JsonActivity extends BaseViewActivity {

    List<JsonBean> mList = new ArrayList<>();
    JsonBean jsonBean, jsonBeanOne;

    @Override
    public int getLayoutId() {
        return R.layout.activity_json;
    }

    @Override
    public void initViewFromXml() {

    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {
        jsonTest();
    }

    private void jsonTest() {
        jsonBean = new JsonBean();
        jsonBean.setName("王莽");
        jsonBean.setSex("男");
        jsonBean.setAge("37");

        jsonBeanOne = new JsonBean();
        jsonBeanOne.setName("曹操");
        jsonBeanOne.setSex("男");
        jsonBeanOne.setAge("38");
        mList.add(jsonBean);
        mList.add(jsonBeanOne);
        String jsonStr = new Gson().toJson(mList);
        String str = jsonStr;
    }

    @Override
    public void fillView() {

    }
}
