package com.texoit.thiago.graapi.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.texoit.thiago.graapi.dto.StudioDTO;
import com.texoit.thiago.graapi.entity.Movie;
import com.texoit.thiago.graapi.entity.MovieStudio;
import com.texoit.thiago.graapi.entity.Studio;
import com.texoit.thiago.graapi.repository.MovieStudioRepository;
import com.texoit.thiago.graapi.repository.StudioRepository;

@Service
public class StudioService {
	
	Logger logger = LoggerFactory.getLogger(StudioService.class);
	
	@Autowired
	private StudioRepository studioRepository;
	
	@Autowired
	private MovieStudioRepository movieStudioRepository;
	
	public void saveStudios(Movie movie, String studios) {
		for (String strStudio : studios.split(",|\\ and ")) {
			Studio studio = new Studio(strStudio.trim());

			Example<Studio> example = Example.of(studio); 

			if (studioRepository.exists(example)) {
				studio = studioRepository.findByName(strStudio.trim());
			} else {
				studio = studioRepository.save(studio);
			}

			movieStudioRepository.save(new MovieStudio(movie, studio));
		}
	}
	
	public StudioDTO getGreatestWinners() {
		return new StudioDTO(studioRepository.findByWinners());
	}

}
