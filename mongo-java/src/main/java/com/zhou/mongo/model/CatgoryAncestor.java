/**
 * Date:     2018/5/1917:07
 * AUTHOR:   Administrator
 */
package com.zhou.mongo.model;

/**
 * 分类信息父类
 * 2018/5/19  17:07
 * created by zhoumb
 */
public class CatgoryAncestor {
    private String name;
    private String parend_id;
    private String slug;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParend_id() {
        return parend_id;
    }

    public void setParend_id(String parend_id) {
        this.parend_id = parend_id;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }
}
