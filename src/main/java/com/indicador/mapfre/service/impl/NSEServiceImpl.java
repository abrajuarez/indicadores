package com.indicador.mapfre.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indicador.mapfre.entity.XxmpfBpmIndEmision;
import com.indicador.mapfre.repository.XxmpfBpmIndEmisionRepository;
import com.indicador.mapfre.service.NSEService;
import com.indicador.mapfre.util.CalendarUtil;
import com.indicador.mapfre.util.DateUtil;

@Service
public class NSEServiceImpl  implements NSEService{

	@Autowired
	XxmpfBpmIndEmisionRepository emision;
	
	@Autowired
	CalendarUtil calendarUtil;
	
	@Override
	public List<String> findAllSectores() {
		return emision.distinctSector();
	}

	@Override
	public List<XxmpfBpmIndEmision> findAllAtendidos(String dateStart, String dateFinish) {
		// TODO Auto-generated method stub
		return emision.findAllByAreaAndFechaFin(calendarUtil.covertStringToCalendar(dateStart), calendarUtil.covertStringToCalendar(dateFinish)).stream().filter(detalle-> !detalle.getEstatus().equals("Pendiente")).collect(Collectors.toList());
	}

	@Override
	public List<XxmpfBpmIndEmision> findAllRecibidos(String dateStart, String dateFinish) {
		return emision.findAllByAreaAndFechaInicio(calendarUtil.covertStringToCalendar(dateStart), calendarUtil.covertStringToCalendar(dateFinish));
	}
	
	@Override
	public List<XxmpfBpmIndEmision> findAllAtiempo(String dateStart, String dateFinish) {
		return emision.findAllByAreaAndFechaFinAndAtiempo(calendarUtil.covertStringToCalendar(dateStart), calendarUtil.covertStringToCalendar(dateFinish));
	}

}
