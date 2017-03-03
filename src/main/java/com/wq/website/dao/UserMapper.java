package com.wq.website.dao;

import com.wq.website.modal.User;
import org.springframework.stereotype.Repository;

/**
 * Created by BlueT on 2017/3/2.
 */

@Repository
public interface UserMapper
{
    int insertUserVo(User user);
    
    User findByName(String name);
    
}
