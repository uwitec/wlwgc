package com.dao.serviceimp;

import com.dao.base.data.Page;
import com.dao.domain.vo.Area;
import com.dao.mapper.AreaDao;
import com.dao.service.IAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zxdong on 2017/1/27.
 */
@Service
public class AreaService implements IAreaService {

    @Autowired
    private AreaDao areaDao;

    public Page<Area> findByPage(Page<Area> areas) {
        areas.setRows(areaDao.findByPage(areas));
        areas.setTotal(areaDao.getTotal(areas));

        return areas;
    }
}
