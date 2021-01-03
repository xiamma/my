package com.demo.entity;

import java.util.Date;

/**
 * @Description
 * @Author leslee
 * @Date 2020-12-11 下午2:52
 */
public class User {

    private Integer id;
    private String username;
    private String password;
    private String createTime;
    private Integer role;


    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(Integer id, String username, String password, String createTime, Integer role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.createTime = createTime;
        this.role = role;
    }

    public User(String username, String password, String createTime, Integer role) {
        this.username = username;
        this.password = password;
        this.createTime = createTime;
        this.role = role;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }


    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", createTime=" + createTime +
                ", role=" + role +
                '}';
    }
}
