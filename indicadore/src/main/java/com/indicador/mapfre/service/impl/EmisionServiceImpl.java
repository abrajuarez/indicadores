package com.indicador.mapfre.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indicador.mapfre.entity.XxmpfBpmIndEmision;
import com.indicador.mapfre.repository.XxmpfBpmIndEmisionRepository;
import com.indicador.mapfre.service.EmisionService;
import com.indicador.mapfre.util.CalendarUtil;
import com.indicador.mapfre.util.DateUtil;

@Service("emisionServiceImpl")
public class EmisionServiceImpl implements EmisionService {

	private static final Logger logger = LogManager.getLogger(EmisionServiceImpl.class);

	@Autowired
	private XxmpfBpmIndEmisionRepository emisionRepository;
	
	@PersistenceContext
    private EntityManager entityManager;
	
	@Autowired
	CalendarUtil calendarUtil;


	@Override
	public List<String> findDistincSectorByFechaInicio(String dateStart, String dateFinish) { // TODO Auto-generated
																								// method stub
		return emisionRepository.distinctSectorByFechaInicio(calendarUtil.covertStringToCalendar(dateStart), calendarUtil.covertStringToCalendar(dateFinish));
	}

	@Override
	public List<XxmpfBpmIndEmision> findAllEmisionByFechaInicio(String dateStart, String dateFinish) {
		logger.info("Method findAllEmisionByFechaInicio param [ " + dateStart + " - " + dateFinish);
		return emisionRepository.findAllEmisionByFechaInicio(calendarUtil.covertStringToCalendar(dateStart), calendarUtil.covertStringToCalendar(dateFinish));
	}

	@Override
	public List<String> findDistincSectorByFechaFin(String dateStart, String dateFinish) {
		// TODO Auto-generated method stub
		return emisionRepository.distinctSectorByFechaFin(calendarUtil.covertStringToCalendar(dateStart), calendarUtil.covertStringToCalendar(dateFinish));
	}

	@Override
	public List<XxmpfBpmIndEmision> findAllEmisionByFechaFin(String dateStart, String dateFinish) {
		// TODO Auto-generated method stub
		return emisionRepository.findAllEmisionByFechaFin(calendarUtil.covertStringToCalendar(dateStart), calendarUtil.covertStringToCalendar(dateFinish));
	}

	@Override
	public Integer countBySector(List<XxmpfBpmIndEmision> listEmision, String sector) {
		logger.info(
				"Method countBySector param[ listEmision.size = " + listEmision.size() + " Sector = " + sector + " ]");
		Long count = 0L;
		if (sector == null) {
			count = listEmision.stream().filter(emision -> emision.getSector() == null).count();
		} else {
			count = listEmision.stream().filter(emision -> emision.getSector().equals(sector)).count();
		}
		logger.info("Method: countBySector return  [ listEmision = "+listEmision.size()+", sector = "+sector+", count = "+count+" ]");
		return count.intValue();
	}

	@Override
	public List<String> distinctStatusByFechfinAndaSector(String dateStart, String dateFinish, String sector) {
		return emisionRepository.distinctStatusByFechaFinAndSector(calendarUtil.covertStringToCalendar(dateStart), calendarUtil.covertStringToCalendar( dateFinish), sector);
	}

	@Override
	public Integer countBySectorAndStatus(List<XxmpfBpmIndEmision> listEmision, String sector, String status) {
		Long count = listEmision.stream()
				.filter(emision -> emision.getSector().equals(sector) && emision.getEstatus().equals(status)).count();
		return count.intValue();
	}
	
	@Override
	public List<Object []> allByEstatus(String status){
		List<Object[]> results = entityManager.
				createQuery("SELECT emision.folio, emision.sector, emision.tipoSolicitud, emision.divisional, emision.regional, "
						          + "emision.oficinaComercial, emision.agente, emision.estatus, emision.motivo, "
						          + "detalle.usuarioAnalista ,detalle.usuarioEmisor, detalle.usuarioSuscriptor, emision.fechaFin"
						+ " FROM XxmpfBpmIndEmision emision, XxmpfBpmIndEmiDetalle detalle"
						+ " WHERE emision.idEmision = detalle.idEmisionFK  AND"
						      + " detalle.area = 'Emisión' AND "
						      + " detalle.estatus = '"+status+"'"
						     ).getResultList();
		return results;
	}
	
	@Override
	public Integer countSector( List<Object[]> listEmision, String sector, int indexSector) {
		//int count = 0;
		
		Long count = listEmision.stream().filter(emision-> emision[indexSector].toString().equals(sector)).count();
		return count.intValue();
		/*for(Object[] emsion :listEmision ) {
			if((emsion[indexSector].toString()).equals(sector)) {
				count++;
			}
		}
		logger.info("Method countSector count = "+count+" sector = "+sector);
		return count*/
	}
}
