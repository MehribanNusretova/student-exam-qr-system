package com.example.studentexamproject.service;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EmailService {
     JavaMailSender mailSender;
    public void sendEmail(String to, String qrUrl) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(to);
            message.setSubject("İkinci imtahan QR kodu");
            message.setText("QR kodunuz: " + qrUrl);
            mailSender.send(message);
            System.out.println("✅ Email göndərildi: " + to);
        } catch (Exception e) {
            System.out.println("❌ Email xətası: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }
}
