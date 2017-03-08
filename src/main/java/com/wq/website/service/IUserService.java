package com.wq.website.service;

import com.wq.website.modal.Vo.UserVo;

/**
 * Created by BlueT on 2017/3/3.
 */
public interface IUserService {

    /**
     * 保存用户数据
     *
     * @param userVo 用户数据
     * @return 主键
     */

    Integer insertUser(UserVo userVo);
}
