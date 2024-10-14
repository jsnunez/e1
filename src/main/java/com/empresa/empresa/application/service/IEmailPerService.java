package com.empresa.empresa.application.service;
import java.util.List;
import java.util.Optional;

import com.empresa.empresa.domain.EmailPer;

public interface IEmailPerService {
    Optional<EmailPer> findById(Long id);
    List<EmailPer> getAll();
    EmailPer save(EmailPer emailPer);
    EmailPer update(Long id, EmailPer emailPer);
    void deleteById(Long id);
}


