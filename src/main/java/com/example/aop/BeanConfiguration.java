package com.example.aop;

import com.example.aop.aspect.LoggableAspect;
import com.example.aop.service.BusinessService;
import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public LoggableAspect getLoggableAspect() {
        return new LoggableAspect();
    }

    @Bean
    public AnnotationAwareAspectJAutoProxyCreator getAnnotationAwareAspectJAutoProxyCreator() {
        return new AnnotationAwareAspectJAutoProxyCreator();
    }

    @Bean
    public BusinessService getBusinessService() {
        return new BusinessService();
    }

}
