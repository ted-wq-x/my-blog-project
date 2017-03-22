package com.wq.website.modal.Vo;

import java.io.Serializable;

/**
 * @author
 */
public class RelationshipVoKey implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 内容主键
     */
    private Integer cid;
    /**
     * 项目主键
     */
    private Integer mid;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }
}