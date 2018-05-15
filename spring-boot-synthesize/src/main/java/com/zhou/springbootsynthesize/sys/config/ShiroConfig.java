/**
 * Date:     2018/5/1521:46
 * AUTHOR:   Administrator
 */
package com.zhou.springbootsynthesize.sys.config;

import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 2018/5/15  21:46
 * created by zhoumb
 */
@Configuration
public class ShiroConfig {
    @Bean
    @DependsOn(value = "securityManager")
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager){
        System.out.println("ShiroConfig.shiroFilter()");
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //设置拦截器容器
        Map<String,String> filterChainDefinitionMap = new LinkedHashMap<>();
        //配置不会被拦截的链接
        filterChainDefinitionMap.put("/static/**","anno");
        //配置退出过滤器，具体的销毁登录对象shiro已经实现
        filterChainDefinitionMap.put("/logout","logout");
        //<!-- 过滤链定义，从上向下顺序执行，一般将/**放在最为下边 -->:这是一个坑呢，一不小心代码就不好使了;
        //<!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
        filterChainDefinitionMap.put("/**", "authc");
        // 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
        shiroFilterFactoryBean.setLoginUrl("/login");
        // 登录成功后要跳转的链接
        shiroFilterFactoryBean.setSuccessUrl("/index");

        //未授权界面;
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    @Bean
    public SystemShiroRealm systemShiroRealm(){
        return new SystemShiroRealm();
    }

    @Bean(value = "securityManager")
    public SecurityManager securityManager(){
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(systemShiroRealm());
        return  defaultSecurityManager;
    }
}
