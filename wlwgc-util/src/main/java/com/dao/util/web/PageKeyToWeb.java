package com.dao.util.web;

import com.alibaba.fastjson.JSON;

/**
 * Created by dzx on 2016/1/28 0028.
 */
public class PageKeyToWeb {
    /**
     * 以下是主页头部直接跳转到到页面键值
     */
    //    跳转到主页的键值
    private Integer home=PageUtils.HOME;

    //    跳转到用户管理界面键值
    private Integer yhgl=PageUtils.YHGL;

    //    跳转到实时监测界面键值
    private Integer ssjc=PageUtils.SSJC;

    //跳转到阈值设置界面键值
    private Integer kzsz=PageUtils.KZSZ;

    //跳转到添加区域键值
    private Integer qygl=PageUtils.QYGL;

    //跳转到中继器管理面键值
    private Integer zjqgl=PageUtils.ZJQGL;
    //跳转到终端管理界面键值
    private Integer zdgl=PageUtils.ZDGL;

    //跳转到个人中心界面键值
    private Integer usercenter=PageUtils.USERCENTER;

    //跳转到设备管理界面键值
    private Integer sbgl =PageUtils.SBGL;

    public Integer getHome() {
        return home;
    }

    public void setHome(Integer home) {
        this.home = home;
    }

    public Integer getYhgl() {
        return yhgl;
    }

    public void setYhgl(Integer yhgl) {
        this.yhgl = yhgl;
    }

    public Integer getSsjc() {
        return ssjc;
    }

    public void setSsjc(Integer ssjc) {
        this.ssjc = ssjc;
    }

    public Integer getKzsz() {
        return kzsz;
    }

    public void setKzsz(Integer kzsz) {
        this.kzsz = kzsz;
    }

    public Integer getQygl() {
        return qygl;
    }

    public void setQygl(Integer qygl) {
        this.qygl = qygl;
    }

    public Integer getZjqgl() {
        return zjqgl;
    }

    public void setZjqgl(Integer zjqgl) {
        this.zjqgl = zjqgl;
    }

    public Integer getZdgl() {
        return zdgl;
    }

    public void setZdgl(Integer zdgl) {
        this.zdgl = zdgl;
    }

    public Integer getUsercenter() {
        return usercenter;
    }

    public void setUsercenter(Integer usercenter) {
        this.usercenter = usercenter;
    }

    public Integer getSbgl() {
        return sbgl;
    }

    public void setSbgl(Integer sbgl) {
        this.sbgl = sbgl;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
