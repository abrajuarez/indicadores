package com.indicador.mapfre.bussine.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indicador.mapfre.bussine.ChartFTE;
import com.indicador.mapfre.model.ChartCombinationModel;
import com.indicador.mapfre.service.FTEService;

@Service
public class ChartFTEImpl implements ChartFTE {

	private static final Logger logger = LogManager.getLogger(ChartFTEImpl.class);

	@Autowired
	FTEService service;

	public List<ChartCombinationModel> createMothCurrent(String sector) {
		logger.info("Method: createMothCurren param [sector " + sector);
		return recorrer(service.getFoliosMesActual(sector));
	}

	public List<ChartCombinationModel> createMothPrevious(String sector) {
		logger.info("Method: createMothPrevious param [sector " + sector);
		return recorrer(service.getFoliosMesPasado(sector));
	}

	private List<ChartCombinationModel> recorrer(List<Object[]> listMes) {
		List<ChartCombinationModel> chart = new ArrayList<ChartCombinationModel>();
		
		List<Integer> dataCount = new ArrayList<Integer>();
		List<Integer> dataSum = new ArrayList<Integer>();
		List<String> categories = new ArrayList<String>();
		
		logger.info("Method: recorrer size " + listMes.size());
		if (listMes.size() > 0) {
			for (Object[] emision : listMes) {
				Integer count = Integer.parseInt(emision[0].toString());
				Integer sum = Integer.parseInt(emision[1].toString());
				String categorias = emision[2].toString();
				dataCount.add(count);
				dataSum.add(sum);
				categories.add(categorias);
				logger.info("Method: recorrer add[ count = " + count + ", sum = " + sum + ", categoria = " + categorias);
			}
			
		} else {
			logger.info("Method: recorrer no hay datos" );
			dataCount.add(0);
			dataSum.add(0);
			//categories.add("no hay datos");
		}
		chart.add(new ChartCombinationModel("", "column", "RED", dataCount, categories));
		chart.add(new ChartCombinationModel("", "column", "BLUE", dataSum, categories));
		return chart;
	}
}
