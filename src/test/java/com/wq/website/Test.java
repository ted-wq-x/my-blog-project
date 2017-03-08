package com.wq.website;

/**
 * Created by Administrator on 2017/3/6 006.
 */

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Administrator on 2017/3/6 006.
 */
public class Test {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        byte[] encode = messageDigest.digest("admin123456".getBytes());
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < encode.length; i++) {
            String hex = Integer.toHexString(0xff & encode[i]);

            if (hex.length() == 1) {
                hexString.append('0');
            }

            hexString.append(hex);
        }

        System.out.println(hexString.toString());
    }
}
