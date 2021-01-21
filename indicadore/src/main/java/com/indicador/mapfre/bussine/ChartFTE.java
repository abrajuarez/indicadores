package com.indicador.mapfre.bussine;

import java.util.List;

import org.springframework.stereotype.Service;

import com.indicador.mapfre.model.ChartCombinationModel;

@Service
public interface ChartFTE {

	List<ChartCombinationModel>createMothCurrent(String sector);
	
	List<ChartCombinationModel>createMothPrevious(String sector);
}
