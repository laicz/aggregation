/**
 * Date:     2018/5/1918:25
 * AUTHOR:   Administrator
 */
package com.zhou.mongo.model;

/**
 * 商品寄送地址
 * 2018/5/19  18:25
 * created by zhoumb
 */
public class ShipAddress {
    private String street;
    private String city;
    private String state;
    private Integer zip;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getZip() {
        return zip;
    }

    public void setZip(Integer zip) {
        this.zip = zip;
    }
}
