package com.internal.zl.logicsystem.en.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: lxf
 * @create: 2020-09-13 11:40
 * @description: 用户信息展示
 */
@Data
@ApiModel(value="user对象",description="用户对象user")
public class UserDto implements Serializable {

    @ApiModelProperty(value="用户id",name="id",example="xingguo")
    private Integer id;

    @ApiModelProperty(value="用户名",name="name",example="xingguo")
    private String name;

    @ApiModelProperty(value="用户密码",name="password",example="xingguo")
    private String password;

    @ApiModelProperty(value="用户地址",name="address",example="address or address ")
    private String address;

    @ApiModelProperty(value="用户电话",name="phone",example="1222334")
    private String phone;
}
