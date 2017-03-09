package com.wq.website.constant;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by BlueT on 2017/3/3.
 */
@Component
public class WebConst {
    /**
     * 存储安装信息的配置文件名称
     */
    public static final String INSTALL_FILE_CONF = "install.lock";

    public static Map<String, String> initConfig = new HashMap<>();

    /**
     * 是否进行过安装
     */
    public static Boolean INSTALL = false;

    public static String LOGIN_SESSION_KEY = "login_user";

    public static final String USER_IN_COOKIE = "S_L_ID";

    /**
     * aes加密加盐
     */
    public static String AES_SALT = "0123456789abcdef";

    /**
     * 最大获取文章条数
     */
    public static final int MAX_POSTS = 9999;
}
