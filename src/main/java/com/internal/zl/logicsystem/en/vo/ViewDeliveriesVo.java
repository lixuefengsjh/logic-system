package com.internal.zl.logicsystem.en.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author: lxf
 * @create: 2020-09-14 09:53
 * @description: 查询物流订单相关信息
 */
@Data
public class ViewDeliveriesVo {

    private String date;

    @JsonProperty("do")
    private String doNo;

}
