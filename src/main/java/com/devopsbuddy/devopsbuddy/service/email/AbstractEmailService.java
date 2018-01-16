package com.devopsbuddy.devopsbuddy.service.email;

import com.devopsbuddy.devopsbuddy.web.controller.domain.frontend.FeedBackPojo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

public abstract class AbstractEmailService implements IEmailService {

    @Value("${default.address}")
    private String defaultAddress;

    protected SimpleMailMessage prepareSimpleMailMessageFromFeedBackPojo(FeedBackPojo feedBackPojo)
    {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(defaultAddress);
        simpleMailMessage.setFrom(feedBackPojo.getEmail());
        simpleMailMessage.setText(feedBackPojo.getMessage());
        simpleMailMessage.setSubject("Feedback received from: " + feedBackPojo.getFirstName() + " "+ feedBackPojo.getLastName());
        return simpleMailMessage;
    }

    @Override
    public void sendFeedBackEmail(FeedBackPojo feedBackPojo) {
        sendGenericEmailMessage(prepareSimpleMailMessageFromFeedBackPojo(feedBackPojo));

    }




}
