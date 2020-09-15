package com.internal.zl.logicsystem.en.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * @author: lxf
 * @create: 2020-09-13 12:32
 * @description: 订单基本信息
 */
@Data
public class DeliveriesInfoVo {

    private Integer id;

    @NotNull(message = "The delivery date is required")
    private Date date;

    @NotNull(message = "The delivery address is required")
    private String address;

    @NotNull(message = "The delivery time is required")
    private String deliveryTime;

    @NotNull(message = "The phone number of the recipient is required")
    private String phone;

    private String notifyEmail;

    private String notifyUrl;

    private String assignTo;

    private String instructions;

    private String zone;

    @NotNull(message = "The deliver address is required")
    private String deliverAddress;

    @NotNull(message = "The deliver phone  is required")
    private String deliverPhone;

    @JsonProperty("do")
    private String doNo;

    private Integer status;

    private List<DeliveriesItem> items;
}
