package com.parom.spring.beans;

/**
 * @author E.Parominsky 20/03/2024 14:04
 */
public class ConnectionPoolXMLbased {

    private String url;

    private void init(){
        System.out.println("Modify bean after create");
    }

    public ConnectionPoolXMLbased() {
        url = "initializedURL";
        System.out.println("Create bean");
    }

    public void setUrl(String url){
        this.url = url;
    }

    // Что бы вызвался метод destroy нужно что-бы начал закрываться контекст приложения
    // желательно открыть контекст в блоке try с ресурсами для автоматического закрытия контекста при завершении работы приложения
    private void destroy(){
        System.out.println("Destroy bean");
    }
}
