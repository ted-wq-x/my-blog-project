package com.wq.website.service.impl;

import com.github.pagehelper.PageHelper;
import com.wq.website.dao.AttachVoMapper;
import com.wq.website.dao.CommentVoMapper;
import com.wq.website.dao.ContentVoMapper;
import com.wq.website.dao.MetaVoMapper;
import com.wq.website.dto.Types;
import com.wq.website.modal.Bo.ArchiveBo;
import com.wq.website.modal.Bo.StatisticsBo;
import com.wq.website.modal.Vo.*;
import com.wq.website.service.ISiteService;
import com.wq.website.utils.DateKit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by BlueT on 2017/3/7.
 */
@Service
public class SiteServiceImpl implements ISiteService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SiteServiceImpl.class);

    @Resource
    private CommentVoMapper commentDao;

    @Resource
    private ContentVoMapper contentDao;

    @Resource
    private AttachVoMapper attachDao;

    @Resource
    private MetaVoMapper metaDao;

    @Override
    public List<CommentVo> recentComments(int limit) {
        LOGGER.debug("Enter recentComments method:limit={}", limit);
        if (limit < 0 || limit > 10) {
            limit = 10;
        }
        CommentVoExample example = new CommentVoExample();
        example.setOrderByClause("created desc");
        PageHelper.startPage(1, limit);
        List<CommentVo> byPage = commentDao.selectByExample(example);
        LOGGER.debug("Exit recentComments method");
        return byPage;
    }

    @Override
    public List<ContentVo> recentContents(int limit) {
        LOGGER.debug("Enter recentContents method");
        if (limit < 0 || limit > 10) {
            limit = 10;
        }
        ContentVoExample example = new ContentVoExample();
        example.createCriteria().andStatusEqualTo(Types.PUBLISH.getType()).andTypeEqualTo(Types.ARTICLE.getType());
        example.setOrderByClause("created");
        PageHelper.startPage(1, limit);
        List<ContentVo> list = contentDao.selectByExample(example);
        LOGGER.debug("Exit recentContents method");
        return list;
    }

    @Override
    public CommentVo getComment(Integer coid) {
        if (null != coid) {
            return commentDao.selectByPrimaryKey(coid);
        }
        return null;
    }

    @Override
    public StatisticsBo getStatistics() {
        return null;
    }

    @Override
    public List<ArchiveBo> getArchives() {
//        List<ArchiveBo> archives = contentDao.findReturnArchiveBo();
//
//        ContentVo contentVo = new ContentVo();
//        contentVo.setType(Types.ARTICLE.getType());
//        contentVo.setStatus(Types.PUBLISH.getType());
//
//        if (null != archives) {
//            archives.forEach(archive -> {
//                String date = archive.getDate();
//                Date sd = DateKit.dateFormat(date, "yyyy年MM月");
//                int start = DateKit.getUnixTimeByDate(sd);
//                int end = DateKit.getUnixTimeByDate(DateKit.dateAdd(DateKit.INTERVAL_MONTH, sd, 1)) - 1;
//
////                List<ContentVo> contentss = contentDao.findContents(,"created desc")
////                        .eq("type", Types.ARTICLE)
////                        .eq("status", Types.PUBLISH)
////                        .gt("created", start).lt("created", end).orderby("created desc"));
////                archive.setArticles(contentss);
//            });
//        }
//        return archives;
        return null;
    }

    @Override
    public List<MetaVo> metas(String type, String orderBy, int limit) {
        return null;
    }
}
