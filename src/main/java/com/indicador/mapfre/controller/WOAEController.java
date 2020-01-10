
package com.indicador.mapfre.controller;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import com.indicador.mapfre.bussine.WOADevolucion;



@Controller
public class WOAEController {
	
	private static final Logger logger = LogManager.getLogger(WOAEController.class);
	
	@Autowired
	@Qualifier("devolucion")
	private WOADevolucion service;
	

	@GetMapping("/woae")
	public String show(Model model) {
		logger.info("show");
		model.addAttribute("actualDevolucionDivisional",service.mesActual("divisional","Devoluci�n"));
		model.addAttribute("actualDevolucionRegional",service.mesActual("regional","Devoluci�n"));
		model.addAttribute("actualDevolucionAgente",service.mesActual("agente","Devoluci�n"));
		model.addAttribute("actualDevolucionAnalista",service.mesActualAnalista("nombreanalista","Devoluci�n"));
		//
		model.addAttribute("anteriorDevolucionDivisional",service.mesAnterior("divisional","Devoluci�n"));
		model.addAttribute("anteriorDevolucionRegional",service.mesAnterior("regional","Devoluci�n"));
		model.addAttribute("anteriorDevolucionAgente",service.mesAnterior("agente","Devoluci�n"));
		model.addAttribute("anteriorDevolucionAnalista",service.mesAnteriorAnalista("nombreanalista","Devoluci�n"));
		//
		//Rechazo
		model.addAttribute("actualRechazoDivisional",service.mesActual("divisional","Rechazo manual"));
		model.addAttribute("actualRechazoRegional",service.mesActual("regional","Rechazo manual"));
		model.addAttribute("actualRechazoAgente",service.mesActual("agente","Rechazo manual"));
		model.addAttribute("actualRechazoAnalista",service.mesActualAnalista("nombreanalista","Rechazo manual"));
		//
		model.addAttribute("anteriorRechazoDivisional",service.mesAnterior("divisional","Rechazo manual"));
		model.addAttribute("anteriorRechazoRegional",service.mesAnterior("regional","Rechazo manual"));
		model.addAttribute("anteriorRechazoAgente",service.mesAnterior("agente","Rechazo manual"));
		model.addAttribute("anteriorRechazoAnalista",service.mesAnteriorAnalista("nombreanalista","Rechazo manual"));
		//
		//Pendiente
		model.addAttribute("actualPendienteDivisional",service.mesActual("divisional","Pendiente de informaci�n"));
		model.addAttribute("actualPendienteRegional",service.mesActual("regional","Pendiente de informaci�n"));
		model.addAttribute("actualPendienteAgente",service.mesActual("agente","Pendiente de informaci�n"));
		model.addAttribute("actualPendienteAnalista",service.mesActualAnalista("nombreanalista","Pendiente de informaci�n"));
		//
		model.addAttribute("anteriorPendienteDivisional",service.mesAnterior("divisional","Pendiente de informaci�n"));
		model.addAttribute("anteriorPendienteRegional",service.mesAnterior("regional","Pendiente de informaci�n"));
		model.addAttribute("anteriorPendienteAgente",service.mesAnterior("agente","Pendiente de informaci�n"));
		model.addAttribute("anteriorPendienteAnalista",service.mesAnteriorAnalista("nombreanalista","Pendiente de informaci�n"));
		//
		//Sistemas
		model.addAttribute("actualSistemaDivisional",service.mesActual("divisional","Sistemas"));
		model.addAttribute("actualSistemaRegional",service.mesActual("regional","Sistemas"));
		model.addAttribute("actualSistemaAgente",service.mesActual("agente","Sistemas"));
		model.addAttribute("actualSistemaAnalista",service.mesActualAnalista("nombreanalista","Sistemas"));
		//
		model.addAttribute("anteriorSistemaDivisional",service.mesAnterior("divisional","Sistemas"));
		model.addAttribute("anteriorSistemaRegional",service.mesAnterior("regional","Sistemas"));
		model.addAttribute("anteriorSistemaAgente",service.mesAnterior("agente","Sistemas"));
		model.addAttribute("anteriorSistemaAnalista",service.mesAnteriorAnalista("nombreanalista","Sistemas"));
		return "mapfre/woae/index";
	}
	
	
}
