package com.devopsbuddy.devopsbuddy.service.email;

import com.devopsbuddy.devopsbuddy.web.controller.domain.frontend.FeedBackPojo;
import org.springframework.mail.SimpleMailMessage;

public interface IEmailService {

     void sendFeedBackEmail(FeedBackPojo feedBackPojo);
     void sendGenericEmailMessage(SimpleMailMessage mailMessage);

}
