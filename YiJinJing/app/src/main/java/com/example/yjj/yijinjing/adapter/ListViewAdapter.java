package com.example.yjj.yijinjing.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.yjj.yijinjing.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tx on 2017/11/22.
 */

public class ListViewAdapter extends BaseAdapter{

    private Context context;
    private List<String> mDatas = new ArrayList<>();

    public ListViewAdapter(Context context, List<String> mDatas){
        this.context = context;
        this.mDatas = mDatas;
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyHolder myHolder;
        if (convertView == null){
            myHolder = new MyHolder();
            convertView = View.inflate(context, R.layout.item_listview, null);
            myHolder.tvContent = (TextView) convertView.findViewById(R.id.tv_content);
            convertView.setTag(myHolder);
        }else {
            myHolder = (MyHolder) convertView.getTag();
        }
        myHolder.tvContent.setText(mDatas.get(position));
        return convertView;
    }

    class MyHolder{

        TextView tvContent;
    }

}
