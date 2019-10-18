package com.person.master.utils;

import org.apache.commons.codec.digest.DigestUtils;
import sun.misc.BASE64Encoder;

/**
 * 密码加密
 */
public class PaasWdUtils {
    /**
     * 加盐扰乱MD5 哈希
     */
    private static final String SALT = "XYLX1.t";

    /**
     * 密码加密  md5 + base64
     * @param paaswd
     * @return
     */
    public static String encode(String paaswd) {

        return new BASE64Encoder().encode(DigestUtils.md5(SALT + paaswd + SALT));
    }

}
