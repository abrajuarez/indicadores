package com.indicador.mapfre.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "XxmpfBpmCmCentralmedica")
public class CMCentralMedica {

	@Id
	private int idSolicitud;
	
	@OneToMany(mappedBy = "centralMedica", cascade = CascadeType.ALL)
	private List<CMSiniestros> listSiniestros;
	
	@OneToMany(mappedBy = "centralMedica")
	private List<CMSdaValoracion>listSdaValoracion;
	
	@OneToMany(mappedBy = "centralMedica")
	private List<CMDocumentos >listDocumentos;
	
	@Column(name="COD_SECTOR")
	private int codSector;
	
	@Column(name="ID_TIPO_SOLICITUD")
	private int idTipoSolicitud;
	
	@Column(name="FOLIO")
	private String folio;
	
	@Column(name="FOLIO_REAPERTURA")
	private String  folioReapertura;
	
	@Column(name="TIPO_TRAMITE")
	private String tipoTramite;
	
	@Column(name="SUBTIPO_TRAMITE")
	private String subTipoTramite;
	
	@Column(name="TIENE_PREAUTORIZACION")
	private String tienePreautorizacion;
	
	@Column(name="FOLIO_PREAUTORIZACION")
	private String folioPreautorizacion;
	
	@Column(name="NOMBRE_PROVEEDOR")
	private String nombreProveedor;
	
	@Column(name="ESTADO_REPUBLICA")
	private String estadoRepublica;
	
	@Column(name="NIVEL_HOSPITALARIO")
	private String nivelHospitalario;
	
	@Column(name="FECHA_INGRESO")
	private String  fechaIngreso;
	

	@Column(name="URGENCIA")
	private String urgencia;

	@Column(name="HABITACION_ASIGNADA")
	private String habitacionAsignada;

	@Column(name="NUMERO_POLIZA")
	private int numeroPoliza;

	@Column(name="RAMO")
	private String ramo;

	@Column(name="POLIZA_PAGADA_HASTA")
	private String polizaPagadaHasta;

	@Column(name="INICIO_VIGENCIA")
	private String inicioVigencia;

	@Column(name="FIN_VIGENCIA")
	private String finVigencia;

	@Column(name="POL_PROCESO_EMISION")
	private String polProcesoEmision;

	@Column(name="NOMBRE_CONTRATANTE")
	private String nombreContratante;

	@Column(name="RAZON_SOCIAL_CONTRATANTE")
	private String razonSocialContratante;

	@Column(name="CATEGORIA_ASEGURADO")
	private String categoriaAsegurado;

	@Column(name="RECIEN_NACIDO")
	private String recienNacido;

	@Column(name="PRIMER_NOMBRE_PACIENTE")
	private String primerNombrePaciente;
	
	@Column(name="SEGUNDO_NOMBRE_PACIENTE")
	private String  segundoNombrePaciente;
	
	@Column(name="APELLIDO_PATERNO_PACIENTE")
	private String apellidoPaternoPaciente;
	
	@Column(name="APELLIDO_MATERNO_PACIENTE")
	private String apellidoMaternoPaciente;
	
	@Column(name="NUMERO_RIESGO")
	private int numeroRiesgo;
	
	@Column(name="FECHA_NACIMIENTO_PACIENTE")
	private String fechaNacimientoPaciente;
	
	@Column(name="GENERO_PACIENTE")
	private String generoPaciente;
	
	@Column(name="TITULAR_POLIZA")
	private String titularPoliza;
	
	@Column(name="MEDICO_RED")
	private String medicoRed;
	
	@Column(name="NOMBRE_MEDICO")
	private String nombreMedico;
	
	@Column(name="ESPECIALIDAD_MEDICO")
	private String especialidadMedico;
	
	@Column(name="RED_PROVEEDOR")
	private String redProveedor;
	
	@Column(name="SINTOMAS_DIAGNOSTICO")
	private String sintomasDiagnostico;
	
	@Column(name="FAMILIAR_RESPONSABLE")
	private String femiliarResponsable;
	
	@Column(name="TEL_FAMILIAR_RESPONSABLE")
	private String telFamiliarResponsable;
	
	@Column(name="NOMBRE_REPORTANTE")
	private String nombreReportante;
	
	@Column(name="TELEFONO_REPORTANTE")
	private String telefonoReportante;
	
	@Column(name="EMAIL_REPORTANTE")
	private String emailReportante;
	
	@Column(name="OBSERVACIONES_INGRESO")
	private String observacionesIngreso;
	
	@Column(name="ESTATUS_TRAMITE")
	private String estatusTramite;
	
	@Column(name="TIENE_PREFACTURAS")
	private String tienePrefacturas;
	
	@Column(name="TIENE_HON_MED")
	private String tieneHonMed;
	
	@Column(name="TIENE_MEDICAMENTOS")
	private String tieneMedicamentos;
	
	@Column(name="TIENE_SERVICIOS")
	private String tieneServicios;
	
	@Column(name="TERRITORIO_ATENCION")
	private String territorioAtencion;
	
	@Column(name="TIPO_MONEDA")
	private String tipoMoneda;
	
	@Column(name="FECHA_EGRESO_HOSPITALARIA")
	private String fechaEgresoHospitalaria;
	
	@Column(name="TIENE_INSUMO_RECOBRO")
	private String tieneInsumoRecobro;
	
	@Column(name="MONTO_AUT_EV_PROG")
	private String montoAutProg;
	
	@Column(name="IMPORTE_EDO_CUENTA_SDESV")
	private String importeEdoCuentaSdesv;
	
	@Column(name="DESVIOS_EDO_CUENTA")
	private String desviosEdoCuenta;
	
	@Column(name="BASE_INDEMNIZACION")
	private String baseIndemnizacion;
	
	@Column(name="MONTO_AUT_HOSPITA")
	private String montoAutHospital;
	
	@Column(name="MONTO_CON_IVA")
	private String montoConIva;
	
	@Column(name="DEDUCIBE_COA_GASTOS_NOCUB")
	private int deducibleConGastosNocub;
	
	@Column(name="COASEGURO_MEDICO")
	private int coaseguroMedico; 
	
	@Column(name="TOTAL_CARGO_PACIENTE")
	private String totalCargoPaciente;
	
	@Column(name="BASES_RECHAZO")
	private String baseRechazo;
	
	@Column(name="SUBESPECIALIDAD")
	private String  subespecialidad;
	
	@Column(name="DOMICILIO_PROVEEDOR")
	private String domicilioProveedor;
	
	@Column(name="MONTO_AUTORIZADO_SDAVA")
	private int montoAutorizadoSdava;
	
	@Column(name="FOLIO_RAM_SGAVAL")
	private String folioRamSgaval;
	
	@Column(name="TELEFONO_UNO_SDAVAL")
	private String telefonoUnoSdaval;
	
	@Column(name="TELEFONO_DOS_SDAVAL")
	private String telefonodosSdaval;
	
	@Column(name="EMAIL_UNO_SDAVAL")
	private String emailUnoSdaval;
	
	@Column(name="OBSERVACIONES_EXTERNAS")
	private String observqacionesExternas;
	
	@Column(name="OBSERVACIONES_INTERNAS")
	private String observacionesInternas;
	
	@Column(name="USUARIO_ACTUAL")
	private String usuarioActual;
	
	@Column(name="USUARIO_REPORTE")
	private String usuarioReporte;
	
	@Column(name="CORREO_REPORTE")
	private String correoReporte;
	
	@Column(name="USUARIO_ASIGNADOR")
	private String usuarioAsignado;
	
	@Column(name="CORREO_ASIGNADOR")
	private String correoAsignado;
	
	@Column(name="USUARIO_DICTAMINADOR")
	private String usuarioDictaminador;
	
	@Column(name="CORREO_DICTAMINADOR")
	private String correoDictaminador;
	
	@Column(name="FTASK_ID_TOMA_REPORTE")
	private int ftaskIdTomaReporte;
	
	@Column(name="TASK_ID_ASIGNACION")
	private int taskIdAsignacion;
	
	@Column(name="TASK_ID_DICTAMINACION")
	private int taskIdDictaminacion;
	
	@Column(name="TASK_ID_ACTUAL")
	private int taskIdActual;
	
	@Column(name="CREATION_DATE")
	private String creationDate;
	
	@Column(name="CREATED_BY")
	private String createBy;
	
	@Column(name="LAST_UPDATE_DATE")
	private String lastupdateDate;
	
	@Column(name="LAST_UPDATED_BY")
	private String lastUpdateBy;
	
	@Column(name="TIPO_ASIGNACION")
	private String tipoAsignacion;
	
	@Column(name="NIVEL_COMPLEJIDAD")
	private String nivelComplejidad;
	
	@Column(name="TIPO_PAGO_SDAVAL")
	private String tipoPagoSdaval;
	
	@Column(name="TIPO_RESERVA_SDAVAL")
	private String tipoReservaSdal;
	
	@Column(name="SUBESPECIALIDAD_SDAVAL")
	private String subespecialidadSdaval;
	
	@Column(name="DOMICILIO_PROVEEDOR_SDAVAL")
	private String domicilioProveedorSdaval;
	
	@Column(name="CIUDAD_SDAVAL")
	private String ciudadSdaval;
	
	@Column(name="MUNICIPIO_SDAVAL")
	private String municipioSdaval;
	
	@Column(name="TIENE_CARTA_PREFACTURA")
	private String tieneCartaPrefactura;
	
	@Column(name="TRAMITADOR_REASIGNADO")
	private String tramitadorReasignado;
}
