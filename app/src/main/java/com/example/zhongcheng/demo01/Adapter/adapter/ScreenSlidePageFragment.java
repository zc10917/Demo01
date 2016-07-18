package com.example.zhongcheng.demo01.Adapter.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.zhongcheng.demo01.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by zhongcheng on 16/7/18.
 */
public class ScreenSlidePageFragment extends Fragment{
    public ScreenSlidePageFragment() {
    }

    private ArrayList<String> data;
    private int count_num;
    private Context context;

    public ScreenSlidePageFragment(ArrayList<String> data, int count_num, Context context) {
        this.data = data;
        this.count_num = count_num;
        this.context = context;
    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
    Bundle savedInstanceState) {

        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.viewpager_page,container,false);
        ImageView imageview = (ImageView) root.findViewById(R.id.slidepage_imageview);


        
        Picasso.with(context).load(data.get(count_num)).into(imageview);
        return  root;




    }
}
