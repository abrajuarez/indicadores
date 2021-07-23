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
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.indicador.mapfre.bussine.ChartFPR;
import com.indicador.mapfre.model.CotizacionModel;
import com.indicador.mapfre.model.DateModel;
import com.indicador.mapfre.model.FPRModel;
import com.indicador.mapfre.util.DateModelUtil;
import com.indicador.mapfre.xls.FPRReport;

@Controller
public class IndicadorFPRController {
	
	private static final Logger logger = LogManager.getLogger(IndicadorFPRController.class);

	@Autowired
	ChartFPR service;
	
	@Autowired
	FPRReport report;
	
	@Autowired
	DateModelUtil dateModelUtil;
	
	@GetMapping("/indicador_fpr")
	public String index(Model model) {
		model.addAttribute("datesmodel", new DateModel());
		return "mapfre/fpr/index";
	}
	
	
	@PostMapping("/indicador_fpr_show")
	public String show(Model model, @Valid DateModel datemodel, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			logger.error("Method: Show param invalid");
			return "redirect:/indicador_fpr";
		}
		
		DateModel datesConver= dateModelUtil.convertLocaldateTime(datemodel) ;

		String dateStart= datesConver.getDateStart();
		 String dateFinish= datesConver.getDateFinish();
		logger.info("Method show param +[ fecha inicio = " + dateStart + " fecha final = " + dateFinish + " ]");
		
		model.addAttribute("datesmodel", datemodel);
		model.addAttribute("listHorario",sumatoriaListHorario(service.create(datesConver)));
		return "mapfre/fpr/show";
	}
	
	public List<FPRModel> sumatoriaListHorario (List<FPRModel> listHorario) {
		System.out.println("sumatoriaListHorario----------");
		FPRModel totalesFPRModel=new FPRModel();
		totalesFPRModel.setSector("Totales");
		totalesFPRModel.setRangoHorario(" ");
		for(FPRModel  fPRModel : listHorario){
			totalesFPRModel.setFolioAtendido(totalesFPRModel.getFolioAtendido()+fPRModel.getFolioAtendido());
			totalesFPRModel.setFolioRecibido(totalesFPRModel.getFolioRecibido()+fPRModel.getFolioRecibido());
		}
		listHorario.add(totalesFPRModel);
		return listHorario;
	}
	
	
	@PostMapping("/download/FoliosRecibidosXHora.xlsx")
	public ResponseEntity<InputStreamResource> excelCustomersReport(@ModelAttribute("datesmodel") DateModel datesmodel)
			throws IOException {
		DateModel datesConver= dateModelUtil.convertLocaldateTime(datesmodel) ;
		String dateStart= datesConver.getDateStart();
		 String dateFinish= datesConver.getDateFinish();
		System.out.println("entro reques2 xls-> " + dateStart + " final " + dateFinish);
		ByteArrayInputStream in = report.create(datesConver);
		// return IOUtils.toByteArray(in);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment; filename=Folios Recibidos por hora.xls");
		return ResponseEntity.ok().headers(headers).body(new InputStreamResource(in));
	}
}
