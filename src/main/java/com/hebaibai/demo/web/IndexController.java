package com.hebaibai.demo.web;

import com.hebaibai.amvc.annotation.Request;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hjx
 */
@Request
public class IndexController {

    /**
     * @param name
     * @return
     */
    @Request
    public Map<String, String> index(String name, int age) {
        Map<String, String> map = new HashMap<>();
        map.put("value", name);
        map.put("msg", "success");
        map.put("msg2", age + "");
        return map;
    }

}
