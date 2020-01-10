package com.indicador.mapfre.bussine.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indicador.mapfre.bussine.ChartTPM;
import com.indicador.mapfre.model.ChartBarraPorcentajeModel;
import com.indicador.mapfre.service.TPMService;

@Service
public class ChartTpmImpl  implements ChartTPM{

	@Autowired
	TPMService service;
	
	public List<ChartBarraPorcentajeModel> create(){
		List<String> sector = service.sectores();
		List<ChartBarraPorcentajeModel> chart = new ArrayList<ChartBarraPorcentajeModel>();
		List<BigDecimal> data = new ArrayList<BigDecimal>();
		
		for(int i = 0; i<sector.size(); i++) {
		data.add(service.truncTiemoActividadBySector(sector.get(i)));	
		}
		chart.add(new ChartBarraPorcentajeModel(sector, "", data));
		return chart;
	}
}
