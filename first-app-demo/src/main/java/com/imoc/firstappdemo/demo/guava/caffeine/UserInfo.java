package com.imoc.firstappdemo.demo.guava.caffeine;

import lombok.Data;
import lombok.ToString;

/**
 * @author jianghua
 * @date 2021/01/30
 */
@Data
@ToString
public class UserInfo {
    private String id;
    private String name;

    public UserInfo(String id) {
        this.id = id;
    }

    public UserInfo() {
    }

}
