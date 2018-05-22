/**
 * Date:     2018/5/2221:48
 * AUTHOR:   Administrator
 */
package com.zhou.mongo.chapter_05;

import com.zhou.mongo.chapter_05.service.OrderService;
import com.zhou.mongo.chapter_05.service.ProductService;
import com.zhou.mongo.chapter_05.service.UserService;
import com.zhou.mongo.model.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

/**
 * 2018/5/22  21:48
 * created by zhoumb
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderAdd {

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;

    @Test
    public void createOrder() {
        Long starTime = new Date().getTime();
        //获取所有的商品
        List<Product> products = productService.getAllProduct();
        //获取所有的用户
        List<User> users = userService.getAllUser();

        int j = -355;
        int[] ints = new int[700];
        //时间
        for (int i = 0; i < 700; i++) {
            ints[i]=j++;
        }

        Random random = new Random();

        List<Order> orders = new ArrayList<>(200000);
        Calendar calendar = Calendar.getInstance();
        for (int i = 0; i < 200000; i++) {
            Order order = new Order();
            //创建时间
            calendar.setTime(new Date());
            calendar.add(Calendar.DAY_OF_YEAR,ints[random.nextInt(700)]);

            order.setCreate_time(calendar.getTime());
            //创建商品
            Item[] items = new Item[random.nextInt(10)];
            for (int k = 0; k < items.length; k++) {
                Item item = new Item();
                Product product = products.get(random.nextInt(products.size()));
                item.setProduct_id(product.getId());
                item.setName(product.getName());
                ProductPrice productPrice = new ProductPrice();
                productPrice.setSale(random.nextLong());
                productPrice.setRetail(productPrice.getSale() + 1000L);
                item.setPricing(productPrice);
                item.setQuantity(random.nextInt(10));
                item.setSku(product.getSku());
                items[k] = item;
            }

            order.setItems(items);
            ShipAddress shipAddress = new ShipAddress();
            shipAddress.setCity("深圳");
            shipAddress.setState("1");
            shipAddress.setStreet("8号街");
            order.setShip_address(shipAddress);
            order.setState("1");
            Long totalPrice = 0L;
            for (Item item:
                 items) {
                totalPrice += item.getPricing().getRetail() * item.getQuantity();
             }
            order.setSub_total(totalPrice);
            order.setUser_id(users.get(random.nextInt(users.size())).getId());

            orders.add(order);
        }
        List<Order> orders1 = orderService.saveAll(orders);
        System.out.println( "工保存：---------   "+ orders1.size());
        Long endTime = new Date().getTime();
        System.out.println((endTime - starTime)/1000 + "秒");
    }
}
