package org.example.config;

import org.springframework.context.annotation.ComponentScan;

import javax.annotation.PostConstruct;

@ComponentScan("org.example")
public class TestGlobalConfig {
    @PostConstruct
    public void init(){
    System.out.println("---- invoked TestGlobalConfig ----");
    }
}
