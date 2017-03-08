package com.wq.website.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * 实现动态数据库
 * Created by Administrator on 2017/3/8 008.
 */
@Component
public class CustomerRoutingDataSource extends AbstractRoutingDataSource
{
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerRoutingDataSource.class);

    @Autowired
    private ApplicationContext applicationContext;
    
    @Override
    protected Object determineCurrentLookupKey()
    {
        return null;
    }
    
    @Override
    public void afterPropertiesSet()
    {
        DataSource dataSource = applicationContext.getBean(DataSource.class);
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(null, dataSource);
        setTargetDataSources(targetDataSources);
        super.afterPropertiesSet();
    }

    /**
     * 动态修改数据源
     * @return
     */
    @Override
    protected DataSource determineTargetDataSource() {
//        TaleUtils.
        DriverManagerDataSource managerDataSource = new DriverManagerDataSource("jdbc:mysql://45.76.205.80:3306/tale?useUnicode=true&characterEncoding=utf-8&useSSL=false","root","taylor1989");
        managerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        return managerDataSource;
    }
}
