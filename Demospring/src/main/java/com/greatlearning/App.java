package com.greatlearning;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext Context=new ClassPathXmlApplicationContext("web.xml");
        student s=(student)Context.getBean("studentbean");
        System.out.println(s);
        
    }
}
