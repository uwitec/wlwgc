package com.dao.web.inc;

import com.dao.util.yzm.GetImg;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by dzx on 2016/10/30.
 */


@Controller
@RequestMapping("/util")
public class UtilController {



    @RequestMapping("/getYzm")
        public void getYzm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        GetImg.getImg(request,response);


        }

}
