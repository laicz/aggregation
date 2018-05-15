/**
 * Date:     2018/5/1521:30
 * AUTHOR:   Administrator
 */
package com.zhou.springbootsynthesize.sys.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * 2018/5/15  21:30
 * created by zhoumb
 */
@Entity
public class UserInfo implements Serializable{
    @Id
    @GeneratedValue
    private Integer id;
    @Column(unique = true)//账号添加唯一属性
    private String username;
    private String name;
    private String password;
    private String salt;
    private byte state;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "SysUserRole",joinColumns = { @JoinColumn(name = "uid") }, inverseJoinColumns ={@JoinColumn(name = "roleId") })
    private List<SysRole> roleList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public byte getState() {
        return state;
    }

    public void setState(byte state) {
        this.state = state;
    }

    public List<SysRole> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<SysRole> roleList) {
        this.roleList = roleList;
    }

    /**
     * 密码盐.
     * @return
     */
    public String getCredentialsSalt(){
        return this.username+this.salt;
    }
    //重新对盐重新进行了定义，用户名+salt，这样就更加不容易被破解
}
