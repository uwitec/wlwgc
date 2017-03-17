package com.dao.base.data;


import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Created by dzx on 2016/10/26.
 */
public class IWebController {

    public static void toWebUTF(HttpServletResponse response,Object obj){
        toWeb(response,"UTF-8",200,"text/html;charset=UTF-8", obj);

    }
    public static void toWebUTF(HttpServletResponse response, Integer ztm, Object obj){
        toWeb(response,"UTF-8",ztm,"text/html;charset=UTF-8", obj);

    }
    public static void toWebUTF(HttpServletResponse response, Integer ztm, String hear, Object obj){

        toWeb(response,"UTF-8",ztm,hear, obj);
    }
    public static void toWebUTF(HttpServletResponse response, String hear, Object obj){

        toWeb(response,"UTF-8",200,hear, obj);
    }

    public static void toWeb(HttpServletResponse response, String charform, Integer ztm, String hear, Object obj){
        response.setStatus(ztm);
        response.setCharacterEncoding(charform);
        response.setHeader("Content-type",hear);
        response.setContentType("application/json; charset=utf-8");
        try{
            PrintWriter writer=response.getWriter();
            writer.write(obj.toString());

        }catch (Exception e){

                System.err.println("出了点小问题："+e);

        }


    }

}
