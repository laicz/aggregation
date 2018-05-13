/**
 * Date:     2018/5/1123:16
 * AUTHOR:   Administrator
 */
package com.zhou.springbootsynthesize.common.model;

import org.springframework.data.annotation.Id;

/**
 * 2018/5/11  23:16
 * created by zhoumb
 */
public class BaseEntity {

    @Id
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
