package com.indicador.mapfre.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.indicador.mapfre.entity.XxmpfBpmIndEmision;;

@Service("nfrService")
public interface NFRService {

	 List<String> findSectorByFechaInicio(String dateStart,String dateFinish );
	 
	 List<XxmpfBpmIndEmision> findAllEmisionByFechaInicio(String dateStart, String dateFinish);
	 
	 public Integer countBySectorAndFechaInicioBetween(List<XxmpfBpmIndEmision>  listEmision, String sector);
}
