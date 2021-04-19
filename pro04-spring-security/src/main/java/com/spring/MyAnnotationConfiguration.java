package com.spring;

import com.spring.entity.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyAnnotationConfiguration {

    @Bean
    public Employee getEmployee(){
        return new Employee();
    }

}
