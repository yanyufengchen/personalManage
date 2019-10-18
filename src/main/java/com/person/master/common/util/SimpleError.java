package com.person.master.common.util;

import com.person.master.common.web.IError;

/**
 * IError 轻量级实现, 用于ErrorMessage需要动态确定的情况
 *
 * @author jjma
 * 2019/9/6
 */
public class SimpleError implements IError {
    /**
     * 错误码
     */
    private String code;

    /**
     * 错误消息
     */
    private String error;

    public SimpleError(String code, String error) {
        this.code = code;
        this.error = error;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getError() {
        return error;
    }

    @Override
    public void setError(final String error) {
        this.error = error;
    }
}
