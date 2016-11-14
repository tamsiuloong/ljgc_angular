package com.tosit.ssh.dao.impl;


import com.tosit.ssh.dao.BaseDao;
import com.tosit.ssh.dao.UserDao;
import com.tosit.ssh.entity.User;
import org.apache.commons.logging.Log;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 佛祖保佑       永无BUG
 * Created by DELL on 2016/10/28.
 */
@Repository
public class UserDaoImpl extends BaseDao<User> implements UserDao {
    @Autowired
    private SessionFactory sessionFactory;

    private final static Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    public User findUserByParas(User user) {
        User result = null;
        //拿到service层已经打开过的session
        Session session = sessionFactory.getCurrentSession();
        try {
           result = (User) session.createQuery("from User u where u.username=:u and u.password=:p")
                    .setParameter("u", user.getUsername())
                    .setParameter("p", user.getPassword())
                    .getSingleResult();
        } catch (Exception e) {
            logger.error("当前用户名，密码存在多条数据,或者没有数据!", e.getCause());
        }


        return result;
    }
}
