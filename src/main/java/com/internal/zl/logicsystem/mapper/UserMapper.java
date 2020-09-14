package com.internal.zl.logicsystem.mapper;

import com.internal.zl.logicsystem.en.entity.User;
import java.util.List;
import java.util.Optional;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    Optional<User> selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

   List<User> selectAll();
}