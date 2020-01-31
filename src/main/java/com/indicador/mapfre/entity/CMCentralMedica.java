package com.indicador.mapfre.entity;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;




@Entity
@Table(name = "XxmpfBpmCmCentralmedica")
public class CMCentralMedica {

	@Id
	private Long idSolicitud;
	
	@OneToMany(mappedBy = "centralMedica")
	@Cascade(CascadeType.ALL)
	private List<CMSiniestros> listSiniestros;
	
	@OneToMany(mappedBy = "centralMedica")
	@Cascade(CascadeType.ALL)
	private List<CMSdaValoracion>listSdaValoracion;
	
	@OneToMany(mappedBy = "centralMedica")
	@Cascade(CascadeType.ALL)
	private List<CMDocumentos >listDocumentos;
	
	@Column(name="COD_SECTOR")
	private Long codSector;
	
	@Column(name="ID_TIPO_SOLICITUD")
	private Long idTipoSolicitud;
	
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
	private Long numeroPoliza;

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
	private Long numeroRiesgo;
	
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
	
	@Column(name="MONTO_AUT_HOSPITAL")
	private String montoAutHospital;
	
	@Column(name="MONTO_CON_IVA")
	private String montoConIva;
	
	@Column(name="DEDUCIBE_COA_GASTOS_NOCUB")
	private BigDecimal deducibleConGastosNocub;
	
	@Column(name="COASEGURO_MEDICO")
	private BigDecimal coaseguroMedico; 
	
	@Column(name="TOTAL_CARGO_PACIENTE")
	private String totalCargoPaciente;
	
	@Column(name="BASES_RECHAZO")
	private String baseRechazo;
	
	@Column(name="SUBESPECIALIDAD")
	private String  subespecialidad;
	
	@Column(name="DOMICILIO_PROVEEDOR")
	private String domicilioProveedor;
	
	@Column(name="MONTO_AUTORIZADO_SDAVAL")
	private BigDecimal montoAutorizadoSdava;
	
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
	
	@Column(name="TASK_ID_TOMA_REPORTE")
	private Long taskIdTomaReporte;
	
	@Column(name="TASK_ID_ASIGNACION")
	private Long taskIdAsignacion;
	
	@Column(name="TASK_ID_DICTAMINACION")
	private Long taskIdDictaminacion;
	
	@Column(name="TASK_ID_ACTUAL")
	private Long taskIdActual;
	
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

	public Long getIdSolicitud() {
		return idSolicitud;
	}

	public void setIdSolicitud(Long idSolicitud) {
		this.idSolicitud = idSolicitud;
	}

	public List<CMSiniestros> getListSiniestros() {
		return listSiniestros;
	}

	public void setListSiniestros(List<CMSiniestros> listSiniestros) {
		this.listSiniestros = listSiniestros;
	}

	public List<CMSdaValoracion> getListSdaValoracion() {
		return listSdaValoracion;
	}

	public void setListSdaValoracion(List<CMSdaValoracion> listSdaValoracion) {
		this.listSdaValoracion = listSdaValoracion;
	}

	public List<CMDocumentos> getListDocumentos() {
		return listDocumentos;
	}

	public void setListDocumentos(List<CMDocumentos> listDocumentos) {
		this.listDocumentos = listDocumentos;
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

	
	
}
