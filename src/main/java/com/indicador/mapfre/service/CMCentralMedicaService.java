package com.indicador.mapfre.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.indicador.mapfre.entity.CMCentralMedica;

@Service
public interface CMCentralMedicaService {
	
	public List<Object[]> findAllByCreationDate2(String fechaInicial, String fechaFinal);
	
	List<CMCentralMedica> findAllByCreationDate(String dateStart, String dateFinish);


}
