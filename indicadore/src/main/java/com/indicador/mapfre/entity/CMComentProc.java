package com.indicador.mapfre.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "XxmpfBpmCmComentProc", schema = "usrwm9com")
public class CMComentProc {

	@Id
	private Long idBitacora;
	
	//ID_REG_PROCESO
	@ManyToOne
	@JoinColumn(name="ID_REG_PROCESO")
	CMRegProceso regProceso;
	
	@Column(name="COMENTARIO")
	private String comentario;
	
	@Column(name="FECHA_COMENTARIO")
	private String fechaComentario;
	
	@Column(name="NOMBRE_PROCESO")
	private String  nombreProceso;
	
	@Column(name="NOMBRE_ACTIVIDAD")
	private String nombreActividad;
	
	@Column(name="SECUENCIA")
	private int secuencia;
	
	@Column(name="CREATION_DATE")
	private String creationDate;
	
	@Column(name="CREATED_BY")
	private String  createdBy;
	
	@Column(name="LAST_UPDATE_DATE")
	private String lastUpdateDate;
	
	@Column(name="LAST_UPDATED_BY")
	private String lastUpdatedBy;

	public Long getIdBitacora() {
		return idBitacora;
	}

	public void setIdBitacora(Long idBitacora) {
		this.idBitacora = idBitacora;
	}

	public CMRegProceso getRegProceso() {
		return regProceso;
	}

	public void setRegProceso(CMRegProceso regProceso) {
		this.regProceso = regProceso;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getFechaComentario() {
		return fechaComentario;
	}

	public void setFechaComentario(String fechaComentario) {
		this.fechaComentario = fechaComentario;
	}

	public String getNombreProceso() {
		return nombreProceso;
	}

	public void setNombreProceso(String nombreProceso) {
		this.nombreProceso = nombreProceso;
	}

	public String getNombreActividad() {
		return nombreActividad;
	}

	public void setNombreActividad(String nombreActividad) {
		this.nombreActividad = nombreActividad;
	}

	public int getSecuencia() {
		return secuencia;
	}

	public void setSecuencia(int secuencia) {
		this.secuencia = secuencia;
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

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}
	
	
}
