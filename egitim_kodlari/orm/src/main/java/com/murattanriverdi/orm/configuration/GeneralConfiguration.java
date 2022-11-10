package com.murattanriverdi.orm.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GeneralConfiguration {

    @Bean
    MyBean myBean() {
        MyBean myBean = new MyBean();
        myBean.setMyLong(123);
        myBean.setMyString("String");
        myBean.setMyDouble(123.123);
        return myBean;
    }
}
