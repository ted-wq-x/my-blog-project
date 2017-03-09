package com.wq.website.dao;

import com.wq.website.modal.Vo.UserVo;
import org.springframework.stereotype.Repository;

/**
 * 数据库操作users表方法
 * Created by BlueT on 2017/3/2.
 */
@Repository
public interface UserMapper
{
    int insertUserVo(UserVo user);
    
    UserVo findByName(String name);

    UserVo findByUid(Integer uid);
    
}
