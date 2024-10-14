package com.empresa.empresa.infrastructure.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.empresa.application.service.IEmailPerService;
import com.empresa.empresa.domain.EmailPer;
import com.empresa.empresa.infrastructure.repository.EmailPerRepository;



@Service
public class EmailPerAdapter implements IEmailPerService {

    @Autowired
    private EmailPerRepository emailPerRepository;

    @Override
    public Optional<EmailPer> findById(Long id) {
        return emailPerRepository.findById(id);
    }

    @Override
    public List<EmailPer> getAll() {
        return emailPerRepository.findAll();
    }

    @Override
    public EmailPer save(EmailPer emailPer) {
        return emailPerRepository.save(emailPer);
    }

    @Override
    public EmailPer update(Long id, EmailPer emailPer) {
        return emailPerRepository.findById(id)
            .map(existingEmail -> {
                existingEmail.setEmail(emailPer.getEmail());
                return emailPerRepository.save(existingEmail);
            })
            .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        emailPerRepository.deleteById(id);
    }
}

