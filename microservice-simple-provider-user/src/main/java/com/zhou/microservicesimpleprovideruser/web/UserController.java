/**
 * Date:     2018/6/622:38
 * AUTHOR:   Administrator
 */
package com.zhou.microservicesimpleprovideruser.web;

import com.zhou.microservicesimpleprovideruser.entity.User;
import com.zhou.microservicesimpleprovideruser.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 2018/6/6  22:38
 * created by zhoumb
 */
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/simple/{id}",method = RequestMethod.GET)
    public User findById(@PathVariable Long id){
        return this.userRepository.findOne(id);
    }
}
