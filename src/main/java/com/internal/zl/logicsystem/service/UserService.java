package com.internal.zl.logicsystem.service;

import com.internal.zl.logicsystem.en.dto.UserDto;
import com.internal.zl.logicsystem.en.vo.UserVo;

import java.util.List;
import java.util.Optional;

/**
 * @author: lxf
 * @create: 2020-09-11 12:54
 * @description: 用户管理
 */
public interface UserService {
    void insert(UserVo user);

    void update(UserVo user);

    List<UserDto> queryAll();
}
