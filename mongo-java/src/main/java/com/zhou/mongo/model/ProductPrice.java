/**
 * Date:     2018/5/1916:51
 * AUTHOR:   Administrator
 */
package com.zhou.mongo.model;

/**
 * 商品价格
 * 2018/5/19  16:51
 * created by zhoumb
 */
public class ProductPrice {
    private Long retail;
    private Long sale;

    public Long getRetail() {
        return retail;
    }

    public void setRetail(Long retail) {
        this.retail = retail;
    }

    public Long getSale() {
        return sale;
    }

    public void setSale(Long sale) {
        this.sale = sale;
    }
}
