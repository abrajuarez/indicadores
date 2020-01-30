package com.indicador.mapfre.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "XxmpfBpmCmMedicamentos")
public class CMMedicamentos {

	@Id
	private int idMedicamento;
	//ID_SINIESTRO
	@ManyToOne
	@JoinColumn(name = "siniestro")
	CMSiniestros siniestro;
	
	@Column(name="PROVEEDOR")
	private String proveedor;
	
	@Column(name="CODIGO_MEDICAMENTO")
	private String codigoMedicamento;
	
	@Column(name="DESCRIPCION_MEDICAMENTO")
	private String descripcionMedicamento;
	
	@Column(name="CANTIDAD")
	private int cantidad;
	
	@Column(name="PRECIO_AUT_UNIDAD")
	private BigDecimal precioAutUnidad; 
	
	@Column(name="TOTAL_AUTORIZADO")
	private BigDecimal totalAutorizado;
	
	@Column(name="CREATION_DATE")
	private String creationDate;
	
	@Column(name="CREATED_BY")
	private String createdBy;
	
	@Column(name="LAST_UPDATE_DATE")
	private String lastUpdateDate;
	
	@Column(name="LAST_UPDATED_BY")
	private String lastUpdateBy;
	
	@Column(name="INDICE_PROVIDER")
	private String indiceProvider;

	public int getIdMedicamento() {
		return idMedicamento;
	}

	public void setIdMedicamento(int idMedicamento) {
		this.idMedicamento = idMedicamento;
	}

	public CMSiniestros getSiniestro() {
		return siniestro;
	}

	public void setSiniestro(CMSiniestros siniestro) {
		this.siniestro = siniestro;
	}

	public String getProveedor() {
		return proveedor;
	}

	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}

	public String getCodigoMedicamento() {
		return codigoMedicamento;
	}

	public void setCodigoMedicamento(String codigoMedicamento) {
		this.codigoMedicamento = codigoMedicamento;
	}

	public String getDescripcionMedicamento() {
		return descripcionMedicamento;
	}

	public void setDescripcionMedicamento(String descripcionMedicamento) {
		this.descripcionMedicamento = descripcionMedicamento;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getPrecioAutUnidad() {
		return precioAutUnidad;
	}

	public void setPrecioAutUnidad(BigDecimal precioAutUnidad) {
		this.precioAutUnidad = precioAutUnidad;
	}

	public BigDecimal getTotalAutorizado() {
		return totalAutorizado;
	}

	public void setTotalAutorizado(BigDecimal totalAutorizado) {
		this.totalAutorizado = totalAutorizado;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(String lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public String getLastUpdateBy() {
		return lastUpdateBy;
	}

	public void setLastUpdateBy(String lastUpdateBy) {
		this.lastUpdateBy = lastUpdateBy;
	}

	public String getIndiceProvider() {
		return indiceProvider;
	}

	public void setIndiceProvider(String indiceProvider) {
		this.indiceProvider = indiceProvider;
	}
	
	
}
