package com.wq.website.controller.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 后台管理首页
 * Created by Administrator on 2017/3/9 009.
 */
@Controller
@RequestMapping("/admin")
public class IndexController {
    private static final Logger LOGGER = LoggerFactory.getLogger(com.wq.website.controller.admin.IndexController.class);

    /**
     * 页面跳转
     * @return
     */
    @RequestMapping(value = {"","/index"})
    public String index(){
        return "admin/index";
    }
}
