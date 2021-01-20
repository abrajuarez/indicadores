package com.indicador.mapfre.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.indicador.mapfre.entity.XxmpfBpmIndEmision;
import com.indicador.mapfre.repository.XxmpfBpmIndEmisionRepository;

@RestController
public class RestTestController {
	
	@Autowired
	XxmpfBpmIndEmisionRepository  emirepository;

	@GetMapping("/listDate")
	List<LocalDateTime> list(){
		return   emirepository.findAllDate();
	}
	
	@GetMapping("/listDates")
	List<LocalDateTime> lists(){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");
		LocalDateTime local = LocalDateTime.parse("2019-12-06T23:59:59.89895");
		return   emirepository.findAllDates(local);
	}
	
	@GetMapping("/list")
	List<XxmpfBpmIndEmision> listEmision(){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");
		LocalDateTime local = LocalDateTime.parse("2019-12-06T23:59:59.89895");
		LocalDateTime local2 = LocalDateTime.parse("2020-12-06T23:59:59.89895");
		return   emirepository.findAllByFechaFinAndEstatusEmision(local,local2);
	}
}
