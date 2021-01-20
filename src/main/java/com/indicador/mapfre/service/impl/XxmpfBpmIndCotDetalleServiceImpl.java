package com.indicador.mapfre.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indicador.mapfre.repository.XxmpfBpmIndCotDetalleRepository;
import com.indicador.mapfre.service.XxmpfBpmIndCotDetalleService;
import com.indicador.mapfre.util.CalendarUtil;
import com.indicador.mapfre.util.DateUtil;

@Service("cotizacionDetalleImpl")
public class XxmpfBpmIndCotDetalleServiceImpl implements XxmpfBpmIndCotDetalleService{

	@Autowired
	private XxmpfBpmIndCotDetalleRepository repository;
	
	@Autowired
	CalendarUtil calendarUtil;
	
	@Override
	public List<String> getDistinctAreaByBetween(String dateStart, String dateFinish) {
		return repository.findDistinctAreaByBetween(calendarUtil.covertStringToCalendar(dateStart), calendarUtil.covertStringToCalendar(dateFinish));
	}

	@Override
	public Integer countAreaByFechaInicioBetween(String dateStart, String dateFinish, String area) {
       return repository.countAreaByFechaInicioBetween(calendarUtil.covertStringToCalendar(dateStart), calendarUtil.covertStringToCalendar(dateFinish), area);
	}

	@Override
	public Integer findAVGTiempoDiasByFechaInicio(String dateStart, String dateFinish, String area) {
		return  repository.findAVGTiempoDiasByFechaInicio(calendarUtil.covertStringToCalendar(dateStart), calendarUtil.covertStringToCalendar(dateFinish), area);
	}

}
