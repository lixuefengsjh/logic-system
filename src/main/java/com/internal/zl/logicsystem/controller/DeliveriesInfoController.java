package com.internal.zl.logicsystem.controller;

import com.internal.zl.logicsystem.base.SystemResponse;
import com.internal.zl.logicsystem.en.dto.DeliveriesDto;
import com.internal.zl.logicsystem.en.vo.DeliveriesInfoVo;
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
    public SystemResponse<String>  confirmOrderDeliveries(@RequestBody DeliveriesInfoVo deliveriesInfoVo){
        deliveriesInfoServiceImpl.confirmOrderDeliveries(deliveriesInfoVo);
        return SystemResponse.ok("pay money ok");
    }
    @GetMapping("/view/{date}/{do}")
    @ApiOperation("查询单个快递记录")
    public SystemResponse<DeliveriesDto> viewDeliveries(@PathVariable String date, @PathVariable(value ="do" ) String doNo){
        DeliveriesDto deliveriesDto= deliveriesInfoServiceImpl.viewDeliveries(date,doNo);
        return SystemResponse.ok(deliveriesDto);
    }

    @GetMapping("/view/{date}")
    @ApiOperation("查询所有快递记录")
    public SystemResponse<List<DeliveriesDto>> viewAllDeliveries(@PathVariable String date){
        List<DeliveriesDto> deliveriesDtos= deliveriesInfoServiceImpl.viewAllDeliveries(date);
        return SystemResponse.ok(deliveriesDtos);
    }
}
