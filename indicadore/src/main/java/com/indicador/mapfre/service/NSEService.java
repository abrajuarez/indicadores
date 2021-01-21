package com.indicador.mapfre.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.indicador.mapfre.entity.XxmpfBpmIndEmision;

@Service
public interface NSEService {

	List<String> findAllSectores();
	
	List<XxmpfBpmIndEmision> findAllAtendidos(String dateStart,String dateFinish);
	
	List<XxmpfBpmIndEmision> findAllRecibidos(String dateStart,String dateFinish);
	
	 List<XxmpfBpmIndEmision> findAllAtiempo(String dateStart, String dateFinish);
}
