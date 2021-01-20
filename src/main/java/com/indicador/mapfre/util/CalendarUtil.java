package com.indicador.mapfre.util;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;



@Component
public class CalendarUtil {
	
	private static final Logger  log = LoggerFactory.getLogger(CalendarUtil.class);
	//yyyy-MM-dd
	public  String covertCalendarToString(LocalDateTime  calendar) {
		/*SimpleDateFormat sdf = new SimpleDateFormat ("dd/mm/yy");
		sdf.format (calendar.getTime ());
		return sdf+"";*/
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yy");
		 return calendar.format(formatter);
	}
	
	public  String covertCalendarToString(Date  calendar) {
		SimpleDateFormat sdf = new SimpleDateFormat ("dd/mm/yy");
		sdf.format (calendar.getTime ());
		return sdf+"";
	
	}
	
	public   LocalDateTime covertStringToCalendar(String calendar) {
		log.info("Method:covertStringToCalendarinput[ date ini = "+calendar);
		if(calendar.length() == 8) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MM-dd HH:mm:ss.");
			//LocalDateTime local = LocalDateTime.parse(calendar, formatter);
			LocalDateTime local = LocalDateTime.parse(calendar);
			log.info("Method:covertStringToCalendar request [ date ini = "+local );
		     return local;
		     }
		
	
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		//LocalDateTime local = LocalDateTime.parse(calendar, formatter);
		LocalDateTime local = LocalDateTime.parse(calendar);
		log.info("Method:covertStringToCalendar request [ date ini = "+local );
	     return local;
	
		
	}
	

}

