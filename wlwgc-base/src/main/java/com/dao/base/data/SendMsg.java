package com.dao.base.data;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

/**
 * Created by dzx on 2016/2/8 0008.
 */
public class SendMsg<T> implements Serializable {
    private Integer flag;
    private String msg;
    private Page<T>  page;
    private T t;

    public Page<T> getPage() {
        return page;
    }

    public void setPage(Page<T> page) {
        this.page = page;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }



    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }


}
