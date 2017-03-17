package com.dao.web.comm;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import com.dao.base.data.IWebController;
import com.dao.base.data.SendMsg;
import com.dao.domain.dto.KZGL;
import com.dao.domain.dto.Login;
import com.dao.service.IKZGLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zxdong on 2017/2/6.
 */

@Controller
@RequestMapping("/kzgl")
public class KZGLController {

    @Autowired
    private IKZGLService ikzglService;

    @RequestMapping("/find")
    public void findAllKZ(HttpServletResponse response){
        SendMsg<List> send=new SendMsg<List>();
        send.setFlag(200);
        send.setMsg("Message is ok!");
        send.setT(ikzglService.findAll());
        IWebController.toWebUTF(response,send);
    }

    @RequestMapping("/update")
    @ResponseBody
    public void update(String kzgls,HttpServletRequest request){
      ikzglService.updateKzgl(kzgls,request);

    }


}
