package com.wq.website;

import com.wq.website.dao.UserMapper;
import com.wq.website.modal.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Administrator on 2017/3/3 003.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.wq.website.dao")
public class JDBCTest
{
    @Autowired
    private UserMapper userDao;

    @Test
    public void testConnect()
    {
        User user = new User();
        user.setUsername("wangqiang");
        user.setPassword("123456");
        int i = userDao.insertUserVo(user);
        System.out.println(i+"\n");
        User byName = userDao.findByName(user.getUsername());
        Assert.assertEquals(byName.getPassword(),user.getPassword());

    }
}
