package com.texoit.thiago.graapi.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.texoit.thiago.graapi.dto.ProducerMinMaxPrizesDTO;
import com.texoit.thiago.graapi.entity.Movie;
import com.texoit.thiago.graapi.entity.MovieProducer;
import com.texoit.thiago.graapi.entity.Producer;
import com.texoit.thiago.graapi.repository.MovieProducerRepository;
import com.texoit.thiago.graapi.repository.ProducerRepository;

@Service
public class ProducerService {
	
	Logger logger = LoggerFactory.getLogger(ProducerService.class);
	
	@Autowired
	private ProducerRepository producerRepository;
	
	@Autowired
	private MovieProducerRepository movieProducerRepository;
	
	public void saveProducers(Movie movie, String producers) {
		for (String strProducer : producers.split(",|\\ and ")) {
			Producer producer = new Producer(strProducer.trim());
			
			Example<Producer> example = Example.of(producer); 
			
			if (producerRepository.exists(example)) {
				producer = producerRepository.findByName(strProducer.trim());
			} else {
				producer = producerRepository.save(producer);
			}
			
			movieProducerRepository.save(new MovieProducer(movie, producer));
		}
	}
	
	public ProducerMinMaxPrizesDTO getMaxAndMinPrizes() {
		return new ProducerMinMaxPrizesDTO(producerRepository.findMaxAndMinProducerPrizesOrderedByInterval());
	}
	
}
