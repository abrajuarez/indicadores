package com.indicador.mapfre.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.indicador.mapfre.entity.CMBitacora;
import com.indicador.mapfre.entity.CMRegProceso;
import com.indicador.mapfre.repository.CMBitacoraRepository;
import com.indicador.mapfre.repository.CMRegProcesoRepository;
import com.indicador.mapfre.service.CMBitacoraService;

@Service
public class CMBitacoraServiceImpl implements CMBitacoraService {

	@Autowired
	private CMRegProcesoRepository procesoRepository;
	
	@Autowired
	private CMBitacoraRepository bitacoraRepository;

	@Override
	public CMBitacora findByIdSolicitud(Long id) {	
		Pageable limit2 = PageRequest.of(0, 1, Sort.by("idBitacora"));
		List<CMBitacora> listBitacora = bitacoraRepository.findFirstElementBYIdRegProceso(limit2, id);
		if(listBitacora.size() > 0) {
		return listBitacora.get(0);
		}
		return new CMBitacora();
	}
}
