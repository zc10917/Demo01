package com.example.zhongcheng.demo01.List_data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by zhongcheng on 16/7/19.
 */
public class PayAbstracts {
    private String type;

    @SerializedName("abstract")
    private String abstractL;


    private String icon_url;

    public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return this.type;
    }

    public void setIcon_url(String icon_url){
        this.icon_url = icon_url;
    }
    public String getIcon_url(){
        return this.icon_url;
    }

    public String getAbstractL() {
        return abstractL;
    }

    public void setAbstractL(String abstractL) {
        this.abstractL = abstractL;
    }
}
