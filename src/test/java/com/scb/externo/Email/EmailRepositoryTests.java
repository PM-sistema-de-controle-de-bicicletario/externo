package com.scb.externo.Email;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSender;


@SpringBootTest
public class EmailRepositoryTests {

    JavaMailSender mailSender;
/*
    @Test
    void envio_de_email() throws MessagingException, NotFoundException {
        EmailRepository emailRepository = new EmailRepository();
        NovoEmailDTO novoEmail = new NovoEmailDTO();
        novoEmail.setEmail("luisa.c.correia@edu.unirio.br");
        novoEmail.setMensagem("Esse é o primeiro e-mail enviado para o e-mail institucional da Unirio do projeto SCB.");

        Email email = new Email();
        novoEmail.setEmail("luisa.c.correia@edu.unirio.br");
        novoEmail.setMensagem("Esse é o primeiro e-mail enviado para o e-mail institucional da Unirio do projeto SCB.");

        when(emailRepository.enviarEmail(novoEmail)).thenReturn(new ResponseEntity<Email>(email, HttpStatus.OK));
        ResponseEntity<Email> resBody =  emailRepository.enviarEmail(novoEmail);
        assertEquals(HttpStatus.OK, resBody.getStatusCode());
    } 
*/
}
  

