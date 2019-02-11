package com.hebaibai.demo.web;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hjx
 */
public class IndexController {

    /**
     * @param name
     * @return
     */
    public Map<String, String> index(String name) {
        Map<String, String> map = new HashMap<>();
        map.put("value", name);
        map.put("msg", "success");
        return map;
    }

}
