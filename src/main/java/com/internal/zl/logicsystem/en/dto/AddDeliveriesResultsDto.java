package com.internal.zl.logicsystem.en.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @author: lxf
 * @create: 2020-09-15 11:52
 * @description:
 */
@Data
public class AddDeliveriesResultsDto {
    private  String date;
    @JsonProperty("do")
    private String doNo;
    private String status;
    private List<AddDeliveriesError> errors;
}
