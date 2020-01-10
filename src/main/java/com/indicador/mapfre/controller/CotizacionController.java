package com.indicador.mapfre.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.indicador.mapfre.bussine.ChartCotizacion;
import com.indicador.mapfre.bussine.CreateXls;
import com.indicador.mapfre.model.ChartModel;
import com.indicador.mapfre.model.CotizacionModel;
import com.indicador.mapfre.model.DateModel;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import java.io.ByteArrayInputStream;
import java.io.IOException;

@Controller
public class CotizacionController {

	@Autowired
	@Qualifier("chartCotizacionImpl")
	private ChartCotizacion cotizacion;
	
	@Autowired
	@Qualifier("createXlsImpl")
	private CreateXls createXls;
	
	@GetMapping("/indicador")
	public String index(Model model) {
		ObjectMapper mapper = new ObjectMapper();
		List<CotizacionModel> charTCotizacion = cotizacion.drawChart();
		List<CotizacionModel> tableCotizacion = cotizacion.drawTables();
		model.addAttribute("tableCotizacion", tableCotizacion);
		//model.addAttribute("charTCotizacion", charTCotizacion);
		String json = "";
		try {
			json = mapper.writeValueAsString(charTCotizacion);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("json", json);
		return "mapfre/semalcotizacion";
	}
	
	@GetMapping("/indicador2")
	public ModelAndView indicador() {
		ModelAndView mv = new ModelAndView("mapfre/semalcotizacion2");
		ObjectMapper mapper = new ObjectMapper();
		
		List<CotizacionModel> charTCotizacion = cotizacion.drawChart();
		List<CotizacionModel> tableCotizacion = cotizacion.drawTables();
		mv.addObject("tableCotizacion", tableCotizacion);
		//model.addAttribute("charTCotizacion", charTCotizacion);
		String json = "";
		try {
			json = mapper.writeValueAsString(charTCotizacion);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.addObject("json", json);
		return mv;
	}
	
	@GetMapping("/result2")
	public @ResponseBody List<ChartModel> ind() {
		
		return cotizacion.drawChartModel();
		
		
	}
	
	@GetMapping("/datecotizacion2")
	public ModelAndView fechaCotizacion() {
		ModelAndView mv = new ModelAndView("mapfre/fechacotizacion");
		ObjectMapper mapper = new ObjectMapper();
		
		List<CotizacionModel> charTCotizacion = cotizacion.drawChart();
		List<CotizacionModel> tableCotizacion = cotizacion.drawTables();
		mv.addObject("tableCotizacion", tableCotizacion);
		//model.addAttribute("charTCotizacion", charTCotizacion);
		String json = "";
		try {
			json = mapper.writeValueAsString(charTCotizacion);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.addObject("json", json);
		return mv;
	}
	
	@GetMapping("/datecotizacion")
	public String fechaCotizacion2(Model model) {
		
		model.addAttribute("datesmodel", new DateModel());

		return "mapfre/fechacotizacion2";
	}
		
	@PostMapping("/chartByDateStarts")
	public @ResponseBody List<ChartModel> chartByDateStart(@ModelAttribute("datesmodel")  DateModel datesmodel) {	
		 String dateStart= datesmodel.getDateStart();
		 String dateFinish= datesmodel.getDateFinish();
		System.out.println("entro reques "+dateStart+" final "+dateFinish);
		return cotizacion.drawChartModel(dateStart,dateFinish);	
	}
	
	@PostMapping("/chartByDateStarts2")
	public @ResponseBody List<CotizacionModel> chartByDateStart2(@ModelAttribute("datesmodel")  DateModel datesmodel) {	
		 String dateStart= datesmodel.getDateStart();
		 String dateFinish= datesmodel.getDateFinish();
		System.out.println("entro reques2-> "+dateStart+" final "+dateFinish);
		return cotizacion.chartByDate(dateStart,dateFinish);	
	}
	
	@PostMapping("/download/customers.xlsx")
    public ResponseEntity<InputStreamResource> excelCustomersReport(@ModelAttribute("datesmodel")  DateModel datesmodel) throws IOException {
		String dateStart= datesmodel.getDateStart();
		 String dateFinish= datesmodel.getDateFinish();
		 System.out.println("entro reques2 xls-> "+dateStart+" final "+dateFinish);
    ByteArrayInputStream in = createXls.create(cotizacion.chartByDate(dateStart,dateFinish));
    // return IOUtils.toByteArray(in);
    
    HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=cotizacion.xls");
    
     return ResponseEntity
                  .ok()
                  .headers(headers)
                  .body(new InputStreamResource(in));
    }
	
	@GetMapping("/home")
	  public String home() {
	    return "home";
	  }

}
