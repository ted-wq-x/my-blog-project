package com.wq.website.controller.admin;

import com.wq.website.modal.Bo.StatisticsBo;
import com.wq.website.modal.Vo.CommentVo;
import com.wq.website.modal.Vo.ContentVo;
import com.wq.website.modal.Vo.LogVo;
import com.wq.website.service.ILogService;
import com.wq.website.service.ISiteService;
import com.wq.website.utils.Commons;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 后台管理首页
 * Created by Administrator on 2017/3/9 009.
 */
@Controller("adminIndexController")
@RequestMapping("/admin")
public class IndexController {
    private static final Logger LOGGER = LoggerFactory.getLogger(com.wq.website.controller.admin.IndexController.class);

    @Resource
    private ISiteService siteService;

    @Resource
    private ILogService logService;

    /**
     * 页面跳转
     * @return
     */
    @GetMapping(value = {"","/index"})
    public String index(HttpServletRequest request){
        LOGGER.info("Enter admin index method");
        List<CommentVo> comments = siteService.recentComments(5);
        List<ContentVo> contents = siteService.recentContents(5);
        StatisticsBo statistics = siteService.getStatistics();
        // 取最新的20条日志
        List<LogVo> logs = logService.getLogs(1, 5);

        request.setAttribute("comments", comments);
        request.setAttribute("articles", contents);
        request.setAttribute("statistics", statistics);
        request.setAttribute("logs", logs);
        LOGGER.info("Exit admin index method");
        return "admin/index";
    }
}
