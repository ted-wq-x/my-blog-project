package com.wq.website.utils;

import com.wq.website.exception.TipException;
import org.apache.commons.lang3.StringUtils;
import org.commonmark.parser.Parser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Date;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Tale工具类
 * <p>
 * Created by biezhi on 2017/2/21.
 */
public class TaleUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(TaleUtils.class);

    private static DataSource newDataSource;
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
    public static boolean isEmail(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }

    /**
     * 获取当前时间
     *
     * @return
     */
    public static int getCurrentTime() {
        return (int) (new Date().getTime() / 1000);
    }

    /**
     * jdbc:mysql://127.0.0.1:3306/tale?useUnicode=true&characterEncoding=utf-8&useSSL=false 保存jdbc数据到文件中
     *
     * @param url      数据库连接地址 127.0.0.1:3306
     * @param dbName   数据库名称
     * @param userName 用户
     * @param password 密码
     */
    public static void updateJDBCFile(String url, String dbName, String userName, String password) {
        LOGGER.info("Enter updateJDBCFile method");
        Properties props = new Properties();
        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream( "application-jdbc.properties");
            props.setProperty("spring.datasource.url",url);
            props.setProperty("spring.datasource.dbname",dbName);
            props.setProperty("spring.datasource.username", userName);
            props.setProperty("spring.datasource.password", password);
            props.setProperty("spring.datasource.driver-class-name", "com.mysql.jdbc.Driver");
            props.store(fos, "update jdbc info.");
        } catch (IOException e) {
            LOGGER.error("updateJDBCFile method fail:{}", e.getMessage());
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        LOGGER.info("Exit updateJDBCFile method");
    }

    /**
     * 获取properties配置数据,
     *
     * @param fileName 文件名 如 application-jdbc.properties来自jar中
     * @return
     */
    public static Properties getPropFromJar(String fileName) {
        Properties properties = new Properties();
        try {
//            默认是classPath路径
            InputStream resourceAsStream = TaleUtils.class.getClassLoader().getResourceAsStream(fileName);
            if(resourceAsStream==null){
                throw new TipException("get resource from path fail");
            }
            properties.load(resourceAsStream);
        } catch (TipException | IOException e) {
            LOGGER.error("get properties file fail={}",e.getMessage());
        }
        return properties;
    }

    /**
     *
     * @param fileName 获取jar外部的文件
     * @return 返回属性
     */
    private static Properties getPropFromFile(String fileName) {
        Properties properties = new Properties();
        try {
//            默认是classPath路径
            InputStream resourceAsStream = new FileInputStream(fileName);
            properties.load(resourceAsStream);
        } catch (TipException | IOException e) {
            LOGGER.error("get properties file fail={}",e.getMessage());
        }
        return properties;
    }

    /**
     * md5加密
     * @param source 数据源
     * @return 加密字符串
     */
    public static String MD5encode(String source){
        if(StringUtils.isBlank(source)){
            return null;
        }
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException ignored) {
        }
        byte[] encode =messageDigest.digest(source.getBytes());
        StringBuilder hexString = new StringBuilder();
        for (byte anEncode : encode) {
            String hex = Integer.toHexString(0xff & anEncode);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    /**
     * 获取新的数据源
     * @return
     */
    public static DataSource getNewDataSource(){
        if(newDataSource==null) synchronized (TaleUtils.class) {
            if (newDataSource == null) {
                Properties properties = TaleUtils.getPropFromFile("application-jdbc.properties");
                DriverManagerDataSource managerDataSource = new DriverManagerDataSource();
                //        TODO 对不同数据库支持
                managerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
                managerDataSource.setPassword(properties.getProperty("spring.datasource.password"));
                String str = "jdbc:mysql://" + properties.getProperty("spring.datasource.url") + "/" + properties.getProperty("spring.datasource.dbname") + "?useUnicode=true&characterEncoding=utf-8&useSSL=false";
                managerDataSource.setUrl(str);
                managerDataSource.setUsername(properties.getProperty("spring.datasource.username"));
                newDataSource = managerDataSource;
            }
        }
        return newDataSource;
    }

}
