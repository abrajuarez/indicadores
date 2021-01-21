package com.indicador.mapfre.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;



@Service
public interface TPMService {

	 BigDecimal truncTiempoActividadBySector(String sector) ;
	 
	 List<String> sectores();
}
