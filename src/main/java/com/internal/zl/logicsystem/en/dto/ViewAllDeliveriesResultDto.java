package com.internal.zl.logicsystem.en.dto;

import lombok.Data;

import java.util.List;

/**
 * @author: lxf
 * @create: 2020-09-15 17:10
 * @description:
 */
@Data
public class ViewAllDeliveriesResultDto {

    private AddDeliveriesInfoDto info;

    private List<DeliveriesDto> deliveries;
}
