package com.dao.serviceimp;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dao.domain.dto.KZGL;
import com.dao.domain.dto.Login;
import com.dao.mapper.KZGLDao;
import com.dao.service.IKZGLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zxdong on 2017/2/6.
 */
@Service
public class KZGLService implements IKZGLService {


    @Autowired
    private KZGLDao kzglDao;

    public List<KZGL> findAll(){

        return kzglDao.findAll();

    }

    public void updateKzgl(String kzgls, HttpServletRequest request) {
        Login user=(Login)request.getSession().getAttribute("currentUser");
        String userid=user.getId();
        String areaid=user.getAreaid();
        try {
            List<JSONObject> kzglList= JSON.parseObject(kzgls, List.class);
            for(JSONObject jo:kzglList){
                KZGL kzgl=new KZGL();

                String id=jo.getString("id");
                if(jo.getString("first")!=null){
                    Integer first=Integer.valueOf(jo.getString("first"));
                    kzgl.setFirst(first);
                }
                if(jo.getString("last")!=null) {
                    Integer last = Integer.valueOf(jo.getString("last"));
                    kzgl.setLast(last);
                }
                kzgl.setId(id);


                kzgl.setUserid(userid);
                kzgl.setQyid(areaid);

                kzglDao.update(kzgl);
            }


        }catch (Exception e){
            System.err.println("json转换错误");
        }
    }
}
