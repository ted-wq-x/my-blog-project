package com.wq.website.service.impl;

import com.wq.website.modal.Bo.ArchiveBo;
import com.wq.website.modal.Bo.StatisticsBo;
import com.wq.website.modal.Vo.CommentVo;
import com.wq.website.modal.Vo.ContentVo;
import com.wq.website.modal.Vo.MetaVo;
import com.wq.website.service.ISiteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by biezhi on 2017/2/23.
 */
@Service
public class SiteServiceImpl implements ISiteService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SiteServiceImpl.class);


    @Override
    public List<CommentVo> recentComments(int limit) {
        return null;
    }

    @Override
    public List<ContentVo> recentContents(int limit) {
        return null;
    }

    @Override
    public CommentVo getComment(Integer coid) {
        return null;
    }

    @Override
    public StatisticsBo getStatistics() {
        return null;
    }

    @Override
    public List<ArchiveBo> getArchives() {
        return null;
    }

    @Override
    public List<MetaVo> metas(String type, String orderBy, int limit) {
        return null;
    }
}
