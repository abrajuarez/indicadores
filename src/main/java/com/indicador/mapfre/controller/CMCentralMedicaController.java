package com.indicador.mapfre.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CMCentralMedicaController {

	@GetMapping("/indicador_centralmedica")
	public String index() {
		return "";
	}
}
