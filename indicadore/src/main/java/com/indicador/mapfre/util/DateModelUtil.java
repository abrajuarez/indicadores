package com.indicador.mapfre.util;

import org.springframework.stereotype.Component;

import com.indicador.mapfre.model.DateModel;

@Component
public class DateModelUtil {
	
	public DateModel convertLocaldateTime(DateModel dates) {
		return new DateModel(dates.getDateStart()+"T00:00:00.89895", dates.getDateFinish()+"T23:59:59.89895");
	}

}
