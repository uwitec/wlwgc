package com.dao.domain.dto;

import com.alibaba.fastjson.JSON;
import com.dao.base.domain.Entity;

/**
 * Created by zxdong on 2017/2/6.
 */
public class KZGL extends Entity {
    private String id;    //     VARCHAR2(20) not null,
    private String qyid;//       VARCHAR2(20),
    private String cslxid;     //VARCHAR2(20),
    private Integer first;      //NUMBER,
    private Integer last;       //NUMBER,
    private String createtime; //VARCHAR2(20),
    private String userid;     //VARCHAR2(20),
    private String  otherone;  // VARCHAR2(50),
    private String othertwo;//   VARCHAR2(50)
    private String areaname;
    private String username;
    private String cscode;
    private String csname;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQyid() {
        return qyid;
    }

    public void setQyid(String qyid) {
        this.qyid = qyid;
    }

    public String getCslxid() {
        return cslxid;
    }

    public void setCslxid(String cslxid) {
        this.cslxid = cslxid;
    }

    public Integer getFirst() {
        return first;
    }

    public void setFirst(Integer first) {
        this.first = first;
    }

    public Integer getLast() {
        return last;
    }

    public void setLast(Integer last) {
        this.last = last;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getOtherone() {
        return otherone;
    }

    public void setOtherone(String otherone) {
        this.otherone = otherone;
    }

    public String getOthertwo() {
        return othertwo;
    }

    public void setOthertwo(String othertwo) {
        this.othertwo = othertwo;
    }

    public String getAreaname() {
        return areaname;
    }

    public void setAreaname(String areaname) {
        this.areaname = areaname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCscode() {
        return cscode;
    }

    public void setCscode(String cscode) {
        this.cscode = cscode;
    }

    public String getCsname() {
        return csname;
    }

    public void setCsname(String csname) {
        this.csname = csname;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
