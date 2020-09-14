package com.internal.zl.logicsystem.en.dto;

import lombok.Data;

/**
 * @author: lxf
 * @create: 2020-09-14 09:31
 * @description: 相关附属信息
 */
@Data
public class ItemDto {
    private String qty;

    private String sku;

    private String desc;

    private Integer reject;

    private String  reason;
}
