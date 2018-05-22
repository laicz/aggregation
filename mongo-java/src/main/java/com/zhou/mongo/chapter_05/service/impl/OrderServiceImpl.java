/**
 * Date:     2018/5/2221:41
 * AUTHOR:   Administrator
 */
package com.zhou.mongo.chapter_05.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.zhou.mongo.chapter_05.dao.OrderMBDao;
import com.zhou.mongo.chapter_05.repository.OrderMBRepository;
import com.zhou.mongo.chapter_05.service.OrderService;
import com.zhou.mongo.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 2018/5/22  21:41
 * created by zhoumb
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMBDao orderMBDao;

    @Autowired
    private OrderMBRepository orderMBRepository;

    @Override
    public JSONArray getOrderGroupByMonth(Date startTime, Date endTime) {
        return orderMBDao.getOrderGroupByMonth(startTime,endTime);
    }

    @Override
    public List<Order> saveAll(List<Order> orders) {
        return orderMBRepository.saveAll(orders);
    }
}
