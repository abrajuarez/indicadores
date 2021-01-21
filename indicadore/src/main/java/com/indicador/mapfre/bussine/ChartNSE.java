package com.indicador.mapfre.bussine;

import java.util.List;

import org.springframework.stereotype.Service;

import com.indicador.mapfre.model.ChartBarraPorcentajeModel;
import com.indicador.mapfre.model.DateModel;

@Service
public interface ChartNSE {
	
	List<ChartBarraPorcentajeModel> chartFilterFecha(DateModel datemodel);

}
