package com.dao.base.data;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;
import java.util.List;

/**
 * Created by dzx on 2016/10/26.
 */
public class Page<T>  implements Serializable {

    //页面大小
    private Integer pagesize;
    //当前页
    private Integer pagenum;
    //起始标志
    private Integer pagestart;
    //结束标志
    private Integer pageend;
    //总数
    private Long total;
    private String totalsql;
    //数据
    private List<T> rows;
    private String datasql;

    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTotalsql() {
        return totalsql;
    }

    public void setTotalsql(String totalsql) {
        this.totalsql = totalsql;
    }

    public String getDatasql() {
        return datasql;
    }

    public void setDatasql(String datasql) {
        this.datasql = datasql;
    }

    public void setStartEnd(Integer pagesize, Integer pagenum){
        this.pagenum=pagenum;
        this.pagesize=pagesize;
        this.pagestart=(pagenum-1)*pagesize+1;
        this.pageend=pagenum*pagesize;
    }

    public Integer getPagesize() {
        return pagesize;
    }

    public void setPagesize(Integer pagesize) {
        this.pagesize = pagesize;
    }

    public Integer getPagenum() {
        return pagenum;
    }

    public void setPagenum(Integer pagenum) {
        this.pagenum = pagenum;
    }

    public Integer getPagestart() {
        return pagestart;
    }

    public void setPagestart(Integer pagestart) {
        this.pagestart = pagestart;
    }

    public Integer getPageend() {
        return pageend;
    }

    public void setPageend(Integer pageend) {
        this.pageend = pageend;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
