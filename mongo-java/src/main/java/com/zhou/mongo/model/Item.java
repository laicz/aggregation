/**
 * Date:     2018/5/1918:15
 * AUTHOR:   Administrator
 */
package com.zhou.mongo.model;

/**
 * 订单中的商品
 * 2018/5/19  18:15
 * created by zhoumb
 */
public class Item {
    private String product_id;
    private String sku;
    private String name;
    private Integer quantity;
    private ProductPrice pricing;

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public ProductPrice getPricing() {
        return pricing;
    }

    public void setPricing(ProductPrice pricing) {
        this.pricing = pricing;
    }
}
