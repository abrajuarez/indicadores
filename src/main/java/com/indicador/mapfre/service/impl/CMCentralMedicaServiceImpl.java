package com.indicador.mapfre.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indicador.mapfre.entity.CMCentralMedica;
import com.indicador.mapfre.repository.CMCentralMedicaRepository;
import com.indicador.mapfre.service.CMCentralMedicaService;

@Service
public class CMCentralMedicaServiceImpl implements CMCentralMedicaService {
	
	private static final Logger logger = LogManager.getLogger(CMCentralMedicaServiceImpl.class);

	@Autowired
	private CMCentralMedicaRepository centralRepository;
	
	@Override
	public List<CMCentralMedica> findAllByCreationDate(String dateStart, String dateFinish) {
		logger.info("Method:findAllByCreationDate");
		return centralRepository.findByCreationDate(dateStart, dateFinish);
	}

}
