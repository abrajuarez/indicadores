package com.indicador.mapfre.util;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class StringUtil {
	private static final Logger logger = LogManager.getLogger(StringUtil.class);
	
	private static final String FORMAT = "dd/MM/uuuu  hh:mm:ss";


	public static String containNull(String word) {
		logger.info("method: containNull param = "+word);
		if(word.equals("null") || word == null)
			return "";
		else
			return word;
	}
	
	public static int getHoraByFecha(LocalDateTime fecha) {
		//logger.info("method: getHoraByFechal param = "+fecha);
		if(fecha == null ) {
			//logger.info("method: getHoraByFechal es (null)");
			return 0;
		}
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(FORMAT);
		String fechaString =  fecha.format(formatter);
		String hora = fechaString.substring(11, 13);
		//logger.info("method: getHoraByFechal return hora = "+hora);
       int hrs = Integer.parseInt(hora.trim());
		return hrs;
		
	}
	
	public static int getHoraByFecha(String fecha) {
		//logger.info("method: getHoraByFechal param = "+fecha);
		if(fecha == null || fecha.isEmpty() || fecha.equals("(null)")|| fecha.equals("null") || fecha.equals("Null")|| fecha.equals("")) {
			//logger.info("method: getHoraByFechal es (null)");
			return 0;
		}
		
		String hora = fecha.substring(11, 13);
		//logger.info("method: getHoraByFechal return hora = "+hora);
       int hrs = Integer.parseInt(hora.trim());
		return hrs;
		
	}
	
	public static String getFecha(String fecha) {
		if(fecha == null || fecha.length() < 11) {
		//	logger.info("Error method: getFecha is null fecha ");
			return "";
		}
		//logger.info("method: getFecha param = "+fecha +" hora: "+fecha.substring(0, 10));
		 return fecha.substring(0, 10);   
	}
	
	public static String getFecha(LocalDateTime fecha) {
		if(fecha == null ) {
		//	logger.info("Error method: getFecha is null fecha ");
			return "";
		}
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(FORMAT);
		String fechaString =  fecha.format(formatter);
		//logger.info("method: getFecha param = "+fecha +" hora: "+fecha.substring(0, 10));
		 return fechaString.substring(0, 10);   
	}
	
	public static String getHora(String fecha) {
		if(fecha == null || fecha.length() < 16) {
		//	logger.info("Error method: getHora is null fecha ");
			return "";
		}
		//logger.info("method: getHora param = "+fecha +" hora: "+fecha.substring(11, 16));
		 return fecha.substring(11, 16);
       
	}
	
	public static String getHora(LocalDateTime fecha) {
		if(fecha == null) {
		//	logger.info("Error method: getHora is null fecha ");
			return "";
		}
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(FORMAT);
		String fechaString =  fecha.format(formatter);
		 return fechaString.substring(11, 16);
       
	}
	
	public static Long convertObjectLong(Object obj) {
		return Long.parseLong(obj.toString());
	}
	
	public static String convertObjetcToString(Object obj) {
		Optional<Object> opt = Optional.ofNullable(obj);
		return opt.orElse("")+"";
	}
	
	public static Long convertObjetcToLong(Object obj) {
		Optional<Object> opt = Optional.ofNullable(obj);
		return Long.parseLong(opt.orElse(0L).toString());
	}
	
	public static BigDecimal convertObjetcToBigDecimal(Object obj) {
		Optional<Object> opt = Optional.ofNullable(obj);
		return new BigDecimal(opt.orElse(0).toString());
	}
	
	public static int convertObjetcToInt(Object obj) {
		Optional<Object> opt = Optional.ofNullable(obj);
		return Integer.parseInt(opt.orElse(0).toString());
	}
	
	public static String validStringIsNull(String cadena) {
		Optional<String> opt = Optional.ofNullable(cadena);
		return opt.orElse("");

	}
}
