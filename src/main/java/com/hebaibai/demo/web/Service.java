package com.hebaibai.demo.web;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * 测试使用的Service
 */
@Singleton
public class Service {

    @Inject
    public Dao dao;

    public int install() {
        return dao.install();
    }

    public int del() {
        return dao.del();
    }
}
