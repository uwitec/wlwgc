package com.dao.util.page;

import com.alibaba.fastjson.JSON;

import java.util.List;
import java.util.Map;

/**
 *  rss指返回结果，默认*； 约定:第一张表为tb1,第二张表为tb2,以此类推
 *
 * tableNames tableNames可以写多种表关联，约定:第一张表为tb1,第二张表为tb2,以此类推
 *                   如【{tb_a}，{tb_b}】
 * links links指表之间的关联,键值以逗号‘，’分开，约定，第一张表为tb1,第二张表为tb2,以此类推
 *              如：【{‘a,b’:'link'}】
 * conditions conditions条件， 约定:第一张表为tb1,第二张表为tb2,以此类推
 *                   【{‘a’:‘condition’}】
 *  start 起始页
 *  end  结束页
 * Created by zxdong on 2017/1/6.
 */
public class FYBean {

    private Map<String,String> rss;
    private List<String> tableNames;
    private String conditions;
    private Integer start;
    private Integer end;


    public List<String> getTableNames() {
        return tableNames;
    }

    public void setTableNames(List<String> tableNames) {
        this.tableNames = tableNames;
    }

    public Map<String, String> getRss() {
        return rss;
    }

    public void setRss(Map<String, String> rss) {
        this.rss = rss;
    }


    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getEnd() {
        return end;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
