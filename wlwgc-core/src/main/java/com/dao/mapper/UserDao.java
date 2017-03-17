package com.dao.mapper;

import com.dao.base.domain.EntityDao;
import com.dao.domain.dto.Login;
import com.dao.domain.vo.User;
import org.springframework.stereotype.Repository;

/**
 * Created by zxdong on 2017/1/9.
 */
@Repository
public interface UserDao extends EntityDao<User>{
//    登陆
    Login isLogin(Login login);

    //注册查询是否用户名已经被占用
    Integer findUserByUsername(User user);

}
