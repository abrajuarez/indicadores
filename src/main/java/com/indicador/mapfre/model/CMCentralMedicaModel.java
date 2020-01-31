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

import com.indicador.mapfre.entity.CMBitacora;
import com.indicador.mapfre.entity.CMCentralMedica;
import com.indicador.mapfre.entity.CMComentProc;
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
	
	/*Proceso*/
	
	
	private int procsesocodSector;
	private int codProceso;
	
	/*Bitacora*/
	
	private int bitacodSector;
	
	private String nombreProceso;
	
	private String nombreActividad;
	
	private String fechaInicioActividad;
	
	private String fechaFinActividad;
	
	private String claveEstatus;
	
	private String secuencia;
	
	private String usuarioEjecutivo;
	
	/*ComentProc*/
	
	private String comentario;
	
	private String fechaComentario;
	
	private String  comentnombreProceso;
	
	private String comentnombreActividad;
	
	private int comentsecuencia;

	public Long getIdSolicitud() {
		return idSolicitud;
	}

	public void setIdSolicitud(Long idSolicitud) {
		this.idSolicitud = idSolicitud;
	}

	public Long getCodSector() {
		return codSector;
	}

	public void setCodSector(Long codSector) {
		this.codSector = codSector;
	}

	public Long getIdTipoSolicitud() {
		return idTipoSolicitud;
	}

	public void setIdTipoSolicitud(Long idTipoSolicitud) {
		this.idTipoSolicitud = idTipoSolicitud;
	}

	public String getFolio() {
		return folio;
	}

	public void setFolio(String folio) {
		this.folio = folio;
	}

	public String getFolioReapertura() {
		return folioReapertura;
	}

	public void setFolioReapertura(String folioReapertura) {
		this.folioReapertura = folioReapertura;
	}

	public String getTipoTramite() {
		return tipoTramite;
	}

	public void setTipoTramite(String tipoTramite) {
		this.tipoTramite = tipoTramite;
	}

	public String getSubTipoTramite() {
		return subTipoTramite;
	}

	public void setSubTipoTramite(String subTipoTramite) {
		this.subTipoTramite = subTipoTramite;
	}

	public String getTienePreautorizacion() {
		return tienePreautorizacion;
	}

	public void setTienePreautorizacion(String tienePreautorizacion) {
		this.tienePreautorizacion = tienePreautorizacion;
	}

	public String getFolioPreautorizacion() {
		return folioPreautorizacion;
	}

	public void setFolioPreautorizacion(String folioPreautorizacion) {
		this.folioPreautorizacion = folioPreautorizacion;
	}

	public String getNombreProveedor() {
		return nombreProveedor;
	}

	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}

	public String getEstadoRepublica() {
		return estadoRepublica;
	}

	public void setEstadoRepublica(String estadoRepublica) {
		this.estadoRepublica = estadoRepublica;
	}

	public String getNivelHospitalario() {
		return nivelHospitalario;
	}

	public void setNivelHospitalario(String nivelHospitalario) {
		this.nivelHospitalario = nivelHospitalario;
	}

	public String getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public String getUrgencia() {
		return urgencia;
	}

	public void setUrgencia(String urgencia) {
		this.urgencia = urgencia;
	}

	public String getHabitacionAsignada() {
		return habitacionAsignada;
	}

	public void setHabitacionAsignada(String habitacionAsignada) {
		this.habitacionAsignada = habitacionAsignada;
	}

	public Long getNumeroPoliza() {
		return numeroPoliza;
	}

	public void setNumeroPoliza(Long numeroPoliza) {
		this.numeroPoliza = numeroPoliza;
	}

	public String getRamo() {
		return ramo;
	}

	public void setRamo(String ramo) {
		this.ramo = ramo;
	}

	public String getPolizaPagadaHasta() {
		return polizaPagadaHasta;
	}

	public void setPolizaPagadaHasta(String polizaPagadaHasta) {
		this.polizaPagadaHasta = polizaPagadaHasta;
	}

	public String getInicioVigencia() {
		return inicioVigencia;
	}

	public void setInicioVigencia(String inicioVigencia) {
		this.inicioVigencia = inicioVigencia;
	}

	public String getFinVigencia() {
		return finVigencia;
	}

	public void setFinVigencia(String finVigencia) {
		this.finVigencia = finVigencia;
	}

	public String getPolProcesoEmision() {
		return polProcesoEmision;
	}

	public void setPolProcesoEmision(String polProcesoEmision) {
		this.polProcesoEmision = polProcesoEmision;
	}

	public String getNombreContratante() {
		return nombreContratante;
	}

	public void setNombreContratante(String nombreContratante) {
		this.nombreContratante = nombreContratante;
	}

	public String getRazonSocialContratante() {
		return razonSocialContratante;
	}

	public void setRazonSocialContratante(String razonSocialContratante) {
		this.razonSocialContratante = razonSocialContratante;
	}

	public String getCategoriaAsegurado() {
		return categoriaAsegurado;
	}

	public void setCategoriaAsegurado(String categoriaAsegurado) {
		this.categoriaAsegurado = categoriaAsegurado;
	}

	public String getRecienNacido() {
		return recienNacido;
	}

	public void setRecienNacido(String recienNacido) {
		this.recienNacido = recienNacido;
	}

	public String getPrimerNombrePaciente() {
		return primerNombrePaciente;
	}

	public void setPrimerNombrePaciente(String primerNombrePaciente) {
		this.primerNombrePaciente = primerNombrePaciente;
	}

	public String getSegundoNombrePaciente() {
		return segundoNombrePaciente;
	}

	public void setSegundoNombrePaciente(String segundoNombrePaciente) {
		this.segundoNombrePaciente = segundoNombrePaciente;
	}

	public String getApellidoPaternoPaciente() {
		return apellidoPaternoPaciente;
	}

	public void setApellidoPaternoPaciente(String apellidoPaternoPaciente) {
		this.apellidoPaternoPaciente = apellidoPaternoPaciente;
	}

	public String getApellidoMaternoPaciente() {
		return apellidoMaternoPaciente;
	}

	public void setApellidoMaternoPaciente(String apellidoMaternoPaciente) {
		this.apellidoMaternoPaciente = apellidoMaternoPaciente;
	}

	public Long getNumeroRiesgo() {
		return numeroRiesgo;
	}

	public void setNumeroRiesgo(Long numeroRiesgo) {
		this.numeroRiesgo = numeroRiesgo;
	}

	public String getFechaNacimientoPaciente() {
		return fechaNacimientoPaciente;
	}

	public void setFechaNacimientoPaciente(String fechaNacimientoPaciente) {
		this.fechaNacimientoPaciente = fechaNacimientoPaciente;
	}

	public String getGeneroPaciente() {
		return generoPaciente;
	}

	public void setGeneroPaciente(String generoPaciente) {
		this.generoPaciente = generoPaciente;
	}

	public String getTitularPoliza() {
		return titularPoliza;
	}

	public void setTitularPoliza(String titularPoliza) {
		this.titularPoliza = titularPoliza;
	}

	public String getMedicoRed() {
		return medicoRed;
	}

	public void setMedicoRed(String medicoRed) {
		this.medicoRed = medicoRed;
	}

	public String getNombreMedico() {
		return nombreMedico;
	}

	public void setNombreMedico(String nombreMedico) {
		this.nombreMedico = nombreMedico;
	}

	public String getEspecialidadMedico() {
		return especialidadMedico;
	}

	public void setEspecialidadMedico(String especialidadMedico) {
		this.especialidadMedico = especialidadMedico;
	}

	public String getRedProveedor() {
		return redProveedor;
	}

	public void setRedProveedor(String redProveedor) {
		this.redProveedor = redProveedor;
	}

	public String getSintomasDiagnostico() {
		return sintomasDiagnostico;
	}

	public void setSintomasDiagnostico(String sintomasDiagnostico) {
		this.sintomasDiagnostico = sintomasDiagnostico;
	}

	public String getFemiliarResponsable() {
		return femiliarResponsable;
	}

	public void setFemiliarResponsable(String femiliarResponsable) {
		this.femiliarResponsable = femiliarResponsable;
	}

	public String getTelFamiliarResponsable() {
		return telFamiliarResponsable;
	}

	public void setTelFamiliarResponsable(String telFamiliarResponsable) {
		this.telFamiliarResponsable = telFamiliarResponsable;
	}

	public String getNombreReportante() {
		return nombreReportante;
	}

	public void setNombreReportante(String nombreReportante) {
		this.nombreReportante = nombreReportante;
	}

	public String getTelefonoReportante() {
		return telefonoReportante;
	}

	public void setTelefonoReportante(String telefonoReportante) {
		this.telefonoReportante = telefonoReportante;
	}

	public String getEmailReportante() {
		return emailReportante;
	}

	public void setEmailReportante(String emailReportante) {
		this.emailReportante = emailReportante;
	}

	public String getObservacionesIngreso() {
		return observacionesIngreso;
	}

	public void setObservacionesIngreso(String observacionesIngreso) {
		this.observacionesIngreso = observacionesIngreso;
	}

	public String getEstatusTramite() {
		return estatusTramite;
	}

	public void setEstatusTramite(String estatusTramite) {
		this.estatusTramite = estatusTramite;
	}

	public String getTienePrefacturas() {
		return tienePrefacturas;
	}

	public void setTienePrefacturas(String tienePrefacturas) {
		this.tienePrefacturas = tienePrefacturas;
	}

	public String getTieneHonMed() {
		return tieneHonMed;
	}

	public void setTieneHonMed(String tieneHonMed) {
		this.tieneHonMed = tieneHonMed;
	}

	public String getTieneMedicamentos() {
		return tieneMedicamentos;
	}

	public void setTieneMedicamentos(String tieneMedicamentos) {
		this.tieneMedicamentos = tieneMedicamentos;
	}

	public String getTieneServicios() {
		return tieneServicios;
	}

	public void setTieneServicios(String tieneServicios) {
		this.tieneServicios = tieneServicios;
	}

	public String getTerritorioAtencion() {
		return territorioAtencion;
	}

	public void setTerritorioAtencion(String territorioAtencion) {
		this.territorioAtencion = territorioAtencion;
	}

	public String getTipoMoneda() {
		return tipoMoneda;
	}

	public void setTipoMoneda(String tipoMoneda) {
		this.tipoMoneda = tipoMoneda;
	}

	public String getFechaEgresoHospitalaria() {
		return fechaEgresoHospitalaria;
	}

	public void setFechaEgresoHospitalaria(String fechaEgresoHospitalaria) {
		this.fechaEgresoHospitalaria = fechaEgresoHospitalaria;
	}

	public String getTieneInsumoRecobro() {
		return tieneInsumoRecobro;
	}

	public void setTieneInsumoRecobro(String tieneInsumoRecobro) {
		this.tieneInsumoRecobro = tieneInsumoRecobro;
	}

	public String getMontoAutProg() {
		return montoAutProg;
	}

	public void setMontoAutProg(String montoAutProg) {
		this.montoAutProg = montoAutProg;
	}

	public String getImporteEdoCuentaSdesv() {
		return importeEdoCuentaSdesv;
	}

	public void setImporteEdoCuentaSdesv(String importeEdoCuentaSdesv) {
		this.importeEdoCuentaSdesv = importeEdoCuentaSdesv;
	}

	public String getDesviosEdoCuenta() {
		return desviosEdoCuenta;
	}

	public void setDesviosEdoCuenta(String desviosEdoCuenta) {
		this.desviosEdoCuenta = desviosEdoCuenta;
	}

	public String getBaseIndemnizacion() {
		return baseIndemnizacion;
	}

	public void setBaseIndemnizacion(String baseIndemnizacion) {
		this.baseIndemnizacion = baseIndemnizacion;
	}

	public String getMontoAutHospital() {
		return montoAutHospital;
	}

	public void setMontoAutHospital(String montoAutHospital) {
		this.montoAutHospital = montoAutHospital;
	}

	public String getMontoConIva() {
		return montoConIva;
	}

	public void setMontoConIva(String montoConIva) {
		this.montoConIva = montoConIva;
	}

	public BigDecimal getDeducibleConGastosNocub() {
		return deducibleConGastosNocub;
	}

	public void setDeducibleConGastosNocub(BigDecimal deducibleConGastosNocub) {
		this.deducibleConGastosNocub = deducibleConGastosNocub;
	}

	public BigDecimal getCoaseguroMedico() {
		return coaseguroMedico;
	}

	public void setCoaseguroMedico(BigDecimal coaseguroMedico) {
		this.coaseguroMedico = coaseguroMedico;
	}

	public String getTotalCargoPaciente() {
		return totalCargoPaciente;
	}

	public void setTotalCargoPaciente(String totalCargoPaciente) {
		this.totalCargoPaciente = totalCargoPaciente;
	}

	public String getBaseRechazo() {
		return baseRechazo;
	}

	public void setBaseRechazo(String baseRechazo) {
		this.baseRechazo = baseRechazo;
	}

	public String getSubespecialidad() {
		return subespecialidad;
	}

	public void setSubespecialidad(String subespecialidad) {
		this.subespecialidad = subespecialidad;
	}

	public String getDomicilioProveedor() {
		return domicilioProveedor;
	}

	public void setDomicilioProveedor(String domicilioProveedor) {
		this.domicilioProveedor = domicilioProveedor;
	}

	public BigDecimal getMontoAutorizadoSdava() {
		return montoAutorizadoSdava;
	}

	public void setMontoAutorizadoSdava(BigDecimal montoAutorizadoSdava) {
		this.montoAutorizadoSdava = montoAutorizadoSdava;
	}

	public String getFolioRamSgaval() {
		return folioRamSgaval;
	}

	public void setFolioRamSgaval(String folioRamSgaval) {
		this.folioRamSgaval = folioRamSgaval;
	}

	public String getTelefonoUnoSdaval() {
		return telefonoUnoSdaval;
	}

	public void setTelefonoUnoSdaval(String telefonoUnoSdaval) {
		this.telefonoUnoSdaval = telefonoUnoSdaval;
	}

	public String getTelefonodosSdaval() {
		return telefonodosSdaval;
	}

	public void setTelefonodosSdaval(String telefonodosSdaval) {
		this.telefonodosSdaval = telefonodosSdaval;
	}

	public String getEmailUnoSdaval() {
		return emailUnoSdaval;
	}

	public void setEmailUnoSdaval(String emailUnoSdaval) {
		this.emailUnoSdaval = emailUnoSdaval;
	}

	public String getObservqacionesExternas() {
		return observqacionesExternas;
	}

	public void setObservqacionesExternas(String observqacionesExternas) {
		this.observqacionesExternas = observqacionesExternas;
	}

	public String getObservacionesInternas() {
		return observacionesInternas;
	}

	public void setObservacionesInternas(String observacionesInternas) {
		this.observacionesInternas = observacionesInternas;
	}

	public String getUsuarioActual() {
		return usuarioActual;
	}

	public void setUsuarioActual(String usuarioActual) {
		this.usuarioActual = usuarioActual;
	}

	public String getUsuarioReporte() {
		return usuarioReporte;
	}

	public void setUsuarioReporte(String usuarioReporte) {
		this.usuarioReporte = usuarioReporte;
	}

	public String getCorreoReporte() {
		return correoReporte;
	}

	public void setCorreoReporte(String correoReporte) {
		this.correoReporte = correoReporte;
	}

	public String getUsuarioAsignado() {
		return usuarioAsignado;
	}

	public void setUsuarioAsignado(String usuarioAsignado) {
		this.usuarioAsignado = usuarioAsignado;
	}

	public String getCorreoAsignado() {
		return correoAsignado;
	}

	public void setCorreoAsignado(String correoAsignado) {
		this.correoAsignado = correoAsignado;
	}

	public String getUsuarioDictaminador() {
		return usuarioDictaminador;
	}

	public void setUsuarioDictaminador(String usuarioDictaminador) {
		this.usuarioDictaminador = usuarioDictaminador;
	}

	public String getCorreoDictaminador() {
		return correoDictaminador;
	}

	public void setCorreoDictaminador(String correoDictaminador) {
		this.correoDictaminador = correoDictaminador;
	}

	public Long getTaskIdTomaReporte() {
		return taskIdTomaReporte;
	}

	public void setTaskIdTomaReporte(Long taskIdTomaReporte) {
		this.taskIdTomaReporte = taskIdTomaReporte;
	}

	public Long getTaskIdAsignacion() {
		return taskIdAsignacion;
	}

	public void setTaskIdAsignacion(Long taskIdAsignacion) {
		this.taskIdAsignacion = taskIdAsignacion;
	}

	public Long getTaskIdDictaminacion() {
		return taskIdDictaminacion;
	}

	public void setTaskIdDictaminacion(Long taskIdDictaminacion) {
		this.taskIdDictaminacion = taskIdDictaminacion;
	}

	public Long getTaskIdActual() {
		return taskIdActual;
	}

	public void setTaskIdActual(Long taskIdActual) {
		this.taskIdActual = taskIdActual;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getLastupdateDate() {
		return lastupdateDate;
	}

	public void setLastupdateDate(String lastupdateDate) {
		this.lastupdateDate = lastupdateDate;
	}

	public String getLastUpdateBy() {
		return lastUpdateBy;
	}

	public void setLastUpdateBy(String lastUpdateBy) {
		this.lastUpdateBy = lastUpdateBy;
	}

	public String getTipoAsignacion() {
		return tipoAsignacion;
	}

	public void setTipoAsignacion(String tipoAsignacion) {
		this.tipoAsignacion = tipoAsignacion;
	}

	public String getNivelComplejidad() {
		return nivelComplejidad;
	}

	public void setNivelComplejidad(String nivelComplejidad) {
		this.nivelComplejidad = nivelComplejidad;
	}

	public String getTipoPagoSdaval() {
		return tipoPagoSdaval;
	}

	public void setTipoPagoSdaval(String tipoPagoSdaval) {
		this.tipoPagoSdaval = tipoPagoSdaval;
	}

	public String getTipoReservaSdal() {
		return tipoReservaSdal;
	}

	public void setTipoReservaSdal(String tipoReservaSdal) {
		this.tipoReservaSdal = tipoReservaSdal;
	}

	public String getSubespecialidadSdaval() {
		return subespecialidadSdaval;
	}

	public void setSubespecialidadSdaval(String subespecialidadSdaval) {
		this.subespecialidadSdaval = subespecialidadSdaval;
	}

	public String getDomicilioProveedorSdaval() {
		return domicilioProveedorSdaval;
	}

	public void setDomicilioProveedorSdaval(String domicilioProveedorSdaval) {
		this.domicilioProveedorSdaval = domicilioProveedorSdaval;
	}

	public String getCiudadSdaval() {
		return ciudadSdaval;
	}

	public void setCiudadSdaval(String ciudadSdaval) {
		this.ciudadSdaval = ciudadSdaval;
	}

	public String getMunicipioSdaval() {
		return municipioSdaval;
	}

	public void setMunicipioSdaval(String municipioSdaval) {
		this.municipioSdaval = municipioSdaval;
	}

	public String getTieneCartaPrefactura() {
		return tieneCartaPrefactura;
	}

	public void setTieneCartaPrefactura(String tieneCartaPrefactura) {
		this.tieneCartaPrefactura = tieneCartaPrefactura;
	}

	public String getTramitadorReasignado() {
		return tramitadorReasignado;
	}

	public void setTramitadorReasignado(String tramitadorReasignado) {
		this.tramitadorReasignado = tramitadorReasignado;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Long getNumeroSiniestro() {
		return numeroSiniestro;
	}

	public void setNumeroSiniestro(Long numeroSiniestro) {
		this.numeroSiniestro = numeroSiniestro;
	}

	public String getTipoSiniestro() {
		return tipoSiniestro;
	}

	public void setTipoSiniestro(String tipoSiniestro) {
		this.tipoSiniestro = tipoSiniestro;
	}

	public int getPorcentajeEdoCta() {
		return porcentajeEdoCta;
	}

	public void setPorcentajeEdoCta(int porcentajeEdoCta) {
		this.porcentajeEdoCta = porcentajeEdoCta;
	}

	public Long getMontoSiniestro() {
		return montoSiniestro;
	}

	public void setMontoSiniestro(Long montoSiniestro) {
		this.montoSiniestro = montoSiniestro;
	}

	public String getFolioRam() {
		return folioRam;
	}

	public void setFolioRam(String folioRam) {
		this.folioRam = folioRam;
	}

	public String getDescDiagnostico() {
		return descDiagnostico;
	}

	public void setDescDiagnostico(String descDiagnostico) {
		this.descDiagnostico = descDiagnostico;
	}

	public String getCodDiagnistico() {
		return codDiagnistico;
	}

	public void setCodDiagnistico(String codDiagnistico) {
		this.codDiagnistico = codDiagnistico;
	}

	public String getFechaOcurrencia() {
		return fechaOcurrencia;
	}

	public void setFechaOcurrencia(String fechaOcurrencia) {
		this.fechaOcurrencia = fechaOcurrencia;
	}

	public String getCausa() {
		return causa;
	}

	public void setCausa(String causa) {
		this.causa = causa;
	}

	public String getConsecuencia() {
		return consecuencia;
	}

	public void setConsecuencia(String consecuencia) {
		this.consecuencia = consecuencia;
	}

	public String getFechaInicioSintomas() {
		return fechaInicioSintomas;
	}

	public void setFechaInicioSintomas(String fechaInicioSintomas) {
		this.fechaInicioSintomas = fechaInicioSintomas;
	}

	public String getCoberturaAfectada() {
		return coberturaAfectada;
	}

	public void setCoberturaAfectada(String coberturaAfectada) {
		this.coberturaAfectada = coberturaAfectada;
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

	public Long getMontoReserva() {
		return montoReserva;
	}

	public void setMontoReserva(Long montoReserva) {
		this.montoReserva = montoReserva;
	}

	public Long getRemanenteSumaAseg() {
		return remanenteSumaAseg;
	}

	public void setRemanenteSumaAseg(Long remanenteSumaAseg) {
		this.remanenteSumaAseg = remanenteSumaAseg;
	}

	public Long getTotalAutorizadoHm() {
		return totalAutorizadoHm;
	}

	public void setTotalAutorizadoHm(Long totalAutorizadoHm) {
		this.totalAutorizadoHm = totalAutorizadoHm;
	}

	public String getFolioRamMed() {
		return folioRamMed;
	}

	public void setFolioRamMed(String folioRamMed) {
		this.folioRamMed = folioRamMed;
	}

	public String getCiudadEntrega() {
		return ciudadEntrega;
	}

	public void setCiudadEntrega(String ciudadEntrega) {
		this.ciudadEntrega = ciudadEntrega;
	}

	public String getCodigoPostalEntrega() {
		return codigoPostalEntrega;
	}

	public void setCodigoPostalEntrega(String codigoPostalEntrega) {
		this.codigoPostalEntrega = codigoPostalEntrega;
	}

	public String getDireccionEntrega() {
		return direccionEntrega;
	}

	public void setDireccionEntrega(String direccionEntrega) {
		this.direccionEntrega = direccionEntrega;
	}

	public String getTelContactoaseg() {
		return telContactoaseg;
	}

	public void setTelContactoaseg(String telContactoaseg) {
		this.telContactoaseg = telContactoaseg;
	}

	public String getCorreoNotifAseg() {
		return correoNotifAseg;
	}

	public void setCorreoNotifAseg(String correoNotifAseg) {
		this.correoNotifAseg = correoNotifAseg;
	}

	public BigDecimal getTotalAutorizadoMed() {
		return totalAutorizadoMed;
	}

	public void setTotalAutorizadoMed(BigDecimal totalAutorizadoMed) {
		this.totalAutorizadoMed = totalAutorizadoMed;
	}

	public String getFolioRamServ() {
		return folioRamServ;
	}

	public void setFolioRamServ(String folioRamServ) {
		this.folioRamServ = folioRamServ;
	}

	public String getTotalAutorizadoServ() {
		return totalAutorizadoServ;
	}

	public void setTotalAutorizadoServ(String totalAutorizadoServ) {
		this.totalAutorizadoServ = totalAutorizadoServ;
	}

	public Long getDeducibleContratado() {
		return deducibleContratado;
	}

	public void setDeducibleContratado(Long deducibleContratado) {
		this.deducibleContratado = deducibleContratado;
	}

	public Long getReduccionDeducible() {
		return reduccionDeducible;
	}

	public void setReduccionDeducible(Long reduccionDeducible) {
		this.reduccionDeducible = reduccionDeducible;
	}

	public Long getIncrementoDeducible() {
		return incrementoDeducible;
	}

	public void setIncrementoDeducible(Long incrementoDeducible) {
		this.incrementoDeducible = incrementoDeducible;
	}

	public Long getTotalDeducible() {
		return totalDeducible;
	}

	public void setTotalDeducible(Long totalDeducible) {
		this.totalDeducible = totalDeducible;
	}

	public Long getCoaseguroContratado() {
		return coaseguroContratado;
	}

	public void setCoaseguroContratado(Long coaseguroContratado) {
		this.coaseguroContratado = coaseguroContratado;
	}

	public Long getRedCoaSeguroHosp() {
		return redCoaSeguroHosp;
	}

	public void setRedCoaSeguroHosp(Long redCoaSeguroHosp) {
		this.redCoaSeguroHosp = redCoaSeguroHosp;
	}

	public Long getIncCoaseguroHosp() {
		return incCoaseguroHosp;
	}

	public void setIncCoaseguroHosp(Long incCoaseguroHosp) {
		this.incCoaseguroHosp = incCoaseguroHosp;
	}

	public Long getTopeCoaseguro() {
		return topeCoaseguro;
	}

	public void setTopeCoaseguro(Long topeCoaseguro) {
		this.topeCoaseguro = topeCoaseguro;
	}

	public String getTipoTopeCoaseguro() {
		return tipoTopeCoaseguro;
	}

	public void setTipoTopeCoaseguro(String tipoTopeCoaseguro) {
		this.tipoTopeCoaseguro = tipoTopeCoaseguro;
	}

	public Long getTotalCoaseguroHosp() {
		return totalCoaseguroHosp;
	}

	public void setTotalCoaseguroHosp(Long totalCoaseguroHosp) {
		this.totalCoaseguroHosp = totalCoaseguroHosp;
	}

	public Long getRedCoaseguroMed() {
		return redCoaseguroMed;
	}

	public void setRedCoaseguroMed(Long redCoaseguroMed) {
		this.redCoaseguroMed = redCoaseguroMed;
	}

	public Long getTotalCoaseguroMed() {
		return totalCoaseguroMed;
	}

	public void setTotalCoaseguroMed(Long totalCoaseguroMed) {
		this.totalCoaseguroMed = totalCoaseguroMed;
	}

	public String getReduccionCoaseguroMed() {
		return reduccionCoaseguroMed;
	}

	public void setReduccionCoaseguroMed(String reduccionCoaseguroMed) {
		this.reduccionCoaseguroMed = reduccionCoaseguroMed;
	}

	public String getTopeIndemnizacion() {
		return topeIndemnizacion;
	}

	public void setTopeIndemnizacion(String topeIndemnizacion) {
		this.topeIndemnizacion = topeIndemnizacion;
	}

	public String getTotalDeducibleMonto() {
		return totalDeducibleMonto;
	}

	public void setTotalDeducibleMonto(String totalDeducibleMonto) {
		this.totalDeducibleMonto = totalDeducibleMonto;
	}

	public String getDeducibleMedicamentos() {
		return deducibleMedicamentos;
	}

	public void setDeducibleMedicamentos(String deducibleMedicamentos) {
		this.deducibleMedicamentos = deducibleMedicamentos;
	}

	public String getCoaseguroMedicamentos() {
		return coaseguroMedicamentos;
	}

	public void setCoaseguroMedicamentos(String coaseguroMedicamentos) {
		this.coaseguroMedicamentos = coaseguroMedicamentos;
	}

	public String getTotalMedicamentos() {
		return totalMedicamentos;
	}

	public void setTotalMedicamentos(String totalMedicamentos) {
		this.totalMedicamentos = totalMedicamentos;
	}

	public String getDeducibleServicios() {
		return deducibleServicios;
	}

	public void setDeducibleServicios(String deducibleServicios) {
		this.deducibleServicios = deducibleServicios;
	}

	public String getCoaseguroServicios() {
		return coaseguroServicios;
	}

	public void setCoaseguroServicios(String coaseguroServicios) {
		this.coaseguroServicios = coaseguroServicios;
	}

	public String getTotalServicios() {
		return totalServicios;
	}

	public void setTotalServicios(String totalServicios) {
		this.totalServicios = totalServicios;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getNotificado() {
		return notificado;
	}

	public void setNotificado(String notificado) {
		this.notificado = notificado;
	}

	public String getRecibido() {
		return recibido;
	}

	public void setRecibido(String recibido) {
		this.recibido = recibido;
	}

	public String getIndiceProvider() {
		return indiceProvider;
	}

	public void setIndiceProvider(String indiceProvider) {
		this.indiceProvider = indiceProvider;
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

	public String getSdafolioRam() {
		return sdafolioRam;
	}

	public void setSdafolioRam(String sdafolioRam) {
		this.sdafolioRam = sdafolioRam;
	}

	public String getSdatipoPago() {
		return sdatipoPago;
	}

	public void setSdatipoPago(String sdatipoPago) {
		this.sdatipoPago = sdatipoPago;
	}

	public String getSdatipoReserva() {
		return sdatipoReserva;
	}

	public void setSdatipoReserva(String sdatipoReserva) {
		this.sdatipoReserva = sdatipoReserva;
	}

	public String getSdaindiceProvider() {
		return sdaindiceProvider;
	}

	public void setSdaindiceProvider(String sdaindiceProvider) {
		this.sdaindiceProvider = sdaindiceProvider;
	}

	public String getHintegrante() {
		return hintegrante;
	}

	public void setHintegrante(String hintegrante) {
		this.hintegrante = hintegrante;
	}

	public String getHnombreMedico() {
		return hnombreMedico;
	}

	public void setHnombreMedico(String hnombreMedico) {
		this.hnombreMedico = hnombreMedico;
	}

	public String getHespecialidad() {
		return hespecialidad;
	}

	public void setHespecialidad(String hespecialidad) {
		this.hespecialidad = hespecialidad;
	}

	public BigDecimal getHmontoAutorizado() {
		return hmontoAutorizado;
	}

	public void setHmontoAutorizado(BigDecimal hmontoAutorizado) {
		this.hmontoAutorizado = hmontoAutorizado;
	}

	public String getHfolioRam() {
		return hfolioRam;
	}

	public void setHfolioRam(String hfolioRam) {
		this.hfolioRam = hfolioRam;
	}

	public String getHtipoPago() {
		return htipoPago;
	}

	public void setHtipoPago(String htipoPago) {
		this.htipoPago = htipoPago;
	}

	public String getHtipoReserva() {
		return htipoReserva;
	}

	public void setHtipoReserva(String htipoReserva) {
		this.htipoReserva = htipoReserva;
	}

	public String getHindiceProvider() {
		return hindiceProvider;
	}

	public void setHindiceProvider(String hindiceProvider) {
		this.hindiceProvider = hindiceProvider;
	}

	public String getProveedor() {
		return proveedor;
	}

	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}

	public String getCodigoMedicamento() {
		return codigoMedicamento;
	}

	public void setCodigoMedicamento(String codigoMedicamento) {
		this.codigoMedicamento = codigoMedicamento;
	}

	public String getDescripcionMedicamento() {
		return descripcionMedicamento;
	}

	public void setDescripcionMedicamento(String descripcionMedicamento) {
		this.descripcionMedicamento = descripcionMedicamento;
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

	public String getMindiceProvider() {
		return mindiceProvider;
	}

	public void setMindiceProvider(String mindiceProvider) {
		this.mindiceProvider = mindiceProvider;
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

	public int getSercantidad() {
		return sercantidad;
	}

	public void setSercantidad(int sercantidad) {
		this.sercantidad = sercantidad;
	}

	public BigDecimal getSerprecioAutUnidad() {
		return serprecioAutUnidad;
	}

	public void setSerprecioAutUnidad(BigDecimal serprecioAutUnidad) {
		this.serprecioAutUnidad = serprecioAutUnidad;
	}

	public BigDecimal getSertotalAutorizado() {
		return sertotalAutorizado;
	}

	public void setSertotalAutorizado(BigDecimal sertotalAutorizado) {
		this.sertotalAutorizado = sertotalAutorizado;
	}

	public String getSerindiceProvider() {
		return serindiceProvider;
	}

	public void setSerindiceProvider(String serindiceProvider) {
		this.serindiceProvider = serindiceProvider;
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

	public int getProcsesocodSector() {
		return procsesocodSector;
	}

	public void setProcsesocodSector(int procsesocodSector) {
		this.procsesocodSector = procsesocodSector;
	}

	public int getCodProceso() {
		return codProceso;
	}

	public void setCodProceso(int codProceso) {
		this.codProceso = codProceso;
	}

	public int getBitacodSector() {
		return bitacodSector;
	}

	public void setBitacodSector(int bitacodSector) {
		this.bitacodSector = bitacodSector;
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

	public String getComentnombreProceso() {
		return comentnombreProceso;
	}

	public void setComentnombreProceso(String comentnombreProceso) {
		this.comentnombreProceso = comentnombreProceso;
	}

	public String getComentnombreActividad() {
		return comentnombreActividad;
	}

	public void setComentnombreActividad(String comentnombreActividad) {
		this.comentnombreActividad = comentnombreActividad;
	}

	public int getComentsecuencia() {
		return comentsecuencia;
	}

	public void setComentsecuencia(int comentsecuencia) {
		this.comentsecuencia = comentsecuencia;
	}
	
	
	
	
	
	
	

}
