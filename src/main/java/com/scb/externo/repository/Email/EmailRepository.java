package com.scb.externo.repository.Email;

import java.util.ArrayList;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Repository;

import com.scb.externo.models.Email;
import com.scb.externo.shared.NovoEmailDTO;

import javassist.NotFoundException;

@Repository
public class EmailRepository {
  private ArrayList<Email> memoria = new ArrayList<>();

    @Autowired
    private JavaMailSender mailSender;

    private Random geradorId = new Random();

    public MimeMessage gerarEmail(NovoEmailDTO email) throws MessagingException {
      MimeMessage mimeMessage = mailSender.createMimeMessage();
      MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");

      helper.setFrom("luisa.c.correia@edu.unirio.br");
      helper.setSubject("Sistema de Controle de Bicicletário");
      helper.setText(email.getMensagem());
      helper.setTo(email.getEmail());

      return mimeMessage;

    }

    public ResponseEntity<Email> enviarEmail(NovoEmailDTO email) throws MessagingException, NotFoundException{

      MimeMessage emailGerado = gerarEmail(email);
      
      try {
        mailSender.send(emailGerado);
        Email emailCriado = new Email();
        emailCriado.setId(Integer.toString(this.geradorId.nextInt(100000)));
        emailCriado.setEmail(email.getEmail());
        emailCriado.setMensagem(email.getMensagem());
        memoria.add(emailCriado);
        return new ResponseEntity<>(emailCriado, HttpStatus.OK);
      } catch(Exception e){
        throw new NotFoundException("E-mail não encontrado");
      }
 
	}
    
}
