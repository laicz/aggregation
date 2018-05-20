/**
 * Date:     2018/5/1923:25
 * AUTHOR:   Administrator
 */
package com.zhou.mongo.chapter_05.service;

import com.zhou.mongo.model.User;

import java.util.List;

/**
 * 2018/5/19  23:25
 * created by zhoumb
 */
public interface UserService {

    List<User> saveAll(List<User> users);
}
