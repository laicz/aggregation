/**
 * Date:     2018/6/623:05
 * AUTHOR:   Administrator
 */
package com.zhou.microservicesimpleconsumermovie.web;

import com.zhou.microservicesimpleconsumermovie.entity.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 2018/6/6  23:05
 * created by zhoumb
 */
@RestController
public class MovieController {

    @RequestMapping(value = "/movie/{id}")
    public User findById(@PathVariable Long id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://localhost:7900/simple/" + id,User.class);
    }
}
