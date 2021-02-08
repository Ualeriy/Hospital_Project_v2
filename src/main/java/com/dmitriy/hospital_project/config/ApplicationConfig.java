package com.dmitriy.hospital_project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Instant;

@Configuration
public class ApplicationConfig {

    @Bean
    public Instant time(){
        return Instant.now();
    }


    @Bean
    public String applicationName() {
        return "Hospital Project";
    }
}
