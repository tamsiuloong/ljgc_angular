package com.tosit.ssh.dao;

import com.tosit.ssh.utils.page.Pagination;
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
public class ChannelDaoTest {
    @Autowired
    private ChannelDao dao;
    @Test
    public void testFindUserByParas(){

        Pagination pagination = dao.queryForPage(null,1,10);
        Assert.assertNotNull(pagination);
        Assert.assertEquals(2,pagination.getList().size());

    }
}
