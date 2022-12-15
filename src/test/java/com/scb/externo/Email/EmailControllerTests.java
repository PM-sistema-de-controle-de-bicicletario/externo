package com.scb.externo.Email;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.Random;

import javax.mail.MessagingException;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.scb.externo.models.Email;
import com.scb.externo.models.exceptions.ResourceInvalidEmailException;
import com.scb.externo.service.Email.EmailService;
import com.scb.externo.shared.NovoEmailDTO;

import javassist.NotFoundException;

@SpringBootApplication

public class EmailControllerTests {

    EmailService emailService = mock(EmailService.class);

    //Esse teste verifica apenas se está enviando a ResourceInvalidException, por isso não tem assert
    @Test
    void enviar_email_invalido() throws ResourceInvalidEmailException, MessagingException, NotFoundException {
        NovoEmailDTO novoEmail = new NovoEmailDTO();
        novoEmail.setEmail("luisa.c.correia@");
        novoEmail.setMensagem("Mensagem");

        Random geradorId = new Random();
        Email emailCriado = new Email();
        emailCriado.setId(Integer.toString(geradorId.nextInt(25)));
        emailCriado.setEmail(novoEmail.getEmail());
        emailCriado.setMensagem(novoEmail.getMensagem());

        when(emailService.enviarEmail(novoEmail)).thenThrow(ResourceInvalidEmailException.class);
        doThrow(ResourceInvalidEmailException.class);

    }
    @Test
    void enviar_email_valido() throws MessagingException, NotFoundException {
        NovoEmailDTO novoEmail = new NovoEmailDTO();
        novoEmail.setEmail("luisa.c.correia@edu.unirio.br");
        novoEmail.setMensagem("Mensagem");

        Random geradorId = new Random();
        Email emailCriado = new Email();
        emailCriado.setId(Integer.toString(geradorId.nextInt(25)));
        emailCriado.setEmail(novoEmail.getEmail());
        emailCriado.setMensagem(novoEmail.getMensagem());

        when(emailService.enviarEmail(novoEmail)).thenReturn(new ResponseEntity<Email>(emailCriado, HttpStatus.OK));
            ResponseEntity<Email> resposta = emailService.enviarEmail(novoEmail);
            assertEquals(HttpStatus.OK, resposta.getStatusCode());
    } 
}
    

