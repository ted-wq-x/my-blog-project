package com.wq.website;

import com.wq.website.dao.CommentVoMapper;
import com.wq.website.exception.TipException;
import com.wq.website.modal.Vo.CommentVo;
import com.wq.website.modal.Vo.UserVo;
import com.wq.website.service.IOptionService;
import com.wq.website.service.ISiteService;
import com.wq.website.service.IUserService;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;

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

    @Autowired
    private CommentVoMapper commentMapper;

    @Autowired
    private ISiteService siteService;

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

    @Ignore
    @Test
    public void testPage(){
//        int pageSize = 8;
//        PageHelper.startPage(1, pageSize);
//        List<CommentVo> byPage = commentMapper.findByPage();
//        Assert.assertEquals(byPage.size(),pageSize);
    }

    @Test
    @Ignore
    public void testPageService(){
        int limit = 3;
        List<CommentVo> commentVos = siteService.recentComments(limit);
        Assert.assertEquals(commentVos.size(),limit);
    }

}
