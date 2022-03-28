package com.learn_spring.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
//        Car car = new Car();
//        car.drive();
        ApplicationContext context = new ClassPathXmlApplicationContext("vehicleconfig.xml");
        
        Car obj = (Car) context.getBean("car");
        obj.drive();
    }
}
 