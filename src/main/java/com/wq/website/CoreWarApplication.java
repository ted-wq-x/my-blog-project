package com.wq.website;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * 测试war部署的方式,还需要将pom.xml中改为war
 * Created by wangq on 2017/4/18.
 */
public class CoreWarApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(CoreApplication.class);
    }
}
