package com.tosit.ssh.service;


import com.tosit.ssh.entity.User;
import org.springframework.stereotype.Service;

/**
 * 佛祖保佑       永无BUG
 * Created by DELL on 2016/10/27.
 */
public interface UserService {

    /**
     * 登陆信息是否正确
     * @param user
     * @return
     */
    public boolean isOk(User user);
}
