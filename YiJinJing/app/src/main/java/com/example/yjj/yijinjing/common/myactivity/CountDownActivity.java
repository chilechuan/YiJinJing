package com.example.yjj.yijinjing.common.myactivity;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

import com.example.yjj.yijinjing.R;
import com.example.yjj.yijinjing.base.BaseViewActivity;

/**
 * Created by tx on 2017/11/16.
 */

public class CountDownActivity extends BaseViewActivity implements View.OnClickListener {

    private TextView tvTimeDown;//计时器
    private TextView tvPause;//暂停
    private TextView tvContinue;//继续
    private TextView tvOver;//结束
    private TextView tvStart;//开始

    private int currentTime = 180;//当前时间
    private static final int COUNT_DOWN_WHAT = 110;//倒计时进行中
    private boolean pauseBool = false;

    private Thread countThread;
    private String sre = "";
    Handler hanlder = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case COUNT_DOWN_WHAT:
                    tvTimeDown.setText(currentTime + "");
                    break;
            }
        }
    };

    @Override
    public int getLayoutId() {
        return R.layout.activity_count_down;
    }

    @Override
    public void initViewFromXml() {
        tvTimeDown = (TextView) findViewById(R.id.tv_time_down);
        tvPause = (TextView) findViewById(R.id.tv_pause);
        tvContinue = (TextView) findViewById(R.id.tv_continue);
        tvOver = (TextView) findViewById(R.id.tv_over);
        tvStart = (TextView) findViewById(R.id.tv_start);
    }

    @Override
    public void initListener() {
        tvPause.setOnClickListener(this);
        tvContinue.setOnClickListener(this);
        tvOver.setOnClickListener(this);
        tvStart.setOnClickListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void fillView() {

    }

    /**
     * 开启线程倒计时
     */
    private void startCountDownThread() {

        countThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (; currentTime > 0; currentTime--) {
                    try {
                        if (pauseBool) {
                            synchronized (countThread) {
                                try {
                                    countThread.wait();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                        Message msg = Message.obtain();
                        msg.what = COUNT_DOWN_WHAT;
                        hanlder.sendMessage(msg);
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_pause://暂停计时
                pauseBool = true;
                break;
            case R.id.tv_continue://继续计时
                pauseBool = false;
                synchronized (countThread) {
                    countThread.notifyAll();
                }
                break;
            case R.id.tv_over://结束计时
                countThread.interrupt();
                currentTime = 180;
                tvTimeDown.setText(currentTime + "");
                break;
            case R.id.tv_start://开始计时

                startCountDownThread();//开启线程倒计时
                if (!countThread.isAlive()) {
                    countThread.start();
                }
                break;
        }
    }
}
