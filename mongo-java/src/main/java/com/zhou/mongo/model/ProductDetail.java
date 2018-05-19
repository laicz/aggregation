/**
 * Date:     2018/5/1916:46
 * AUTHOR:   Administrator
 */
package com.zhou.mongo.model;

/**
 * 商品详情
 * 2018/5/19  16:46
 * created by zhoumb
 */
public class ProductDetail {
    private Integer weight;
    private String weigth_units;
    private Long model_num;
    private String manufacturer;
    private String color;

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getWeigth_units() {
        return weigth_units;
    }

    public void setWeigth_units(String weigth_units) {
        this.weigth_units = weigth_units;
    }

    public Long getModel_num() {
        return model_num;
    }

    public void setModel_num(Long model_num) {
        this.model_num = model_num;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
