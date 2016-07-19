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
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.zhongcheng.demo01.Adapter.adapter.ScreenSlidePagerAdapter;
import com.example.zhongcheng.demo01.ListViewModel.MyListView;
import com.example.zhongcheng.demo01.ListViewModel.MyListViewAdapter;
import com.example.zhongcheng.demo01.List_data.ListViewData;
import com.example.zhongcheng.demo01.gson_object.viewpager_data.ViewPagerData;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends FragmentActivity {
    private static final int VIEWPAGERDATA = 0;
    private static final int VIEWPAGERCHANGE = 1;
    private static final int LISTVIEWDATA = 2;
    private ScreenSlidePagerAdapter screenSlidePagerAdapter;
    private MyListViewAdapter myListViewAdapter;
    private ArrayList<String> slideFragementurl;
    private ViewPagerData viewPagerData = null;
    private ListViewData listViewData = null;
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
                    break;
                case LISTVIEWDATA:
                    myListViewAdapter = new MyListViewAdapter(MainActivity.this,R.layout.list_view_item,listViewData);
                    listView.setAdapter(myListViewAdapter);
                    Log.e("setAdapeter",myListViewAdapter.toString());
                    Utility.setListViewHeightBasedOnChildren1(listView);





                    break;



                    //TODO



            }
        }
    };


    private Gson gson = null;



    private ViewPager mPager = null;
    private ImageView scrollView_imageView01 = null;
    private ImageView scrollView_imageView02 = null;
    private ImageView scrollView_imageView03 = null;

    private ImageView table_item_view_image1 = null;
    private ImageView table_item_view_image2 = null;
    private ImageView table_item_view_image3 = null;
    private ImageView table_item_view_image4 = null;
    private ImageView table_item_view_image5 = null;
    private ImageView table_item_view_image6 = null;
    private ImageView table_item_view_image7 = null;
    private ImageView table_item_view_image8 = null;

    private MyListView listView = null;






    private OkHttpClient client = null;
    Callback viewPagercallback = new Callback() {
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
    private Callback listViewCallBack = new Callback() {
        @Override
        public void onFailure(Call call, IOException e) {

        }

        @Override
        public void onResponse(Call call, Response response) throws IOException {
            listViewData = gson.fromJson(response.body().string(),ListViewData.class);

            handler.sendEmptyMessage(LISTVIEWDATA);


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
        String viewPagerUrl = "http://api.meituan.com/advert/v3/adverts?cityid=1&category=1&version=7.0.1&new=0&app=group&clienttp=android&devid=000000000000000&uid=&movieid=&partner=0&apptype=0&smId=&__vhost=api.mobile.meituan.com&utm_source=baidumobile&utm_medium=android&utm_term=401&version_name=7.0.1&utm_content=000000000000000&utm_campaign=AgroupBgroupC576591972453269000_a246307_c1E0Ghomepage_category1_1__a1__gfood&ci=1&msid=0000000000000001468846313953&uuid=2C2C0ECD557F366849954BEF88D0017A50438D0ED090872E11700645B17CCB50&userid=-1&__reqTraceID=eb982f51-aa80-41d8-9a41-9580b04c3010&__skck=6a375bce8c66a0dc293860dfa83833ef&__skts=1468849475314&__skua=a8f3d512c6de28d1b1cf638d4c1dbb33&__skno=dc4944df-71c6-41ba-ae9b-06ecae4cf1b8&__skcy=oBPcF4WW9JP75JSKLXNRT0%2By8hM%3D";
        String listViewUrl = "http://api.meituan.com/meishi/filter/v4/deal/select/city/1/cate/1?sort=defaults&ci=1&hasGroup=true&mpt_cate1=-1&mpt_cate2=1&wifi-name=WiredSSID%08&wifi-mac=01%3A80%3Ac2%3A00%3A00%3A03%08&wifi-strength=-55%08&wifi-cur=0&offset=0&limit=25&poiFields=cityId%2Clng%2CfrontImg%2CavgPrice%2CavgScore%2Cname%2Clat%2CcateName%2CareaName%2CcampaignTag%2Cabstracts%2Crecommendation%2CpayInfo%2CpayAbstracts%2CqueueStatus%2CgroupInfo%2CiUrl%2CcharacteristicArea&client=android&__vhost=api.meishi.meituan.com&utm_source=baidumobile&utm_medium=android&utm_term=401&version_name=7.0.1&utm_content=000000000000000&utm_campaign=AgroupBgroupC576591972453269000_a246307_c1E0Ghomepage_category1_1__a1__gfood&msid=0000000000000001468863838414&uuid=2C2C0ECD557F366849954BEF88D0017A50438D0ED090872E11700645B17CCB50&userid=-1&__reqTraceID=79ea795a-a79b-4171-a591-6d985ff1efa9&__skck=6a375bce8c66a0dc293860dfa83833ef&__skts=1468865455068&__skua=a8f3d512c6de28d1b1cf638d4c1dbb33&__skno=114f6b8a-b306-42e0-8415-fe5527677285&__skcy=1y1qDMKDn2T8ENyJBRxA0AZIN0w%3D";

        Request viewPagerReq = new Request.Builder().url(viewPagerUrl).build();
        Request listViewReq = new Request.Builder().url(listViewUrl).build();

        Call viewPagercall = client.newCall(viewPagerReq);
        Call listViewCall = client.newCall(listViewReq);



        viewPagercall.enqueue(viewPagercallback);
        listViewCall.enqueue(listViewCallBack);


        Picasso.with(MainActivity.this).load("http://p1.meituan.net/codeman/4baac3ebf72fbb3cd53dae988ab00cb1108455.png").into(scrollView_imageView01);
        Picasso.with(MainActivity.this).load("http://p0.meituan.net/codeman/b068be6042f0f7893921da484a7060c718125.jpg").into(scrollView_imageView02);
        Picasso.with(MainActivity.this).load("http://p0.meituan.net/codeman/4d7e63d215b2f992bba715a3aada559417450.jpg").into(scrollView_imageView03);

        Picasso.with(MainActivity.this).load("http://p0.meituan.net/meishiop/2d29dcd41943e54365c44d51605420184876.png").into(table_item_view_image1);
        Picasso.with(MainActivity.this).load("http://p1.meituan.net/meishiop/a589f18f364770b305ac3d02b023f0e65250.png").into(table_item_view_image2);
        Picasso.with(MainActivity.this).load("http://p1.meituan.net/meishiop/9c29430eec831af89c210653a0a368545684.png").into(table_item_view_image3);
        Picasso.with(MainActivity.this).load("http://p1.meituan.net/meishiop/a80faae4c702c6d46098cb97307cb0144485.png").into(table_item_view_image4);
        Picasso.with(MainActivity.this).load("http://p0.meituan.net/meishiop/2a76a503b60e6b0d52149559fd3908854901.png").into(table_item_view_image5);
        Picasso.with(MainActivity.this).load("http://p0.meituan.net/meishiop/01c563c7769c772395218ae583b73b536228.png").into(table_item_view_image6);
        Picasso.with(MainActivity.this).load("http://p1.meituan.net/meishiop/6d121e02c696ab5cd423a764b54811c75489.png").into(table_item_view_image7);
        Picasso.with(MainActivity.this).load("http://p0.meituan.net/meishiop/e4c317e7b05fae1190ba3cd897d1b9256211.png").into(table_item_view_image8);





    }

    private void initView() {

        mPager = (ViewPager) findViewById(R.id.pager);


        scrollView_imageView01 = (ImageView) findViewById(R.id.scrollview_image01);
        scrollView_imageView02 = (ImageView) findViewById(R.id.scrollview_image02);
        scrollView_imageView03 = (ImageView) findViewById(R.id.scrollview_image03);

        table_item_view_image1 = (ImageView) findViewById(R.id.table_item_view_image1);
        table_item_view_image2 = (ImageView) findViewById(R.id.table_item_view_image2);
        table_item_view_image3 = (ImageView) findViewById(R.id.table_item_view_image3);
        table_item_view_image4 = (ImageView) findViewById(R.id.table_item_view_image4);
        table_item_view_image5 = (ImageView) findViewById(R.id.table_item_view_image5);
        table_item_view_image6 = (ImageView) findViewById(R.id.table_item_view_image6);
        table_item_view_image7 = (ImageView) findViewById(R.id.table_item_view_image7);
        table_item_view_image8 = (ImageView) findViewById(R.id.table_item_view_image8);


        listView = (MyListView) findViewById(R.id.list_view_main);






    }

    private void init() {
        client = new OkHttpClient();
    }


}
