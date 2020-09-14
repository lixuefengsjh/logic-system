package com.internal.zl.logicsystem.en.entity;

import lombok.Data;

import java.util.Date;
@Data
public class DeliveriesInfo {
    private Integer id;

    private Date date;

    private String address;

    private String deliveryTime;

    private String phone;

    private String notifyEmail;

    private String notifyUrl;

    private String assignTo;

    private String instructions;

    private String zone;

    private String deliverAddress;

    private String deliverPhone;

    private String doNo;

    private Integer status;

}