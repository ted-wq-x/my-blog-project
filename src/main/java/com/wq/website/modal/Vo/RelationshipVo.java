package com.wq.website.modal.Vo;


/**
 * Created by BlueT on 2017/3/2.
 */
public class RelationshipVo {

    // 内容主键
    private Integer cid;

    // 项目主键
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

    @Override
    public String toString() {
        return "RelationshipVo{" +
                "cid=" + cid +
                ", mid=" + mid +
                '}';
    }
}