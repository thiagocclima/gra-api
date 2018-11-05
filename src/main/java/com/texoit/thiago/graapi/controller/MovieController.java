package com.texoit.thiago.graapi.controller;

import java.security.InvalidParameterException;
import java.util.List;

import javax.validation.ValidationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.texoit.thiago.graapi.dto.MovieDTO;
import com.texoit.thiago.graapi.dto.YearWinnerDTO;
import com.texoit.thiago.graapi.service.MovieService;

@RestController
@RequestMapping("/movie")
public class MovieController {
	
	Logger logger = LoggerFactory.getLogger(MovieController.class);
	
	@Autowired
	private MovieService movieService;
	
	@GetMapping("/{year}")
    public ResponseEntity<List<MovieDTO>> getMovies(@PathVariable(name="year") Integer year) {
		List<MovieDTO> movies = movieService.getMoviesByYear(year);
		
		HttpStatus status = HttpStatus.OK;
		if ( movies.isEmpty() ) {
			status = HttpStatus.NO_CONTENT;
		}
		
        return new ResponseEntity<List<MovieDTO>>( movies, status ) ;
    }
	
	/**
	 * @return {@link YearWinnerDTO}
	 */
	@GetMapping("/years")
	public ResponseEntity<YearWinnerDTO> getYearsWithMoreThanOneWinners() {
		YearWinnerDTO dto = movieService.getYearsWithMoreThanOneWinners();
		
		HttpStatus status = HttpStatus.OK;
		if ( dto.getYears().isEmpty() ) {
			status = HttpStatus.NO_CONTENT;
		}
		
		return new ResponseEntity<YearWinnerDTO>( dto, status ) ;
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> removeMovie(@PathVariable(name="id") Long id) {
		try {
			movieService.remove(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (InvalidParameterException e) {
			logger.info(e.getMessage());
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} catch (ValidationException e) {
			logger.info(e.getMessage());
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}

}