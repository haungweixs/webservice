package com.example.entity;

        import com.dingtalk.api.request.OapiProcessinstanceCreateRequest;

/**
 * Created by LiWeijie
 * 19/03/25 11:46
 */
public class TextCes {
    private  OapiProcessinstanceCreateRequest.FormComponentValueVo mix1;
    private  OapiProcessinstanceCreateRequest.FormComponentValueVo mix2;

    public OapiProcessinstanceCreateRequest.FormComponentValueVo getMix1() {
        return mix1;
    }

    public void setMix1(OapiProcessinstanceCreateRequest.FormComponentValueVo mix1) {
        this.mix1 = mix1;
    }

    public OapiProcessinstanceCreateRequest.FormComponentValueVo getMix2() {
        return mix2;
    }

    public void setMix2(OapiProcessinstanceCreateRequest.FormComponentValueVo mix2) {
        this.mix2 = mix2;
    }
}
