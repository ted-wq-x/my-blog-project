package com.wq.website.service;

import com.wq.website.dto.MetaDto;

/**
 * 分类信息service接口
 * Created by BlueT on 2017/3/17.
 */
public interface IMetaService {
    /**
     * 根据类型和名字查询项
     *
     * @param type
     * @param name
     * @return
     */
    MetaDto getMeta(String type, String name);

    Integer countMeta(Integer mid);
}
