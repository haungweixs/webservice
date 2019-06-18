package com.example.entity;

/**
 * Created by LiWeijie
 * 19/03/22 16:02
 */
public class Processin {
       private  String  createTime;
       private  String  staffId;
       private  String  bizCategoryId;
       private  String  EventType;
       private  String  type;
       private  String  content;
       private  String  title;
       private  String  processCode;
       private  String  processInstanceId;
       private  String corpId;

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getBizCategoryId() {
        return bizCategoryId;
    }

    public void setBizCategoryId(String bizCategoryId) {
        this.bizCategoryId = bizCategoryId;
    }

    public String getEventType() {
        return EventType;
    }

    public void setEventType(String eventType) {
        EventType = eventType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProcessCode() {
        return processCode;
    }

    public void setProcessCode(String processCode) {
        this.processCode = processCode;
    }

    public String getProcessInstanceId() {
        return processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    public String getCorpId() {
        return corpId;
    }

    public void setCorpId(String corpId) {
        this.corpId = corpId;
    }
}
