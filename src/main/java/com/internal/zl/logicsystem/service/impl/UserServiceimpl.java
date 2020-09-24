package com.internal.zl.logicsystem.service.impl;

import com.internal.zl.logicsystem.base.SystemException;
import com.internal.zl.logicsystem.base.SystemResponse;
import com.internal.zl.logicsystem.en.dto.UserDto;
import com.internal.zl.logicsystem.en.entity.User;
import com.internal.zl.logicsystem.en.vo.UserVo;
import com.internal.zl.logicsystem.mapper.UserMapper;
import com.internal.zl.logicsystem.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author: lxf
 * @create: 2020-09-11 12:55
 * @description: 用户管理实现
 */
@Service
public class UserServiceimpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public void insert(UserVo user) {
        userMapper.insertSelective(copyProperties(user));
    }

    @Override
    public void update(UserVo user) {
        userMapper.updateByPrimaryKeySelective(copyProperties(user));
    }

    @Override
    public List<UserDto> queryAll() {
        List<User> lists=userMapper.selectAll();
        List<UserDto>  result=new ArrayList<>();
        if(null==lists){return result;}
        result= lists.stream().map(e->{
            UserDto userDto=new UserDto();
            BeanUtils.copyProperties(e,userDto);
            return userDto;
        }).collect(Collectors.toList());
        return result;
    }

    @Override
    public UserDto findUserByNameAndPassword(String name, String password) {
       User user= userMapper.findUserByNameAndPassword(name,password);
        UserDto dto =new UserDto();
        BeanUtils.copyProperties(user,dto);
        return dto;
    }

    private  User copyProperties( UserVo user){
        User userInfo=new User();
        BeanUtils.copyProperties(user,userInfo);
        return  userInfo;
    }
}
