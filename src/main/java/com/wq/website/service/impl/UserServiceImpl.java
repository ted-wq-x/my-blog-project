package com.wq.website.service.impl;

import com.wq.website.dao.UserMapper;
import com.wq.website.modal.Vo.UserVo;
import com.wq.website.service.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by BlueT on 2017/3/3.
 */
@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private UserMapper userDao;

    @Override
    public Integer insertUser(UserVo userVo) {
        Integer uid=null;
        if (StringUtils.isNotBlank(userVo.getUsername()) && StringUtils.isNoneBlank(userVo.getEmail())) {
//            用户密码加密
            String encodePwd = MD5Encoder.encode((userVo.getUsername() + userVo.getPassword()).getBytes());
            userVo.setPassword(encodePwd);
            uid= userDao.insertUserVo(userVo);
        }
        return uid;
    }
}
