package com.internal.zl.logicsystem.en.entity;
import lombok.Data;

/**
 * @author: lxf
 * @create: 2020-09-10 17:11
 * @description: 用户信息
 */
@Data
public class User {

    private Integer id;

    private String name;

    private String password;

    private String address;

    private String phone;
}
