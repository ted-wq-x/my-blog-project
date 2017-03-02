package com.wq.website.dao;

import com.wq.website.modal.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;

/**
 * Created by BlueT on 2017/3/2.
 */
@MapperScan("com.wq.website.dao")
public interface UserMapper {

    @Select("select * from")
    User findByName(@Param("name") String name);


}
