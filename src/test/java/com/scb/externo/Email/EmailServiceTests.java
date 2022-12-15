package com.scb.externo.Email;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.Random;

import javax.mail.MessagingException;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.scb.externo.models.Email;
import com.scb.externo.repository.Email.EmailRepository;
import com.scb.externo.shared.NovoEmailDTO;

import javassist.NotFoundException;

@SpringBootTest
public class EmailServiceTests {

    EmailRepository emailRepository = mock(EmailRepository.class);

    @Test
    void enviar_email() throws MessagingException, NotFoundException {
        NovoEmailDTO novoEmail = new NovoEmailDTO();
        novoEmail.setEmail("luisa.c.correia@edu.unirio.br");
        novoEmail.setMensagem("Mensagem");

        Random geradorId = new Random();
        Email emailCriado = new Email();
        emailCriado.setId(Integer.toString(geradorId.nextInt(25)));
        emailCriado.setEmail(novoEmail.getEmail());
        emailCriado.setMensagem(novoEmail.getMensagem());

            when(emailRepository.enviarEmail(novoEmail)).thenReturn(new ResponseEntity<Email>(emailCriado, HttpStatus.OK));
            ResponseEntity<Email> resposta = emailRepository.enviarEmail(novoEmail);
            assertEquals(HttpStatus.OK, resposta.getStatusCode());
        } 
}

    

