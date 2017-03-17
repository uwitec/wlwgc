package com.dao.web.inc;

import com.dao.base.data.SendMsg;
import com.dao.base.data.IWebController;
import com.dao.domain.dto.Login;
import com.dao.domain.vo.User;
import com.dao.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by dzx on 2016/10/31.
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    IUserService userService;

    @RequestMapping("/enter")
    public void Enter(Login login, HttpServletRequest request, HttpServletResponse response){
        String verCode=(String)request.getSession().getAttribute("verCode");
        System.err.println("数据："+login+";验证码："+verCode);

        if(verCode.equals(login.getYzm().toLowerCase())){

            Login currentUser=userService.isLogin(login);
            login=currentUser;



            if(currentUser!=null){
                request.getSession().setAttribute("currentUser",currentUser);
                login.setFlag(1);
            }else{
                login=new Login();
                login.setFlag(3);
            }

        }else{
            login.setFlag(2);
        }
        SendMsg<Login> send=new SendMsg<Login>();
        send.setFlag(200);
        send.setMsg("Message is ok!");
        send.setT(login);
        IWebController.toWebUTF(response,send);
    }

    @RequestMapping("/usernameIsNew")
    @ResponseBody
    public boolean usernameIsNew(User user) {
        if (userService.findUserByUsername(user) == 0) {
            return true;
        }
        return false;
    }

    @RequestMapping("/exit")
    public String exit(HttpServletRequest request){
        request.getSession().removeAttribute("currentUser");

        return "login";
    }
}
