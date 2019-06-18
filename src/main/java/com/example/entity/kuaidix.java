package com.example.entity;

import java.util.List;

/**
 * Created by huangwei
 * 19/03/01 13:54
 */
public class kuaidix {
    private String  state;   //快递单当前签收状态
    private List<Nerro>  data;  //最新查询结果，全量，倒序

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<Nerro> getData() {
        return data;
    }

    public void setData(List<Nerro> data) {
        this.data = data;
    }
}
