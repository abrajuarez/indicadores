package com.indicador.mapfre.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indicador.mapfre.entity.XxmpfBpmIndEmision;
import com.indicador.mapfre.model.DateModel;
import com.indicador.mapfre.repository.XxmpfBpmIndEmisionRepository;
import com.indicador.mapfre.service.EmisionService;
import com.indicador.mapfre.service.NMRService;
import com.indicador.mapfre.util.CalendarUtil;
import com.indicador.mapfre.util.DateUtil;

@Service
public class NMRServiceImpl implements NMRService{
	
	@PersistenceContext
    private EntityManager entityManager;

	@Autowired
	private XxmpfBpmIndEmisionRepository repository;
	
	@Autowired
	private EmisionService emisionService;
	
	@Autowired
	CalendarUtil calendarUtil;
	
	
	@Override
	public List<String> sectorAll() {
		// TODO Auto-generated method stub
		return repository.distinctSector();
	}

	@Override
	public List<XxmpfBpmIndEmision> allByFechaFin(DateModel dates){
		return repository.findAllByAreaAndEstatusAndFechaFin(calendarUtil.covertStringToCalendar(dates.getDateStart()), calendarUtil.covertStringToCalendar(dates.getDateFinish()));
	}
	 
	@Override
	public Integer countBySector(List<XxmpfBpmIndEmision> listEmision, String sector) {
		// TODO Auto-generated method stub
		return emisionService.countBySector(listEmision, sector);
	}
	
	@Override
	public List<Object []> allNumMovimientosRealizados(DateModel date){
		List<Object[]> results = entityManager.
				createQuery("SELECT emision.folio, emision.sector, emision.tipoSolicitud, emision.divisional, emision.regional, "
						          + "emision.oficinaComercial, emision.agente, emision.estatus, emision.motivo, "
						          + "detalle.usuarioAnalista ,detalle.usuarioEmisor, detalle.usuarioSuscriptor, emision.fechaFin"
						+ " FROM XxmpfBpmIndEmision emision, XxmpfBpmIndEmiDetalle detalle"
						+ " WHERE emision.idEmision = detalle.idEmisionFK  AND"
						      + " detalle.area = 'Emisión' AND "
						      + " detalle.estatus = 'Emitido' AND"
						      + " emision.estatus = 'Emitido' AND"
						      + " emision.fechaFin  > ?1 AND"
						      + " emision.fechaFin  < ?2"
						     ).setParameter(1, calendarUtil.covertStringToCalendar(date.getDateStart()))
				              .setParameter(2, calendarUtil.covertStringToCalendar(date.getDateFinish())).getResultList();
		return results;
	}

}
