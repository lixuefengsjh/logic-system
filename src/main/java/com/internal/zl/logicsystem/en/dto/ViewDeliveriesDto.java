package com.internal.zl.logicsystem.en.dto;

import lombok.Data;

import java.util.List;

/**
 * @author: lxf
 * @create: 2020-09-15 14:35
 * @description: 查询物流信息
 */
@Data
public class ViewDeliveriesDto {
    private  AddDeliveriesInfoDto info;

    private List<ViewDeliveriesResultDto> results;
}
