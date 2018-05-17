/**
 * Date:     2018/5/178:02
 * AUTHOR:   Administrator
 */
package com.zhou.mongo.chapter_03.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 2018/5/17  8:02
 * created by zhoumb
 */
@Entity
public class Twitter  {
    @Id
    private String id;

    private String content;
    private String[] tags;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }
}
