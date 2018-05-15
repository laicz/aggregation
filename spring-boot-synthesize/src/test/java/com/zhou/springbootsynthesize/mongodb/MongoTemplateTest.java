/**
 * Date:     2018/5/1323:21
 * AUTHOR:   Administrator
 */
package com.zhou.springbootsynthesize.mongodb;

import com.mongodb.DBCollection;
import com.zhou.springbootsynthesize.mongodb.model.Item;
import com.zhou.springbootsynthesize.mongodb.model.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.UUID;

/**
 * 2018/5/13  23:21
 * created by zhoumb
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class MongoTemplateTest {

    @Autowired
    private MongoTemplate mongoTemplate ;

    @Test
    public  void saveOrderItem(){
        Item item1 = new Item();
        Order order = new Order();
        item1.setId(11L);
        item1.setOrder(order);
        item1.setPrice(26D);
        item1.setProduct("java白城思想");
        item1.setQuantity(3);

        Item item2 = new Item();
        item2.setId(11L);
        item2.setOrder(order);
        item2.setPrice(26D);
        item2.setProduct("spring实战");
        item2.setQuantity(3);

        order.setCustomer("周庄");
        order.setId(UUID.randomUUID().toString().substring(11).replaceAll("-",""));
        order.setType("1");

        LinkedHashSet<Item> set = new LinkedHashSet();
        set.add(item1);
        set.add(item2);
        order.setItems(set);
        mongoTemplate.save(order);
    }

    @Test
    public  void findOrderItemTest(){
        DBCollection order = mongoTemplate.getCollection("order");
        long count = order.count();
        System.out.println(count);
    }

    @Test
    public void findOrderItemByClient(){
        List<Order> orders = mongoTemplate.find(Query.query(Criteria.where("type").is("1")/*.orOperator(Criteria.where("customer").is("庄周"))*/),Order.class);
        System.out.println("一共查询到：" + orders.size());
        for (Order order:
             orders) {
            System.out.println(order);
        }
    }
}
