package com.person.master.conf.security;

import com.person.master.common.exception.AuthcErrorException;
import com.person.master.constant.Constant;
import com.person.master.dto.UserDto;
import com.person.master.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * 自定义shiro realm
 *
 * @author liuht
 * 2018/10/19 14:49
 */
@Slf4j
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    /**
     * 权限注入(未使用)
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(final PrincipalCollection principals) {
        return new SimpleAuthorizationInfo();
    }

    /**
     * 用户认证
     *
     * @param authcToken 用户token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(final AuthenticationToken authcToken) throws
            AuthenticationException {
        // 用户账号，密码
        final String account = (String) authcToken.getPrincipal();
        String password = new String((char[]) authcToken.getCredentials());
        UserDto user = userService.searchUser(account);
        //用户判断
        if (!password.equalsIgnoreCase(user.getPassword())) {
            throw new AuthcErrorException("用户登录/认证失败,密码错误");
        }
        final SessionUser sessionUser = new SessionUser();
        sessionUser.setUserDto(user);
        //将用户信息放入session中
        SecurityUtils.getSubject().getSession().setAttribute(Constant.SESSION_USER_INFO, sessionUser);
        SecurityUtils.getSubject().getSession().setAttribute(Constant.SESSION_USER_PASSWORD, password);
        return new SimpleAuthenticationInfo(account, password, getName());
    }
}
