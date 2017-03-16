package com.wq.website.service;

import com.github.pagehelper.PageInfo;
import com.wq.website.modal.Vo.ContentVo;

import java.util.List;

/**
 * Created by Administrator on 2017/3/13 013.
 */
public interface IContentService {

    /**
     * 保存文章
     * @param contentVo
     */
    void insertContent(ContentVo contentVo);

    /**
     *查询文章返回多条数据
     * @param p 当前页
     * @param limit 每页条数
     * @return
     */
    PageInfo<ContentVo> getContents(Integer p, Integer limit);


    /**
     * 根据id或slug获取文章
     *
     * @param id
     * @return
     */
    ContentVo getContents(String id);

    /**
     * 根据主键更新
     * @param contentVo
     */
    void updateContentByCid(ContentVo contentVo);
}
