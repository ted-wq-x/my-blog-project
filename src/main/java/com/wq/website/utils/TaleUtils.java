package com.wq.website.utils;

import org.commonmark.parser.Parser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Tale工具类
 * <p>
 * Created by biezhi on 2017/2/21.
 */
public class TaleUtils
{
    private static final Logger LOGGER = LoggerFactory.getLogger(TaleUtils.class);
    
    /**
     * 一个月
     */
    private static final int one_month = 30 * 24 * 60 * 60;
    /**
     * 匹配邮箱正则
     */
    private static final Pattern VALID_EMAIL_ADDRESS_REGEX =
        Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    private static final Pattern SLUG_REGEX = Pattern.compile("^[A-Za-z0-9_-]{5,100}$", Pattern.CASE_INSENSITIVE);
    /**
     * markdown解析器
     */
    private static Parser parser = Parser.builder().build();
    /**
     * 获取文件所在目录
     */
    private static String location = TaleUtils.class.getClassLoader().getResource("").getPath();
    
    /**
     * 判断是否是邮箱
     *
     * @param emailStr
     * @return
     */
    public static boolean isEmail(String emailStr)
    {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }
    
    /**
     * 获取当前时间
     * 
     * @return
     */
    public static int getCurrentTime()
    {
        return (int)(new Date().getTime() / 1000);
    }
    
    /**
     * jdbc:mysql://127.0.0.1:3306/tale?useUnicode=true&characterEncoding=utf-8&useSSL=false 保存jdbc数据到文件中
     * 
     * @param url 数据库连接地址 127.0.0.1:3306
     * @param dbName 数据库名称
     * @param userName 用户
     * @param password 密码
     */
    public static void updateJDBCFile(String url, String dbName,String userName, String password)
    {
        Properties props = new Properties();
        FileOutputStream fos = null;
        
        try
        {
            fos = new FileOutputStream(location + "application-jdbc.properties");
            props.setProperty("spring.datasource.url",
                "jdbc:mysql://" + url +"/"+dbName+ "?useUnicode=true&characterEncoding=utf-8&useSSL=false");
            props.setProperty("spring.datasource.username", userName);
            props.setProperty("spring.datasource.password", password);
            props.setProperty("spring.datasource.driver-class-name", "com.mysql.jdbc.Driver");
            props.store(fos, "update jdbc info.");
        }
        catch (IOException e)
        {
            LOGGER.error("updateJDBCFile method fail:{}",e.getMessage());
            e.printStackTrace();
        }
        finally
        {
            if (fos != null)
            {
                try
                {
                    fos.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 获取properties配置数据
     * @param fileName 文件名 如 application-jdbc.properties
     * @return
     */
    public static Properties getPropFromFile(String fileName){
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(location+fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

}
