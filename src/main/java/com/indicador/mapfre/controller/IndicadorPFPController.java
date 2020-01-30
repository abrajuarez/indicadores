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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.indicador.mapfre.bussine.ChartPFP;
import com.indicador.mapfre.model.DateModel;
import com.indicador.mapfre.pdf.PFPPdf;
import com.indicador.mapfre.xls.PFPReport;

@Controller
public class IndicadorPFPController {

	private static final Logger logger = LogManager.getLogger(IndicadorPFPController.class);

	@Autowired
	private ChartPFP chartPfp;

	@Autowired
	private PFPReport report;

	@Autowired
	private PFPPdf pdfReport;

	@GetMapping("/indicador_pfp")
	public String index(Model model) {
		logger.info("Method: index  param[size =" + chartPfp.chart().size()+"]");
		model.addAttribute("grafica", chartPfp.chart());
		return "mapfre/pfp/index";
	}

	@PostMapping("/indicador_pfp_show")
	public String show(Model model, @ModelAttribute("datesmodel") DateModel datemodel) {
		String dateStart = datemodel.getDateStart();
		String dateFinish = datemodel.getDateFinish();
		logger.info("Method: show ");
		model.addAttribute("datesmodel", new DateModel(dateStart, dateFinish));
		return "mapfre/nfa/show";
	}

	@PostMapping("/download/foliosPendientes.xlsx")
	public ResponseEntity<InputStreamResource> excelCustomersReport() throws IOException {
		logger.info("Method: excelCustomersReport ");
		ByteArrayInputStream in = report.create();
		// return IOUtils.toByteArray(in);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment; filename=PFP (Promedio de folios pendientes).xls");

		return ResponseEntity.ok().headers(headers).body(new InputStreamResource(in));
	}

	@PostMapping("/download/pfp.pdf")
	public ResponseEntity<InputStreamResource> CreatePdfReport() throws IOException {
		logger.info("Method: CreatePdfReport ");
		ByteArrayInputStream in = pdfReport.create(chartPfp.chart());
		// return IOUtils.toByteArray(in);
		logger.info("entro reques2 pdf-> " + in);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment; filename=Prom_Folios_Pendientes.pdf");
		headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
		headers.add("Pragma", "no-cache");
		headers.add("Expires", "0");

		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(in));
	}
}
