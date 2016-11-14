package com.tosit.ssh.dao.impl;

import com.tosit.ssh.dao.ChannelDao;
import com.tosit.ssh.entity.Channel;
import com.tosit.ssh.utils.page.Pagination;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 佛祖保佑       永无BUG
 * Created by DELL on 2016/11/10.
 */
@Repository
public class ChannelDaoImpl implements ChannelDao {

    @Autowired
    private SessionFactory sessionFactory;
    public Pagination queryForPage(String keyWord, Integer pageNo, Integer pageSize) {
        Session session = sessionFactory.getCurrentSession();

        //获取总记录条数
        Long totalCount = (Long) (session.createQuery("select count(c.id) from Channel c").getSingleResult());
        Pagination result = new Pagination(pageNo,pageSize,totalCount.intValue());

        //获取分页列表数据
         keyWord = keyWord==null?"%":keyWord;
        List list = sessionFactory.getCurrentSession().createQuery("from Channel c where c.name like :n or c.description like :d order by c.id desc")
        .setParameter("n","%"+keyWord+"%")
        .setParameter("d","%"+keyWord+"%")
                .setFirstResult(result.getFirstResult())
                .setMaxResults(result.getPageSize())
        .list();
        result.setList(list);
        return result;
    }

    public Boolean delete(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(session.get(Channel.class,id));
        return true;
    }

    public Channel merge(Channel channel) {
        sessionFactory.getCurrentSession().merge(channel);
        return channel;
    }


}
