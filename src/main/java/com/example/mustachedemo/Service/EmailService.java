package com.example.mustachedemo.Service;

import com.example.mustachedemo.model.EmailRequest;
import com.example.mustachedemo.model.entities.UserEntitites;
import com.samskivert.mustache.Mustache;
import com.sendgrid.Content;
import com.sendgrid.Email;
import com.sendgrid.Mail;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mustache.MustacheResourceTemplateLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class EmailService {

    @Autowired
    SendGrid sendGrid;

    @Autowired
    private UserService userService;

    public Response sendemail(EmailRequest emailRequest) {

        Email from = new Email("tzuyin1231@gmail.com");
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
            log.info("Context email sent");
            return sendGrid.api(request);

        } catch (IOException ex) {
            log.info("Context email didn't send. "+ ex.getMessage());
            return null;
        }

    }

    @Autowired
    private Mustache.Compiler compiler;
    public Response sendHTML(EmailRequest emailRequest) throws Exception {
        // 準備template
        MustacheResourceTemplateLoader loader = new MustacheResourceTemplateLoader("templates/", ".mustache");   // Inside resources emailTemplates dir
        Reader reader = loader.getTemplate("home");

        List<UserEntitites> users = userService.getAllUsers();

        Map<String,Object> params = new HashMap<>();
        params.put("users",users);
        Writer writer = new StringWriter();
        compiler.compile(reader).execute(params,writer);
        Email from = new Email("tzuyin1231@gmail.com");
        String subject = emailRequest.getSubject();
        Email to = new Email(emailRequest.getTo());
        Content content = new Content("text/HTML", writer.toString());
        Mail mail = new Mail(from, subject, to, content);

        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            log.info("HTML email sent");
            log.info(writer.toString());
            return sendGrid.api(request);
        } catch (IOException ex) {
            log.info(ex.getMessage());
            return null;
        }

    }

}
