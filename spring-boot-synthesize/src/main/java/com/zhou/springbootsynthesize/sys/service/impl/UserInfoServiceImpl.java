/**
 * Date:     2018/5/1522:12
 * AUTHOR:   Administrator
 */
package com.zhou.springbootsynthesize.sys.service.impl;

import com.zhou.springbootsynthesize.sys.dao.UserInfoDao;
import com.zhou.springbootsynthesize.sys.model.UserInfo;
import com.zhou.springbootsynthesize.sys.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 2018/5/15  22:12
 * created by zhoumb
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    public UserInfo findUserInfoByUsername(String username) {
        return userInfoDao.findUserInfoByUsername(username);
    }
}
