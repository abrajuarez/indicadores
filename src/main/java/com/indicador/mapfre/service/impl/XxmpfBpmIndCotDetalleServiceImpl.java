package com.indicador.mapfre.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indicador.mapfre.repository.XxmpfBpmIndCotDetalleRepository;
import com.indicador.mapfre.service.XxmpfBpmIndCotDetalleService;

@Service("cotizacionDetalleImpl")
public class XxmpfBpmIndCotDetalleServiceImpl implements XxmpfBpmIndCotDetalleService{

	@Autowired
	private XxmpfBpmIndCotDetalleRepository repository;
	
	@Override
	public List<String> getDistinctAreaByBetween(String dateStart, String dateFinish) {
		return repository.findDistinctAreaByBetween(dateStart, dateFinish);
	}

	@Override
	public Integer countAreaByFechaInicioBetween(String dateStart, String dateFinish, String area) {
       return repository.countAreaByFechaInicioBetween(dateStart, dateFinish, area);
	}

	@Override
	public Integer findAVGTiempoDiasByFechaInicio(String dateStart, String dateFinish, String area) {
		return  repository.findAVGTiempoDiasByFechaInicio(dateStart, dateFinish, area);
	}

}
