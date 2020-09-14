package com.internal.zl.logicsystem.service.impl;

import cn.hutool.core.util.StrUtil;

/**
 * @author: lxf
 * @create: 2020-09-13 21:17
 * @description:
 */
public class Test {
    public static void main(String[] args) {
        String ss="{\n" +
                "   \"info\":{\n" +
                "      \"status\":\"ok\",\n" +
                "      \"failed\":0\n" +
                "   },\n" +
                "   \"results\":[\n" +
                "      {\n" +
                "         \"date\":\"2014-02-13\",\n" +
                "         \"do\":\"DO140213001\",\n" +
                "         \"status\":\"ok\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"date\":\"2014-02-13\",\n" +
                "         \"do\":\"DO140213002\",\n" +
                "         \"status\":\"ok\"\n" +
                "      }\n" +
                "   ]\n" +
                "}";
        String sss= StrUtil.subBetween(ss,"status\":\"","\",failed");
        System.out.println(sss);
    }
}
