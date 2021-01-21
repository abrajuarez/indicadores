package com.indicador.mapfre.service.impl;

import java.util.List;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indicador.mapfre.entity.XxmpfBpmIndEmision;
import com.indicador.mapfre.repository.XxmpfBpmIndEmisionRepository;
import com.indicador.mapfre.service.NFRService;
import com.indicador.mapfre.util.CalendarUtil;
import com.indicador.mapfre.util.DateUtil;

@Service("nfrServiceImpl")
public class NFRServiceImpl implements NFRService {
	
	private static final Logger logger = LogManager.getLogger(NFRServiceImpl.class);

	@Autowired
	private XxmpfBpmIndEmisionRepository emisionRepository;
	
	@Autowired
	private EmisionServiceImpl emisionService;
	
	@Autowired
	CalendarUtil calendarUtil;

	@Override
	public List<String> findSectorByFechaInicio(String dateStart, String dateFinish) {
		// TODO Auto-generated method stub
		logger.info("Method findSectorByFechaInicio param [ "+dateStart+" - "+dateFinish);
		return emisionService.findDistincSectorByFechaInicio(dateStart, dateFinish);
	}

	@Override
	public List<XxmpfBpmIndEmision> findAllEmisionByFechaInicio(String dateStart, String dateFinish) {
	 logger.info("Method findAllEmisionByFechaInicio param [ "+dateStart+" - "+dateFinish);
	                            
		return emisionRepository.findAllByFechaFinAndEstatusEmision(calendarUtil.covertStringToCalendar(dateStart), calendarUtil.covertStringToCalendar(dateFinish));
	}

	@Override
	public Integer countBySectorAndFechaInicioBetween(List<XxmpfBpmIndEmision>  listEmision, String sector) {
		logger.info("Method countBySectorAndFechaInicioBetween ");
		return emisionService.countBySector(listEmision, sector);
	}
	
	

}
