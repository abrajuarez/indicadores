package com.indicador.mapfre.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.indicador.mapfre.entity.CMCentralMedica;

@Service
public interface CMCentralMedicaService {
	
	List<CMCentralMedica> findAllByCreationDate(String dateStart, String dateFinish);


}
