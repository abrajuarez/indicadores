package com.indicador.mapfre.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "XxmpfBpmCmBitacora")
public class CMBitacora {

	@Id
	private Long idBitacora;
	
	//ID_REG_PROCESO
	@ManyToOne
	@JoinColumn(name="ID_REG_PROCESO")
	CMRegProceso regProceso;
	
	@Column(name="COD_SECTOR")
	private int codSector;
	
	@Column(name="NOMBRE_PROCESO")
	private String nombreProceso;
	
	@Column(name="NOMBRE_ACTIVIDAD")
	private String nombreActividad;
	
	@Column(name="FECHA_INICIO_ACTIVIDAD")
	private String fechaInicioActividad;
	
	@Column(name="FECHA_FIN_ACTIVIDAD")
	private String fechaFinActividad;
	
	@Column(name="CLAVE_ESTATUS")
	private String claveEstatus;
	
	@Column(name="SECUENCIA")
	private String secuencia;
	
	@Column(name="USUARIO_EJECUTO")
	private String usuarioEjecutivo;
	
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

	public int getCodSector() {
		return codSector;
	}

	public void setCodSector(int codSector) {
		this.codSector = codSector;
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

	public String getFechaInicioActividad() {
		return fechaInicioActividad;
	}

	public void setFechaInicioActividad(String fechaInicioActividad) {
		this.fechaInicioActividad = fechaInicioActividad;
	}

	public String getFechaFinActividad() {
		return fechaFinActividad;
	}

	public void setFechaFinActividad(String fechaFinActividad) {
		this.fechaFinActividad = fechaFinActividad;
	}

	public String getClaveEstatus() {
		return claveEstatus;
	}

	public void setClaveEstatus(String claveEstatus) {
		this.claveEstatus = claveEstatus;
	}

	public String getSecuencia() {
		return secuencia;
	}

	public void setSecuencia(String secuencia) {
		this.secuencia = secuencia;
	}

	public String getUsuarioEjecutivo() {
		return usuarioEjecutivo;
	}

	public void setUsuarioEjecutivo(String usuarioEjecutivo) {
		this.usuarioEjecutivo = usuarioEjecutivo;
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
