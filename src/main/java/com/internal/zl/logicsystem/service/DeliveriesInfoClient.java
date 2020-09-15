package com.internal.zl.logicsystem.service;

import com.internal.zl.logicsystem.en.dto.AddDeliveriesDto;
import com.internal.zl.logicsystem.en.dto.DeliveriesDto;
import com.internal.zl.logicsystem.en.dto.ViewAllDeliveriesResultDto;
import com.internal.zl.logicsystem.en.dto.ViewDeliveriesDto;
import com.internal.zl.logicsystem.en.vo.DeliveriesInfoVo;
import com.internal.zl.logicsystem.en.vo.ViewDeliveriesVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * @author: lxf
 * @create: 2020-09-15 11:26
 * @description: 本地客户端
 */
@FeignClient(name="default", url = "https://app.detrack.com")
public interface DeliveriesInfoClient {
    @PostMapping("/api/v1/deliveries/create.json?key=f7f09e353da79b9ad3823e9dd4fc95b844766e11a63d584f")
    public AddDeliveriesDto addDeliveriesInfo(List<DeliveriesInfoVo> lists);

    @PostMapping("/api/v1/deliveries/view.json?key=f7f09e353da79b9ad3823e9dd4fc95b844766e11a63d584f")
    public ViewDeliveriesDto viewDeliveries(List<ViewDeliveriesVo> lists);

    @PostMapping("/api/v1/deliveries/view/all.json?key=f7f09e353da79b9ad3823e9dd4fc95b844766e11a63d584f")
    public ViewAllDeliveriesResultDto viewAllDeliveries(ViewDeliveriesVo lists);
}
