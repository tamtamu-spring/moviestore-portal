package com.devopsbuddy.devopsbuddy.config;


import com.devopsbuddy.devopsbuddy.service.email.SmtpEmailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("production")
public class ProductionConfig {

    @Bean
    SmtpEmailService emailService()
    {
        return new SmtpEmailService();
    }

}
