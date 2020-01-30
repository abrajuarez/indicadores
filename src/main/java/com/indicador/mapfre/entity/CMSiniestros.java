package com.indicador.mapfre.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "XxmpfBpmCmSiniestros")
public class CMSiniestros {

	@Id
	private int idSiniestro;
	
	@ManyToOne
	@JoinColumn(name="ID_SOLICITUD", nullable=false)
	private CMCentralMedica centralMedica;
	
	@OneToMany(mappedBy = "siniestro")
	private List<CMCpt> listCpt;
	
	@OneToMany(mappedBy = "siniestro")
	private List<CMHonorariosMed> listHonorarios;
	
	@OneToMany(mappedBy = "siniestro")
	private List<CMMedicamentos> listMedicamentos;
	
	@OneToMany(mappedBy = "siniestro")
	private List<CMServicios> listServicios;
	
	@Column(name="ESTADO")
	private String estado;
	
	@Column(name="NUMERO_SINIESTRO")
	private int numeroSiniestro;
	
	@Column(name="TIPO_SINIESTRO")
	private String tipoSiniestro;
	
	@Column(name="PORCENTAJE_EDO_CTA")
	private int porcentajeEdoCta;
	
	@Column(name="MONTO_SINIESTRO")
	private int montoSiniestro;
	
	@Column(name="FOLIO_RAM")
	private String folioRam;
	
	@Column(name="DESC_DIAGNOSTICO")
	private String descDiagnostico;
	
	@Column(name="COD_DIAGNOSTICO")
	private String codDiagnistico;
	
	@Column(name="FECHA_OCURRENCIA")
	private String fechaOcurrencia;
	
	@Column(name="CAUSA")
	private String causa;
	
	@Column(name="CONSECUENCIA")
	private String consecuencia;
	
	@Column(name="FECHA_INICIO_SINTOMAS")
	private String fechaInicioSintomas;
	
	@Column(name="COBERTURA_AFECTADA")
	private String coberturaAfectada;
	
	@Column(name="TIPO_PAGO")
	private String tipoPago;
	
	@Column(name="TIPO_RESERVA")
	private String tipoReserva;
	
	@Column(name="MONTO_RESERVA")
	private int montoReserva;
	
	@Column(name="REMANENTE_SUMA_ASEG")
	private int remanenteSumaAseg;
	
	@Column(name="TOTAL_AUTORIZADO_HM")
	private int totalAutorizadoHm;
	
	@Column(name="FOLIO_RAM_MED")
	private String folioRamMed;
	
	@Column(name="CIUDAD_ENTREGA")
	private String ciudadEntrega;
	
	@Column(name="CODIGO_POSTAL_ENTREGA")
	private String codigoPostalEntrega;
	
	@Column(name="DIRECCION_ENTREGA")
	private String direccionEntrega;
	
	@Column(name="TEL_CONTACTO_ASEG")
	private String telContactoaseg;
	
	@Column(name="CORREO_NOTIF_ASEG")
	private String correoNotifAseg;
	
	@Column(name="TOTAL_AUTORIZADO_MED")
	private BigDecimal totalAutorizadoMed;
	
	@Column(name="FOLIO_RAM_SERV")
	private String folioRamServ;
	
	@Column(name="TOTAL_AUTORIZADO_SERV")
	private String totalAutorizadoServ;
	
	@Column(name="DEDUCIBLE_CONTRATADO")
	private int deducibleContratado;
	
	@Column(name="REDUCCION_DEDUCIBLE")
	private int reduccionDeducible;
	
	@Column(name="INCREMENTO_DEDUCIBLE")
	private int incrementoDeducible;
	
	@Column(name="TOTAL_DEDUCIBLE")
	private int totalDeducible;
	
	@Column(name="COASEGURO_CONTRATADO")
	private int coaseguroContratado;
	
	@Column(name="RED_COASEGURO_HOSP")
	private int redCoaSeguroHosp;
	
	@Column(name="INC_COASEGURO_HOSP")
	private int incCoaseguroHosp;
	
	@Column(name="TOPE_COASEGURO")
	private int topeCoaseguro;
	
	@Column(name="TIPO_TOPE_COASEGURO")
	private String tipoTopeCoaseguro;
	
	@Column(name="TOTAL_COASEGURO_HOSP")
	private int totalCoaseguroHosp;
	
	@Column(name="COASEGURO_MEDICO")
	private int coaseguroMedico;
	
	@Column(name="RED_COASEGURO_MED")
	private int redCoaseguroMed;
	
	@Column(name="TOTAL_COASEGURO_MED")
	private int totalCoaseguroMed;
	
	@Column(name="CREATION_DATE")
	private String creationDate;
	
	@Column(name="CREATED_BY")
	private String createdBy;
	
	@Column(name="LAST_UPDATE_DATE")
	private String lastUpdateDate;
	
	@Column(name="LAST_UPDATED_BY")
	private String lastUpdateBy;
	
	@Column(name="REDUCCION_COASEGURO_MED")
	private String reduccionCoaseguroMed;
	
	@Column(name="TOPE_INDEMNIZACION")
	private String topeIndemnizacion;
	
	@Column(name="TOTAL_DEDUCIBLE_MONTO")
	private String totalDeducibleMonto;
	
	@Column(name="DEDUCIBLE_MEDICAMENTOS")
	private String deducibleMedicamentos;
	
	@Column(name="COASEGURO_MEDICAMENTOS")
	private String coaseguroMedicamentos;
	
	@Column(name="TOTAL_MEDICAMENTOS")
	private String totalMedicamentos;
	
	@Column(name="DEDUCIBLE_SERVICIOS")
	private String deducibleServicios;
	
	@Column(name="COASEGURO_SERVICIOS")
	private String coaseguroServicios;
	
	@Column(name="TOTAL_SERVICIOS")
	private String totalServicios;
}
