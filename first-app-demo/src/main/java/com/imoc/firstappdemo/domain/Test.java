package com.imoc.firstappdemo.domain;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jianghua
 * @date 2020/12/30
 */
public class Test {

    public static void main(String [] args) {
//        Map<String, String> cache = new HashMap<>();
        System.out.println("-->" + System.currentTimeMillis());

        Date date = new Date(1611645017000L);
        System.out.println("-->:" + date);
    }


}
