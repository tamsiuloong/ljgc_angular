package com.tosit.ssh.service.impl;


import com.tosit.ssh.dao.UserDao;
import com.tosit.ssh.entity.User;
import com.tosit.ssh.service.BaseService;
import com.tosit.ssh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 佛祖保佑       永无BUG
 * Created by DELL on 2016/10/27.
 */
@Service
public class UserServiceImpl extends BaseService<User> implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public void add(User user) {
        baseDao.add(user);
    }

    public boolean isOk(User _user) {
        boolean result = false;
        User user = userDao.findUserByParas(_user);
        if(user!=null){
            result = true;
        }
        return result;
    }
}
