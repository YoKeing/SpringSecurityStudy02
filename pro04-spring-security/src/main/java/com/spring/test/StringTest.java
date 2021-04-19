package com.spring.test;

import com.spring.MyAnnotationConfiguration;
import com.spring.entity.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class StringTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(MyAnnotationConfiguration.class);
        Employee employee = applicationContext.getBean(Employee.class);
        System.out.println(employee);

    }

}
