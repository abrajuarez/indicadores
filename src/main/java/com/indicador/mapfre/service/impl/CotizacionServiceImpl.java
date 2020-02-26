package com.indicador.mapfre.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indicador.mapfre.repository.XxmpfBpmIndCotizacionRepository;
import com.indicador.mapfre.service.CotizacionService;
import com.indicador.mapfre.util.DateUtil;

@Service("cotizacionServiceImpl")
public class CotizacionServiceImpl implements CotizacionService {

	@Autowired
	private XxmpfBpmIndCotizacionRepository repository;
	
	@Override
	public List<String> findDistinctSectorByFechaInicio(String dateStart, String dateFinish, String status) {
		return repository.findDistinctSectorByFechaInicio(DateUtil.formatterString(dateStart), DateUtil.formatterString(dateFinish), status);
	}

	@Override
	public Integer countSectorByFechaInicioBetween(String dateStart, String dateFinish, String status, String sector) {
		return repository.countSectorByFechaInicioBetween(DateUtil.formatterString(dateStart), DateUtil.formatterString(dateFinish),status, sector);
	}

	@Override
	public List<String> findDistinctAgenteByFechaInicio(String dateStart, String dateFinish, String status) {
		// TODO Auto-generated method stub
		return repository.findDistinctAgenteByFechaInicio(DateUtil.formatterString(dateStart), DateUtil.formatterString(dateFinish), status);
	}

	@Override
	public Integer countAgenteByFechaInicioBetween(String dateStart, String dateFinish, String status, String agente) {
		// TODO Auto-generated method stub
		return repository.countAgenteByFechaInicioBetween(DateUtil.formatterString(dateStart), DateUtil.formatterString(dateFinish), status, agente);
	}

	@Override
	public List<String> distinctSectorByDevolucionesAndFechaInicio(String dateStart, String dateFinish) {
		// TODO Auto-generated method stub
		return repository.distinctSectorByDevolucionesAndFechaInicio(DateUtil.formatterString(dateStart), DateUtil.formatterString(dateFinish));
	}

	@Override
	public int countRecotizacionBySectorAndFechaInicio(String dateStart, String dateFinish, String sector) {
		return repository.countRetrabajoDevolucionBySectorAndFechaInicio(DateUtil.formatterString(dateStart), DateUtil.formatterString(dateFinish), sector);
	}

	@Override
	public List<String> distinctSectorByRecotizacionAndFechaInicio(String dateStart, String dateFinish) {
		// TODO Auto-generated method stub
		return repository.distinctSectorByRecotizacionAndFechaInicio(DateUtil.formatterString(dateStart), DateUtil.formatterString(dateFinish));
	}

	@Override
	public int countRetrabajoRecotizacionBySectorAndFechaInicio(String dateStart, String dateFinish, String sector) {
		// TODO Auto-generated method stub
		return repository.countRetrabajoRecotizacionBySectorAndFechaInicio(DateUtil.formatterString(dateStart), DateUtil.formatterString(dateFinish), sector);
	}

	@Override
	public List<String> distinctAgenteByRecotizacionAndFechaInicio(String dateStart, String dateFinish) {
		// TODO Auto-generated method stub
		return repository.distinctAgenteByRecotizacionAndFechaInicio(DateUtil.formatterString(dateStart), DateUtil.formatterString(dateFinish));
	}

	@Override
	public int countRetrabajoRecotizacionAgenteBySectorAndFechaInicio(String dateStart, String dateFinish,
			String agente) {
		// TODO Auto-generated method stub
		return repository.countRetrabajoRecotizacionAgenteBySectorAndFechaInicio(DateUtil.formatterString(dateStart), DateUtil.formatterString(dateFinish), agente);
	}

	@Override
	public List<String> distinctAgenteByDevolucionesAndFechaInicio(String dateStart, String dateFinish) {
		// TODO Auto-generated method stub
		return repository.distinctAgenteByDevolucionesAndFechaInicio(DateUtil.formatterString(dateStart), DateUtil.formatterString(dateFinish));
	}

	@Override
	public int countRetrabajoDevolucionAgenteBySectorAndFechaInicio(String dateStart, String dateFinish,
			String agente) {
		// TODO Auto-generated method stub
		return repository.countRetrabajoDevolucionAgenteBySectorAndFechaInicio(DateUtil.formatterString(dateStart), DateUtil.formatterString(dateFinish), agente);
	}

}
