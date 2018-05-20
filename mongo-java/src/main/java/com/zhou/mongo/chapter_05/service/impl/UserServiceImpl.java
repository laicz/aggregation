/**
 * Date:     2018/5/1923:25
 * AUTHOR:   Administrator
 */
package com.zhou.mongo.chapter_05.service.impl;

import com.zhou.mongo.chapter_05.repository.UserMBRepository;
import com.zhou.mongo.chapter_05.service.UserService;
import com.zhou.mongo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 2018/5/19  23:25
 * created by zhoumb
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMBRepository userMBRepository;

    @Override
    public List<User> saveAll(List<User> users){
        return  userMBRepository.saveAll(users);
    }
}
