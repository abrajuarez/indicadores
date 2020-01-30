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

import com.indicador.mapfre.bussine.ChartNSE;
import com.indicador.mapfre.model.DateModel;
import com.indicador.mapfre.pdf.NSEPdf;

@Controller
public class IndicadorNSEController {
	
	private static final Logger logger = LogManager.getLogger(IndicadorNSEController.class);
	
	@Autowired
    private ChartNSE chartNSE;
	
	@Autowired
	private NSEPdf pdfReport;

	@GetMapping("/indicador_nse")
	public String index(Model model) {
		model.addAttribute("datesmodel", new DateModel());
		return "mapfre/nse/index";
	}
	
	@PostMapping("/indicador_nse_show")
	public String show(Model model, @Valid DateModel datemodel, BindingResult bindingResult) {
		logger.info("Method: show");
		if (bindingResult.hasErrors()) {
            return "redirect:/indicador_nse";
        }
		String dateStart = datemodel.getDateStart();
		String dateFinish = datemodel.getDateFinish();	
		
		model.addAttribute("datesmodel", new DateModel(dateStart, dateFinish));
		model.addAttribute("grafica", chartNSE.chartFilterFecha(datemodel));
		return "mapfre/nse/show";
	}
	
	@PostMapping("/download/nse.pdf")
	public ResponseEntity<InputStreamResource> CreatePdfReport(@ModelAttribute("datesmodel") DateModel datesmodel)
			throws IOException {
		logger.info("Method: CreatePdfReport");
		
		String dateStart = datesmodel.getDateStart();
		String dateFinish = datesmodel.getDateFinish();
		
		System.out.println("entro reques2 xls-> " + dateStart + " final " + dateFinish);
		ByteArrayInputStream in = pdfReport.create(datesmodel,chartNSE.chartFilterFecha(datesmodel));
		// return IOUtils.toByteArray(in);
		logger.info("entro reques2 pdf-> " + in);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment; filename=Nivel_servicio_emision.pdf");
		headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");

		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(new InputStreamResource(in));
	}
}
