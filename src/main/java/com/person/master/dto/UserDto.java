package com.person.master.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserDto implements Serializable {

    /**
     * 用户id
     */
    private  int id;

    /**
     * 用户名
     */
    private  String name;

    /**
     * 账号
     */
    private  String account;

    /**
     * 用户密码
     */
    private  String password;

    /**
     * 邮箱
     */
    private  String email;

    /**
     * 电话
     */
    private  String phone;


    /**
     * 创建时间
     */
    private Date create_time;

    /**
     * 上次登陆时间
     */
    private Date update_time;

}

