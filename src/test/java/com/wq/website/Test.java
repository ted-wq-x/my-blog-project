package com.wq.website;

/**
 * Created by Administrator on 2017/3/6 006.
 */

import com.wq.website.dto.Types;
import com.wq.website.utils.TaleUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * Created by Administrator on 2017/3/6 006.
 */
public class Test {
    public static void main(String[] args) throws NoSuchAlgorithmException {
//        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
//        byte[] encode = messageDigest.digest("admin123456".getBytes());
//        StringBuffer hexString = new StringBuffer();
//        for (int i = 0; i < encode.length; i++) {
//            String hex = Integer.toHexString(0xff & encode[i]);
//
//            if (hex.length() == 1) {
//                hexString.append('0');
//            }
//
//            hexString.append(hex);
//        }
//
//        System.out.println(hexString.toString());
//        System.out.println(TaleUtils.MD5encode("admin123456"));
        String str = "Oriented+Design+Principles";
        System.out.println(str.replaceAll("\\+", " "));
    }

    public static void test() throws IOException {
        Properties properties = new Properties();
        InputStream resourceAsStream = Test.class.getClassLoader().getResourceAsStream("application-jdbc.properties");
        properties.load( resourceAsStream);
        System.out.println(properties.getProperty("spring.datasource.url"));
    }
}
