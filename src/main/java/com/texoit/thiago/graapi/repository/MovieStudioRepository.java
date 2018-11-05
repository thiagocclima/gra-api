package com.texoit.thiago.graapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.texoit.thiago.graapi.entity.MovieStudio;
import com.texoit.thiago.graapi.entity.MovieStudioId;

public interface MovieStudioRepository extends JpaRepository<MovieStudio, MovieStudioId>{

}
