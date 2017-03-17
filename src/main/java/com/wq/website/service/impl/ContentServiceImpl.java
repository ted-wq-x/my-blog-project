package com.wq.website.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wq.website.dao.ContentVoMapper;
import com.wq.website.dao.MetaVoMapper;
import com.wq.website.dto.Types;
import com.wq.website.exception.TipException;
import com.wq.website.modal.Vo.ContentVo;
import com.wq.website.modal.Vo.ContentVoExample;
import com.wq.website.service.IContentService;
import com.wq.website.utils.TaleUtils;
import com.wq.website.utils.Tools;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/3/13 013.
 */
@Service
public class ContentServiceImpl implements IContentService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ContentServiceImpl.class);

    @Resource
    private ContentVoMapper contentDao;

    @Resource
    private MetaVoMapper metaDao;


    @Override
    public void insertContent(ContentVo contentVo) {

    }

    @Override
    public PageInfo<ContentVo> getContents(Integer p,Integer limit) {
        LOGGER.debug("Enter getContents method");
        ContentVoExample example = new ContentVoExample();
        example.setOrderByClause("created desc");
        example.createCriteria().andTypeEqualTo(Types.ARTICLE.getType()).andStatusEqualTo(Types.PUBLISH.getType());
        PageHelper.offsetPage((p - 1), limit);
        List<ContentVo> data = contentDao.selectByExampleWithBLOBs(example);
        PageInfo<ContentVo> pageInfo = new PageInfo<>(data);
        LOGGER.debug("Exit getContents method");
        return pageInfo;
    }

    @Override
    public ContentVo getContents(String id) {
        if (StringUtils.isNotBlank(id)) {
            if (Tools.isNumber(id)) {
                return contentDao.selectByPrimaryKey(Integer.valueOf(id));
            } else {
                ContentVoExample contentVoExample = new ContentVoExample();
                contentVoExample.createCriteria().andSlugEqualTo(id);
                List<ContentVo> contentVos = contentDao.selectByExampleWithBLOBs(contentVoExample);
                if (contentVos.size() != 1) {
                    throw new TipException("query content by id and return is not one");
                }
                return contentVos.get(0);
            }
        }
        return null;
    }

    @Override
    public void updateContentByCid(ContentVo contentVo) {
        if (null != contentVo && null != contentVo.getCid()) {
            contentDao.updateByPrimaryKeySelective(contentVo);
        }
    }

    @Override
    public PageInfo<ContentVo> getArticles(Integer mid, int page, int limit) {
        int total = metaDao.countWithSql(mid);
        PageHelper.startPage(page, limit);
        List<ContentVo> list = contentDao.findByCatalog(mid);
        PageInfo<ContentVo> paginator = new PageInfo<>(list);
        paginator.setTotal(total);
        return paginator;
    }
}
