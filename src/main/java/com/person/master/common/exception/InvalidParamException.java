package com.person.master.common.exception;

import com.person.master.common.errorcode.DefaultErrorCode;

/**
 * 参数校验失败异常
 */

public class InvalidParamException extends BaseCodeException {


    private static final long serialVersionUID = 8614821514821643663L;

    public InvalidParamException() {
        super(DefaultErrorCode.INVALID_PARAM);
    }

    public InvalidParamException(String message) {
        super(DefaultErrorCode.INVALID_PARAM, message);
    }
}

