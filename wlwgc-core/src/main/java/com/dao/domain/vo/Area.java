package com.dao.domain.vo;

import com.alibaba.fastjson.JSON;
import com.dao.base.domain.Entity;

/**
 * Created by zxdong on 2017/1/27.
 */
public class Area extends Entity {
    private String id;//         VARCHAR2(10) not null,
    private String name;//           VARCHAR2(50),
    private String address;//        VARCHAR2(50),
    private String function;//       VARCHAR2(50),
    private String otherone;//       VARCHAR2(50),
    private String othertwo;//       VARCHAR2(50),
    private String createtime;//     VARCHAR2(20),
    private String updatetime;//     VARCHAR2(20)

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
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
