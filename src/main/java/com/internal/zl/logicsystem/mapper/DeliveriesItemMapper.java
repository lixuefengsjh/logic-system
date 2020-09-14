package com.internal.zl.logicsystem.mapper;

import com.internal.zl.logicsystem.en.entity.DeliveriesItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeliveriesItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DeliveriesItem record);

    int insertSelective(DeliveriesItem record);

    DeliveriesItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DeliveriesItem record);

    int updateByPrimaryKey(DeliveriesItem record);

    void batchInsert(@Param("items")List<DeliveriesItem> deliveriesItems);
}