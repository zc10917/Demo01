package com.example.zhongcheng.demo01.List_data;

/**
 * Created by zhongcheng on 16/7/19.
 */
public class Tipmsgs {
    private int type;

    private int valueId;

    private int parentId;

    private String name;

    private String strategy;

    private String iUrl;

    private String iUrlType;

    private SelectMsg selectMsg;

    public void setType(int type){
        this.type = type;
    }
    public int getType(){
        return this.type;
    }
    public void setValueId(int valueId){
        this.valueId = valueId;
    }
    public int getValueId(){
        return this.valueId;
    }
    public void setParentId(int parentId){
        this.parentId = parentId;
    }
    public int getParentId(){
        return this.parentId;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setStrategy(String strategy){
        this.strategy = strategy;
    }
    public String getStrategy(){
        return this.strategy;
    }
    public void setIUrl(String iUrl){
        this.iUrl = iUrl;
    }
    public String getIUrl(){
        return this.iUrl;
    }
    public void setIUrlType(String iUrlType){
        this.iUrlType = iUrlType;
    }
    public String getIUrlType(){
        return this.iUrlType;
    }
    public void setSelectMsg(SelectMsg selectMsg){
        this.selectMsg = selectMsg;
    }
    public SelectMsg getSelectMsg(){
        return this.selectMsg;
    }

}