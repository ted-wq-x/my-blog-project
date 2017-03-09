package com.wq.website;

import com.wq.website.exception.TipException;
import com.wq.website.modal.Vo.UserVo;
import com.wq.website.service.IOptionService;
import com.wq.website.service.IUserService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by Administrator on 2017/3/3 003.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@EnableTransactionManagement
@MapperScan("com.wq.website.dao")
public class JDBCTest {
    @Autowired
    private IUserService userService;

    @Autowired
    private IOptionService optionService;

    @Test
    @Ignore
    public void testConnect() {
        UserVo user = new UserVo();
        user.setUsername("wangqiang");
        user.setPassword("123456");
        int i = userService.insertUser(user);

        optionService.insertOption("ssss", "qwqwq");
        throw new TipException();
    }
}
