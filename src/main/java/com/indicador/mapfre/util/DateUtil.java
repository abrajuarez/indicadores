package com.indicador.mapfre.util;

import java.util.Date;


import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtil {

	public static String formatterString(String fecha)  {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
		try {
		if (fecha.isEmpty() || fecha.length() < 8) {
			String dateString = "01/01/2020";
			Date date = formatter.parse(dateString);
			return formatter.format(date) + "";
		}
		if (fecha.length() == 8 && fecha.contains("-")) {
			String dateString = fecha.replace('-', '/');
			Date date = formatter.parse(dateString);
			return formatter.format(date) + "";
		} else {
			Date date = formatter.parse(fecha);
			return formatter.format(date) + "";
		}
		}catch (Exception e) {
			
		}
		return "01/01/2020";
	}

	public static String minusMonths(String fecha, long meses) {
		// Crear un formateador como 16/10/2018
		DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/uu");

		// Lo convertimos a objeto para poder trabajar con �l
		LocalDate fechaLocal = LocalDate.parse(fecha, formateador);

		// Restar meses
		fechaLocal = fechaLocal.minusMonths(meses);

		// Formatear de nuevo y regresar como cadena
		return fechaLocal.format(formateador);
	}

	public static String plusMonths(String fecha, long meses) {
		// Crear un formateador como 16/10/2018
		DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/uu");

		// Lo convertimos a objeto para poder trabajar con �l
		LocalDate fechaLocal = LocalDate.parse(fecha, formateador);

		// Sumar los meses indicados
		fechaLocal = fechaLocal.plusMonths(meses);

		// Formatear de nuevo y regresar como cadena
		return fechaLocal.format(formateador);
	}

	public static String plusDay(String fecha, long daysToAdd) {
		DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/uu");
		LocalDate fechaLocal = LocalDate.parse(fecha, formateador);

		fechaLocal = fechaLocal.plusDays(daysToAdd);
		return fechaLocal.format(formateador);
	}

	public static String plusDayToUUU(String fecha, long daysToAdd) {
		DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/uuuu");
		LocalDate fechaLocal = LocalDate.parse(fecha, formateador);

		fechaLocal = fechaLocal.plusDays(daysToAdd);
		return fechaLocal.format(formateador);
	}

}
