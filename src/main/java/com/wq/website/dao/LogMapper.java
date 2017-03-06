package com.wq.website.dao;

import com.wq.website.modal.Vo.LogVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by BlueT on 2017/3/4.
 */
@Repository
public interface LogMapper {

    /**
     * 记录日志
     * @param logVo
     */
    void insertLog(LogVo logVo);

    /**
     * TODO 分页查询
     * 读取日志
     * @param page
     * @param limit
     * @return
     */
    List<LogVo> getLogs(int page, int limit);
}
