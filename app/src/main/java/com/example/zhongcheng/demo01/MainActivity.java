package com.example.zhongcheng.demo01;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zhongcheng.demo01.Adapter.adapter.ScreenSlidePagerAdapter;
import com.example.zhongcheng.demo01.gson_object.viewpager_data.ViewPagerData;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends FragmentActivity {
    private static final int VIEWPAGERDATA = 0;
    private static final int VIEWPAGERCHANGE = 1;
    private ScreenSlidePagerAdapter screenSlidePagerAdapter;
    private ArrayList<String> slideFragementurl;
    private int viewPager_NUM = 0;
    private ViewPagerData viewPagerData = null;
    private Handler handler = new MyHandler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case VIEWPAGERDATA:
                    screenSlidePagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager(),
                            viewPagerData.getData().size(), slideFragementurl, MainActivity.this);

                    mPager.setAdapter(screenSlidePagerAdapter);
                    break;
                case VIEWPAGERCHANGE:
                    if(viewPagerData!=null){
                        int current = mPager.getCurrentItem();
                        mPager.setCurrentItem((current+1)%slideFragementurl.size());

                    }

            }
        }
    };


    private Gson gson = null;

    private ViewPager mPager = null;
    private ImageView imageView = null;


    private OkHttpClient client = null;
    Callback ViewPagercallback = new Callback() {
        @Override
        public void onFailure(Call call, IOException e) {
            Log.e("dd", "2");

        }

        @Override
        public void onResponse(Call call, Response response) throws IOException {
            viewPagerData = gson.fromJson(response.body().string(), ViewPagerData.class);
            slideFragementurl = new ArrayList<String>();
            for (int i = 0; i < viewPagerData.getData().size(); i++) {
                slideFragementurl.add(viewPagerData.getData().get(i).getImgUrl());
            }
            handler.sendEmptyMessage(VIEWPAGERDATA);


        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        initView();
        loadData();
        //dddd

    }

    @Override
    protected void onResume() {
        super.onResume();
        reFreshViewPager();



    }

    private void reFreshViewPager() {
        new Thread(){
            @Override
            public void run() {
                try {
                    while(true){
                        sleep(2000);
                        handler.sendEmptyMessage(VIEWPAGERCHANGE);
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        }.start();
    }

    private void loadData() {
        gson = new Gson();
        Request req = new Request.Builder().url("http://api.meituan" +
                ".com/advert/v3/adverts?cityid=1&category=1&version=7.0" +
                ".1&new=0&app=group&clienttp=android&devid=000000000000000&uid=&movieid=&partner" +
                "=0&apptype=0&smId=&__vhost=api.mobile.meituan" +
                ".com&utm_source=baidumobile&utm_medium=android&utm_term=401&version_name=7.0" +
                ".1&utm_content=000000000000000&utm_campaign" +
                "=AgroupBgroupC0E7494123390684811264_a94574128_c0_e13562730998495393057Ghomepage_category1_1__a1__gfood&ci=1&msid=0000000000000001468676770276&uuid=2C2C0ECD557F366849954BEF88D0017A50438D0ED090872E11700645B17CCB50&userid=-1&__reqTraceID=49d3161e-2ba3-4b86-909e-b426d10a3a64&__skck=6a375bce8c66a0dc293860dfa83833ef&__skts=1468688199172&__skua=a8f3d512c6de28d1b1cf638d4c1dbb33&__skno=f5317d0f-39bd-440d-9ce7-46d2488adfb2&__skcy=O5F%2BNL3o%2FHKw9FSmo9Ytd5R5Z5E%3D").build();

        Call callViewPager = client.newCall(req);

        callViewPager.enqueue(ViewPagercallback);


    }

    private void initView() {

        mPager = (ViewPager) findViewById(R.id.pager);


    }

    private void init() {
        client = new OkHttpClient();
    }


}
