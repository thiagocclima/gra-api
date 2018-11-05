package com.texoit.thiago.graapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.texoit.thiago.graapi.entity.MovieProducer;
import com.texoit.thiago.graapi.entity.MovieProducerId;

public interface MovieProducerRepository extends JpaRepository<MovieProducer, MovieProducerId> {

}
