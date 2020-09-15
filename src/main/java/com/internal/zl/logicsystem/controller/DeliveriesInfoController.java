package com.internal.zl.logicsystem.controller;

import cn.hutool.core.util.StrUtil;
import com.internal.zl.logicsystem.base.SystemResponse;
import com.internal.zl.logicsystem.en.dto.AddDeliveriesDto;
import com.internal.zl.logicsystem.en.dto.DeliveriesDto;
import com.internal.zl.logicsystem.en.vo.DeliveriesInfoVo;
import com.internal.zl.logicsystem.en.vo.ViewDeliveriesVo;
import com.internal.zl.logicsystem.service.DeliveriesInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: lxf
 * @create: 2020-09-13 12:28
 * @description: 包裹订单相关信息
 */
@RestController
@RequestMapping("/deliveries")
@Api(tags = "包裹订单相关信息相关接口")
public class DeliveriesInfoController {
    @Autowired
    private DeliveriesInfoService deliveriesInfoServiceImpl;

    @PostMapping
    @ApiOperation("在线下订单接口")
    public SystemResponse<String> orderDeliveries(@RequestBody DeliveriesInfoVo  deliveriesInfoVo){
       String doNo= deliveriesInfoServiceImpl.save(deliveriesInfoVo);
        return SystemResponse.ok(doNo);
    };

    @PostMapping("/confirm")
    @ApiOperation("确认支付接口")
    public SystemResponse<AddDeliveriesDto>  confirmOrderDeliveries(@RequestBody DeliveriesInfoVo deliveriesInfoVo){
        AddDeliveriesDto dto=deliveriesInfoServiceImpl.confirmOrderDeliveries(deliveriesInfoVo);
        String status=dto.getInfo().getStatus();
        int filed=dto.getInfo().getFailed();
        if(StrUtil.equals("ok",status,true)&&filed==0){
            return SystemResponse.ok(dto);
        }
        return SystemResponse.failed(dto);
    }
    @PostMapping("/viewDeliveries")
    @ApiOperation("查询单个快递记录")
    public SystemResponse<DeliveriesDto> viewDeliveries(@RequestBody ViewDeliveriesVo viewDeliveriesVo){
        DeliveriesDto deliveriesDto= deliveriesInfoServiceImpl.viewDeliveries(viewDeliveriesVo);
        return SystemResponse.ok(deliveriesDto);
    }

    @PostMapping("/viewAllDeliveries")
    @ApiOperation("查询所有快递记录")
    public SystemResponse<List<DeliveriesDto>> viewAllDeliveries(@RequestBody ViewDeliveriesVo viewDeliveriesVo){
        List<DeliveriesDto> deliveriesDtos= deliveriesInfoServiceImpl.viewAllDeliveries(viewDeliveriesVo);
        return SystemResponse.ok(deliveriesDtos);
    }
}
