package com.wq.website.service;

import com.wq.website.modal.Vo.LogVo;

/**
 * Created by BlueT on 2017/3/4.
 */
public interface ILogService {

    /**
     * 保存操作日志
     *
     * @param logVo
     */
    void insertLog(LogVo logVo);
}
