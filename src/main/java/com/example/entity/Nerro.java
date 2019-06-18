package com.example.entity;

/**
 * Created by huangwei
 * 19/03/01 13:58
 */
public class Nerro {
    private   String  context;
    private  String  time;
    private  String  ftime;

    public Nerro() {
    }

    public Nerro(String context, String time, String ftime) {

        this.context = context;
        this.time = time;
        this.ftime = ftime;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getFtime() {
        return ftime;
    }

    public void setFtime(String ftime) {
        this.ftime = ftime;
    }
}
