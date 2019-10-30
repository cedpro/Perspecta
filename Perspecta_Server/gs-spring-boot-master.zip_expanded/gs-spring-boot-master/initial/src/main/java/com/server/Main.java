package com.server;

import java.util.Arrays;

import javax.swing.JOptionPane;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Main {
    
    public static void main(String[] args) {    	
    	
        ApplicationContext ctx = SpringApplication.run(Main.class, args);        
        
        //display initialized beans
        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
        System.out.println("*********************************************************");
        System.out.println("Server initialization complete.");
        System.out.println("*********************************************************");    	
    }
}
