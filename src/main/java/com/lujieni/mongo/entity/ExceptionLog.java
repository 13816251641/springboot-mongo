package com.lujieni.mongo.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class ExceptionLog {
    @Id
    private String openId;//可以随意命名,但存在mongo中的字段名称还是叫_id
    private Integer status;
    private String body;


}
