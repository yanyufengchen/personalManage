package com.person.master.common.exception;

import com.person.master.common.util.SimpleError;
import com.person.master.common.web.IError;

/**
 * 错误码异常基类
 */
public class BaseCodeException extends RuntimeException{


    private static final long serialVersionUID = -7812630736243447637L;
    /**
     * 错误码
     */
    private String errorCode;

    /**
     * 错误信息，默认为错误码描述
     */
    private String errorMessage;

    public BaseCodeException(IError iError) {
        super(iError.getError());
        this.errorCode = iError.getCode();
        this.errorMessage = iError.getError();
    }

    public BaseCodeException(IError iError, String message) {
        super(message);
        this.errorCode = iError.getCode();
        this.errorMessage = message;
    }

    public IError getErrorCode() {
        return new SimpleError(errorCode, errorMessage);
    }
}
