package com.dao.serviceimp;

import com.dao.base.data.Page;
import com.dao.domain.dto.Login;
import com.dao.domain.vo.User;
import com.dao.mapper.UserDao;
import com.dao.service.IUserService;
import com.dao.util.comm.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.util.comm.IDCreateUtil;

import java.util.Date;

/**
 * Created by zxdong on 2017/1/25.
 */
@Service
public class UserService implements IUserService {

    @Autowired
    UserDao userDao;

    public Login isLogin(Login login) {
        return userDao.isLogin(login);
    }

    public Integer findUserByUsername(User user){
        return userDao.findUserByUsername(user);
    }

    public void insertUser(User user) {
        user.setId(IDCreateUtil.getID());
        user.setUsertype(2);
        user.setCreatetime(DateUtils.doFormatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
        user.setUpdatetime(DateUtils.doFormatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
        userDao.insert(user);
    }
    public Page<User> findByPage(Page<User> users) {
        users.setRows(userDao.findByPage(users));
        users.setTotal(userDao.getTotal(users));

        return users;
    }
   public User findUserById(User user){
       return userDao.findById(user);
   }
}
