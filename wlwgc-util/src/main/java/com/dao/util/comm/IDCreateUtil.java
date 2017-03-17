package com.dao.util.comm;

import com.dao.util.comm.DateUtils;

import java.util.Date;
import java.util.Random;

/**
 * Created by zxdong on 2017/1/14.
 */
public class IDCreateUtil {

    //默认16位，20170101191022
    public static String getID(){
        String zfc="0123456789ABCDEFGHJKLMNPQRSTUVWXYZ";
        String id= DateUtils.doFormatDate(new Date(), "yyyyMMddHHmmss");
        for(int i=0;i<6;i++){
            Random ra =new Random();
            int rdm=ra.nextInt(27);
            id+=zfc.charAt(rdm);
        }


        return id;
    }

    public static String getID(String zfc, Integer len){
        String id="";
        for(int i=0;i<len;i++){
            Random ra =new Random();
            int rdm=ra.nextInt(zfc.length());
            id+=zfc.charAt(rdm);
        }


        return id;
    }
    public static String getID(Integer len){
        String zfc="0123456789ABCDEFGHJKLMNPQRSTUVWXYZ";
        String id="";
        for(int i=0;i<len;i++){
            Random ra =new Random();
            int rdm=ra.nextInt(27);
            id+=zfc.charAt(rdm);
        }


        return id;
    }
}
