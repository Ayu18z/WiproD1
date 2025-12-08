package com.example.message.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
@Service
public class MessageService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendOrderStatusEmail(Map<String, Object> body) {

        String email = body.get("email").toString();  //  email
        String text = body.get("text").toString();    
        String orderId = body.get("orderId").toString();

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(email);
        msg.setSubject("Order Update - Order #" + orderId);
        msg.setText(text);

        mailSender.send(msg);

        System.out.println("EMAIL SENT → " + email);
    }
}
