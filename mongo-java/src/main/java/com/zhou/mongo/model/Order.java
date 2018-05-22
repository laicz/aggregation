/**
 * Date:     2018/5/1916:40
 * AUTHOR:   Administrator
 */
package com.zhou.mongo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * 商品订单文档
 * 2018/5/19  16:40
 * created by zhoumb
 */
@Document
public class Order {
    @Id
    private String id;
    private String user_id;
    private String state;
    private Item[] items;
    private ShipAddress ship_address;
    private Long sub_total;
    private Date create_time;

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Item[] getItems() {
        return items;
    }

    public void setItems(Item[] items) {
        this.items = items;
    }

    public ShipAddress getShip_address() {
        return ship_address;
    }

    public void setShip_address(ShipAddress ship_address) {
        this.ship_address = ship_address;
    }

    public Long getSub_total() {
        return sub_total;
    }

    public void setSub_total(Long sub_total) {
        this.sub_total = sub_total;
    }
}
