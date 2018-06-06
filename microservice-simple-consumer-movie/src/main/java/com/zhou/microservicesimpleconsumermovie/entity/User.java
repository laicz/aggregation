/**
 * Date:     2018/6/622:11
 * AUTHOR:   Administrator
 */
package com.zhou.microservicesimpleconsumermovie.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 2018/6/6  22:11
 * created by zhoumb
 */
public class User implements Serializable{

    private Long id;
    private String username;
    private String name;
    private Short age;
    private BigDecimal balance;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Short getAge() {
        return age;
    }

    public void setAge(Short age) {
        this.age = age;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
