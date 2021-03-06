package com.example.yjj.yijinjing.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.yjj.yijinjing.R;

/**
 * Created by dell-3020 on 2017/11/30.
 */

public class MyListView extends ListView implements AbsListView.OnScrollListener{

    View footer;//底部布局
    int totalItemCount;//总数量
    int lastVisibleItem;//最后一个可见的Item
    boolean isLoading;//正在加载
    ILoadListener iLoadListener;

    public MyListView(Context context) {
        super(context);
        initView(context);
    }

    public MyListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public MyListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    /**
     * 添加底部加载提示布局到listview
     * @param context
     */
    private void initView(Context context) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        footer=layoutInflater.inflate(R.layout.foot_view, null);
        footer.findViewById(R.id.ll_load_more).setVisibility(View.GONE);
        this.addFooterView(footer);
        this.setOnScrollListener(this);
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount)
    {
        this.lastVisibleItem=firstVisibleItem+visibleItemCount;
        this.totalItemCount=totalItemCount;
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        if (totalItemCount==lastVisibleItem&&scrollState==SCROLL_STATE_IDLE) {
            if (!isLoading) {
                isLoading=true;
                footer.findViewById(R.id.ll_load_more).setVisibility(View.VISIBLE);
                iLoadListener.onLoad();//加载更多数据
            }
        }
    }
    //加载完毕
    public void loadComplete() {
        isLoading=false;
        footer.findViewById(R.id.ll_load_more).setVisibility(View.GONE);
    }

    //没有更多数据
    public void loadOver(){
        isLoading = false;
        ((ProgressBar)footer.findViewById(R.id.pb)).setVisibility(GONE);
        ((TextView) footer.findViewById(R.id.tv_load_more)).setText("没有更多数据了");
    }
    public void setInterface(ILoadListener iLoadListener) {
        this.iLoadListener=iLoadListener;
    }
    //加载更多数据的回调接口
    public interface ILoadListener
    {
        public void onLoad();
    }

}
