package com.indicador.mapfre.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.indicador.mapfre.bussine.ChartTPE;

import com.indicador.mapfre.pdf.TPEPdf;
import com.indicador.mapfre.util.DateModelUtil;

@Controller
public class IndicadorTPEController {
	
	private static final Logger logger = LogManager.getLogger(IndicadorTPEController.class);

	@Autowired
	private ChartTPE service;
	
	@Autowired
	private TPEPdf pdfReport;
	
	@Autowired
	DateModelUtil dateModelUtil;
	
	@GetMapping("/indicador_tpe")
	public String index(Model model) {
		model.addAttribute("grafica", service.create());
		return "mapfre/tpe/index";
	}
	
	@PostMapping("/download/tpe.pdf")
	public ResponseEntity<InputStreamResource> CreatePdfReport()
			throws IOException {
		
		ByteArrayInputStream in = pdfReport.create(service.create());
		
		logger.info("entro reques2 pdf-> " + in);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment; filename=Tiempo_promedio_realizado_por_emisores.pdf");
		headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");

		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(new InputStreamResource(in));
	}
	
}
