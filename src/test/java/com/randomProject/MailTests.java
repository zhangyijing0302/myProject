package com.randomProject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.MailMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailTests {
    @Autowired
    JavaMailSenderImpl mailSender;

    @Test
    public void test() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("您好");
        message.setText("Text");
        message.setTo("344796884@qq.com");
        message.setFrom("344796884@qq.com");
        mailSender.send(message);
    }

    @Test
    public void message() throws MessagingException {

        File file = new File("sql/mysql/init.sql");


        // 复杂邮件
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        //
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "utf-8");
        mimeMessageHelper.setSubject("文件主题");
        mimeMessageHelper.setText("你好");
        // 附件
        mimeMessageHelper.addAttachment("1.sql", file);

        mimeMessageHelper.setTo("344796884@qq.com");
        mimeMessageHelper.setFrom("344796884@qq.com");

        mailSender.send(mimeMessage);
    }
}
