package com.person.master.common.errorcode;

/**
 * 全局通用错误码定义
 *
 * @author jjma
 * 2019/08/30 16:32
 */
public interface DefaultCode {

    /**
     * 请求成功返回码
     */
    String SUCCESS = "00000000";

    /**
     * 系统错误 全局兜底错误码：系统不可用、系统繁忙、其他一些未知错误
     */
    String SYS_ERROR = "99999999";

    /**
     * 参数校验失败
     */
    String INVALID_PARAM = "00000001";

    /**
     * 用户登录、认证失败错误码，可包括用户不存在、密码错误、认证服务不可用等场景
     */
    String AUTHC_ERROR = "00000002";

    /**
     * 接口鉴权失败，调用接口没有权限时使用的错误码
     */
    String ACCESS_DENIED = "00000003";

    /**
     * 没有登录，用以异步返回需要登录的错误码
     */
    String NO_LOGIN = "00000004";
}
