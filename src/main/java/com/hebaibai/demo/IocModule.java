package com.hebaibai.demo;

import com.google.inject.AbstractModule;
import com.google.inject.Binder;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.name.Names;
import com.hebaibai.demo.web.Dao;
import com.hebaibai.demo.web.Service;
import lombok.SneakyThrows;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

/**
 * 测试使用Ioc框架：guice
 */
public class IocModule extends AbstractModule {
    @Override
    protected void configure() {
        Binder binder = binder();
        loadConfig(binder);

    }

    /**
     * 从配置文件中加载配置
     *
     * @param binder
     */
    @SneakyThrows(IOException.class)
    void loadConfig(Binder binder) {
        InputStream resource = Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties");
        Properties properties = new Properties();
        properties.load(resource);
        Enumeration<?> enumeration = properties.propertyNames();
        while (enumeration.hasMoreElements()) {
            String key = enumeration.nextElement().toString();
            binder.bind(String.class).annotatedWith(Names.named(key)).toInstance(properties.getProperty(key));
        }
    }


    @Provides
    @Singleton
    Dao dao() {
        return new Dao();
    }

    @Provides
    @Singleton
    Service service(Dao dao) {
        Service service = new Service();
        service.setServiceName("这是一个Service");
        service.setDao(dao);
        return service;
    }

}
