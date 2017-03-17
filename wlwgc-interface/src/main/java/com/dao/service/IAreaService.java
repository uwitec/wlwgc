package com.dao.service;

import com.dao.base.data.Page;
import com.dao.domain.vo.Area;
import com.dao.mapper.AreaDao;

/**
 * Created by zxdong on 2017/1/27.
 */
public interface IAreaService {
    Page<Area> findByPage(Page<Area> areas);
}
