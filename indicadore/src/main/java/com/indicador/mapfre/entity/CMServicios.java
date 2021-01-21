package com.indicador.mapfre.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "XxmpfBpmCmServicios", schema = "usrwm9com")
public class CMServicios {


	@Id
	private int idServicio;
	
	//ID_SINIESTRO
	@ManyToOne
	@JoinColumn(name = "ID_SINIESTRO")
	CMSiniestros siniestro;
	
	@Column(name="RAZON_SOCIAL")
	private String razonSocial;
	
	@Column(name="TIPO_SERVICIO")
	private String tipoServicio;
	
	@Column(name="SUBTIPO_SERVICIO")
	private String subtipoServicio;
	
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

	public int getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(int idServicio) {
		this.idServicio = idServicio;
	}

	public CMSiniestros getSiniestro() {
		return siniestro;
	}

	public void setSiniestro(CMSiniestros siniestro) {
		this.siniestro = siniestro;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getTipoServicio() {
		return tipoServicio;
	}

	public void setTipoServicio(String tipoServicio) {
		this.tipoServicio = tipoServicio;
	}

	public String getSubtipoServicio() {
		return subtipoServicio;
	}

	public void setSubtipoServicio(String subtipoServicio) {
		this.subtipoServicio = subtipoServicio;
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
