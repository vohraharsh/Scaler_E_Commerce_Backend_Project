package com.vohraharsh.productservice.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    //Create a bean of RestTemplate.

    //Note - Name of the class and Name of the method does not matter.

    @Bean
    public RestTemplate createRestTemplate() {
        return new RestTemplate();

        //Will not take any input parameter, and will return new RestTemplate.
    }
}
