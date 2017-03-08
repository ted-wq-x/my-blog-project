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

    public static Boolean INSTALL = false;

}
