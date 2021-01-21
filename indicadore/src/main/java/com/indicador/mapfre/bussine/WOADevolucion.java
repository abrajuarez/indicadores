package com.indicador.mapfre.bussine;

import java.util.List;

import org.springframework.stereotype.Service;

import com.indicador.mapfre.model.ChartModel;

@Service
public interface WOADevolucion {

	List<ChartModel> mesActual(String selectParam, String estatus);
	
	List<ChartModel> mesActualAnalista(String selectParam, String estatus);
	
	List<ChartModel> mesAnterior(String selectParam, String estatus);
	
	List<ChartModel> mesAnteriorAnalista(String selectParam, String estatus);
	
}
