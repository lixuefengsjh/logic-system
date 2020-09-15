package com.internal.zl.logicsystem.en.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author: lxf
 * @create: 2020-09-13 21:41
 * @description:
 */
@Data
public class DeliveriesDto {
    private Date date;

    private String address;

    private String delivery_time;

    private String deliver_to;

    private String phone;

    private String notify_email;

    private String notifyUrl;

    private String assign_to;

    private String instructions;

    private String zone;

    private String reason;

    private String note;

    private String received_by;

    private Integer image;

    @JsonProperty("do")
    private String  doNo ;

    private String pod_lat;

    private String pod_lng;

    private String  pod_address;

    private List<ItemDto> items;

}
