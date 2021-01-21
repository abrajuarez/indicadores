package com.indicador.mapfre.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.indicador.mapfre.entity.XxmpfBpmIndEmision;
import com.indicador.mapfre.service.NFAService;
import com.indicador.mapfre.util.CalendarUtil;
import com.indicador.mapfre.util.DateUtil;

@Service("nfaServiceImpl")
public class NFAServiceImpl implements NFAService{
	
	private static final Logger logger = LogManager.getLogger(NFAServiceImpl.class);
	
	@Autowired
	private EmisionServiceImpl emisionService;

	@PersistenceContext
    private EntityManager entityManager;
	
	@Autowired
	CalendarUtil calendar;
	
	@Override
	public List<String> distincSectorByFechaFin(String dateStart, String dateFinish) {
		logger.info("Method:distincSectorByFechaFin");
		List<String> resultList= entityManager.
			      createQuery("SELECT DISTINCT(emision.sector)  "
			      		     + "FROM XxmpfBpmIndEmision emision INNER JOIN XxmpfBpmIndEmiDetalle detalle"
			      		     + " ON emision.idEmision = detalle.idEmisionFK"
			      		     + " WHERE detalle.estatus != 'En Proceso'  AND"
			      		     + " detalle.area = 'Emisión' AND"
			      		     + " emision.fechaFin > ?1 AND"
			      		     + " emision.fechaFin < ?2")
			                        .setParameter(1, calendar.covertStringToCalendar(dateStart))
			                        .setParameter(2, calendar.covertStringToCalendar(dateFinish)).getResultList();		    
			  return resultList;
		//return emisionService.findDistincSectorByFechaFin(dateStart, dateFinish);
	}

	@Override
	public List<XxmpfBpmIndEmision> allEmisionByFechaFin(String dateStart, String dateFinish) {  
		logger.info("Method:allEmisionByFechaFin");
		
		List<XxmpfBpmIndEmision> query = entityManager.
			      createQuery("SELECT emision  "
			      		+ "FROM XxmpfBpmIndEmision emision INNER JOIN XxmpfBpmIndEmiDetalle detalle "
			      		+ " ON emision.idEmision = detalle.idEmisionFK"
			      		+ " WHERE  detalle.estatus != 'En Proceso' AND"
			      		+ " detalle.area = 'Emisión' AND"
			      		+ " emision.fechaFin > ?1 AND emision.fechaFin < ?2")
			      .setParameter(1, calendar.covertStringToCalendar(dateStart))
                  .setParameter(2, calendar.covertStringToCalendar(dateFinish))
                  .getResultList();
		
		return query;
			   
	//	return emisionService.findAllEmisionByFechaFin(dateStart, dateFinish);
	}
	
	@Override
	public List<Object[]> allEmisionAndDetalleByFechaFin(String dateStart, String dateFinish) {
		logger.info("Method:allEmisionAndDetalleByFechaFin");
		List<Object[]> results = entityManager.
				createQuery("SELECT emision.folio, emision.sector, emision.tipoSolicitud, emision.divisional, emision.regional, "
						          + "emision.oficinaComercial, emision.agente, emision.estatus, emision.motivo, "
						          + "detalle.usuarioAnalista ,detalle.usuarioEmisor, detalle.usuarioSuscriptor, emision.fechaFin"
						+ " FROM XxmpfBpmIndEmision emision, XxmpfBpmIndEmiDetalle detalle"
						+ " WHERE emision.idEmision = detalle.idEmisionFK  AND"
						      + " detalle.area = 'Emisión' AND "
						      + "emision.fechaFin > ?1 AND "
						      + "emision.fechaFin < ?2")
				 .setParameter(1, calendar.covertStringToCalendar(dateStart))
                 .setParameter(2, calendar.covertStringToCalendar(dateFinish)).getResultList();
		return results;
	}

	@Override
	public Integer countBySector(List<XxmpfBpmIndEmision> listEmision, String sector) {
		logger.info("Method:countBySector");
		// TODO Auto-generated method stub
		return emisionService.countBySector(listEmision, sector);
	}

	@Override
	public List<String> distinctStatusByFechaFinAndSector(String dateStart, String dateFinish, String sector) {
		// TODO Auto-generated method stub
		logger.info("Method:distinctStatusByFechaFinAndSector");
		return emisionService.distinctStatusByFechfinAndaSector(dateStart, dateFinish, sector);
	}

	@Override
	public Integer countBySectorAndStatus(List<XxmpfBpmIndEmision> listEmision, String sector, String status) {
		logger.info("Method:countBySectorAndStatus");
		return emisionService.countBySectorAndStatus(listEmision, sector, status);
	}

}
