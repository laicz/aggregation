/**
 * Date:     2018/5/2221:44
 * AUTHOR:   Administrator
 */
package com.zhou.mongo.chapter_05.web;

import com.alibaba.fastjson.JSONArray;
import com.zhou.mongo.chapter_05.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 2018/5/22  21:44
 * created by zhoumb
 */
@RestController
@RequestMapping(value = "/index")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/product/getOrderByDate")
    public JSONArray getOrderByDate(){
        return orderService.getOrderGroupByMonth(new Date(),new Date());
    }
}
