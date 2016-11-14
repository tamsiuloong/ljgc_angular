package com.tosit.ssh.service;


import com.tosit.ssh.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 佛祖保佑       永无BUG
 * Created by DELL on 2016/10/27.
 */
public class BaseService<M> {

    @Autowired
    protected BaseDao<M> baseDao;

    public void add(M m){

        baseDao.add(m);
    }

}
