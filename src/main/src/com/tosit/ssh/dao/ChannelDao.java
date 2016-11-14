package com.tosit.ssh.dao;

import com.tosit.ssh.entity.Channel;
import com.tosit.ssh.utils.page.Pagination;

/**
 * 佛祖保佑       永无BUG
 * Created by DELL on 2016/11/10.
 */
public interface ChannelDao {
    Pagination queryForPage(String keyWord, Integer pageNo, Integer pageSize);

    Boolean delete(Integer id);

    Channel merge(Channel channel);
}
