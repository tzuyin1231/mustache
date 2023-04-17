package com.example.mustachedemo;

import com.sendgrid.Content;
import com.sendgrid.Email;
import com.sendgrid.Mail;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class SendgridTest {
    @Test
    public void testWebApi() {
        // 发件人，即配置的发件人邮箱地址
        Email from = new Email("jin19941231@gmail.com");
        // 邮件主题
        String subject = "Sending with SendGrid is Fun";
        // 收件人邮件地址
        Email to = new Email("jin19941231@gmail.com");
        // 邮件内容
        Content content = new Content("text/plain", "and easy to do anywhere, even with Java");
        Mail mail = new Mail(from, subject, to, content);
        // 配置API Keys的密钥
        SendGrid sg = new SendGrid("SENDGRID_API_KEY");
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
