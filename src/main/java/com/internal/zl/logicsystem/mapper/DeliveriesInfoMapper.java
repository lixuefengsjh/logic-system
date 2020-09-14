package com.internal.zl.logicsystem.mapper;

import com.internal.zl.logicsystem.en.entity.DeliveriesInfo;

public interface DeliveriesInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DeliveriesInfo record);

    int insertSelective(DeliveriesInfo record);

    DeliveriesInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DeliveriesInfo record);

    int updateByPrimaryKey(DeliveriesInfo record);
}