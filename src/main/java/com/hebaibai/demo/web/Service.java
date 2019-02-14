package com.hebaibai.demo.web;

import lombok.Data;

import javax.inject.Inject;

/**
 * 测试使用的Service
 */
@Data
public class Service {

    private String serviceName;

    @Inject
    private Dao dao;

}
