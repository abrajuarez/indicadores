package com.indicador.mapfre.bussine.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indicador.mapfre.bussine.ChartTPM;
import com.indicador.mapfre.model.ChartBarraPorcentajeModel;
import com.indicador.mapfre.service.TPMService;
import com.indicador.mapfre.service.impl.TPMServiceImpl;

@Service
public class ChartTpmImpl  implements ChartTPM{
	
	private static final Logger logger = LogManager.getLogger(ChartTpmImpl.class);

	@Autowired
	private TPMService service;
	
	public List<ChartBarraPorcentajeModel> create(){
		List<String> sector = service.sectores();
		List<ChartBarraPorcentajeModel> chart = new ArrayList<ChartBarraPorcentajeModel>();
		List<BigDecimal> data = new ArrayList<BigDecimal>();
		
		for(int i = 0; i<sector.size(); i++) {
			BigDecimal result = service.truncTiempoActividadBySector(sector.get(i));
			logger.info("Method: create add [ sector = "+sector.get(i)+", tiempo = "+result);
		data.add(result);	
		}
		chart.add(new ChartBarraPorcentajeModel(sector, "", data));
		return chart;
	}
}
