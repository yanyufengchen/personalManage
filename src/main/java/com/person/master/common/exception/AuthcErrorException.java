package com.person.master.common.exception;

import com.person.master.common.errorcode.DefaultErrorCode;

/**
 * 用户登录/认证失败异常
 *
 * @author jjma
 * 2019/9/6
 */
public class AuthcErrorException extends BaseCodeException{

    private static final long serialVersionUID = 2231958581949794967L;

    public AuthcErrorException() {
        super(DefaultErrorCode.AUTHC_ERROR);
    }

    public AuthcErrorException(String message) {
        super(DefaultErrorCode.AUTHC_ERROR, message);
    }

}
