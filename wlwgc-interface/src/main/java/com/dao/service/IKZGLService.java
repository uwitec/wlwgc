package com.dao.service;

import com.dao.domain.dto.KZGL;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by zxdong on 2017/2/6.
 */
public interface IKZGLService {
    List<KZGL> findAll();
    void updateKzgl(String kzgls,HttpServletRequest request);
}
