package com.wq.website;

import com.google.gson.Gson;
import com.wq.website.modal.Vo.UserVo;

/**
 * Created by Administrator on 2017/3/13 013.
 */
public class GsonTest {
    public static void main(String[] args) {
        UserVo userVo = new UserVo();
        userVo.setPassword("123");
        userVo.setEmail("773622@qq.com");
        userVo.setUsername("wangqaing");

        Gson gson = new Gson();
        System.out.println(gson.toJson(userVo));
    }
}
