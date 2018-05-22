/**
 * Date:     2018/5/2222:14
 * AUTHOR:   Administrator
 */
package com.zhou.mongo.chapter_05.repository;

import com.zhou.mongo.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 2018/5/22  22:14
 * created by zhoumb
 */
public interface OrderMBRepository extends MongoRepository<Order,String>{
}
