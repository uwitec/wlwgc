package com.dao.util.page;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zxdong on 2016/12/27.
 */
public class FYUtil {


    /**
     * @param fyBean
     *
     * rss指返回结果，默认*；
     *
     * tableNames tableNames可以写多种表关联，约定:第一张表为tb1,第二张表为tb2,以此类推
     *                   如【{tb_a}，{tb_b}】
     * links links指表之间的关联,键值以逗号‘，’分开，约定，第一张表为tb1,第二张表为tb2,以此类推
     *              如：【{‘a,b’:'link'}】
     * conditions conditions条件， 约定:第一张表为tb1,第二张表为tb2,以此类推
     *                   【{‘a’:‘condition’}】
     * start 起始页
     *
     * end  结束页
     *
     *  @return
     */


    public static String getPageSql(FYBean fyBean){

        String sql="with partdata as (select rownum as rowno,tt.* from (" +getSql(fyBean,1)+")tt where rownum<="+fyBean.getEnd().toString()+")\n"+
        "SELECT * from partdata where rowno>=" +fyBean.getStart().toString();
        return sql;
    }
    public static String getTotalSql(FYBean fyBean){
        return getSql(fyBean,2);
    }

    public static String getSql(FYBean fyBean, Integer xs){
        //分解参数
        List<String> rsKeys=new ArrayList<String>();
        if(fyBean.getRss()!=null){
            for(String s:fyBean.getRss().keySet()){
                rsKeys.add(s);
            }
        }





//        默认
        String sql="select * from ";
        boolean flag=true;
        if(xs==1){


            //指定返回的结果
            if (rsKeys.size()!=0){
                if(flag){
                    sql="select ";
                    flag=false;
                }

                for(String s:rsKeys){
                    for(String sc:fyBean.getRss().get(s).split(",")) {
                        sql += "tb" + s + "." + sc + ",";
                    }
                }
                sql=sql.substring(0,sql.length()-1)+" from ";
            }

        }else{
            sql="select count(*) from ";
        }



        flag=true;

        Integer tableNamebm=1;

        //拼接相关连接表
        if(fyBean.getTableNames()!=null) {
            for (String tableName : fyBean.getTableNames()) {

                String tName=tableName;
                String tJoin="left";
                String tTinkTable="";
                String tLink="";

                if (!flag) {
                    sql += " left join ";
                    String[] t=tableName.split(",");
                    tName=t[0];
                    tTinkTable=t[1];
                    tLink=t[2];
                    if(t.length==4){
                        tJoin=t[4];
                    }
                }

                sql += tName + " tb" + tableNamebm.toString();
                tableNamebm++;

                if (flag) {
                    flag = false;
                    continue;
                }
                sql += " on tb" +tTinkTable + "." + tLink + "= tb" +(tableNamebm-1) + "." + tLink;
            }


        }

        //根据条件来查询
        sql+=" where 1=1 ";
        if(fyBean.getConditions()!=null){
            sql+="and "+fyBean.getConditions();
        }

        return sql;
    }
}
