package com.internal.zl.logicsystem.en.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author: lxf
 * @create: 2020-09-15 16:57
 * @description:
 */
@Data
public class ViewDeliveriesResultDto {

    private String date;

    @JsonProperty("do")
    private String doNo;

    private String status;

    private DeliveriesDto  delivery;
}
