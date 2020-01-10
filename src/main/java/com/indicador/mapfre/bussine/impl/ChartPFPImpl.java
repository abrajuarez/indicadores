package com.indicador.mapfre.bussine.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indicador.mapfre.bussine.ChartPFP;
import com.indicador.mapfre.model.ChartModel;
import com.indicador.mapfre.service.PFPService;
import com.indicador.mapfre.util.PercentageUtil;

@Service
public class ChartPFPImpl implements ChartPFP{
	
	private static final Logger logger = LogManager.getLogger(ChartPFPImpl.class);

	@Autowired
	PFPService pfpService;
	
	@Autowired
	PercentageUtil porcentajeUtil;
	
	@Override
	public List<ChartModel> chart(){
		List<String>listSector = pfpService.distinctSector();
		List<Object[]> listEmision = pfpService.allFoliosPendiente();
		List<ChartModel>listChart = new ArrayList<ChartModel>();
		int numTotal = listEmision.size();
		if(listSector.size() == 0) {
			listChart.add(new ChartModel(1, "No hay folios pendientes", 100d));
			logger.info("Method: chart  no hay datos");
		}else {
		for(int i = 0; i < listSector.size(); i++) {
			String name = listSector.get(i);
			int numDatos = pfpService.countSector(listEmision, name);
			String porcentaje = porcentajeUtil.porcentaje(numTotal, numDatos);
			double y = Double.parseDouble(porcentaje);
			listChart.add(new ChartModel(i, name, y));
			logger.info("Method: chart addList [ i ="+i+" name = "+name+" y = "+porcentaje);
		}
	}
		
		return listChart;
	}
}
