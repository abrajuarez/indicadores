package com.indicador.mapfre.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "XxmpfBpmSdavaloracion")
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
}
