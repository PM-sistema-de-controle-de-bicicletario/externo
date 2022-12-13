package com.scb.externo.service;

import java.net.http.HttpHeaders;
import java.util.Map;

import javax.mail.MessagingException;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.scb.externo.repository.ExternoRepository;
import com.scb.externo.shared.NovoCartaoDeCreditoDTO;
import com.scb.externo.shared.NovoEmailDTO;

@Service
public class ExternoService {

    @Autowired
    private ExternoRepository externoRepository;
    
	public void enviarEmail(NovoEmailDTO email) throws MessagingException{
            externoRepository.enviarEmail(email);
	}

	public ResponseEntity<JSONObject> validarCartao(Map<String, String> headers , NovoCartaoDeCreditoDTO novoCartao) {
       return externoRepository.validarCartao(headers, novoCartao);
	}
}
