package com.indicador.mapfre.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "XxmpfBpmCmHonorariosmed")
public class CMHonorariosMed {

	@Id
	private int idHonorarioMedico;
	//ID_SINIESTRO
	@ManyToOne
	@JoinColumn(name = "siniestro")
	CMSiniestros siniestro;
	
	@Column(name="INTEGRANTE")
	private String integrante;
	
	@Column(name="NOMBRE_MEDICO")
	private String nombreMedico;
	
	@Column(name="ESPECIALIDAD")
	private String especialidad;
	
	@Column(name="MONTO_AUTORIZADO")
	private BigDecimal montoAutorizado;
	
	@Column(name="FOLIO_RAM")
	private String folioRam;
	
	@Column(name="TIPO_PAGO")
	private String tipoPago;
	
	@Column(name="TIPO_RESERVA")
	private String tipoReserva;
	
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
}
