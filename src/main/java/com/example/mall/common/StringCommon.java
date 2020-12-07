package com.example.mall.common;

public class StringCommon {

    /**
     * 判断字符串是否为空，不为空返回true,为空返回false
     * @param mes
     * @return
     */
    public static boolean isNotEmpty(String mes){
        return !(mes == null || "".equals(mes));
    }
}
