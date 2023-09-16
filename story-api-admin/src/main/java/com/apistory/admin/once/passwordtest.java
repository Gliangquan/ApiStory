package com.apistory.admin.once;

import org.springframework.util.DigestUtils;

public class passwordtest {

    private static final String SALT = "story";

    public static void main(String[] args) {
        String userPassword = "030201";

        String s1 = DigestUtils.md5DigestAsHex((SALT + userPassword).getBytes());
        String s2 = DigestUtils.md5DigestAsHex((SALT + userPassword).getBytes());
        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);
    }
}
