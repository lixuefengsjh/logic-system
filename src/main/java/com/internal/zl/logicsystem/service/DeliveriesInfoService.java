package com.internal.zl.logicsystem.service;

import com.internal.zl.logicsystem.en.dto.AddDeliveriesDto;
import com.internal.zl.logicsystem.en.dto.DeliveriesDto;
import com.internal.zl.logicsystem.en.vo.DeliveriesInfoVo;
import com.internal.zl.logicsystem.en.vo.ViewDeliveriesVo;

import java.util.List;

/**
 * @author: lxf
 * @create: 2020-09-13 13:49
 * @description: 包裹订单相关
 */
public interface DeliveriesInfoService {
    String  save(DeliveriesInfoVo deliveriesInfoVo);

    AddDeliveriesDto confirmOrderDeliveries(DeliveriesInfoVo deliveriesInfoVo);

    DeliveriesDto viewDeliveries(ViewDeliveriesVo viewDeliveriesVo);

    List<DeliveriesDto> viewAllDeliveries(ViewDeliveriesVo viewDeliveriesVo);
}
