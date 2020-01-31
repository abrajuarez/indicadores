package com.indicador.mapfre.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.indicador.mapfre.entity.CMCentralMedica;
import com.indicador.mapfre.model.DateModel;
import com.indicador.mapfre.service.CMCentralMedicaService;

@Controller
public class CMCentralMedicaController {
	
	private static final Logger logger = LogManager.getLogger(CMCentralMedicaController.class);
	
	@Autowired
	private CMCentralMedicaService centralService;

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
}
