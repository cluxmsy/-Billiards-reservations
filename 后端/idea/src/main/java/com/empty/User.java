package com.empty;

import lombok.Data;

/**
 * 用户实体类
 */

@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private String sex;
    private String introduction;
    private Integer ball_age;
    private Integer phone;
    private double balance;
    private Integer role_id;

}


