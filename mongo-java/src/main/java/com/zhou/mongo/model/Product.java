/**
 * Date:     2018/5/1916:41
 * AUTHOR:   Administrator
 */
package com.zhou.mongo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 商品
 * 2018/5/19  16:41
 * created by zhoumb
 */
@Document
public class Product {
    @Id
    private String id;//商品id
    private String slug;//唯一slug
    private String sku;//商品编号
    private String name;//商品名称
    private String description;//商品描述
    private ProductDetail details;//商品详情
    private Long total_reviews;//评价总数
    private Double average_review;//评价平均分
    private ProductPrice pricing;//价格：包含定价和折后价
    private PriceHistory[] price_histoty;//历史价格
    private String primary_category;//主要分类
    private String[] category_ids;
    private String main_cat_id;//主要类别
    private String[] tags;//标签

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProductDetail getDetails() {
        return details;
    }

    public void setDetails(ProductDetail details) {
        this.details = details;
    }

    public Long getTotal_reviews() {
        return total_reviews;
    }

    public void setTotal_reviews(Long total_reviews) {
        this.total_reviews = total_reviews;
    }

    public Double getAverage_review() {
        return average_review;
    }

    public void setAverage_review(Double average_review) {
        this.average_review = average_review;
    }

    public ProductPrice getPricing() {
        return pricing;
    }

    public void setPricing(ProductPrice pricing) {
        this.pricing = pricing;
    }

    public PriceHistory[] getPrice_histoty() {
        return price_histoty;
    }

    public void setPrice_histoty(PriceHistory[] price_histoty) {
        this.price_histoty = price_histoty;
    }

    public String getPrimary_category() {
        return primary_category;
    }

    public void setPrimary_category(String primary_category) {
        this.primary_category = primary_category;
    }

    public String[] getCategory_ids() {
        return category_ids;
    }

    public void setCategory_ids(String[] category_ids) {
        this.category_ids = category_ids;
    }

    public String getMain_cat_id() {
        return main_cat_id;
    }

    public void setMain_cat_id(String main_cat_id) {
        this.main_cat_id = main_cat_id;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }
}
