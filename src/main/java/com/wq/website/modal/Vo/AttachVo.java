package com.wq.website.modal.Vo;


/**
 * 日志记录对象
 * Created by BlueT on 2017/3/2.
 */
public class AttachVo {

    private Integer id;
    private String fname;
    private String ftype;
    private String fkey;
    private Integer author_id;
    private Integer created;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getFtype() {
        return ftype;
    }

    public void setFtype(String ftype) {
        this.ftype = ftype;
    }

    public String getFkey() {
        return fkey;
    }

    public void setFkey(String fkey) {
        this.fkey = fkey;
    }

    public Integer getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(Integer author_id) {
        this.author_id = author_id;
    }

    public Integer getCreated() {
        return created;
    }

    public void setCreated(Integer created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "AttachVo{" +
                "id=" + id +
                ", fname='" + fname + '\'' +
                ", ftype='" + ftype + '\'' +
                ", fkey='" + fkey + '\'' +
                ", author_id=" + author_id +
                ", created=" + created +
                '}';
    }
}
