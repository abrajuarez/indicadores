package com.indicador.mapfre.bussine;

import java.util.List;

import org.springframework.stereotype.Service;

import com.indicador.mapfre.model.ChartBarraModel;
import com.indicador.mapfre.model.DetalleCotizacionModel;

@Service("chartNFAService")
public interface ChartNFA {

	public List<ChartBarraModel> drawChart(String dateStart, String dateFinish);
	
	public List<ChartBarraModel> drawChartStatus(DetalleCotizacionModel detallemodel);
}
