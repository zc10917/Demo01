package com.example.zhongcheng.demo01.ListViewModel;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.DataSetObserver;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.zhongcheng.demo01.List_data.ListViewData;
import com.example.zhongcheng.demo01.List_data.PayAbstracts;
import com.example.zhongcheng.demo01.List_data.Poi;
import com.example.zhongcheng.demo01.R;
import com.example.zhongcheng.demo01.Utility;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.zip.Inflater;

import static com.example.zhongcheng.demo01.R.*;
import static com.example.zhongcheng.demo01.R.id.payAbstract;
import static com.example.zhongcheng.demo01.R.id.payabstract_image;

/**
 * Created by zhongcheng on 16/7/19.
 */
public class MyListViewAdapter extends BaseAdapter {
    private Context context;
    private Poi poi;
    private ListViewData listViewData;
    private int resID;

    public MyListViewAdapter(Context context, int resID,ListViewData listViewData) {

        this.context = context;
        this.listViewData = listViewData;
        this.resID = resID;
    }




    @Override
    public int getCount() {
        if(listViewData==null){
            return 0;
        }
        return listViewData.getData().size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        poi = listViewData.getData().get(position).getPoi();
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(resID, null, false);
            holder = new ViewHolder();

            holder.camp = (TextView) convertView.findViewById(id.camp);
            holder.left = (LinearLayout) convertView.findViewById(id.left);
            holder.frontImage = (ImageView) convertView.findViewById(id.list_view_item_frontimg);
            holder.title = (TextView) convertView.findViewById(id.list_view_item_title);
            holder.ratingBar = (RatingBar) convertView.findViewById(id.list_view_item_avgscore);
            holder.avgPrice = (TextView) convertView.findViewById(id.list_view_item_avgprice);
            holder.cateName = (TextView) convertView.findViewById(id.list_view_item_catename);
            holder.areaName = (TextView) convertView.findViewById(id.list_view_item_areaname);
            holder.maidianImage = (ImageView) convertView.findViewById(id.maidian_image);
            holder.waimaiImage = (ImageView) convertView.findViewById(id.waimai_image);
            convertView.setTag(holder);

        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        Picasso.with(context).load(poi.getFrontImg()).placeholder(mipmap.de1).into(holder.frontImage);

        holder.title.setText(poi.getName());
        holder.ratingBar.setRating((float) poi.getAvgScore());
        holder.avgPrice.setText("¥" + poi.getAvgPrice());
        holder.cateName.setText(poi.getCateName());
        holder.areaName.setText(poi.getAreaName());
        LinearLayout payabstract = (LinearLayout) convertView.findViewById(id.payAbstract);
        payabstract.removeAllViews();

        if(poi.getIsWaimai()==1){
            holder.waimaiImage.setVisibility(View.VISIBLE);
        }
        if(poi.getExtra().getIcons().size()!=0){
            holder.maidianImage.setImageResource(mipmap.maidian);
        }
        String  campTag = poi.getCampaignTag();
        if(campTag!=""){
            Log.e("tag:",""+campTag);

            holder.camp.setBackground(context.getResources().getDrawable(drawable.tv));
            holder.camp.setText(campTag);
            holder.camp.setVisibility(View.VISIBLE);
        }
        List<PayAbstracts> abs = poi.getPayAbstracts();
        for(int i=0;i<abs.size();i++){

            Log.e(">>>>>>>>>size",""+abs.size());
            LinearLayout root = (LinearLayout) LayoutInflater.from(context).inflate(layout.payabstract_item,null,false);
            TextView tv = (TextView) root.findViewById(id.payabstract_text);
            ImageView img  = (ImageView) root.findViewById(payabstract_image);
            tv.setText(abs.get(i).getAbstractL());
            Picasso.with(context).load(abs.get(i).getIcon_url()).into(img);
            payabstract.addView(root,i);
        }




        return convertView;
    }


}

class ViewHolder {
    ImageView maidianImage;
    ImageView waimaiImage;
    ImageView frontImage;
    TextView title;
    RatingBar ratingBar;
    TextView camp;
    TextView avgPrice;
    TextView cateName;
    TextView areaName;
    LinearLayout left;

}
