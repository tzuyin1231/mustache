package com.example.mustachedemo.controller;

import com.example.mustachedemo.Service.EmailService;
import com.example.mustachedemo.model.EmailRequest;
import com.sendgrid.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class EmailController {
    @Autowired
    private EmailService emailService;

    @PostMapping("/sendemail")
    public ResponseEntity<String> sendemail(@RequestBody EmailRequest emailRequest){
        Response response = emailService.sendemail(emailRequest);
        if(response.getStatusCode()==200||response.getStatusCode()==202)
            return new ResponseEntity<>("Send Successfully", HttpStatus.OK);
        return new ResponseEntity<>("Failed to Send", HttpStatus.NOT_FOUND);
    }
    @PostMapping("/sendHTML")
    public ResponseEntity<String> sendHTML(@RequestBody EmailRequest emailRequest) throws Exception {
        Response response = emailService.sendHTML(emailRequest);
        if(response.getStatusCode()==200||response.getStatusCode()==202)
            return new ResponseEntity<>("Send Successfully", HttpStatus.OK);
        return new ResponseEntity<>("Failed to Send", HttpStatus.NOT_FOUND);
    }
}
