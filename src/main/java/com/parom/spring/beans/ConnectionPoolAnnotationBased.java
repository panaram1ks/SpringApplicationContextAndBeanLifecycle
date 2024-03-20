package com.parom.spring.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author E.Parominsky 20/03/2024 14:38
 */
public class ConnectionPoolAnnotationBased {

    private String url;

    @PostConstruct
    void init(){
        System.out.println("Post construct modification");
    }

    public ConnectionPoolAnnotationBased() {
        System.out.println("Create bean");
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @PreDestroy
    void destroy(){
        System.out.println("Destroy bean");
    }
}
