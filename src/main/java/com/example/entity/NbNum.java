package com.example.entity;

/**
 * Created by LiWeijie
 * 19/08/09 14:17
 */
public class NbNum {
    /**
     * 盒子标识
     * */
    private String  boxCodes;
    /**
     * 发送时间。(单位:毫秒)
     * */
    private String  sendDate;
    /**读取时间。(单位:毫秒)*/
    private String  readDate;
    /**黑白A4*/
    private  Integer  black_A4;
    /**	黑白A3*/
    private Integer black_A3;
    /**彩色A4*/
    private Integer color_A4;
    /**	彩色A3*/
    private Integer color_A3;

    public String getBoxCodes() {
        return boxCodes;
    }

    public void setBoxCodes(String boxCodes) {
        this.boxCodes = boxCodes;
    }

    public String getSendDate() {
        return sendDate;
    }

    public void setSendDate(String sendDate) {
        this.sendDate = sendDate;
    }

    public String getReadDate() {
        return readDate;
    }

    public void setReadDate(String readDate) {
        this.readDate = readDate;
    }

    public Integer getBlack_A4() {
        return black_A4;
    }

    public void setBlack_A4(Integer black_A4) {
        this.black_A4 = black_A4;
    }

    public Integer getBlack_A3() {
        return black_A3;
    }

    public void setBlack_A3(Integer black_A3) {
        this.black_A3 = black_A3;
    }

    public Integer getColor_A4() {
        return color_A4;
    }

    public void setColor_A4(Integer color_A4) {
        this.color_A4 = color_A4;
    }

    public Integer getColor_A3() {
        return color_A3;
    }

    public void setColor_A3(Integer color_A3) {
        this.color_A3 = color_A3;
    }
}
