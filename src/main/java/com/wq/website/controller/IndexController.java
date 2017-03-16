package com.wq.website.controller;

import com.github.pagehelper.PageInfo;
import com.wq.website.constant.WebConst;
import com.wq.website.dto.Types;
import com.wq.website.modal.Vo.ContentVo;
import com.wq.website.service.IContentService;
import com.wq.website.utils.Commons;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 首页
 * Created by Administrator on 2017/3/8 008.
 */
@Controller
public class IndexController extends BaseController{
    private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

    @Resource
    private IContentService contentService;

    /**
     * 首页
     *
     * @return
     */
    @GetMapping(value = "/")
    public String index(HttpServletRequest request, @RequestParam(value = "limit", defaultValue = "12") int limit) {
        return this.index(request, 1, limit);
    }

    /**
     * 首页分页
     *
     * @param request request
     * @param p 第几页
     * @param limit 每页大小
     * @return 主页
     */
    @GetMapping(value = "page/{p}")
    public String index(HttpServletRequest request, @PathVariable int p, @RequestParam(value = "limit", defaultValue = "12") int limit) {
        p = p < 0 || p > WebConst.MAX_PAGE ? 1 : p;
        PageInfo<ContentVo> articles = contentService.getContents(p, limit);
        request.setAttribute("articles", articles);
        if (p > 1) {
            this.title(request, "第" + p + "页");
        }
        return this.render("index");
    }

    /**
     * 文章页
     * @param request 请求
     * @param cid  文章主键
     * @return
     */
    @GetMapping(value = {"article/{cid}", "article/{cid}.html"})
    public String post(HttpServletRequest request, @PathVariable  String cid) {
        ContentVo contents = contentService.getContents(cid);
        if (null == contents) {
            return this.render_404();
        }
        request.setAttribute("article", contents);
        request.setAttribute("is_post", true);
        if (contents.getAllowComment()) {
            String cp = request.getParameter("cp");
            if (StringUtils.isBlank(cp)) {
                cp = "1";
            }
            request.setAttribute("cp", cp);
        }
        updateArticleHit(contents.getCid(), contents.getHits());
        return this.render("post");
    }

    /**
     * 更新文章的点击率
     * @param cid
     * @param chits
     */
    private void updateArticleHit(Integer cid, Integer chits) {
        Integer hits = cache.hget("article", "hits");
        hits = null == hits ? 1 : hits + 1;
        if (hits >= WebConst.HIT_EXCEED) {
            ContentVo temp = new ContentVo();
            temp.setCid(cid);
            temp.setHits(chits + hits);
            contentService.updateContentByCid(temp);
            cache.hset("article", "hits", 1);
        } else {
            cache.hset("article", "hits", hits);
        }
    }

}
