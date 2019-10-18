package com.person.master.vo;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

/**
 * 登陆数据
 *
 * @author jjma
 * 2019/08/30
 */
@Data
public class LoginVo {

    /**
     * 账号
     */
    @Length(min = 4,max = 20,message = "账号长度4-20个字符")
    @NotEmpty(message = "账号不能为空")
    private String account;

    /**
     * 密码
     */
    @Length(min = 4,max = 20,message = "密码长度4-20个字符")
    @NotEmpty(message = "密码不能为空")
    private String password;
}
