package com.person.master.conf.security;

import com.person.master.constant.Constant;
import com.person.master.constant.SessionConstants;
import com.person.master.dto.UserDto;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.util.StringUtils;

public class SecurityHelper {
    /**
     * 获取当前登录用户 不包含密码
     *
     * @return
     */
    public static SessionUser getLoginUser() {
        final Session session = SecurityUtils.getSubject().getSession();
        if (session.getAttribute(Constant.SESSION_USER_INFO) != null) {
            return (SessionUser) session.getAttribute(Constant.SESSION_USER_INFO);
        }
        return new SessionUser();
    }

    /**
     * 存放session 用户信息
     * @param user
     */
    public static void putSessionUser(UserDto user) {
        SecurityUtils.getSubject().getSession().setAttribute(SessionConstants.SESSION_USER, user);
    }

    /**
     * 存放session 属性
     * @param key
     * @param value
     */
    public static void putSessionAttr(String key, Object value){
        if (!StringUtils.isEmpty(key)) {
            SecurityUtils.getSubject().getSession().setAttribute(key, value);
        }
    }

    /**
     * 移除session 属性
     * @param key
     */
    public static void removeSessionAttr(String key){
        if (StringUtils.isEmpty(key)) {
            SecurityUtils.getSubject().getSession().setAttribute(key, null);
        }
    }

}
