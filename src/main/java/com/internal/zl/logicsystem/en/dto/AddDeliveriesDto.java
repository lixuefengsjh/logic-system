package com.internal.zl.logicsystem.en.dto;

import lombok.Data;

import java.util.List;

/**
 * @author: lxf
 * @create: 2020-09-15 12:11
 * @description:
 */
@Data
public class AddDeliveriesDto {

    private AddDeliveriesInfoDto info;

    private List<AddDeliveriesResultsDto> results;
}
