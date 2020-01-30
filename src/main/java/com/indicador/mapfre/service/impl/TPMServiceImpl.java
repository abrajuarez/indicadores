package com.indicador.mapfre.service.impl;

import java.math.BigDecimal;
import java.util.List;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.indicador.mapfre.repository.XxmpfBpmIndEmiDetalleRepository;
import com.indicador.mapfre.repository.XxmpfBpmIndEmisionRepository;
import com.indicador.mapfre.service.TPMService;

@Service
public class TPMServiceImpl implements TPMService {
	
	private static final Logger logger = LogManager.getLogger(TPMServiceImpl.class);

	@Autowired
	XxmpfBpmIndEmisionRepository emisionRepository;

	@Autowired
	XxmpfBpmIndEmiDetalleRepository detalleRepository;

	@Override
	public BigDecimal truncTiempoActividadBySector(String sector) {
		return detalleRepository.truncTiempoActividadBySector(sector);
	}

	@Override
	public List<String> sectores() {
		return emisionRepository.distinctSector();
	}

}
