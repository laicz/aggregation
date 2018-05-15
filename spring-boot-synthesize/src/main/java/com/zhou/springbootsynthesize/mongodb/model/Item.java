/**
 * Date:     2018/5/1323:15
 * AUTHOR:   Administrator
 */
package com.zhou.springbootsynthesize.mongodb.model;

import org.springframework.data.annotation.Transient;

/**
 * 因为item在order中被引用，而且item并不会被独立持久化在mongodb中，因此不需要使用@Document来进行注解
 * 2018/5/13  23:15
 * created by zhoumb
 */
public class Item {
    private Long id;
    @Transient
    private Order order;
    private String product;
    private double price;
    private int quantity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
