/**
 * Date:     2018/5/1123:15
 * AUTHOR:   Administrator
 */
package com.zhou.springbootsynthesize.sys.model;

import com.zhou.springbootsynthesize.common.model.BaseEntity;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 2018/5/11  23:15
 * created by zhoumb
 */
//@Document(collection = "/specifical")//可以用来指定document的名称
public class LoginInfo extends BaseEntity {
    private String username;
    private String password;
    private Integer status;//0 正常状态,2  被禁用

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
