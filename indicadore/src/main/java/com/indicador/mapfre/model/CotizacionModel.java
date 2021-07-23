package com.indicador.mapfre.model;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import org.springframework.stereotype.Component;

@Component
public class CotizacionModel {

	private String estatus;
	private int numFolios;
	private String porcentaje;
	private float  porcentajeFloat;
	
	public CotizacionModel() {}
	
	public CotizacionModel(String estatus, int numFolios, String porcentaje) {
		super();
		this.setEstatus(estatus);
		this.setNumFolios(numFolios);
		this.setPorcentaje(porcentaje);
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public int getNumFolios() {
		return numFolios;
	}

	public void setNumFolios(int numFolios) {
		this.numFolios = numFolios;
	}

	public String getPorcentaje() {
		System.out.println("get Porcentaje:"+porcentaje);
		return porcentaje;
	}

	public void setPorcentaje(String porcentaje) {
		System.out.println("set PorcentajeCadena "+porcentaje);
		this.porcentaje = porcentaje;
		String porcentajeTMP=porcentaje.trim();
		//porcentajeTMP=porcentajeTMP.substring(0, porcentajeTMP.length()-1);
		this.porcentajeFloat=Float.parseFloat(porcentajeTMP);
		System.out.println("PorcentajeCadena convertido a float:"+porcentajeFloat);
		
	}

	public float getPorcentajeFloat() {
		return porcentajeFloat;
	}
	
	public void setPorcentajeFloat(float porcentajeFloat) {
		this.porcentajeFloat = porcentajeFloat;
		System.out.println("set  PorcentajeFloat:"+porcentajeFloat);
		NumberFormat formatter = new DecimalFormat("0.000000"); 
		this.porcentaje = formatter.format(porcentajeFloat);
		System.out.println("PorcentajeFloat convertido a cadena:"+porcentaje);
		
	}

	
}
