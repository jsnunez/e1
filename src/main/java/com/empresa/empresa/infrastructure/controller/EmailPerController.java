package com.empresa.empresa.infrastructure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.empresa.application.service.IEmailPerService;
import com.empresa.empresa.domain.EmailPer;



@RestController
@RequestMapping("/api/email")
public class EmailPerController {

    @Autowired
    private IEmailPerService emailPerService;

    @GetMapping
    public ResponseEntity<List<EmailPer>> list() {
        List<EmailPer> emails = emailPerService.getAll();
        return new ResponseEntity<>(emails, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmailPer> show(@PathVariable Long id) {
        return emailPerService.findById(id)
                .map(email -> new ResponseEntity<>(email, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<EmailPer> create(@RequestBody EmailPer email) {
        EmailPer createdEmail = emailPerService.save(email);
        return new ResponseEntity<>(createdEmail, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmailPer> update(@PathVariable Long id, @RequestBody EmailPer email) {
        EmailPer updatedEmail = emailPerService.update(id, email);
        if (updatedEmail != null) {
            return new ResponseEntity<>(updatedEmail, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (emailPerService.findById(id).isPresent()) {
            emailPerService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } 
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}