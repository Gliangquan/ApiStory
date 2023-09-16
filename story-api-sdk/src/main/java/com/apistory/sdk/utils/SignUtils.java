package com.apistory.sdk.utils;

import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;

/**
 * 签名工具
 */
public class SignUtils {

    /**
     * 生成签名
     */
    public static String genSign(String body, String secretKey) {
        Digester md5 = new Digester(DigestAlgorithm.SHA1);
        String content = body + "." + secretKey;
        return md5.digestHex(content);
    }

    public static final String name = "权";
    public static final String secretKey = "key";

    public static void main(String[] args) {
        System.out.println("genSign(name, secretKey) = " + genSign(name, secretKey));
    }
}
