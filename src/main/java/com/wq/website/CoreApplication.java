package com.wq.website;

import com.wq.website.interceptor.BaseInterceptor;
import com.wq.website.utils.TaleUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.Resource;

@MapperScan("com.wq.website.dao")
@SpringBootApplication
@EnableTransactionManagement
public class CoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoreApplication.class, args);
    }


    /**
     * 向mvc中添加自定义组件
     * Created by BlueT on 2017/3/9.
     */
    @Component
    static class WebMvcConfig extends WebMvcConfigurerAdapter {
        @Resource
        private BaseInterceptor baseInterceptor;

        @Override
        public void addInterceptors(InterceptorRegistry registry) {
            registry.addInterceptor(baseInterceptor);
        }

        /**
         * 添加静态资源文件，外部可以直接访问地址
         *
         * @param registry
         */
        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            registry.addResourceHandler("/upload/**").addResourceLocations("file:" + TaleUtils.getUplodFilePath() + "upload/");
            super.addResourceHandlers(registry);
        }
    }


}
