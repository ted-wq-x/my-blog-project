package com.wq.website.dto;

import com.wq.website.modal.Vo.CommentVo;

import java.util.List;

/**
 * Created by biezhi on 2017/2/24.
 */
public class Comment extends CommentVo {

    private int levels;
    private List<CommentVo> children;

    public Comment(CommentVo comments) {
        setAuthor(comments.getAuthor());
        setMail(comments.getMail());
        setCoid(comments.getCoid());
        setAuthorId(comments.getAuthorId());
        setUrl(comments.getUrl());
        setCreated(comments.getCreated());
        setAgent(comments.getAgent());
        setIp(comments.getIp());
        setContent(comments.getContent());
        setOwnerId(comments.getOwnerId());
        setCid(comments.getCid());
    }

    public int getLevels() {
        return levels;
    }

    public void setLevels(int levels) {
        this.levels = levels;
    }

    public List<CommentVo> getChildren() {
        return children;
    }

    public void setChildren(List<CommentVo> children) {
        this.children = children;
    }
}
