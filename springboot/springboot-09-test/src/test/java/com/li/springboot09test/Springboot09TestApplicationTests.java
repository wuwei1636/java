package com.li.springboot09test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class Springboot09TestApplicationTests {

    @Autowired
    JavaMailSenderImpl mailSender;

    @Test
    void contextLoads() {

        // 一个简单的邮件发送
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setSubject("你好呀"); // 邮件题目
        simpleMailMessage.setText("谢谢你的贡献"); // 邮件内容

        simpleMailMessage.setTo("1537628435@qq.com");
        simpleMailMessage.setFrom("1537628435@qq.com");
        mailSender.send(simpleMailMessage);

    }

    @Test
    void contextLoad() throws MessagingException {
    //     一个复杂的邮件

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        // 组装
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage,true);

        messageHelper.setSubject("你好呀");
        messageHelper.setText("<p>谢谢你的贡献</p>");

        // 附件  文件可以使用本地绝对地址
        messageHelper.addAttachment("infinity-1966300.jpg",new File("E:\\Pictures\\bgc\\infinity-1966300.jpg"));

        messageHelper.setTo("1537628435@qq.com");
        messageHelper.setFrom("1537628435@qq.com");

        mailSender.send(mimeMessage);

    }

    /**
     *
     * @param html : 是否支持html
     * @param subject  邮件的标题
     * @param text  邮件的内容
     * @param sendToEmail 发送邮件给谁
     * @param sendFromEmail 谁来发送邮件
     * @throws MessagingException
     * @Author lks
     */
    public void sendMail(boolean html,String subject,String text,String sendToEmail,String sendFromEmail) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        // 组装
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage,html);

        messageHelper.setSubject(subject);
        // 默认支持html格式是true
        messageHelper.setText(text,true);

        // 附件  文件可以使用本地绝对地址
        messageHelper.addAttachment("infinity-1966300.jpg",new File("E:\\Pictures\\bgc\\infinity-1966300.jpg"));

        messageHelper.setTo(sendToEmail);
        messageHelper.setFrom(sendFromEmail);

        mailSender.send(mimeMessage);
    }

}
