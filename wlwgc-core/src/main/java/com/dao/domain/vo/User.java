package com.dao.domain.vo;

import com.alibaba.fastjson.JSON;
import com.dao.base.domain.Entity;
/**
 * Created by zxdong on 2017/1/25.
 */
public class User extends Entity {
    private String id;//         VARCHAR2(20) not null,
    private String username;//   VARCHAR2(50),
    private String realname;//   VARCHAR2(20),
    private String password;//   VARCHAR2(50),
    private String areaid;//     VARCHAR2(10),
    private Integer usertype;//   NUMBER,
    private String other;//      VARCHAR2(50),
    private String createtime;// VARCHAR2(20),
    private String updatetime;// VARCHAR2(20)


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAreaid() {
        return areaid;
    }

    public void setAreaid(String areaid) {
        this.areaid = areaid;
    }

    public Integer getUsertype() {
        return usertype;
    }

    public void setUsertype(Integer usertype) {
        this.usertype = usertype;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
