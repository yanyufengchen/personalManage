package com.person.master.common.errorcode;


import com.person.master.common.web.IError;

/**
 * 全局通用ErrorCode定义
 *
 * @author jjma
 * 2019/08/30 16:42
 */
public enum DefaultErrorCode implements IError {
    /**
     * 系统错误 全局兜底错误码：系统不可用、系统繁忙、其他一些未知错误
     */
    SYS_ERROR(DefaultCode.SYS_ERROR, "系统错误"),
    /**
     * 参数校验失败
     */
    INVALID_PARAM(DefaultCode.INVALID_PARAM, "参数校验失败"),
    /**
     * 用户登录、认证失败错误码，可包括用户不存在、密码错误、认证服务不可用等场景
     */
    AUTHC_ERROR(DefaultCode.AUTHC_ERROR, "用户登录/认证失败"),
    /**
     * 接口鉴权失败，调用接口没有权限时使用的错误码
     */
    ACCESS_DENIED(DefaultCode.ACCESS_DENIED, "没有访问权限"),
    /**
     * 没有登录，用以异步返回需要登录的错误码
     */
    NO_LOGIN(DefaultCode.NO_LOGIN, "没有登录"),
    ;

    private String code;
    private String error;

    DefaultErrorCode(String code, String error) {
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

