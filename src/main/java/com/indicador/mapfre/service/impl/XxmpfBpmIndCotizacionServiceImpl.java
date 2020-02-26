package com.indicador.mapfre.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indicador.mapfre.service.XxmpfBpmIndCotizacionService;
import com.indicador.mapfre.util.DateUtil;
import com.indicador.mapfre.repository.XxmpfBpmIndCotizacionRepository;

@Service("cotizacionImpl")
public class XxmpfBpmIndCotizacionServiceImpl  implements XxmpfBpmIndCotizacionService{

	@Autowired
	private XxmpfBpmIndCotizacionRepository repository;
	
	
	@Override
	public List<String> distinctEstatus(){
		return  repository.findDistinctEstatus();
	}

	@Override
	public int countCotizacion() {
		return repository.countRegistreCotizacion();
	}

	@Override
	public int countRegistreByEstatus(String status) {
	    return repository.countByStatus(status);
	}
	
	@Override
	public List<String> getStatusByBetween(String dateStart,String dateFinish ){
		List<String> listStatus = repository.findDistinctEstatusByBetween(DateUtil.formatterString(dateStart), DateUtil.formatterString(dateFinish) );
		listStatus.forEach(item->System.out.println("Status = "+item));
		return listStatus;
	}
	
	@Override
	public int countEstatusByFechaInicioBetweens(String dateStart,String dateFinish,String status ){
		if(status == null) {
			return repository.countEstatusIsNullFechaInicioBetween(DateUtil.formatterString(dateStart), DateUtil.formatterString(dateFinish));
		}return repository.countEstatusByFechaInicioBetween(dateStart,dateFinish,status );
	}
	
	@Override
	public int countEstatusByFechaInicioBetween(String dateStart,String dateFinish) {
		return repository.countEstatusByFechaInicioBetween(DateUtil.formatterString(dateStart), DateUtil.formatterString(dateFinish) );
	}
	
	@Override
    public int countRecotizacionByFechaInicioBetween(String dateStart,String dateFinish ) {
		return repository.countRecotizacionByFechaInicioBetween(DateUtil.formatterString(dateStart), DateUtil.formatterString(dateFinish));
	}
	
	@Override
	public int countDevolucionByFechaInicioBetween(String dateStart,String dateFinish ) {
		return repository.countDevolucionByFechaInicioBetween(DateUtil.formatterString(dateStart), DateUtil.formatterString(dateFinish));
	}
	
	@Override
	public Integer getAVGTiempoDiasByFecaInicio(String dateStart,String dateFinish) {
		return repository.findAVGTiempoDiasByFechaInicio(DateUtil.formatterString(dateStart), DateUtil.formatterString(dateFinish));
	}

	@Override
	public List<String> findDistinctMotivoByFechaInicio(String dateStart, String dateFinish, String status) {
		return repository.findDistinctMotivoByFechaInicio(DateUtil.formatterString(dateStart), DateUtil.formatterString(dateFinish), status);
	}

	@Override
	public Integer countMotivosByFechaInicioBetween(String dateStart, String dateFinish, String motivo,  String status) {
		return repository.countMotivosByFechaInicioBetween(DateUtil.formatterString(dateStart), DateUtil.formatterString(dateFinish),motivo, status);
	}

	@Override
	public Integer totalMotivosByFechaInicioBetween(String dateStart, String dateFinish, String status) {
		// TODO Auto-generated method stub
		return repository.totalMotivosByFechaInicioBetween(DateUtil.formatterString(dateStart), DateUtil.formatterString(dateFinish), status);
	}
	
}
