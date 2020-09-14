package com.internal.zl.logicsystem.service.impl;

import cn.hutool.core.util.StrUtil;
import com.internal.zl.logicsystem.en.dto.DeliveriesDto;
import com.internal.zl.logicsystem.en.vo.DeliveriesInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.*;

/**
 * @author: lxf
 * @create: 2020-09-11 17:20
 * @description: 用于测试detrack的api
 */
@Component
public class DeliveriesInfoApi {
    @Autowired
    private RestTemplate  restTemplate;
    public  String addDeliveries(List<DeliveriesInfoVo> deliveriesInfoVo){
        HttpHeaders headers = new HttpHeaders();
        MultiValueMap<String, DeliveriesInfoVo> map = new LinkedMultiValueMap<>();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        map.put("list",deliveriesInfoVo);
        HttpEntity<MultiValueMap<String, DeliveriesInfoVo>> httpEntity = new HttpEntity<>(map, headers);
        String url="https://app.detrack.com/api/v1/deliveries/create.json?key=f7f09e353da79b9ad3823e9dd4fc95b844766e11a63d584f";
        ResponseEntity<Object> response = restTemplate.postForEntity(url, httpEntity, Object.class);
        System.out.println( response.getBody().toString());
        String status= StrUtil.subBetween(response.getBody().toString(),"","");
        return  status;
    }

    public DeliveriesDto viewDeliveries(String date, String doNo){
        HttpHeaders headers = new HttpHeaders();
        MultiValueMap<String, Map> map = new LinkedMultiValueMap<>();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        HashMap<String,String> param=new HashMap(){{
            put("date",date);
            put("do",doNo);
        }};
        map.put("list", Collections.singletonList(param));
        HttpEntity<MultiValueMap<String,List<Map>>> httpEntity = new HttpEntity(map, headers);
        String url="https://app.detrack.com/api/v1/deliveries/view.json?key=f7f09e353da79b9ad3823e9dd4fc95b844766e11a63d584f";
        ResponseEntity<Object> response = restTemplate.postForEntity(url, httpEntity, Object.class);
        System.out.println( response.getBody().toString());
        String status= StrUtil.subBetween(response.getBody().toString(),"","");
        return  new DeliveriesDto();
    }

    public List<DeliveriesDto> viewDeliveries(String date) {
        HttpHeaders headers = new HttpHeaders();
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        map.put("date", Collections.singletonList(date));
        HttpEntity<MultiValueMap<String,List<Map>>> httpEntity = new HttpEntity(map, headers);
        String url="https://app.detrack.com/api/v1/deliveries/view/all.json?key=f7f09e353da79b9ad3823e9dd4fc95b844766e11a63d584f";
        ResponseEntity<Object> response = restTemplate.postForEntity(url, httpEntity, Object.class);
        System.out.println( response.getBody().toString());
        String status= StrUtil.subBetween(response.getBody().toString(),"","");
        return  Arrays.asList(new DeliveriesDto());
    }
}
