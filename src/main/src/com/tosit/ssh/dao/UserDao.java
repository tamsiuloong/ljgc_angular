package com.tosit.ssh.dao;

import com.tosit.ssh.entity.User;

/**
 * 佛祖保佑       永无BUG
 * Created by DELL on 2016/11/10.
 */
public interface UserDao {
    /**
     * 根据参数查找用户对象
     * @param user
     * @return
     */
    User findUserByParas(User user);
}
