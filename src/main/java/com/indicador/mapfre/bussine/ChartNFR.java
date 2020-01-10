package com.indicador.mapfre.bussine;

import java.util.List;

import org.springframework.stereotype.Service;

import com.indicador.mapfre.model.ChartBarraModel;

@Service("chartNFR")
public interface ChartNFR {

	List<ChartBarraModel> drawChartBarraSimple(String dateStart, String dateFinish);
	
}
