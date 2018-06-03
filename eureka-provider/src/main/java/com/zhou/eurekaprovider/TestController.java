/**
 * Date:     2018/6/311:17
 * AUTHOR:   Administrator
 */
package com.zhou.eurekaprovider;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 2018/6/3  11:17
 * created by zhoumb
 */
@RestController
public class TestController {

    @RequestMapping(value = "/test/ping")
    public String ping(){
        return "pong";
    }
}
