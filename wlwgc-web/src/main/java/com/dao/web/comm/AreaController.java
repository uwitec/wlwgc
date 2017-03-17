package com.dao.web.comm;

import com.dao.base.data.IWebController;
import com.dao.base.data.Page;
import com.dao.base.data.SendMsg;
import com.dao.domain.vo.Area;
import com.dao.service.IAreaService;
import com.dao.util.page.FYBean;
import com.dao.util.page.FYUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zxdong on 2017/1/27.
 */

@Controller
@RequestMapping("/area")
public class AreaController {

    @Autowired
    private IAreaService areaService;

    @RequestMapping("/findAreaByPage")
    public void getArea(String keyval, Page<Area> areas, HttpServletResponse response){
        areas.setStartEnd(areas.getPagesize(), areas.getPagenum());

        if(keyval==null){
            keyval="";
        }
        FYBean fyBean = new FYBean();
        //添加表
        List<String> tableNames = new ArrayList<String>();
        tableNames.add("TB_AREA");
        fyBean.setTableNames(tableNames);

        //添加条件
        String conditions = " 1=1 order by tb1.id";
        fyBean.setConditions(conditions);
        fyBean.setStart(areas.getPagestart());

        //放入起始页
        fyBean.setEnd(areas.getPageend());
        areas.setDatasql(FYUtil.getPageSql(fyBean));
        areas.setTotalsql(FYUtil.getTotalSql(fyBean));
        areas = areaService.findByPage(areas);


        areas.setDatasql("保密");
        areas.setTotalsql("保密");

        SendMsg<Page> send=new SendMsg<Page>();
        send.setFlag(200);
        send.setMsg("Message is ok!");
        send.setT(areas);
        IWebController.toWebUTF(response,send);

    }
}
