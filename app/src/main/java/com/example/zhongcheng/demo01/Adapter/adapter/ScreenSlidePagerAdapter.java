package com.example.zhongcheng.demo01.Adapter.adapter;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

/**
 * Created by zhongcheng on 16/7/18.
 */


public class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
    private int page_count;
    private ArrayList<String> data;
    private Context context;



    public ScreenSlidePagerAdapter(FragmentManager fm,int page_count,ArrayList<String> data, Context context) {
        super(fm);
        this.page_count = page_count;
        this.data = data;
        this.context = context;
    }

    @Override
    public android.support.v4.app.Fragment getItem(int position) {

        return new ScreenSlidePageFragment(data, position, context);
    }

    @Override
    public int getCount() {
        return page_count;
    }
}