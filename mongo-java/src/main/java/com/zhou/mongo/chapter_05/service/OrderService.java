/**
 * Date:     2018/5/2221:40
 * AUTHOR:   Administrator
 */
package com.zhou.mongo.chapter_05.service;

import com.alibaba.fastjson.JSONArray;
import com.zhou.mongo.model.Order;

import java.util.Date;
import java.util.List;

/**
 * 2018/5/22  21:40
 * created by zhoumb
 */
public interface OrderService {
    JSONArray getOrderGroupByMonth(Date startTime, Date endTime);

    List<Order> saveAll(List<Order> orders);
}
