package com.indicador.mapfre.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.indicador.mapfre.entity.XxmpfBpmIndEmision;
import com.indicador.mapfre.model.DateModel;;

@Service
public interface NMRService {

	List<String> sectorAll();
	
	List<XxmpfBpmIndEmision> allByFechaFin(DateModel dates);
	
	Integer countBySector(List<XxmpfBpmIndEmision> listEmision, String sector);
	
	List<Object []> allNumMovimientosRealizados(DateModel date);
}
