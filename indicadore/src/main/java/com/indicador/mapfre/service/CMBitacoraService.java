package com.indicador.mapfre.service;

import org.springframework.stereotype.Service;

import com.indicador.mapfre.entity.CMBitacora;



@Service
public interface CMBitacoraService {

	CMBitacora findByIdSolicitud(Long id);
	
	CMBitacora findFirstElementBYIdRegProcesoAndNombreActividad(Long idSolicitud, int numPage, String order, String actividad);

	CMBitacora findLastElementBYIdRegProcesoAndNombreActividad(Long idSolicitud,  String actividad);
}
