package com.texoit.thiago.graapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.texoit.thiago.graapi.entity.Producer;

public interface ProducerRepository extends JpaRepository<Producer, Long> {
	
	Producer findByName(String name);
	
}
