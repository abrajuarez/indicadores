package com.indicador.mapfre.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

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

import com.indicador.mapfre.entity.CMCentralMedica;
import com.indicador.mapfre.model.DateModel;
import com.indicador.mapfre.service.CMCentralMedicaService;
import com.indicador.mapfre.xls.CMCentralMedicaReport;

@Controller
public class CMCentralMedicaController {
	
	private static final Logger logger = LogManager.getLogger(CMCentralMedicaController.class);
	
	@Autowired
	private CMCentralMedicaService centralService;
	
	@Autowired
	private CMCentralMedicaReport report;

	@GetMapping("/indicador_centralmedica")
	public String index(Model model) {
		model.addAttribute("datesmodel", new DateModel());
		return "centralmedica/index";
	}
	
	@PostMapping("/indicador_centralmedica_show")
	public String show(Model model, @Valid DateModel datesmodel, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			logger.error("Error method show not valid date "+bindingResult);
            return "redirect:indicador_centralmedica";
        }
		List<CMCentralMedica> listCentral = centralService.findAllByCreationDate(datesmodel.getDateStart(), datesmodel.getDateFinish());
		for(int i = 0; i<listCentral.size(); i++) {
			logger.info("Method: show "+listCentral.get(i).getListSiniestros().get(0).getCoaseguroContratado());
		}
		
		model.addAttribute("datesmodel", new DateModel());
		model.addAttribute("listcentral",listCentral );
		return "centralmedica/show";
	}
	
	@PostMapping("/download/centralmedica.xlsx")
	public ResponseEntity<InputStreamResource> excelCustomersReport(@ModelAttribute("datesmodel") DateModel datesmodel)
			throws IOException {
		String dateStart = datesmodel.getDateStart();
		String dateFinish = datesmodel.getDateFinish();
		logger.info("entro reques2 xls-> " + dateStart + " final " + dateFinish);
		ByteArrayInputStream in = report.create(datesmodel);
		// return IOUtils.toByteArray(in);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment; filename=reportecentralmedica.xlsx");

		return ResponseEntity.ok().headers(headers).body(new InputStreamResource(in));
	}
}
