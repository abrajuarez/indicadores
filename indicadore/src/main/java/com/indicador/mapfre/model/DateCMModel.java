package com.indicador.mapfre.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class DateCMModel {
	@NotNull
    @Size(min=8, max=10)
	//@Pattern(regexp ="^([0-2][0-9]|3[0-1])(/)(0[1-9]|1[0-2])(/)(\\d{4})")
	private String dateStart;

	public String getDateStart() {
		return dateStart;
	}

	public void setDateStart(String dateStart) {
		this.dateStart = dateStart;
	}
	
	
	
}
