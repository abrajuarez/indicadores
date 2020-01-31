package com.indicador.mapfre.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indicador.mapfre.entity.CMCentralMedica;
import com.indicador.mapfre.repository.CMCentralMedicaRepository;
import com.indicador.mapfre.service.CMCentralMedicaService;
import com.indicador.mapfre.util.ScriptReportCentralMedica;

@Service
public class CMCentralMedicaServiceImpl implements CMCentralMedicaService {
	
	private static final Logger logger = LogManager.getLogger(CMCentralMedicaServiceImpl.class);

	@Autowired
	private CMCentralMedicaRepository centralRepository;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	String REPORTQUERY = "SELECT cm,sin"
            + " FROM CMCentralMedica cm,"
            + " CMSiniestros sin,"
            + " CMDocumentos doc,"
            + " CMSdaValoracion valoracion,"
            + " CMHonorariosMed honorariosmd,"
            + " CMMedicamentos medicamento,"
            + " CMServicios servicio,"
            + " CMCpt cpt "
            + " WHERE cm.idSolicitud = sin.centralMedica"
            + " AND cm.idSolicitud = doc.centralMedica"
            + " AND cm.idSolicitud = valoracion.centralMedica "
            + " AND sin.idSiniestro = honorariosmd.siniestro"
            + " AND sin.idSiniestro = medicamento.siniestro"
            + " AND sin.idSiniestro = servicio.siniestro"
            + " AND sin.idSiniestro = cpt.siniestro"
            + " AND cm.creationDate >= :dateStart"
            + " AND cm.creationDate <= :dateFinish";
	
	@Override
	public List<Object[]> findAllByCreationDate2(String sector, String fecha) {
		List<Object[]> results = entityManager.createQuery(ScriptReportCentralMedica.REPORTQUERY).getResultList();
		
		return results;
	}
	
	@Override
	public List<CMCentralMedica> findAllByCreationDate(String dateStart, String dateFinish) {
		logger.info("Method:findAllByCreationDate");
		 findAllByCreationDate2("", "");
		 List<CMCentralMedica> l = new ArrayList<CMCentralMedica>();
		 return l;
		//return centralRepository.findByCreationDate(dateStart, dateFinish);
	}

}
