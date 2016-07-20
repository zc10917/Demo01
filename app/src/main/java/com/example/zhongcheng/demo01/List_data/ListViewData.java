package com.example.zhongcheng.demo01.List_data;

import java.util.List;

/**
 * Created by zhongcheng on 16/7/19.
 */
public class ListViewData {
    private Paging paging;

    private List<Data> data ;

    private List<Tips> tips ;

    private List<Ct_pois> ct_pois ;

    public void setPaging(Paging paging){
        this.paging = paging;
    }
    public Paging getPaging(){
        return this.paging;
    }
    public void setData(List<Data> data){
        this.data = data;
    }
    public List<Data> getData(){
        return this.data;
    }
    public void setTips(List<Tips> tips){
        this.tips = tips;
    }
    public List<Tips> getTips(){
        return this.tips;
    }
    public void setCt_pois(List<Ct_pois> ct_pois){
        this.ct_pois = ct_pois;
    }
    public List<Ct_pois> getCt_pois(){
        return this.ct_pois;
    }

}