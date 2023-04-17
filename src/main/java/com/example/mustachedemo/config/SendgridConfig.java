package com.example.mustachedemo.config;

import com.sendgrid.SendGrid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SendgridConfig {
    @Value("${spring.sendgrid.api-key}")
    private String key;

    @Bean
    public SendGrid getSendgrid(){
        return new SendGrid(key);
    }
}
