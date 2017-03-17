package com.dao.web.comm;

import com.dao.base.data.IWebController;
import com.dao.base.data.Page;
import com.dao.base.data.SendMsg;
import com.dao.domain.dto.Login;
import com.dao.domain.vo.User;
import com.dao.service.IUserService;
import com.dao.util.page.FYBean;
import com.dao.util.page.FYUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zxdong on 2017/1/27.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/register")
    public ModelAndView register(Model model,Integer zczh, User user, HttpServletRequest request, HttpServletResponse response) {
        userService.insertUser(user);
        if(zczh==1){
            return new ModelAndView("redirect:/page/login");
        }else{
            Login currentUser=new Login();
            currentUser.setUsername(user.getUsername());
            currentUser.setPassword(user.getPassword());
                    userService.isLogin(currentUser);
            request.getSession().setAttribute("currentUser",currentUser);
            return new ModelAndView("redirect:/page/home");
        }
    }

    @RequestMapping("/findUserByPage")
    public void findUserByPage(String keyval,Page<User> users, HttpServletResponse response){
        users.setStartEnd(users.getPagesize(), users.getPagenum());
        if(keyval==null){
            keyval="";
        }
        FYBean fyBean = new FYBean();
        //添加表
        List<String> tableNames = new ArrayList<String>();
        tableNames.add("TB_User");
        fyBean.setTableNames(tableNames);

        //添加条件

        String conditions = " tb1.username like'%"+keyval+"%' order by tb1.id";

        fyBean.setConditions(conditions);
        fyBean.setStart(users.getPagestart());

        //放入起始页
        fyBean.setEnd(users.getPageend());
        users.setDatasql(FYUtil.getPageSql(fyBean));
        users.setTotalsql(FYUtil.getTotalSql(fyBean));
        users = userService.findByPage(users);


        users.setDatasql("保密");
        users.setTotalsql("保密");

        SendMsg<Page> send=new SendMsg<Page>();
        send.setFlag(200);
        send.setMsg("Message is ok!");
        send.setT(users);
        IWebController.toWebUTF(response,send);
    }

    @RequestMapping("/findUserById")
    public void findUserById(User user,HttpServletResponse response){
        SendMsg<User> send=new SendMsg<User>();
        send.setFlag(200);
        send.setMsg("Message is ok!");
        send.setT(userService.findUserById(user));
        IWebController.toWebUTF(response,send);
    }


}
