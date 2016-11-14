package com.tosit.ssh.service.impl;

import com.tosit.ssh.dao.ChannelDao;
import com.tosit.ssh.service.ChannelService;
import com.tosit.ssh.utils.page.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 佛祖保佑       永无BUG
 * Created by DELL on 2016/11/10.
 */
@Service
public class ChannelServiceImpl implements ChannelService{
    @Autowired
    private ChannelDao channelDao;
    public Pagination queryForPage(String keyWord, Integer pageNo, Integer pageSize) {
        return channelDao.queryForPage(keyWord, pageNo, pageSize);
    }

    public Boolean delete(Integer id) {
        return channelDao.delete(id);
    }


}
