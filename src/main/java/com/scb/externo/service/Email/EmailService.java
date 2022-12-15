package com.scb.externo.service.Email;

import javax.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import com.scb.externo.models.Email;
import com.scb.externo.repository.Email.EmailRepository;
import com.scb.externo.service.Email.EmailService;
import com.scb.externo.shared.NovoEmailDTO;

import javassist.NotFoundException;


public class EmailService {

  @Autowired
  EmailRepository emailRepository;

  public ResponseEntity<Email> enviarEmail(NovoEmailDTO novoEmail) throws MessagingException, NotFoundException {
    return emailRepository.enviarEmail(novoEmail);
  }
    
}
