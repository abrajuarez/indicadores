package com.indicador.mapfre.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.indicador.mapfre.entity.CMCentralMedica;
import com.indicador.mapfre.model.CMCentralMedicaModel;

@Service
public interface CMCentralMedicaService {
	
	public List<Object[]> findAllByCreationDate2(String fechaInicial, String fechaFinal);
	
	List<CMCentralMedica> findAllByCreationDate(String dateStart, String dateFinish);
	
	public List<CMCentralMedicaModel> reporte(String dateStart, String dateFinish);


}
