package com.indicador.mapfre.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.indicador.mapfre.bussine.ChartNMR;
import com.indicador.mapfre.model.DateModel;
import com.indicador.mapfre.pdf.NMRPdf;
import com.indicador.mapfre.util.DateModelUtil;
import com.indicador.mapfre.xls.NMRReport;

@Controller
public class IndicadorNMRController {
	
	private static final Logger logger = LogManager.getLogger(IndicadorNMRController.class);

	@Autowired
	private ChartNMR chart;
	
	@Autowired
	private  NMRReport report;
	
	@Autowired
	private  NMRPdf pdfReport;
	
	@Autowired
	DateModelUtil dateModelUtil;
	
	@GetMapping("/indicador_nmr")
	public String index(Model model) {
		model.addAttribute("datesmodel", new DateModel());
		return "mapfre/nmr/index";
	}
	
	@PostMapping("/indicador_nmr_show")
	public String show(Model model,@Valid DateModel datemodel, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
            return "redirect:/indicador_nmr";
        }
		
		DateModel datesConver= dateModelUtil.convertLocaldateTime(datemodel) ;
		String dateStart= datesConver.getDateStart();
		 String dateFinish= datesConver.getDateFinish();
		logger.info("Method show param +[ fecha inicio = "+dateStart +" fecha final = "+dateFinish+ " ]");
		model.addAttribute("datesmodel", datemodel);
		model.addAttribute("grafica", chart.chart(datesConver));
		return "mapfre/nmr/show";
	}
	
	@PostMapping("/download/numMoviemtosRealizados.xlsx")
	public ResponseEntity<InputStreamResource> excelCustomersReport(@ModelAttribute("datesmodel") DateModel datesmodel)
			throws IOException {
		DateModel datesConver= dateModelUtil.convertLocaldateTime(datesmodel) ;
		String dateStart= datesConver.getDateStart();
		 String dateFinish= datesConver.getDateFinish();
		System.out.println("entro reques2 xls-> " + dateStart + " final " + dateFinish);
		ByteArrayInputStream in = report.create(datesConver);
		// return IOUtils.toByteArray(in);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment; filename=Num Movimientos Realizados.xls");

		return ResponseEntity.ok().headers(headers).body(new InputStreamResource(in));
	}
	
	@PostMapping("/download/nmr.pdf")
	public ResponseEntity<InputStreamResource> CreatePdfReport(@ModelAttribute("datesmodel") DateModel datesmodel)
			throws IOException {
		DateModel datesConver= dateModelUtil.convertLocaldateTime(datesmodel) ;
		String dateStart= datesConver.getDateStart();
		 String dateFinish= datesConver.getDateFinish();
		System.out.println("entro reques2 xls-> " + dateStart + " final " + dateFinish);
		ByteArrayInputStream in = pdfReport.create(datesConver,chart.chart(datesConver));
		// return IOUtils.toByteArray(in);
		logger.info("entro reques2 pdf-> " + in);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment; filename=Num_Movimientos_Realizados.pdf");
		headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");

		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(new InputStreamResource(in));
	}
}
