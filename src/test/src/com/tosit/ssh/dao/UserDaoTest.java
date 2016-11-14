package com.tosit.ssh.dao;

import com.tosit.ssh.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * 佛祖保佑       永无BUG
 * Created by DELL on 2016/11/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration("/spring.xml")
public class UserDaoTest {

    @Autowired
    private UserDao userDao;
    @Test
    public void testQueryForPage(){
        User _user = new User();
        _user.setUsername("刘德华");
        _user.setPassword("123");

        User user = userDao.findUserByParas(_user);

        Assert.assertNotNull(user);
        Assert.assertEquals("刘德华",user.getUsername());
    }
}
