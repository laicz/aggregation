/**
 * Date:     2018/5/1311:24
 * AUTHOR:   Administrator
 */
package com.zhou.springbootsynthesize.mongodb.model;

import com.zhou.springbootsynthesize.common.model.BaseEntity;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * 2018/5/13  11:24
 * created by zhoumb
 */
@Document
public class Person extends BaseEntity{
    private String name;
    private Integer age;
    private String email;
    private String country;
    private String[] book;
    private Date createTime;


    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Person() {
    }

    public Person(String name, Integer age, String email, String country, String[] book,Date createTime) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.country = country;
        this.book = book;
        this.createTime = createTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String[] getBook() {
        return book;
    }

    public void setBook(String[] book) {
        this.book = book;
    }
}
