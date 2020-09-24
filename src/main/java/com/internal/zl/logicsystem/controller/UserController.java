package com.internal.zl.logicsystem.controller;

import com.internal.zl.logicsystem.base.SystemResponse;
import com.internal.zl.logicsystem.en.dto.UserDto;
import com.internal.zl.logicsystem.en.vo.UserVo;
import com.internal.zl.logicsystem.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * @author: lxf
 * @create: 2020-09-10 17:23
 * @description: 用户相关接口
 */
@RestController
@RequestMapping("/user")
@Api(tags = "用户管理相关接口")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping
    @ApiOperation("用户注册接口")
    public SystemResponse<String> register(@RequestBody @Valid UserVo user){
        userService.insert(user);
        return SystemResponse.ok("Registered successfully");
    }

    @PostMapping("/update")
    @ApiOperation("用户修改接口")
    public SystemResponse<String> updateUserInfo(@RequestBody @Valid UserVo user){
        userService.update(user);
        return SystemResponse.ok("update userInfo success");
    }

    @GetMapping
    @ApiOperation("用户查询接口")
    public SystemResponse<List<UserDto>> queryAll(){
        List<UserDto> results=userService.queryAll();
        if(results.size()==0){
            return  SystemResponse.failed(" datas not query");
        }else {
            return  SystemResponse.ok(results);
        }
    };
    @PostMapping("/login")
    @ApiOperation("用户查询接口")
    public SystemResponse<String> login(@RequestBody @Valid UserVo user){
        UserDto dto=userService.findUserByNameAndPassword(user.getName(),user.getPassword());
        if(null==dto){
            return SystemResponse.failed("user is not exist");
        }else {
            return SystemResponse.ok("login success");
        }

    }
}
