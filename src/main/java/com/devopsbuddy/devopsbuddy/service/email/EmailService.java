package com.devopsbuddy.devopsbuddy.service.email;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;

public class EmailService extends AbstractEmailService
{
    private static final Logger LOG = LoggerFactory.getLogger(EmailService.class);
    @Override
    public void sendGenericEmailMessage(SimpleMailMessage mailMessage) {
        LOG.debug("Simulating email message sending...");
        LOG.info(mailMessage.toString());
        LOG.debug("Email sent");
        
    }
}
