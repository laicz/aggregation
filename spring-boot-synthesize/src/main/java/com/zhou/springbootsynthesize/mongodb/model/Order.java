/**
 * Date:     2018/5/1323:13
 * AUTHOR:   Administrator
 */
package com.zhou.springbootsynthesize.mongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

/**
 * 2018/5/13  23:13
 * created by zhoumb
 */
@Document
public class Order {
    @Id//指定id
    private String id;
    @Field("client")//指定field在mongo中的键
    private String customer;
    private String type;
    private Collection<Item> items = new LinkedHashSet<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Collection<Item> getItems() {
        return items;
    }

    public void setItems(Collection<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", customer='" + customer + '\'' +
                ", type='" + type + '\'' +
                ", items=" + items +
                '}';
    }
}
