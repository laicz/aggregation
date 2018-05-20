/**
 * Date:     2018/5/1521:51
 * AUTHOR:   Administrator
 */
package com.zhou.springbootsynthesize.sys.config;

import com.zhou.springbootsynthesize.sys.model.SysPermission;
import com.zhou.springbootsynthesize.sys.model.SysRole;
import com.zhou.springbootsynthesize.sys.model.UserInfo;
import com.zhou.springbootsynthesize.sys.service.UserInfoService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 2018/5/15  21:51
 * created by zhoumb
 */
public class SystemShiroRealm extends AuthorizingRealm{

    @Autowired
    private UserInfoService userInfoService;

    /**
     * 授权方法
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        UserInfo userInfo  = (UserInfo)principalCollection.getPrimaryPrincipal();
        for(SysRole role:userInfo.getRoleList()){
            authorizationInfo.addRole(role.getRole());
            for(SysPermission p:role.getPermissions()){
                authorizationInfo.addStringPermission(p.getPermission());
            }
        }
        return authorizationInfo;
    }

    /**
     * 认证方法
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("SystemShiroRealm.doGetAuthenticationInfo()");
        //获取用户的输入信息
        String username = (String)authenticationToken.getPrincipal();
        System.out.println(authenticationToken.getCredentials());
        //通过username到数据库来进行查找，这里可以进行加缓存
        UserInfo userInfo = userInfoService.findUserInfoByUsername(username);
        System.out.println("----->>userInfo="+userInfo);
        if(userInfo == null){
            return null;
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                userInfo, //用户名
                userInfo.getPassword(), //密码
                ByteSource.Util.bytes(userInfo.getCredentialsSalt()),//salt=username+salt
                getName()  //realm name
        );
        return authenticationInfo;
    }
}
