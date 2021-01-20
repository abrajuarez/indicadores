package com.indicador.mapfre.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indicador.mapfre.repository.XxmpfBpmIndCotizacionRepository;
import com.indicador.mapfre.service.CotizacionService;
import com.indicador.mapfre.util.CalendarUtil;
import com.indicador.mapfre.util.DateUtil;

@Service("cotizacionServiceImpl")
public class CotizacionServiceImpl implements CotizacionService {

	@Autowired
	private XxmpfBpmIndCotizacionRepository repository;
	
	
	@Autowired
	CalendarUtil calendarUtil;


@Override
	public List<String> findDistinctSectorByFechaInicio(String dateStart, String dateFinish, String status) {
		return repository.findDistinctSectorByFechaInicio(calendarUtil.covertStringToCalendar(dateStart), calendarUtil.covertStringToCalendar(dateFinish), status);
	}

	@Override
	public Integer countSectorByFechaInicioBetween(String dateStart, String dateFinish, String status, String sector) {
		return repository.countSectorByFechaInicioBetween(calendarUtil.covertStringToCalendar(dateStart), calendarUtil.covertStringToCalendar(dateFinish),status, sector);
	}

	@Override
	public List<String> findDistinctAgenteByFechaInicio(String dateStart, String dateFinish, String status) {
		// TODO Auto-generated method stub
		return repository.findDistinctAgenteByFechaInicio(calendarUtil.covertStringToCalendar(dateStart), calendarUtil.covertStringToCalendar(dateFinish), status);
	}

	@Override
	public Integer countAgenteByFechaInicioBetween(String dateStart, String dateFinish, String status, String agente) {
		// TODO Auto-generated method stub
		return repository.countAgenteByFechaInicioBetween(calendarUtil.covertStringToCalendar(dateStart), calendarUtil.covertStringToCalendar(dateFinish), status, agente);
	}

	@Override
	public List<String> distinctSectorByDevolucionesAndFechaInicio(String dateStart, String dateFinish) {
		// TODO Auto-generated method stub
		return repository.distinctSectorByDevolucionesAndFechaInicio(calendarUtil.covertStringToCalendar(dateStart), calendarUtil.covertStringToCalendar(dateFinish));
	}

	@Override
	public int countRecotizacionBySectorAndFechaInicio(String dateStart, String dateFinish, String sector) {
		return repository.countRetrabajoDevolucionBySectorAndFechaInicio(calendarUtil.covertStringToCalendar(dateStart), calendarUtil.covertStringToCalendar(dateFinish), sector);
	}

	@Override
	public List<String> distinctSectorByRecotizacionAndFechaInicio(String dateStart, String dateFinish) {
		// TODO Auto-generated method stub
		return repository.distinctSectorByRecotizacionAndFechaInicio(calendarUtil.covertStringToCalendar(dateStart), calendarUtil.covertStringToCalendar(dateFinish));
	}

	@Override
	public int countRetrabajoRecotizacionBySectorAndFechaInicio(String dateStart, String dateFinish, String sector) {
		// TODO Auto-generated method stub
		return repository.countRetrabajoRecotizacionBySectorAndFechaInicio(calendarUtil.covertStringToCalendar(dateStart), calendarUtil.covertStringToCalendar(dateFinish), sector);
	}

	@Override
	public List<String> distinctAgenteByRecotizacionAndFechaInicio(String dateStart, String dateFinish) {
		// TODO Auto-generated method stub
		return repository.distinctAgenteByRecotizacionAndFechaInicio(calendarUtil.covertStringToCalendar(dateStart), calendarUtil.covertStringToCalendar(dateFinish));
	}

	@Override
	public int countRetrabajoRecotizacionAgenteBySectorAndFechaInicio(String dateStart, String dateFinish,
			String agente) {
		// TODO Auto-generated method stub
		return repository.countRetrabajoRecotizacionAgenteBySectorAndFechaInicio(calendarUtil.covertStringToCalendar(dateStart), calendarUtil.covertStringToCalendar(dateFinish), agente);
	}

	@Override
	public List<String> distinctAgenteByDevolucionesAndFechaInicio(String dateStart, String dateFinish) {
		// TODO Auto-generated method stub
		return repository.distinctAgenteByDevolucionesAndFechaInicio(calendarUtil.covertStringToCalendar(dateStart), calendarUtil.covertStringToCalendar(dateFinish));
	}

	@Override
	public int countRetrabajoDevolucionAgenteBySectorAndFechaInicio(String dateStart, String dateFinish,
			String agente) {
		// TODO Auto-generated method stub
		return repository.countRetrabajoDevolucionAgenteBySectorAndFechaInicio(calendarUtil.covertStringToCalendar(dateStart), calendarUtil.covertStringToCalendar(dateFinish), agente);
	}

}
