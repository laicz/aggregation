/**
 * Date:     2018/6/39:38
 * AUTHOR:   Administrator
 */
package com.zhou.clouddemo.testController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 2018/6/3  9:38
 * created by zhoumb
 */
@RestController
public class TestController {

    @RequestMapping("/ping")
    public String ping(){
        return "pong";
    }
}
