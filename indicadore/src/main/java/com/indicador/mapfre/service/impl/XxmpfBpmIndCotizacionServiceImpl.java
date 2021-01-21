package com.indicador.mapfre.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indicador.mapfre.service.XxmpfBpmIndCotizacionService;
import com.indicador.mapfre.util.CalendarUtil;
import com.indicador.mapfre.util.DateUtil;
import com.indicador.mapfre.repository.XxmpfBpmIndCotizacionRepository;

@Service("cotizacionImpl")
public class XxmpfBpmIndCotizacionServiceImpl  implements XxmpfBpmIndCotizacionService{

	@Autowired
	private XxmpfBpmIndCotizacionRepository repository;
	
	@Autowired
	CalendarUtil calendarUtil;
	
	
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
		List<String> listStatus = repository.findDistinctEstatusByBetween(calendarUtil.covertStringToCalendar(dateStart), calendarUtil.covertStringToCalendar(dateFinish) );
		listStatus.forEach(item->System.out.println("Status = "+item));
		return listStatus;
	}
	
	@Override
	public int countEstatusByFechaInicioBetweens(String dateStart,String dateFinish,String status ){
		if(status == null) {
			return repository.countEstatusIsNullFechaInicioBetween(calendarUtil.covertStringToCalendar(dateStart), calendarUtil.covertStringToCalendar(dateFinish));
		}return repository.countEstatusByFechaInicioBetween(calendarUtil.covertStringToCalendar(dateStart),calendarUtil.covertStringToCalendar(dateFinish),status );
	}
	
	@Override
	public int countEstatusByFechaInicioBetween(String dateStart,String dateFinish) {
		return repository.countEstatusByFechaInicioBetween(calendarUtil.covertStringToCalendar(dateStart), calendarUtil.covertStringToCalendar(dateFinish) );
	}
	
	@Override
    public int countRecotizacionByFechaInicioBetween(String dateStart,String dateFinish ) {
		return repository.countRecotizacionByFechaInicioBetween(calendarUtil.covertStringToCalendar(dateStart), calendarUtil.covertStringToCalendar(dateFinish));
	}
	
	@Override
	public int countDevolucionByFechaInicioBetween(String dateStart,String dateFinish ) {
		return repository.countDevolucionByFechaInicioBetween(calendarUtil.covertStringToCalendar(dateStart), calendarUtil.covertStringToCalendar(dateFinish));
	}
	
	@Override
	public Integer getAVGTiempoDiasByFecaInicio(String dateStart,String dateFinish) {
		return repository.findAVGTiempoDiasByFechaInicio(calendarUtil.covertStringToCalendar(dateStart), calendarUtil.covertStringToCalendar(dateFinish));
	}

	@Override
	public List<String> findDistinctMotivoByFechaInicio(String dateStart, String dateFinish, String status) {
		return repository.findDistinctMotivoByFechaInicio(calendarUtil.covertStringToCalendar(dateStart), calendarUtil.covertStringToCalendar(dateFinish), status);
	}

	@Override
	public Integer countMotivosByFechaInicioBetween(String dateStart, String dateFinish, String motivo,  String status) {
		return repository.countMotivosByFechaInicioBetween(calendarUtil.covertStringToCalendar(dateStart), calendarUtil.covertStringToCalendar(dateFinish),motivo, status);
	}

	@Override
	public Integer totalMotivosByFechaInicioBetween(String dateStart, String dateFinish, String status) {
		// TODO Auto-generated method stub
		return repository.totalMotivosByFechaInicioBetween(calendarUtil.covertStringToCalendar(dateStart), calendarUtil.covertStringToCalendar(dateFinish), status);
	}
	
}
