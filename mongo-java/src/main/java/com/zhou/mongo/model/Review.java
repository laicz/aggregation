/**
 * Date:     2018/5/1921:32
 * AUTHOR:   Administrator
 */
package com.zhou.mongo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * 商品评价
 * 2018/5/19  21:32
 * created by zhoumb
 */
@Document
public class Review {
    @Id
    private String id;
    private String product_id;
    private Date date;
    private String title;
    private String text;
    private Long rating;
    private String user_id;
    private String username;
    private Long helpful_votes;
    private String[] voter_ids;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getRating() {
        return rating;
    }

    public void setRating(Long rating) {
        this.rating = rating;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getHelpful_votes() {
        return helpful_votes;
    }

    public void setHelpful_votes(Long helpful_votes) {
        this.helpful_votes = helpful_votes;
    }

    public String[] getVoter_ids() {
        return voter_ids;
    }

    public void setVoter_ids(String[] voter_ids) {
        this.voter_ids = voter_ids;
    }
}
