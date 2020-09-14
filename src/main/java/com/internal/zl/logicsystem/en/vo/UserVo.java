package com.internal.zl.logicsystem.en.vo;

import io.swagger.models.auth.In;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author: lxf
 * @create: 2020-09-10 17:14
 * @description: 用户信息vo
 */
@Data
public class UserVo {

    private Integer id;

    @NotNull(message = "用户账号不能为空")
    @Size(min = 2, max = 11, message = "账号长度必须是6-11个字符")
    private String name;

    @NotNull(message = "用户密码不能为空")
    @Size(min = 6, max = 11, message = "密码长度必须是6-16个字符")
    private String password;

    private String phone;

    private String address;
}
