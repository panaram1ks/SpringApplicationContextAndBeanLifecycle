package com.parom.spring;

import com.parom.spring.beans.ConnectionPoolXMLbased;
import com.parom.spring.config.ApplicationConfigurationMy;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author E.Parominsky 20/03/2024 13:53
 */
public class ApplicationRunner {

    public static void main(String[] args) {

//        ClassPathXmlApplicationContext contextJavaBased = new ClassPathXmlApplicationContext("applicationContext.xml"); // обработка этого контекста вынесена в ApplicationConfiguration.class для объединения их в один общий контекст
        AnnotationConfigApplicationContext contextJavaBased = new AnnotationConfigApplicationContext(ApplicationConfigurationMy.class);

// 1 XML based Context
        try (contextJavaBased) {
            // в дебаге ищем в contextJavaBased beanFactory beanDefenitionMap, там храниться наш bean в Map
            // clazz -> String -> Map<String, Object>

            // можно смотреть в singletonObjects синглетоны соответственно

            // получим Exception потому что бинов такого класса 2 !
// 1.1 пример
// System.out.println("<<<<<< " + contextJavaBased.getBean(ConnectionPool.class) + " >>>>>>>>");

            // поэтому нужно ввести идентификаторы в дефенишены
// 1.2 пример
            System.out.println("<<<<<< " + contextJavaBased.getBean("pool1") + " >>>>>>>>"); // return bean типа Object это неудобно
            System.out.println("<<<<<< " + contextJavaBased.getBean("pool1").getClass() + " >>>>>>>>"); // return bean типа Object это неудобно
            // поэтому используем метод
            System.out.println("<<<<<< " + contextJavaBased.getBean("pool1", ConnectionPoolXMLbased.class) + " >>>>>>>>");
            System.out.println("<<<<<< " + contextJavaBased.getBean("pool1", ConnectionPoolXMLbased.class).getClass() + " >>>>>>>>");

// 1.3 пример
            // id и alias бинов хранятья contextJavaBased beanFactory в  aliasMap соответственно и их можно получать по ним
            System.out.println("<<<<<< " + contextJavaBased.getBean("alias2", ConnectionPoolXMLbased.class) + " >>>>>>>>");
            System.out.println("<<<<<< " + contextJavaBased.getBean("alias4", ConnectionPoolXMLbased.class) + " >>>>>>>>");


// 2 Annotation-based configuration
            System.out.println(contextJavaBased.getBean("anyNameBean123"));
            System.out.println("<<<<<< " + contextJavaBased.getBean("сonnectionPoolAnnotationBased") + " >>>>>>>>");


//3 Java-based configuration ( для его работы нам нужен класс ConfigurationClassBeanDefinitionReader он ищет конфигурации в классах помеченных аннотациями @Configuration и @Bean )
            System.out.println(contextJavaBased.getBean("anyNameBean123"));
            System.out.println();
        }

    }

}
