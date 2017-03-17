package com.dao.web.inc;

import com.dao.util.web.PageKeyToWeb;
import com.dao.util.web.PageUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by dzx on 2016/11/1.
 */
@Controller
@RequestMapping("/page")
public class PageController {


    @RequestMapping("/login")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/register")
    public String toRegister(){
        return "register";
    }

    @RequestMapping("/islogin")
    public String IsLogin(HttpServletRequest request, Model model){
        String login=(String)request.getSession().getAttribute("login");
        if(login!=null){return toIndex(model);}else{
            return toLogin();
        }
    }

    /**
     * 主页
     * @param model
     * @return
     */

     @RequestMapping("/home")
    public String toIndex(Model model){
        return toPage(model, PageUtils.HOME);
    }

    /**
     * 用户管理
     * @param model
     * @return
     */

    @RequestMapping("/yhgl")
    public String toYhgl(Model model){
        return toPage(model, PageUtils.YHGL);
    }

    /**
     * 实时监测
     * @param model
     * @return
     */
    @RequestMapping("/ssjc")
    public String toSsjc(Model model){
        return toPage(model, PageUtils.SSJC);
    }


    /**
     * 阈值设置
     * @param model
     * @return
     */
    @RequestMapping("/kzsz")
    public String toKzsz(Model model){
        return toPage(model, PageUtils.KZSZ);
    }

    /**
     * 添加区域
     * @param model
     * @return
     */
    @RequestMapping("/qygl")
    public String toQygl(Model model){
        return toPage(model, PageUtils.QYGL);
    }


    /**
     * 中继器管理
     * @param model
     * @return
     */
    @RequestMapping("/zjqgl")
    public String toZjqgl(Model model){
        return toPage(model, PageUtils.ZJQGL);
    }


    /**
     * 终端管理
     * @param model
     * @return
     */
    @RequestMapping("/zdgl")
    public String toZdgl(Model model){
        return toPage(model, PageUtils.ZDGL);
    }

    /**
     * 设备管理
     * @param model
     * @return
     */
    @RequestMapping("/sbgl")
    public String toSbgl(Model model){
        return toPage(model, PageUtils.SBGL);
    }
    /**
     * 个人中心
     * @param model
     * @return
     */
    @RequestMapping("/usercenter")
    public String toUsercenter(Model model){
        return toPage(model, PageUtils.USERCENTER);
    }



    /**
     * 跳转到页面
     *
     * @param model
     * @param page
     * @return
     */
    public String toPage(Model model, Integer page) {
        model.addAttribute("page", page);
        model.addAttribute("pageutils", new PageKeyToWeb());

        return "index";
    }

}
