package com.lucspb.email.controller;

import com.lucspb.email.entities.Email;
import com.lucspb.email.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping
    public ResponseEntity<Email> sendEmail(@RequestBody Email email) {
        emailService.sendEmail(email);
        return new ResponseEntity<>(email, HttpStatus.OK);
    }

}
