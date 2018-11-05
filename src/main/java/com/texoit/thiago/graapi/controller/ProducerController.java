package com.texoit.thiago.graapi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.texoit.thiago.graapi.dto.ProducerMinMaxPrizesDTO;
import com.texoit.thiago.graapi.service.ProducerService;

@RestController
@RequestMapping("producer")
public class ProducerController {
	
	Logger logger = LoggerFactory.getLogger(ProducerController.class);
	
	@Autowired
	private ProducerService producerService;
	
	@GetMapping("interval-prizes")
	public ResponseEntity<ProducerMinMaxPrizesDTO> getMaxAndMinPrizes() {
		ProducerMinMaxPrizesDTO dto = producerService.getMaxAndMinPrizes();
		
		HttpStatus status = HttpStatus.OK;
		if ( dto.getMax().isEmpty() && dto.getMin().isEmpty() ) {
			status = HttpStatus.NO_CONTENT;
		}
		
		return new ResponseEntity<ProducerMinMaxPrizesDTO>(dto, status);
	}

}
