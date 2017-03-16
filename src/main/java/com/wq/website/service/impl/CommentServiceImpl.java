package com.wq.website.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wq.website.dao.CommentVoMapper;
import com.wq.website.dao.ContentVoMapper;
import com.wq.website.dto.Comment;
import com.wq.website.exception.TipException;
import com.wq.website.modal.Vo.CommentVo;
import com.wq.website.modal.Vo.CommentVoExample;
import com.wq.website.modal.Vo.ContentVo;
import com.wq.website.service.ICommentService;
import com.wq.website.utils.DateKit;
import com.wq.website.utils.TaleUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by BlueT on 2017/3/16.
 */
@Service
public class CommentServiceImpl implements ICommentService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CommentServiceImpl.class);

    @Resource
    private CommentVoMapper commentDao;

    @Resource
    private ContentVoMapper contentDao;

    @Override
    public void insertComment(CommentVo comments) {
        if (null == comments) {
            throw new TipException("评论对象为空");
        }
        if (StringUtils.isBlank(comments.getAuthor())) {
            throw new TipException("姓名不能为空");
        }
        if (StringUtils.isBlank(comments.getMail())) {
            throw new TipException("邮箱不能为空");
        }
        if (!TaleUtils.isEmail(comments.getMail())) {
            throw new TipException("请输入正确的邮箱格式");
        }
        if (StringUtils.isBlank(comments.getContent())) {
            throw new TipException("评论内容不能为空");
        }
        if(comments.getContent().length() < 5 || comments.getContent().length() > 2000){
            throw new TipException("评论字数在5-2000个字符");
        }
        if (null == comments.getCid()) {
            throw new TipException("评论文章不能为空");
        }
        ContentVo contents =contentDao.selectByPrimaryKey(comments.getCid());
        if (null == contents) {
            throw new TipException("不存在的文章");
        }
        comments.setOwnerId(contents.getAuthorId());
        comments.setCreated(DateKit.getCurrentUnixTime());
        commentDao.insert(comments);

        ContentVo temp = new ContentVo();
        temp.setCid(contents.getCid());
        temp.setCommentsNum(contents.getCommentsNum() + 1);
        contentDao.updateByPrimaryKeySelective(temp);
    }

//    TODO
    @Override
    public PageInfo<CommentVo> getComments(Integer cid, int page, int limit) {
//
//        if (null != cid) {
//            PageHelper.offsetPage((page - 1), limit);
//            CommentVoExample commentVoExample = new CommentVoExample();
//            commentVoExample.createCriteria().andCidEqualTo(cid).andParentEqualTo(0);
//            commentVoExample.setOrderByClause("coid desc");
//            List<CommentVo> parents = commentDao.selectByExampleWithBLOBs(commentVoExample);
//            PageInfo<CommentVo> commentPaginator = new PageInfo<>(parents);
//            if (parents.size()!=0) {
//                List<Comment> comments = new ArrayList<>(parents.size());
//                parents.forEach(parent -> {
//                    Comment comment = new Comment(parent);
//                    List<CommentVo> children = new ArrayList<>();
//                    getChildren(children, comment.getCoid());
//                    comment.setChildren(children);
//                    if (children.size() > 0) {
//                        comment.setLevels(1);
//                    }
//                    comments.add(comment);
//                });
//                PageInfo<Comment> temp = commentPaginator;
//                commentPaginator.setList(Comment);
//            }
//            return commentPaginator;
//        }
        return null;
    }

    /**
     * 获取该评论下的追加评论
     * @param list
     * @param coid
     */
    private void getChildren(List<CommentVo> list, Integer coid) {
        CommentVoExample commentVoExample = new CommentVoExample();
        commentVoExample.setOrderByClause("coid asc");
        commentVoExample.createCriteria().andParentEqualTo(coid);
        List<CommentVo> cms = commentDao.selectByExampleWithBLOBs(commentVoExample);
        if (null != cms) {
            list.addAll(cms);
            cms.forEach(c -> getChildren(list, c.getCoid()));
        }
    }
}
