package com.indicador.mapfre.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.indicador.mapfre.entity.CMCentralMedica;
import com.indicador.mapfre.entity.CMCpt;
import com.indicador.mapfre.entity.CMDocumentos;
import com.indicador.mapfre.entity.CMHonorariosMed;
import com.indicador.mapfre.entity.CMMedicamentos;
import com.indicador.mapfre.entity.CMSdaValoracion;
import com.indicador.mapfre.entity.CMServicios;
import com.indicador.mapfre.entity.CMSiniestros;

public class CMCentralMedicaModel {


	private Long idSolicitud;
	
	private Long codSector;
	
	private Long idTipoSolicitud;
	
	private String folio;
	
	private String  folioReapertura;
	
	private String tipoTramite;
	
	private String subTipoTramite;
	

	private String tienePreautorizacion;
	
	private String folioPreautorizacion;
	
	private String nombreProveedor;
	
	private String estadoRepublica;
	
	private String nivelHospitalario;
	
	private String  fechaIngreso;
	
	private String urgencia;

	private String habitacionAsignada;

	private Long numeroPoliza;

	private String ramo;

	private String polizaPagadaHasta;

	private String inicioVigencia;

	private String finVigencia;

	private String polProcesoEmision;

	private String nombreContratante;

	private String razonSocialContratante;

	private String categoriaAsegurado;

	private String recienNacido;

	private String primerNombrePaciente;
	
	private String  segundoNombrePaciente;
	
	private String apellidoPaternoPaciente;
	
	private String apellidoMaternoPaciente;
	
	private Long numeroRiesgo;
	
	private String fechaNacimientoPaciente;
	
	private String generoPaciente;
	
	private String titularPoliza;
	
	private String medicoRed;
	
	private String nombreMedico;
	
	private String especialidadMedico;
	
	private String redProveedor;
	
	private String sintomasDiagnostico;
	
	private String femiliarResponsable;
	
	private String telFamiliarResponsable;
	
	private String nombreReportante;
	
	private String telefonoReportante;
	
	private String emailReportante;
	
	private String observacionesIngreso;
	
	private String estatusTramite;
	
	private String tienePrefacturas;
	
	private String tieneHonMed;
	
	private String tieneMedicamentos;
	
	private String tieneServicios;
	
	private String territorioAtencion;
	
	private String tipoMoneda;
	
	private String fechaEgresoHospitalaria;
	
	private String tieneInsumoRecobro;
	
	private String montoAutProg;
	
	private String importeEdoCuentaSdesv;
	
	private String desviosEdoCuenta;
	
	private String baseIndemnizacion;
	
	private String montoAutHospital;
	
	private String montoConIva;
	
	private BigDecimal deducibleConGastosNocub;
	
	private BigDecimal coaseguroMedico; 
	
	private String totalCargoPaciente;
	
	private String baseRechazo;
	
	private String  subespecialidad;
	
	private String domicilioProveedor;
	
	private BigDecimal montoAutorizadoSdava;
	
	private String folioRamSgaval;
	
	private String telefonoUnoSdaval;
	
	private String telefonodosSdaval;
	
	private String emailUnoSdaval;
	
	private String observqacionesExternas;
	
	private String observacionesInternas;
	
	private String usuarioActual;

	private String usuarioReporte;
	
	private String correoReporte;
	
	private String usuarioAsignado;
	
	private String correoAsignado;
	
	private String usuarioDictaminador;
	
	private String correoDictaminador;
	

	private Long taskIdTomaReporte;
	
	private Long taskIdAsignacion;
	
	private Long taskIdDictaminacion;
	
	private Long taskIdActual;
	
	private String creationDate;
	
	private String createBy;
	
	private String lastupdateDate;
	
	private String lastUpdateBy;
	
	private String tipoAsignacion;
	
	private String nivelComplejidad;
	
	private String tipoPagoSdaval;
	
	private String tipoReservaSdal;

	private String subespecialidadSdaval;
	
	private String domicilioProveedorSdaval;
	
	private String ciudadSdaval;
	
	private String municipioSdaval;
	
	private String tieneCartaPrefactura;
	
	private String tramitadorReasignado;
	
	/*Siniestros*/
	
	
	private String estado;
	private Long numeroSiniestro;
	private String tipoSiniestro;
	private int porcentajeEdoCta;
	private Long montoSiniestro;
	private String folioRam;
	private String descDiagnostico;
	private String codDiagnistico;
	private String fechaOcurrencia;
	private String causa;
	private String consecuencia;
	private String fechaInicioSintomas;
	private String coberturaAfectada;
	private String tipoPago;
	private String tipoReserva;
	private Long montoReserva;
	private Long remanenteSumaAseg;
	private Long totalAutorizadoHm;
	private String folioRamMed;
	private String ciudadEntrega;
	private String codigoPostalEntrega;
	private String direccionEntrega;
	private String telContactoaseg;
	private String correoNotifAseg;
	private BigDecimal totalAutorizadoMed;
	private String folioRamServ;
	private String totalAutorizadoServ;
	private Long deducibleContratado;
	private Long reduccionDeducible;
	private Long incrementoDeducible;
	private Long totalDeducible;
	private Long coaseguroContratado;
	private Long redCoaSeguroHosp;
	private Long incCoaseguroHosp;
	private Long topeCoaseguro;
	private String tipoTopeCoaseguro;
	private Long totalCoaseguroHosp;
	//private Long coaseguroMedico;
	private Long redCoaseguroMed;
	private Long totalCoaseguroMed;
	private String reduccionCoaseguroMed;
	private String topeIndemnizacion;
	private String totalDeducibleMonto;
	private String deducibleMedicamentos;
	private String coaseguroMedicamentos;
	private String totalMedicamentos;
	private String deducibleServicios;
	private String coaseguroServicios;
	private String totalServicios;
	
	/*DOCUMENTOS*/
	
	private String tipoDocumento;
	private String observaciones;
	private String notificado;
	private String recibido;
	private String indiceProvider;
	
	/*SdaValoracion */
	
	private String integrante;
	private String especialidad;
	private String medicoTratante;
	private int montoAutorizado;
	private String sdafolioRam;
	private String sdatipoPago;
	private String sdatipoReserva;
	private String sdaindiceProvider;
	
	/*Honorarios medicos*/
	
	
	private String hintegrante;
	private String hnombreMedico;
	private String hespecialidad;
	private BigDecimal hmontoAutorizado;
	private String hfolioRam;
	private String htipoPago;
	private String htipoReserva;
	private String hindiceProvider;
	
	/*Medicamentos*/

	private String proveedor;
	private String codigoMedicamento;
	private String descripcionMedicamento;
	private int cantidad;
	private BigDecimal precioAutUnidad; 
	private BigDecimal totalAutorizado;
	private String mindiceProvider;
	
	/*Servicios*/
	
	
	private String razonSocial;
	private String tipoServicio;
	private String subtipoServicio;
	private int sercantidad;
	private BigDecimal serprecioAutUnidad;
	private BigDecimal sertotalAutorizado;
	private String serindiceProvider;
	
	/*CPT*/
	
	private String descripcionCpt;
	private String claveCpt;
	

}
