package com.person.master.common.web;

/**
 * 错误码接口
 *
 * @author jjma
 * 2019/08/30
 */
public interface IError {

    /**
     * 错误码
     *
     * @return 错误码
     */
    String getCode();

    /**
     * 错误信息
     *
     * @return 错误信息
     */
    String getError();

    /**
     * 设置错误信息 适用于同一错误码, 不同错误提示信息
     *
     * @param message 错误提示信息
     */
    void setError(String message);
}
