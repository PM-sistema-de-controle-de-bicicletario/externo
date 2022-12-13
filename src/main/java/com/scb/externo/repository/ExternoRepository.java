package com.scb.externo.repository;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.scb.externo.shared.NovoCartaoDeCreditoDTO;
import com.scb.externo.shared.NovoEmailDTO;

import io.swagger.models.HttpMethod;

import java.net.http.HttpHeaders;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Repository
public class ExternoRepository {

	@Autowired
    private JavaMailSender mailSender;

	public void enviarEmail(NovoEmailDTO email) throws MessagingException{
		MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");

        helper.setFrom("luisakcorreia@gmail.com");
        helper.setSubject("Testando e-mail SCB");
        helper.setText(email.getMensagem(), true);
        helper.setTo(email.getEmail());
        
        mailSender.send(mimeMessage);
	}

	public ResponseEntity<JSONObject> validarCartao(Map<String, String> headers, NovoCartaoDeCreditoDTO novoCartao) {

		String uri = "https://api-sandbox.getnet.com.br/v1/cards/verification";

		ResponseEntity<JSONObject> res = new RestTemplate().postForEntity(uri, novoCartao, JSONObject.class);
		
		System.out.println(res);
		
		return res;
	}    
}
