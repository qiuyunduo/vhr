package cn.qyd.mailserver;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.Date;

@SpringBootTest
class MailserverApplicationTests {

    @Autowired
    JavaMailSender javaMailSender;

    @Test
    void contextLoads() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("iqiuyunduo@163.com");
        message.setSubject("邮件主题-测试");
        message.setSentDate(new Date());
        message.setText("Hello 我的qq邮箱 2497999605");
        message.setTo("qiuyunduo@foxmail.com");
        javaMailSender.send(message);
    }
}
