package com.example.mall.common;

public class StringCommon {

    /**
     * 判断字符串是否为空
     * @param mes
     * @return
     */
    public static boolean isNotEmpty(String mes){
        return !(mes == null || "".equals(mes));
    }
}
