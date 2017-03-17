package com.dao.domain.dto;

import com.alibaba.fastjson.JSON;
import com.dao.domain.vo.User;

/**
 * Created by dzx on 2016/10/31.
 */
public class Login extends User{
    private Integer flag;
    private String yzm;
    private String remenber;
    private String avatarurl;


    public String getAvatarurl() {
        return avatarurl;
    }

    public void setAvatarurl(String avatarurl) {
        this.avatarurl = avatarurl;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getYzm() {
        return yzm;
    }

    public void setYzm(String yzm) {
        this.yzm = yzm;
    }

    public String getRemenber() {
        return remenber;
    }

    public void setRemenber(String remenber) {
        this.remenber = remenber;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
