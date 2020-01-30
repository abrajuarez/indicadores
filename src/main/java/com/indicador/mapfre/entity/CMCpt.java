package com.indicador.mapfre.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "XxmpfBpmCmCpt")
public class CMCpt {

	@Id
	private Long idCpt;
	//ID_SINIESTRO
	@ManyToOne
	@JoinColumn(name = "siniestro")
	CMSiniestros siniestro;
	
	@Column(name="CODIGO_CPT")
	private String descripcionCpt;
	
	@Column(name="DESCRIPCION_CPT")
	private String claveCpt;
	
	
	
	@Column(name="CREATION_DATE")
	private String creationDate;
	
	@Column(name="CREATED_BY")
	private String createdBy;
	
	@Column(name="LAST_UPDATED_DATE")
	private String lastUpdatedDate;
	
	@Column(name="LAST_UPDATED_BY")
	private String lastUpdatedBy;

	public Long getIdCpt() {
		return idCpt;
	}

	public void setIdCpt(Long idCpt) {
		this.idCpt = idCpt;
	}

	public CMSiniestros getSiniestro() {
		return siniestro;
	}

	public void setSiniestro(CMSiniestros siniestro) {
		this.siniestro = siniestro;
	}

	public String getDescripcionCpt() {
		return descripcionCpt;
	}

	public void setDescripcionCpt(String descripcionCpt) {
		this.descripcionCpt = descripcionCpt;
	}

	public String getClaveCpt() {
		return claveCpt;
	}

	public void setClaveCpt(String claveCpt) {
		this.claveCpt = claveCpt;
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

	public String getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(String lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}
	
	
}
