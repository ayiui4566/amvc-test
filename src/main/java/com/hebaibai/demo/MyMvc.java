package com.hebaibai.demo;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.hebaibai.amvc.Application;
import com.hebaibai.amvc.MvcServlet;

public class MyMvc extends MvcServlet {

    /**
     * 初始化Ioc框架
     * Ioc框架使用：Guice
     *
     * @param application
     */
    @Override
    protected void afterInitMvc(Application application) {
        Injector injector = Guice.createInjector(new IocModule());
        application.setObjectFactory(aClass -> injector.getInstance(aClass));
    }

}
