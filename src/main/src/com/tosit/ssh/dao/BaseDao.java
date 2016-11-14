package com.tosit.ssh.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 佛祖保佑       永无BUG
 * Created by DELL on 2016/10/27.
 */

public abstract class BaseDao<M> {
    @Autowired
    private SessionFactory sessionFactory ;

    public void add(M m) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(m);
        System.out.println("add()");
    }

    public void update(M m) {
        System.out.println("update()");
    }

    public void delete(M m) {
        System.out.println("delete()");
    }

    public void find() {
        System.out.println("find()");
    }
}
