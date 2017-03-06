package com.wq.website.listener;

import com.wq.website.constant.WebConst;
import com.wq.website.dao.OptionMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 初始化监听器
 * Created by BlueT on 2017/3/3.
 */
public class initListener implements ApplicationListener<ApplicationReadyEvent> {
    private static final Logger LOGGER = LoggerFactory.getLogger(initListener.class);

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        LOGGER.debug("Enter method:init listener");
        ConfigurableApplicationContext applicationContext = applicationReadyEvent.getApplicationContext();
        OptionMapper optionDao = applicationContext.getBean(OptionMapper.class);

        // 初始化加载数据库配置
        optionDao.getOptions().forEach((option)->{
            WebConst.initConfig.put(option.getName(), option.getValue());
        });
        LOGGER.debug("Exit method:init listener");
    }
}
