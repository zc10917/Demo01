package com.example.zhongcheng.demo01.List_data;

import java.util.List;

/**
 * Created by zhongcheng on 16/7/19.
 */
public class Tips {
    private int position;

    private List<Tipmsgs> tipmsgs ;

    public void setPosition(int position){
        this.position = position;
    }
    public int getPosition(){
        return this.position;
    }
    public void setTipmsgs(List<Tipmsgs> tipmsgs){
        this.tipmsgs = tipmsgs;
    }
    public List<Tipmsgs> getTipmsgs(){
        return this.tipmsgs;
    }

}
