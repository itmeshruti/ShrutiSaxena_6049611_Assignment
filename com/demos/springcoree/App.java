package com.demos.springcoree;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demos.springcoree.beans.SBU;

public class App {

    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring.xml");

        SBU sbu = (SBU) context.getBean("sbu");

        sbu.display();
    }
}