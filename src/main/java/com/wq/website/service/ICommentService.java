package com.wq.website.service;

import com.github.pagehelper.PageInfo;
import com.wq.website.modal.Vo.CommentVo;

/**
 * Created by BlueT on 2017/3/16.
 */
public interface ICommentService {

    /**
     * 保存对象
     * @param commentVo
     */
    void insertComment(CommentVo commentVo);

    /**
     * 获取文章下的评论
     * @param cid
     * @param page
     * @param limit
     * @return
     */
    PageInfo<CommentVo> getComments(Integer cid, int page, int limit);
}
