package com.texoit.thiago.graapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.texoit.thiago.graapi.dto.StudioWinDTO;
import com.texoit.thiago.graapi.entity.Studio;

public interface StudioRepository extends JpaRepository<Studio, Long>{
	
	Studio findByName(String name);
	
	@Query(value="select new com.texoit.thiago.graapi.dto.StudioWinDTO(studio.name, count(movie.winner)) "
			+ "from MovieStudio as ms join ms.movie as movie join ms.studio as studio "
			+ "where movie.winner=true group by studio.name order by 2 desc")
	List<StudioWinDTO> findByWinners();

}
