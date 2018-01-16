package com.devopsbuddy.devopsbuddy.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3Client;
import com.devopsbuddy.devopsbuddy.service.email.EmailService;
import com.devopsbuddy.devopsbuddy.service.email.SmtpEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("development")
public class DevelopmentConfig {

    @Value("${aws.s3.profile}")
    private String awsProfileName;


    @Bean
    public AmazonS3Client s3Client()
    {
        AWSCredentials credentials = new ProfileCredentialsProvider(awsProfileName).getCredentials();
        AmazonS3Client s3Client = new AmazonS3Client(credentials);
        return s3Client;
    };


    @Bean
    public EmailService emailService()
    {

        return new EmailService();
    }

    @Bean
    public SmtpEmailService smtpEmailService()
    {

        return new SmtpEmailService();
    }




}
