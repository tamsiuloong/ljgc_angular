package com.tosit.ssh.service;

import com.tosit.ssh.utils.page.Pagination;

/**
 * 佛祖保佑       永无BUG
 * Created by DELL on 2016/11/10.
 */
public interface ChannelService {
    /**
     * 分页查询
     * @param keyWord 关键字（标题,描述）
     * @param pageNo
     *@param pageSize @return  分页对象
     */
    Pagination queryForPage(String keyWord, Integer pageNo, Integer pageSize);

    Boolean delete(Integer id);
}
