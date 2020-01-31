package com.indicador.mapfre.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "XxmpfBpmCmSdavaloracion")
public class CMSdaValoracion {

	@Id
	private int IdSdavaloracion;
	
	@ManyToOne
	@JoinColumn(name="ID_SOLICITUD")
	private CMCentralMedica centralMedica;
	
	@Column(name="INTEGRANTE")
	private String integrante;
	
	@Column(name="ESPECIALIDAD")
	private String especialidad;
	
	@Column(name="MEDICO_TRATANTE")
	private String medicoTratante;
	
	@Column(name="MONTO_AUTORIZADO")
	private int montoAutorizado;
	
	@Column(name="FOLIO_RAM")
	private String folioRam;
	
	@Column(name="TIPO_PAGO")
	private String tipoPago;
	
	@Column(name="TIPO_RESERVA")
	private String tipoReserva;
	
	@Column(name="CREATION_DATE")
	private String creationDate;
	
	@Column(name="CREATED_BY")
	private String  createdBy;
	
	@Column(name="LAST_UPDATE_DATE")
	private String lastUpdateDate;
	
	@Column(name="LAST_UPDATED_BY")
	private String lastUpdatedBy;
	
	@Column(name="INDICE_PROVIDER")
	private String indiceProvider;

	public int getIdSdavaloracion() {
		return IdSdavaloracion;
	}

	public void setIdSdavaloracion(int idSdavaloracion) {
		IdSdavaloracion = idSdavaloracion;
	}

	public CMCentralMedica getCentralMedica() {
		return centralMedica;
	}

	public void setCentralMedica(CMCentralMedica centralMedica) {
		this.centralMedica = centralMedica;
	}

	public String getIntegrante() {
		return integrante;
	}

	public void setIntegrante(String integrante) {
		this.integrante = integrante;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public String getMedicoTratante() {
		return medicoTratante;
	}

	public void setMedicoTratante(String medicoTratante) {
		this.medicoTratante = medicoTratante;
	}

	public int getMontoAutorizado() {
		return montoAutorizado;
	}

	public void setMontoAutorizado(int montoAutorizado) {
		this.montoAutorizado = montoAutorizado;
	}

	public String getFolioRam() {
		return folioRam;
	}

	public void setFolioRam(String folioRam) {
		this.folioRam = folioRam;
	}

	public String getTipoPago() {
		return tipoPago;
	}

	public void setTipoPago(String tipoPago) {
		this.tipoPago = tipoPago;
	}

	public String getTipoReserva() {
		return tipoReserva;
	}

	public void setTipoReserva(String tipoReserva) {
		this.tipoReserva = tipoReserva;
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

	public String getIndiceProvider() {
		return indiceProvider;
	}

	public void setIndiceProvider(String indiceProvider) {
		this.indiceProvider = indiceProvider;
	}
	
	
}
