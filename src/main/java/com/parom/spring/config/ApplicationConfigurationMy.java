package com.parom.spring.config;

import com.parom.spring.beansForJavaBasedContext.MyJavaBasedBean;
import com.parom.spring.configurationFromNotScunedPacage.WebConfiguration;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.*;

/**
 * @author E.Parominsky 20/03/2024 15:16
 */

@Configuration // Наследуется от @Component и автоматически будет отсканирована componentScan
@ImportResource("classpath:applicationContext.xml") // загружает бины из xml конфигурации
@ComponentScan(basePackages = "com.parom.spring.beansForJavaBasedContext")
@Import(WebConfiguration.class)
public class ApplicationConfigurationMy {

    @Bean // для того чтобы класс попал в контекст, метод нужно пометить аннотацией @Bean
    @Scope(BeanDefinition.SCOPE_SINGLETON) // Singleton - Default
    public MyJavaBasedBean anyNameBean123(){
        return new MyJavaBasedBean("dummy string");
    }
}
