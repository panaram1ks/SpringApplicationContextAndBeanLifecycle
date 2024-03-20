package com.parom.spring.beansForJavaBasedContext;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author E.Parominsky 20/03/2024 16:03
 */
public class MyJavaBasedBean {

    @PostConstruct
    private void init(){
        System.out.println("postConstructMyJavaBasedBean");
    }

    private String dummy;

    public MyJavaBasedBean(String dummy) {
        this.dummy = dummy;
    }

    @PreDestroy
    private void destroy(){
        System.out.println("preDestroyMyJavaBasedBean");
    }
}
