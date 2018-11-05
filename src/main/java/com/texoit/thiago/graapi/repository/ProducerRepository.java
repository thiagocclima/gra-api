package com.texoit.thiago.graapi.repository;

import java.util.LinkedList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.texoit.thiago.graapi.dto.ProducerPrizesDTO;
import com.texoit.thiago.graapi.entity.Producer;

public interface ProducerRepository extends JpaRepository<Producer, Long> {
	
	Producer findByName(String name);
	
	@Query(value="select new com.texoit.thiago.graapi.dto.ProducerPrizesDTO(producer.name, max(movie.year)-min(movie.year), min(movie.year), max(movie.year)) "
			+ "from MovieProducer as mp join mp.movie as movie join mp.producer as producer "
			+ "where movie.winner = true group by producer.name having max(movie.year)-min(movie.year) > 0 "
			+ "order by 2")
	LinkedList<ProducerPrizesDTO> findMaxAndMinProducerPrizesOrderedByInterval();

}
