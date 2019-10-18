package com.person.master.conf.security;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
@Slf4j
public class ShiroConfiguration {
    @Value("${server.servlet.path}")
    private String contextPath;

    //@Autowired
   // private RedisTemplate redisTemplate;

    /**
     * Shiro的Web过滤器Factory 命名:shiroFilter
     */
    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //把securityManager加到环境变量中
        SecurityUtils.setSecurityManager(securityManager);
        // Shiro的核心安全接口,这个属性是必须的
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        // 自定义拦截器
        Map<String, Filter> filters = new HashMap<>(1);
        // 定义shiro过滤链
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();

        filterChainDefinitionMap.put(contextPath + "/api/v1/authc/**", "anon");
        filterChainDefinitionMap.put(contextPath + "/error", "anon");
        filterChainDefinitionMap.put(contextPath + "/**", "authc");
        shiroFilterFactoryBean.setFilters(filters);
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        shiroFilterFactoryBean.setLoginUrl(contextPath + "/api/v1/authc/nologin");
        shiroFilterFactoryBean.setUnauthorizedUrl(contextPath + "/api/v1/authc/unauthorized");
        return shiroFilterFactoryBean;
    }

    /**
     * shiro SecurityManager
     */
    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm());
        return securityManager;
    }

    /**
     * 自定义 Shiro Realm
     */
    @Bean
    public UserRealm userRealm() {
        return new UserRealm();
    }
}
