package com.scb.externo.controller.Email;

import javax.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.scb.externo.models.Email;
import com.scb.externo.models.exceptions.ResourceInvalidEmailException;
import com.scb.externo.service.Email.EmailService;
import com.scb.externo.shared.NovoEmailDTO;

import javassist.NotFoundException;

@RestController
@RequestMapping("/api/externo")
public class EmailController {

    @Autowired
	EmailService emailService;

	@PostMapping("/enviarEmail")
	public ResponseEntity<Email> enviarEmail(@RequestBody NovoEmailDTO email) throws MessagingException, NotFoundException {
		String[] partesEmail = email.getEmail().split("@");

		if(partesEmail.length == 2 && !partesEmail[0].equals("") && !partesEmail[1].equals("")) {
			return emailService.enviarEmail(email);
		} else {
			throw new ResourceInvalidEmailException("E-mail com formato inválido.");
		}
		
		
	}
    
}
