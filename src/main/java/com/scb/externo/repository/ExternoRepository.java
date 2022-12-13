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
		JSONObject teste = new JSONObject();
		teste.put("number_token", "dfe05208b105578c070f806c80abd3af09e246827d29b866cf4ce16c205849977c9496cbf0d0234f42339937f327747075f68763537b90b31389e01231d4d13c");
		teste.put("expiration_month", "12");
		teste.put("expiration_year", "28");

	//	HttpEntity<JSONObject> entity = new HttpEntity<>(teste, headers);

	//	ResponseEntity<JSONObject> res = new RestTemplate().postForEntity(uri, entity, JSONObject.class);
		
	//	System.out.println(res);
		
		return null;
	}    
}
