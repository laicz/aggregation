/**
 * Date:     2018/5/1522:11
 * AUTHOR:   Administrator
 */
package com.zhou.springbootsynthesize.sys.service;

import com.zhou.springbootsynthesize.sys.model.UserInfo;

/**
 * 2018/5/15  22:11
 * created by zhoumb
 */
public interface UserInfoService {

    UserInfo findUserInfoByUsername(String username);
}
