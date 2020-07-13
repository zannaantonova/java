package ee.bcs.java.demo;

import ee.bcs.java.demo.controller.Book;
import ee.bcs.java.demo.controller.BookValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@org.springframework.context.annotation.Configuration
public class Configuration {
    @Bean
    public LocalValidatorFactoryBean localValidatorFactoryBean(){
        return new LocalValidatorFactoryBean();
    }

    @Bean
    public BookValidator beforeCreateBookValidator(){
        return new BookValidator();
    }

}
