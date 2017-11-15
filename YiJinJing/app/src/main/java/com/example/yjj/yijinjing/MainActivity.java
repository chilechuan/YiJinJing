package com.example.yjj.yijinjing;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.example.yjj.yijinjing.common.fragment.HomeFragment;
import com.example.yjj.yijinjing.common.fragment.MyFragment;
import com.example.yjj.yijinjing.common.fragment.SecondFragment;
import com.example.yjj.yijinjing.common.fragment.ThirdFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView tvTitle;//标题
    private TextView tvTabHome;//tab标签-首页
    private TextView tvTabSecond;//tab标签-第二页
    private TextView tvTabThird;//tab标签-第三页
    private TextView tvTabMe;//tab标签-我的

    /** ViewPager 和 Fragment 相关 */
    private ViewPager viewPager;//fragment容器
    private List<Fragment> fragmentList = new ArrayList<>();
    private FragmentAdapter fragmentAdapter;
    private String[] titles = new String[]{"主页", "第二页", "第三页", "我的"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);//去除标题栏
        setContentView(R.layout.activity_main);

        initViewForXml();//初始化view
        initListener();//设置监听事件
        initData();//初始化数据
        initViewPagerListener();//ViewPager监听事件
    }

    /**
     *ViewPager监听
     */
    private void initViewPagerListener() {
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {//滑动停止后，当前显示页面的position
                tvTitle.setText(titles[position]);//设置每个fragment的标题
                changeTabTextColor(position);//设置底部文字的颜色以及背景色
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    /**
     * 设置底部文字的颜色以及背景色
     * @param position 当前fragment所在位置
     */
    private void changeTabTextColor(int position) {

        switch (position){
            case 0://主页
                tvTabHome.setTextColor(getResources().getColor(R.color.green));
                tvTabSecond.setTextColor(getResources().getColor(R.color.font_gray_color));
                tvTabThird.setTextColor(getResources().getColor(R.color.font_gray_color));
                tvTabMe.setTextColor(getResources().getColor(R.color.font_gray_color));
                break;
            case 1://第二页
                tvTabHome.setTextColor(getResources().getColor(R.color.font_gray_color));
                tvTabSecond.setTextColor(getResources().getColor(R.color.green));
                tvTabThird.setTextColor(getResources().getColor(R.color.font_gray_color));
                tvTabMe.setTextColor(getResources().getColor(R.color.font_gray_color));
                break;
            case 2://第三页
                tvTabHome.setTextColor(getResources().getColor(R.color.font_gray_color));
                tvTabSecond.setTextColor(getResources().getColor(R.color.font_gray_color));
                tvTabThird.setTextColor(getResources().getColor(R.color.green));
                tvTabMe.setTextColor(getResources().getColor(R.color.font_gray_color));
                break;
            case 3://我的
                tvTabHome.setTextColor(getResources().getColor(R.color.font_gray_color));
                tvTabSecond.setTextColor(getResources().getColor(R.color.font_gray_color));
                tvTabThird.setTextColor(getResources().getColor(R.color.font_gray_color));
                tvTabMe.setTextColor(getResources().getColor(R.color.green));
                break;
        }
    }

    /**
     * 初始化数据
     */
    private void initData() {
        fragmentList.add(new HomeFragment());
        fragmentList.add(new SecondFragment());
        fragmentList.add(new ThirdFragment());
        fragmentList.add(new MyFragment());

        fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(), fragmentList);
        viewPager.setOffscreenPageLimit(4);//ViewPager的缓存
        viewPager.setAdapter(fragmentAdapter);
        viewPager.setCurrentItem(0);//设置默认显示item
        tvTabHome.setTextColor(getResources().getColor(R.color.green));//设置底部首页字体默认颜色
    }

    /**
     * 设置监听事件
     */
    private void initListener() {
        tvTabHome.setOnClickListener(this);
        tvTabSecond.setOnClickListener(this);
        tvTabThird.setOnClickListener(this);
        tvTabMe.setOnClickListener(this);
    }

    /**
     * 初始化view
     */
    private void initViewForXml() {
        tvTitle = (TextView) findViewById(R.id.tv_title);
        tvTabHome = (TextView) findViewById(R.id.tv_tab_home);
        tvTabSecond = (TextView) findViewById(R.id.tv_tab_second);
        tvTabThird = (TextView) findViewById(R.id.tv_tab_third);
        tvTabMe = (TextView) findViewById(R.id.tv_tab_me);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_tab_home://首页
                viewPager.setCurrentItem(0, true);
                changeTabTextColor(0);
                break;
            case R.id.tv_tab_second://第二页
                viewPager.setCurrentItem(1, true);
                changeTabTextColor(1);
                break;
            case R.id.tv_tab_third://第三页
                viewPager.setCurrentItem(2, true);
                changeTabTextColor(2);
                break;
            case R.id.tv_tab_me://我的
                viewPager.setCurrentItem(3, true);
                changeTabTextColor(3);
                break;
        }
    }

    private class FragmentAdapter extends FragmentPagerAdapter{

        private List<Fragment> fragmentList = new ArrayList<>();

        public FragmentAdapter(FragmentManager fm, List<Fragment> fragmentList) {
            super(fm);
            this.fragmentList = fragmentList;
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }
    }
}
