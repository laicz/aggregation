/**
 * Date:     2018/5/1522:13
 * AUTHOR:   Administrator
 */
package com.zhou.springbootsynthesize.sys.dao;

import com.zhou.springbootsynthesize.sys.model.UserInfo;
import org.springframework.data.repository.CrudRepository;

/**
 * 2018/5/15  22:13
 * created by zhoumb
 */
public interface UserInfoDao extends CrudRepository<UserInfo,Long>{
    UserInfo findUserInfoByUsername(String username);
}
