package com.example.aop;

import com.example.aop.service.BusinessService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"com.example.aop"})
public class App {

    private BusinessService businessService;

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(App.class);
        BusinessService businessService = (BusinessService) applicationContext.getBean("getBusinessService");
        businessService.getDataFromApi();
    }

}
