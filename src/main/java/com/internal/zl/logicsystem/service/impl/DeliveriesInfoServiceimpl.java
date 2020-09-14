package com.internal.zl.logicsystem.service.impl;

import cn.hutool.core.lang.UUID;
import com.internal.zl.logicsystem.en.dto.DeliveriesDto;
import com.internal.zl.logicsystem.en.entity.DeliveriesInfo;
import com.internal.zl.logicsystem.en.entity.DeliveriesItem;
import com.internal.zl.logicsystem.en.vo.DeliveriesInfoVo;
import com.internal.zl.logicsystem.mapper.DeliveriesInfoMapper;
import com.internal.zl.logicsystem.mapper.DeliveriesItemMapper;
import com.internal.zl.logicsystem.service.DeliveriesInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: lxf
 * @create: 2020-09-13 13:50
 * @description:
 */
@Service
@Transactional
public class DeliveriesInfoServiceimpl implements DeliveriesInfoService {
    @Autowired
    DeliveriesInfoMapper deliveriesInfoMapper;

    @Autowired
    DeliveriesItemMapper deliveriesItemMapper;

    @Autowired
    private DeliveriesInfoApi  deliveriesInfoApi;

    @Override
    public String save(DeliveriesInfoVo deliveriesInfoVo) {
        String doNo="DO"+ UUID.randomUUID().toString();
        DeliveriesInfo deliveriesInfo =new DeliveriesInfo();
        BeanUtils.copyProperties(deliveriesInfoVo,deliveriesInfo);
        deliveriesInfo.setDoNo(doNo);
        List<DeliveriesItem> deliveriesItems=deliveriesInfoVo.getItems().stream()
                .map(e->{
                    DeliveriesItem deliveriesItem =new DeliveriesItem();
                    BeanUtils.copyProperties(e,deliveriesInfo);
                    deliveriesItem.setDoNo(doNo);
                    return deliveriesItem;
                }).collect(Collectors.toList());
        deliveriesInfoMapper.insert(deliveriesInfo);
        deliveriesItemMapper.batchInsert(deliveriesItems);
        return  doNo;
    }

    @Override
    public void confirmOrderDeliveries(DeliveriesInfoVo deliveriesInfoVo) {
        deliveriesInfoApi.addDeliveries(Arrays.asList(deliveriesInfoVo));
        if(true){
            DeliveriesInfo deliveriesInfo =new DeliveriesInfo();
            BeanUtils.copyProperties(deliveriesInfoVo,deliveriesInfo);
            deliveriesInfo.setStatus(1);
            deliveriesInfoMapper.updateByPrimaryKeySelective(deliveriesInfo);
        }
    }

    @Override
    public DeliveriesDto viewDeliveries(String date, String doNo) {
        return  deliveriesInfoApi.viewDeliveries(date,doNo);
    }

    @Override
    public List<DeliveriesDto> viewAllDeliveries(String date) {
        return  deliveriesInfoApi.viewDeliveries(date);
    }

}
