package com.example.service.zizuyin;

import com.example.entity.zizuyin.OutUser;
import com.example.entity.zizuyin.Register;

/**
 * Created by LiWeijie
 * 19/08/15 14:14
 */
public interface ZizuYinService {

    /**服务商注册*/
    public  String  Register(Register register);

    /**增加租户信息*/
    public  String  outUserSave(OutUser outUser);
}
