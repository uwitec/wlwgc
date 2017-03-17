package com.dao.service;

import com.dao.base.data.Page;
import com.dao.domain.vo.User;
import com.dao.domain.dto.Login;


/**
 * Created by zxdong on 2017/1/9.
 */
public interface IUserService {
//    登陆
    Login isLogin(Login login);
    Integer findUserByUsername(User user);
    void insertUser(User user);
    Page<User> findByPage(Page<User> users);
    User findUserById(User user);
}
