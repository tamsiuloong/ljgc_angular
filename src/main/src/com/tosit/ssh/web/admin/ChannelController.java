package com.tosit.ssh.web.admin;

import com.tosit.ssh.service.ChannelService;
import com.tosit.ssh.utils.page.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 佛祖保佑       永无BUG
 * Created by DELL on 2016/11/10.
 */
@Controller
//@RequestMapping("/channel")
public class ChannelController {
    @Autowired
    private ChannelService channelService;
    @RequestMapping(value="/channel",method = RequestMethod.GET)
    public @ResponseBody Pagination list(Integer pageNo, Integer pageSize, String keyWord, ModelMap map){
        if(pageNo==null){
            pageNo=1;
        }
        if(pageSize==null){
            pageSize=10;
        }
        Pagination pagination =channelService.queryForPage(keyWord,pageNo ,pageSize);

        return pagination;
    }


    @RequestMapping(value="/channel/{id}",method=RequestMethod.DELETE)
    public @ResponseBody Boolean delete(@PathVariable Integer id){
        Boolean result = false;

        result = channelService.delete(id);
        return result;
    }
}
