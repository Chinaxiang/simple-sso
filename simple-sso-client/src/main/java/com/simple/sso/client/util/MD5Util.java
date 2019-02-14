package com.simple.sso.client.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * 
 * @author yanxiang.huang 2019-02-14 10:06:52
 */
public class MD5Util {
    /**
     * MD5加密字符串
     * 
     * @param src
     * @return
     */
    public static String encode(String src) {
        return DigestUtils.md5Hex(src);
    }
}