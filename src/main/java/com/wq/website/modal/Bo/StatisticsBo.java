package com.wq.website.modal.Bo;

import java.io.Serializable;

/**
 * 后台统计对象
 */
public class StatisticsBo implements Serializable {

    private int articles;
    private int comments;
    private int links;
    private int attachs;

    public int getArticles() {
        return articles;
    }

    public void setArticles(int articles) {
        this.articles = articles;
    }

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public int getLinks() {
        return links;
    }

    public void setLinks(int links) {
        this.links = links;
    }

    public int getAttachs() {
        return attachs;
    }

    public void setAttachs(int attachs) {
        this.attachs = attachs;
    }

    @Override
    public String toString() {
        return "StatisticsBo{" +
                "articles=" + articles +
                ", comments=" + comments +
                ", links=" + links +
                ", attachs=" + attachs +
                '}';
    }
}
