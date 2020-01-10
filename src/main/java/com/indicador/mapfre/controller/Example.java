package com.indicador.mapfre.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
//@RequestMapping(path = "/admin")
public class Example {

	@GetMapping("/sim")
	public String index() {
		System.out.println("--------------------------entro --");
		return "index";
	}
	
	@GetMapping("/barrasimple")
	public String line() {
		System.out.println("--------------------------entro line --");
		return "chart/bsimple";
	}
	
	@GetMapping("/pastel")
	public String pastels() {
		System.out.println("--------------------------entro line --");
		return "chart/pastel";
	}
}
