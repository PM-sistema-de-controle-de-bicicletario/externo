package com.scb.externo.controller;

import java.net.http.HttpHeaders;
import java.util.Map;

import javax.mail.MessagingException;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scb.externo.service.ExternoService;
import com.scb.externo.shared.NovoCartaoDeCreditoDTO;
import com.scb.externo.shared.NovoEmailDTO;



@RestController
@RequestMapping("/api/externo")
public class ExternoController {

	@Autowired
	private ExternoService externoService;

	@PostMapping("/enviarEmail")
	public String enviarEmail(@RequestBody NovoEmailDTO email) throws MessagingException {
		try {
			externoService.enviarEmail(email);
			return "E-mail enviado com sucesso!";
		} catch (Exception e) {
			e.printStackTrace();
			return "Falha ao enviar e-mail. ";
		}

	}

	@PostMapping("/validaCartaoDeCredito")
	public ResponseEntity<JSONObject> validarCartao(@RequestHeader Map<String, String> headers, @RequestBody NovoCartaoDeCreditoDTO novoCartao) {
		System.out.println(headers);
		return externoService.validarCartao(headers, novoCartao);
	}
}