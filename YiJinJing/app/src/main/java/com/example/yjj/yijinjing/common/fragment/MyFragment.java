package com.example.yjj.yijinjing.common.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.yjj.yijinjing.R;
import com.example.yjj.yijinjing.common.myactivity.TestActivity;

/**
 * Created by tx on 2017/11/15.
 */

public class MyFragment extends Fragment implements View.OnClickListener{

    private View view;

    private TextView tvExplore;//探索发现

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_me, container, false);
        initViewFromXml(view);//初始化view
        initListener();//设置监听
        return view;
    }

    /**
     * 设置监听
     */
    private void initListener() {
        tvExplore.setOnClickListener(this);
    }

    /**
     * 初始化view
     */
    private void initViewFromXml(View view) {
        tvExplore = (TextView) view.findViewById(R.id.tv_explore);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_explore:
                Intent mIntent = new Intent(getActivity(), TestActivity.class);
                startActivity(mIntent);
                break;
        }
    }
}
