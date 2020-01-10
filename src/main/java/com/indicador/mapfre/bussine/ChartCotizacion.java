package com.indicador.mapfre.bussine;

import org.springframework.stereotype.Service;

import com.indicador.mapfre.model.AreaTable;
import com.indicador.mapfre.model.ChartModel;
import com.indicador.mapfre.model.CotizacionModel;
import com.indicador.mapfre.model.DetalleCotizacionModel;
import com.indicador.mapfre.model.Retrabajo;

import java.util.List;

@Service
public interface ChartCotizacion {
	
	public List<CotizacionModel> drawTables();
	public List<ChartModel> drawChartModel();
	public List<CotizacionModel> drawChart();
	public List<CotizacionModel> drawChart(List<String> listEstatus);
	List<ChartModel> drawChartModel(String dateStart, String dateFinish);
	public List<CotizacionModel> chartByDate(String dateStart, String dateFinish);
	public List<Retrabajo> listRetrabajoByDateStart(String dateStart, String dateFinish);
	public Integer drawTableProcesos(String dateStart, String dateFinish);
	public List<AreaTable> drawTableArea(String dateStart, String dateFinish);
	public List<CotizacionModel> drawTableNoAceptado(String dateStart, String dateFinish, String containStatus);
	
	public List<CotizacionModel> drawTableMotivo(String dateStart, String dateFinish, String containStatus);
	
	public List<CotizacionModel> drawTableNoAceptado(String dateStart, String dateFinish);
	
	public List<ChartModel> drawChartSector(DetalleCotizacionModel detallemodel);
	
	public List<ChartModel> drawChartAgente(DetalleCotizacionModel detallemodel);
	
	public List<ChartModel> drawChartretrabajoSector(DetalleCotizacionModel detallemodel);
	
	public List<ChartModel> drawChartretrabajoAgente(DetalleCotizacionModel detallemodel);
}
