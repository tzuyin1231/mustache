package com.example.mustachedemo.Service;

import com.example.mustachedemo.model.EmailRequest;
import com.example.mustachedemo.model.entities.UserEntitites;
import com.sendgrid.Content;
import com.sendgrid.Email;
import com.sendgrid.Mail;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;

@Service
public class EmailService {
    @Autowired
    SendGrid sendGrid;

    @Autowired
    private UserService userService;

    public Response sendemail(EmailRequest emailRequest) {

        Email from = new Email("jin19941231@gmail.com");
        String subject = emailRequest.getSubject();
        Email to = new Email(emailRequest.getTo());
//        text/html 用於寄送HTML格式
//        text/plain 用於寄送純文字格式
        Content content = new Content("text/content", emailRequest.getBody());
        Mail mail = new Mail(from, subject, to, content);

        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            return sendGrid.api(request);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            return null;
        }

    }

    public Response sendHTML(EmailRequest emailRequest) throws IOException {
        List<UserEntitites> users = userService.getAllUsers();

        Writer writer = new StringWriter();
        mf.compile("/Users/cfh00893566/Desktop/DemoCode/mustacheDemo/src/main/resources/templates/home.mustache")
                .execute(writer, users).flush();
        String output = writer.toString();
        System.out.println(users);
        System.out.println(output);

        Email from = new Email("jin19941231@gmail.com");
        String subject = emailRequest.getSubject();
        Email to = new Email(emailRequest.getTo());
        Content content = new Content("text/HTML", output);
        Mail mail = new Mail(from, subject, to, content);

        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            return sendGrid.api(request);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            return null;
        }

    }

}
