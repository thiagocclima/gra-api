package com.texoit.thiago.graapi.dto;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ProducerMinMaxPrizesDTO {
	
	private List<ProducerPrizesDTO> min = new ArrayList<>();
	
	private List<ProducerPrizesDTO> max = new ArrayList<>();
	
	public ProducerMinMaxPrizesDTO (LinkedList<ProducerPrizesDTO> lista) {
		this.min.add(lista.getFirst());
		this.max.add(lista.getLast());
	}

	public List<ProducerPrizesDTO> getMin() {
		return min;
	}

	public void setMin(List<ProducerPrizesDTO> min) {
		this.min = min;
	}

	public List<ProducerPrizesDTO> getMax() {
		return max;
	}

	public void setMax(List<ProducerPrizesDTO> max) {
		this.max = max;
	}

}
