package com.example.tx.viewpagernine;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;
    private List<View> viewList = new ArrayList<View>();
    private LayoutInflater li;

    private TextView tv_dialog;
    private Bitmap bitmap = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //获取数据
        initData();
        //解析布局
        initViewForXml();
        //填充布局
        fillViewForXml();
        //设置监听
        initListener();
    }

    private void initListener() {
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Toast.makeText(MainActivity.this, "你选择了第" + position + "页", Toast.LENGTH_SHORT).show();
                float offset = positionOffset;
                float offsetPixels = positionOffsetPixels;

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        tv_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDailogs();
            }
        });
    }

    private void showDailogs() {
        BaseDialogAlertUtils.showAlertDialog(this, "标题党", "内容党", bitmap, "知道党", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        }, "去看党", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "去看看", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void fillViewForXml() {
        viewPager.setAdapter(pagerAdapter);
    }

    private void initData() {
        li = getLayoutInflater();
        viewList.add(li.inflate(R.layout.activity_fragment_one, null));
        viewList.add(li.inflate(R.layout.activity_fragment_two, null));
        viewList.add(li.inflate(R.layout.activity_fragment_three, null));
        pagerAdapter = new PagerAdapter() {
            @Override
            public int getCount() {
                return viewList.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                container.addView(viewList.get(position));
                return viewList.get(position);
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(viewList.get(position));
            }
        };
    }

    private void initViewForXml() {
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        tv_dialog = (TextView) findViewById(R.id.tv_dialog);
    }
}
