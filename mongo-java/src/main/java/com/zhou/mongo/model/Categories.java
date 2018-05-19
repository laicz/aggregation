/**
 * Date:     2018/5/1917:04
 * AUTHOR:   Administrator
 */
package com.zhou.mongo.model;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

/**
 * 分类信息
 * 2018/5/19  17:04
 * created by zhoumb
 */
@Document
public class Categories {
    @Id
    private String id;
    private String slug;
    private String name;
    private String description;
    private String parent_id;
    private CatgoryAncestor ancestors;

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

    public String getParent_id() {
        return parent_id;
    }

    public void setParent_id(String parent_id) {
        this.parent_id = parent_id;
    }

    public CatgoryAncestor getAncestors() {
        return ancestors;
    }

    public void setAncestors(CatgoryAncestor ancestors) {
        this.ancestors = ancestors;
    }
}
