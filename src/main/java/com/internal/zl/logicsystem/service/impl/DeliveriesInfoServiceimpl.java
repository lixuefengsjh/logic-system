package com.internal.zl.logicsystem.service.impl;

import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.StrUtil;
import com.internal.zl.logicsystem.en.dto.AddDeliveriesDto;
import com.internal.zl.logicsystem.en.dto.DeliveriesDto;
import com.internal.zl.logicsystem.en.dto.ViewAllDeliveriesResultDto;
import com.internal.zl.logicsystem.en.dto.ViewDeliveriesDto;
import com.internal.zl.logicsystem.en.entity.DeliveriesInfo;
import com.internal.zl.logicsystem.en.entity.DeliveriesItem;
import com.internal.zl.logicsystem.en.vo.DeliveriesInfoVo;
import com.internal.zl.logicsystem.en.vo.ViewDeliveriesVo;
import com.internal.zl.logicsystem.mapper.DeliveriesInfoMapper;
import com.internal.zl.logicsystem.mapper.DeliveriesItemMapper;
import com.internal.zl.logicsystem.service.DeliveriesInfoClient;
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
    private DeliveriesInfoClient deliveriesInfoClient;

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
    public AddDeliveriesDto confirmOrderDeliveries(DeliveriesInfoVo deliveriesInfoVo) {
        AddDeliveriesDto addDeliveriesDto=deliveriesInfoClient.addDeliveriesInfo(Arrays.asList(deliveriesInfoVo));
        String status=addDeliveriesDto.getInfo().getStatus();
        int filed=addDeliveriesDto.getInfo().getFailed();
        if(StrUtil.equals("ok",status,true)&&filed==0){
            DeliveriesInfo deliveriesInfo =new DeliveriesInfo();
            BeanUtils.copyProperties(deliveriesInfoVo,deliveriesInfo);
            deliveriesInfo.setStatus(1);
            deliveriesInfoMapper.updateByPrimaryKeySelective(deliveriesInfo);
        }
        return addDeliveriesDto;
    }

    @Override
    public DeliveriesDto viewDeliveries(ViewDeliveriesVo viewDeliveriesVo) {
        ViewDeliveriesDto viewDeliveriesDto=  deliveriesInfoClient.viewDeliveries(Arrays.asList(viewDeliveriesVo));
        if(StrUtil.equals("ok",viewDeliveriesDto.getInfo().getStatus(),true)){
            return  viewDeliveriesDto.getResults().get(0).getDelivery();
        };
        return  null;
    }

    @Override
    public List<DeliveriesDto> viewAllDeliveries(ViewDeliveriesVo viewDeliveriesVo) {
        ViewAllDeliveriesResultDto viewAllDeliveriesResultDto=    deliveriesInfoClient.viewAllDeliveries(viewDeliveriesVo);
        if(StrUtil.equals("ok",viewAllDeliveriesResultDto.getInfo().getStatus(),true)){
            return viewAllDeliveriesResultDto.getDeliveries();
        }
        return null;
    }

}
