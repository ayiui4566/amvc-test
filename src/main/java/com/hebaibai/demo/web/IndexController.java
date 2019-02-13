package com.hebaibai.demo.web;

import com.hebaibai.amvc.annotation.Request;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hjx
 */
@Request
public class IndexController {

    @Inject
    public Service service;

    @Inject
    public Dao dao;

    /**
     * @param name
     * @return
     */
    @Request("/index")
    public Map<String, Object> index(String name) {
        Map<String, Object> map = new HashMap<>();
        map.put("name", name);
        map.put("IndexController.hashCode", hashCode());
        map.put("server.hashCode", service.hashCode());
        map.put("server.dao.hashCode", service.dao.hashCode());
        map.put("dao.hashCode", dao.hashCode());
        return map;
    }

}
