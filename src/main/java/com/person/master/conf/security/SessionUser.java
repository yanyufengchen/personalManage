package com.person.master.conf.security;

import com.person.master.dto.UserDto;
import lombok.Data;

import java.io.Serializable;

/**
 * 缓存登陆信息
 */
@Data
public class SessionUser implements Serializable {
    private static final long serialVersionUID = -4199855906486768174L;

    /**
     * 用户信息
     */
    private UserDto userDto;
}
