package com.hebaibai.demo.web;

import com.hebaibai.amvc.RequestType;
import com.hebaibai.amvc.annotation.Request;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hjx
 */
@Request
public class IndexController {

    @Named("url")
    @Inject
    private String url;

    @Named("name")
    @Inject
    private String name;

    @Named("web")
    @Inject
    private String web;

    @Inject
    private Dao dao;

    @Inject
    private Service service;

    /**
     * @return
     */
    @Request(value = "/config", type = RequestType.GET)
    public Map<String, Object> index() {
        Map<String, Object> map = new HashMap<>();
        map.put("url", url);
        map.put("name", name);
        map.put("web", web);
        return map;
    }

    @Request(value = "/dao", type = RequestType.GET)
    public String daoName() {
        return dao.getDaoName()+"=="+dao.hashCode();
    }

    @Request(value = "/service", type = RequestType.GET)
    public String serviceName() {
        return service.getServiceName() + "==" + service.hashCode();
    }

    @Request(value = "/service.dao", type = RequestType.GET)
    public String serviceDao() {
        return service.getServiceName() + "==" + service.getDao().hashCode();
    }

}
