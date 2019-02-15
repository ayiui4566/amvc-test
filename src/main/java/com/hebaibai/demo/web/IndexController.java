package com.hebaibai.demo.web;

import com.hebaibai.amvc.RequestType;
import com.hebaibai.amvc.annotation.Request;

/**
 * @author hjx
 */
@Request("index")
public class IndexController {

    @Request(value = "test", type = RequestType.GET)
    public String testGet() {
        return "success";
    }

    @Request(value = "user/{name}/{age}", type = RequestType.POST)
    public String user(String name, int age, String body) {
        System.out.println(name);
        System.out.println(age);
        System.out.println(body);
        return "success";
    }

}
