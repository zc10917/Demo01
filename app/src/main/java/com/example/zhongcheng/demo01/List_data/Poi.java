package com.example.zhongcheng.demo01.List_data;

import java.util.List;

/**
 * Created by zhongcheng on 16/7/19.
 */
public class Poi {
    private String poiid;

    private String channel;

    private String name;

    private String frontImg;

    private int avgPrice;

    private double avgScore;

    private String cateName;

    private String areaName;

    private double lat;

    private double lng;

    private String iUrl;

    private int isWaimai;

    private String addr;

    private String phone;

    private CharacteristicArea characteristicArea;

    private List<PayAbstracts> payAbstracts ;

    private Extra extra;

    public String getiUrl() {
        return iUrl;
    }

    public void setiUrl(String iUrl) {
        this.iUrl = iUrl;
    }

    public Extra getExtra() {
        return extra;
    }

    public void setExtra(Extra extra) {
        this.extra = extra;
    }

    private String campaignTag;

    private ExtCampaign extCampaign;

    private Recommendation recommendation;

    public void setPoiid(String poiid){
        this.poiid = poiid;
    }
    public String getPoiid(){
        return this.poiid;
    }
    public void setChannel(String channel){
        this.channel = channel;
    }
    public String getChannel(){
        return this.channel;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setFrontImg(String frontImg){
        this.frontImg = frontImg;
    }
    public String getFrontImg(){
        return this.frontImg;
    }
    public void setAvgPrice(int avgPrice){
        this.avgPrice = avgPrice;
    }
    public int getAvgPrice(){
        return this.avgPrice;
    }
    public void setAvgScore(double avgScore){
        this.avgScore = avgScore;
    }
    public double getAvgScore(){
        return this.avgScore;
    }
    public void setCateName(String cateName){
        this.cateName = cateName;
    }
    public String getCateName(){
        return this.cateName;
    }
    public void setAreaName(String areaName){
        this.areaName = areaName;
    }
    public String getAreaName(){
        return this.areaName;
    }
    public void setLat(double lat){
        this.lat = lat;
    }
    public double getLat(){
        return this.lat;
    }
    public void setLng(double lng){
        this.lng = lng;
    }
    public double getLng(){
        return this.lng;
    }
    public void setIUrl(String iUrl){
        this.iUrl = iUrl;
    }
    public String getIUrl(){
        return this.iUrl;
    }
    public void setIsWaimai(int isWaimai){
        this.isWaimai = isWaimai;
    }
    public int getIsWaimai(){
        return this.isWaimai;
    }
    public void setAddr(String addr){
        this.addr = addr;
    }
    public String getAddr(){
        return this.addr;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }
    public String getPhone(){
        return this.phone;
    }
    public void setCharacteristicArea(CharacteristicArea characteristicArea){
        this.characteristicArea = characteristicArea;
    }
    public CharacteristicArea getCharacteristicArea(){
        return this.characteristicArea;
    }
    public void setPayAbstracts(List<PayAbstracts> payAbstracts){
        this.payAbstracts = payAbstracts;
    }
    public List<PayAbstracts> getPayAbstracts(){
        return this.payAbstracts;
    }
    public void setCampaignTag(String campaignTag){
        this.campaignTag = campaignTag;
    }
    public String getCampaignTag(){
        return this.campaignTag;
    }
    public void setExtCampaign(ExtCampaign extCampaign){
        this.extCampaign = extCampaign;
    }
    public ExtCampaign getExtCampaign(){
        return this.extCampaign;
    }
    public void setRecommendation(Recommendation recommendation){
        this.recommendation = recommendation;
    }
    public Recommendation getRecommendation(){
        return this.recommendation;
    }

}
