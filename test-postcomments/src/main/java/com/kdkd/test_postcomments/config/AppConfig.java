package com.kdkd.test_postcomments.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.util.UriComponentsBuilder;

@Configuration
public class AppConfig {

    @Value("${conf.jsonplaceholder.host}")
    private String host;

    @Value("${conf.protocol}")
    private String protocol; 

    @Bean
    UriComponentsBuilder UriManager() {
        return UriComponentsBuilder.newInstance()
            .scheme(protocol)
            .host(host);
    }
    
}