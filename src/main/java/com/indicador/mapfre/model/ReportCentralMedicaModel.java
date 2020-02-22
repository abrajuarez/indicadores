package com.indicador.mapfre.model;


/*import javax.persistence.SqlResultSetMapping;
import javax.persistence.ConstructorResult;
import javax.persistence.ColumnResult;*/





public class ReportCentralMedicaModel {
	
	String cmcreationDates;
	String cmcodSector;
	String cmidTipoSolicitud;
	String cmfolioReapertura;
	String cmfolio;//5
	String cmSubTipoTramite;
	String cmtienePreautorizacion;
	String cmfolioPreautorizacion;
	String cmnombreProveedor;
	String cmestadoRepublica;//10
	String cmnivelHospitalario;
	String cmfechaIngreso;
	String cmurgencia;
	String cmhabitacionAsignada;
	String cmnumeroPoliza;//15
	String cmramo;
	String cmpolizaPagadaHasta;
	String cminicioVigencia;
	String cmfinVigencia;
	String cmpolProcesoEmision;//20
	String cmnombreContratante;
	String cmrecienNacido;
	String cmapellidoPaternoPaciente;
	String cmapellidoMaternoPaciente;
	String cmprimerNombrePaciente;//25
	String cmsegundoNombrePaciente;
	String cmnumeroRiesgo;
	String cmfechaNacimientoPaciente;
	String cmgeneroPaciente;
	String cmtitularPoliza;//30
	String cmmedicoRed;
	String cmnombreMedico;
	String cmespecialidadMedico;
	String cmredProveedor;
	String cmsintomasDiagnostico;//35
	String cmfemiliarResponsable;
	String cmtelFamiliarResponsable;
	String cmnombreReportante;
	String cmtelefonoReportante;
	String cmemailReportante;//40
	String cmobservacionesIngreso; 
	String cmnivelComplejidad;
	String cmusuarioAsignado;
	
	String cmtipoTramite;
	String cmterritorioAtencion;//45
	String cmtipoMoneda;
	String cmfechaPrealtaHospitalaria;//
	String cmfechaEgresoHospitalaria;
	String cmtieneInsumoRecobro;
	String cmimporteEdoCuentaSdesv;//50
	String cmdesviosEdoCuenta;
	String cmbaseIndemnizacion;
	String cmmontoAutHospital;
	String cmmontoConIva; 
	String sinnumeroSiniestro;//55
	String sinestado;
	String sintipoSiniestro;
	String sinporcentajeEdoCta;
	String sinmontoSiniestro; 
	String sinfolioRam;//60
	String sincodDiagnistico;
	String sindescDiagnostico;
	String sinfechaOcurrencia;
	String sincausa;
	String sinconsecuencia;//65
	String sinfechaInicioSintomas;
	String sincoberturaAfectada;
	String sintipoPago;
	String sintipoReserva;
	String cptclaveCpt;//70
	String cptdescripcionCpt;
	String sindeducibleContratado;
	String sinreduccionDeducible;//
	String sinincrementoDeducible;
	String sintotalDeducible;//75
	String sincoaseguroContratado;
	String sinredCoaSeguroHosp;
	String sinincCoaseguroHosp;// 
	String sintopeCoaseguro;
	String sintipoTopeCoaseguro;//80
	String sintotalCoaseguroHosp;//
	String hmedintegrante;//
	String hmednombreMedico;//
	String hmedespecialidad;//
	String hmedmontoAutorizado;//85
	String hmedfolioRam;//
	String hmedtipoPago; //
		
	String hmedtipoReserva;//
	String sintotalAutorizadoHm;//
	String sincoaseguroMedico;//90
	String sinredCoaseguroMed;//
	String sintotalCoaseguroMed;//
	String cmcoaseguroMedico;
	String cmtotalCargoPaciente;
	String mediproveedor; //95
	String medidescripcionMedicamento;// 
	String medicodigoMedicamento;
	String medicantidad;
	String mediprecioAutUnidad;
	String sintotalAutorizadoMed;//100
	String sinfolioRamMed;
	String sindeducibleMedicamentos;
	String sincoaseguroMedicamentos;//
	String sintotalMedicamentos;
	String serviciotipoServicio;//1058
	String serviciorazonSocial;
	String serviciocantidad;
	String servicioprecioAutUnidad;
	String sintotalAutorizadoServ;
	String sinfolioRamServ;//110
	String sindeducibleServicios;//
	String sincoaseguroServicios;
	String sintotalServicios;
	String cmbaseRechazo;
	String valorMedicoTratante;//115
	String valorEspecialidad;
	String valorMontoAutorizado; 
	String valorTipoPago; 
	String valorTipoReserva;
	String docTipoDocumento;//120
	Long cmidSolicitud;
	
	
	public ReportCentralMedicaModel() {}
	
	
	
	
	public ReportCentralMedicaModel(String cmcreationDates, String cmcodSector, String cmidTipoSolicitud,
			String cmfolioReapertura, String cmfolio, String cmSubTipoTramite, String cmtienePreautorizacion,
			String cmfolioPreautorizacion, String cmnombreProveedor, String cmestadoRepublica,
			String cmnivelHospitalario, String cmfechaIngreso, String cmurgencia, String cmhabitacionAsignada,
			String cmnumeroPoliza, String cmramo, String cmpolizaPagadaHasta, String cminicioVigencia,
			String cmfinVigencia, String cmpolProcesoEmision, String cmnombreContratante, String cmrecienNacido,
			String cmapellidoPaternoPaciente, String cmapellidoMaternoPaciente, String cmprimerNombrePaciente,
			String cmsegundoNombrePaciente, String cmnumeroRiesgo, String cmfechaNacimientoPaciente,
			String cmgeneroPaciente, String cmtitularPoliza, String cmmedicoRed, String cmnombreMedico,
			String cmespecialidadMedico, String cmredProveedor, String cmsintomasDiagnostico,
			String cmfemiliarResponsable, String cmtelFamiliarResponsable, String cmnombreReportante,
			String cmtelefonoReportante, String cmemailReportante, String cmobservacionesIngreso,
			String cmnivelComplejidad, String cmusuarioAsignado, String cmtipoTramite, String cmterritorioAtencion,
			String cmtipoMoneda, String cmfechaPrealtaHospitalaria, String cmfechaEgresoHospitalaria,
			String cmtieneInsumoRecobro, String cmimporteEdoCuentaSdesv, String cmdesviosEdoCuenta,
			String cmbaseIndemnizacion, String cmmontoAutHospital, String cmmontoConIva, String sinnumeroSiniestro,
			String sinestado, String sintipoSiniestro, String sinporcentajeEdoCta, String sinmontoSiniestro,
			String sinfolioRam, String sincodDiagnistico, String sindescDiagnostico, String sinfechaOcurrencia,
			String sincausa, String sinconsecuencia, String sinfechaInicioSintomas, String sincoberturaAfectada,
			String sintipoPago, String sintipoReserva, String cptclaveCpt, String cptdescripcionCpt,
			String sindeducibleContratado, String sinreduccionDeducible, String sinincrementoDeducible,
			String sintotalDeducible, String sincoaseguroContratado, String sinredCoaSeguroHosp,
			String sinincCoaseguroHosp, String sintopeCoaseguro, String sintipoTopeCoaseguro,
			String sintotalCoaseguroHosp, String hmedintegrante, String hmednombreMedico, String hmedespecialidad,
			String hmedmontoAutorizado, String hmedfolioRam, String hmedtipoPago, String hmedtipoReserva,
			String sintotalAutorizadoHm, String sincoaseguroMedico, String sinredCoaseguroMed,
			String sintotalCoaseguroMed, String cmcoaseguroMedico, String cmtotalCargoPaciente, String mediproveedor,
			String medidescripcionMedicamento, String medicodigoMedicamento, String medicantidad,
			String mediprecioAutUnidad, String sintotalAutorizadoMed, String sinfolioRamMed,
			String sindeducibleMedicamentos, String sincoaseguroMedicamentos, String sintotalMedicamentos,
			String serviciotipoServicio, String serviciorazonSocial, String serviciocantidad,
			String servicioprecioAutUnidad, String sintotalAutorizadoServ, String sinfolioRamServ,
			String sindeducibleServicios, String sincoaseguroServicios, String sintotalServicios, String cmbaseRechazo,
			String valorMedicoTratante, String valorEspecialidad, String valorMontoAutorizado, String valorTipoPago,
			String valorTipoReserva, String docTipoDocumento, Long cmidSolicitud) {
		super();
		this.cmcreationDates = cmcreationDates;
		this.cmcodSector = cmcodSector;
		this.cmidTipoSolicitud = cmidTipoSolicitud;
		this.cmfolioReapertura = cmfolioReapertura;
		this.cmfolio = cmfolio;
		this.cmSubTipoTramite = cmSubTipoTramite;
		this.cmtienePreautorizacion = cmtienePreautorizacion;
		this.cmfolioPreautorizacion = cmfolioPreautorizacion;
		this.cmnombreProveedor = cmnombreProveedor;
		this.cmestadoRepublica = cmestadoRepublica;
		this.cmnivelHospitalario = cmnivelHospitalario;
		this.cmfechaIngreso = cmfechaIngreso;
		this.cmurgencia = cmurgencia;
		this.cmhabitacionAsignada = cmhabitacionAsignada;
		this.cmnumeroPoliza = cmnumeroPoliza;
		this.cmramo = cmramo;
		this.cmpolizaPagadaHasta = cmpolizaPagadaHasta;
		this.cminicioVigencia = cminicioVigencia;
		this.cmfinVigencia = cmfinVigencia;
		this.cmpolProcesoEmision = cmpolProcesoEmision;
		this.cmnombreContratante = cmnombreContratante;
		this.cmrecienNacido = cmrecienNacido;
		this.cmapellidoPaternoPaciente = cmapellidoPaternoPaciente;
		this.cmapellidoMaternoPaciente = cmapellidoMaternoPaciente;
		this.cmprimerNombrePaciente = cmprimerNombrePaciente;
		this.cmsegundoNombrePaciente = cmsegundoNombrePaciente;
		this.cmnumeroRiesgo = cmnumeroRiesgo;
		this.cmfechaNacimientoPaciente = cmfechaNacimientoPaciente;
		this.cmgeneroPaciente = cmgeneroPaciente;
		this.cmtitularPoliza = cmtitularPoliza;
		this.cmmedicoRed = cmmedicoRed;
		this.cmnombreMedico = cmnombreMedico;
		this.cmespecialidadMedico = cmespecialidadMedico;
		this.cmredProveedor = cmredProveedor;
		this.cmsintomasDiagnostico = cmsintomasDiagnostico;
		this.cmfemiliarResponsable = cmfemiliarResponsable;
		this.cmtelFamiliarResponsable = cmtelFamiliarResponsable;
		this.cmnombreReportante = cmnombreReportante;
		this.cmtelefonoReportante = cmtelefonoReportante;
		this.cmemailReportante = cmemailReportante;
		this.cmobservacionesIngreso = cmobservacionesIngreso;
		this.cmnivelComplejidad = cmnivelComplejidad;
		this.cmusuarioAsignado = cmusuarioAsignado;
		this.cmtipoTramite = cmtipoTramite;
		this.cmterritorioAtencion = cmterritorioAtencion;
		this.cmtipoMoneda = cmtipoMoneda;
		this.cmfechaPrealtaHospitalaria = cmfechaPrealtaHospitalaria;
		this.cmfechaEgresoHospitalaria = cmfechaEgresoHospitalaria;
		this.cmtieneInsumoRecobro = cmtieneInsumoRecobro;
		this.cmimporteEdoCuentaSdesv = cmimporteEdoCuentaSdesv;
		this.cmdesviosEdoCuenta = cmdesviosEdoCuenta;
		this.cmbaseIndemnizacion = cmbaseIndemnizacion;
		this.cmmontoAutHospital = cmmontoAutHospital;
		this.cmmontoConIva = cmmontoConIva;
		this.sinnumeroSiniestro = sinnumeroSiniestro;
		this.sinestado = sinestado;
		this.sintipoSiniestro = sintipoSiniestro;
		this.sinporcentajeEdoCta = sinporcentajeEdoCta;
		this.sinmontoSiniestro = sinmontoSiniestro;
		this.sinfolioRam = sinfolioRam;
		this.sincodDiagnistico = sincodDiagnistico;
		this.sindescDiagnostico = sindescDiagnostico;
		this.sinfechaOcurrencia = sinfechaOcurrencia;
		this.sincausa = sincausa;
		this.sinconsecuencia = sinconsecuencia;
		this.sinfechaInicioSintomas = sinfechaInicioSintomas;
		this.sincoberturaAfectada = sincoberturaAfectada;
		this.sintipoPago = sintipoPago;
		this.sintipoReserva = sintipoReserva;
		this.cptclaveCpt = cptclaveCpt;
		this.cptdescripcionCpt = cptdescripcionCpt;
		this.sindeducibleContratado = sindeducibleContratado;
		this.sinreduccionDeducible = sinreduccionDeducible;
		this.sinincrementoDeducible = sinincrementoDeducible;
		this.sintotalDeducible = sintotalDeducible;
		this.sincoaseguroContratado = sincoaseguroContratado;
		this.sinredCoaSeguroHosp = sinredCoaSeguroHosp;
		this.sinincCoaseguroHosp = sinincCoaseguroHosp;
		this.sintopeCoaseguro = sintopeCoaseguro;
		this.sintipoTopeCoaseguro = sintipoTopeCoaseguro;
		this.sintotalCoaseguroHosp = sintotalCoaseguroHosp;
		this.hmedintegrante = hmedintegrante;
		this.hmednombreMedico = hmednombreMedico;
		this.hmedespecialidad = hmedespecialidad;
		this.hmedmontoAutorizado = hmedmontoAutorizado;
		this.hmedfolioRam = hmedfolioRam;
		this.hmedtipoPago = hmedtipoPago;
		this.hmedtipoReserva = hmedtipoReserva;
		this.sintotalAutorizadoHm = sintotalAutorizadoHm;
		this.sincoaseguroMedico = sincoaseguroMedico;
		this.sinredCoaseguroMed = sinredCoaseguroMed;
		this.sintotalCoaseguroMed = sintotalCoaseguroMed;
		this.cmcoaseguroMedico = cmcoaseguroMedico;
		this.cmtotalCargoPaciente = cmtotalCargoPaciente;
		this.mediproveedor = mediproveedor;
		this.medidescripcionMedicamento = medidescripcionMedicamento;
		this.medicodigoMedicamento = medicodigoMedicamento;
		this.medicantidad = medicantidad;
		this.mediprecioAutUnidad = mediprecioAutUnidad;
		this.sintotalAutorizadoMed = sintotalAutorizadoMed;
		this.sinfolioRamMed = sinfolioRamMed;
		this.sindeducibleMedicamentos = sindeducibleMedicamentos;
		this.sincoaseguroMedicamentos = sincoaseguroMedicamentos;
		this.sintotalMedicamentos = sintotalMedicamentos;
		this.serviciotipoServicio = serviciotipoServicio;
		this.serviciorazonSocial = serviciorazonSocial;
		this.serviciocantidad = serviciocantidad;
		this.servicioprecioAutUnidad = servicioprecioAutUnidad;
		this.sintotalAutorizadoServ = sintotalAutorizadoServ;
		this.sinfolioRamServ = sinfolioRamServ;
		this.sindeducibleServicios = sindeducibleServicios;
		this.sincoaseguroServicios = sincoaseguroServicios;
		this.sintotalServicios = sintotalServicios;
		this.cmbaseRechazo = cmbaseRechazo;
		this.valorMedicoTratante = valorMedicoTratante;
		this.valorEspecialidad = valorEspecialidad;
		this.valorMontoAutorizado = valorMontoAutorizado;
		this.valorTipoPago = valorTipoPago;
		this.valorTipoReserva = valorTipoReserva;
		this.docTipoDocumento = docTipoDocumento;
		this.cmidSolicitud = cmidSolicitud;
	}




	public String getCmcreationDate() {
		return cmcreationDates;
	}
	public void setCmcreationDate(String cmcreationDate) {
		this.cmcreationDates = cmcreationDate;
	}
	public String getCmcodSector() {
		return cmcodSector;
	}
	public void setCmcodSector(String cmcodSector) {
		this.cmcodSector = cmcodSector;
	}
	public String getCmidTipoSolicitud() {
		return cmidTipoSolicitud;
	}
	public void setCmidTipoSolicitud(String cmidTipoSolicitud) {
		this.cmidTipoSolicitud = cmidTipoSolicitud;
	}
	public String getCmfolioReapertura() {
		return cmfolioReapertura;
	}
	public void setCmfolioReapertura(String cmfolioReapertura) {
		this.cmfolioReapertura = cmfolioReapertura;
	}
	public String getCmfolio() {
		return cmfolio;
	}
	public void setCmfolio(String cmfolio) {
		this.cmfolio = cmfolio;
	}
	public String getCmSubTipoTramite() {
		return cmSubTipoTramite;
	}
	public void setCmSubTipoTramite(String cmubTipoTramite) {
		this.cmSubTipoTramite = cmubTipoTramite;
	}
	public String getCmtienePreautorizacion() {
		return cmtienePreautorizacion;
	}
	public void setCmtienePreautorizacion(String cmtienePreautorizacion) {
		this.cmtienePreautorizacion = cmtienePreautorizacion;
	}
	public String getCmfolioPreautorizacion() {
		return cmfolioPreautorizacion;
	}
	public void setCmfolioPreautorizacion(String cmfolioPreautorizacion) {
		this.cmfolioPreautorizacion = cmfolioPreautorizacion;
	}
	public String getCmnombreProveedor() {
		return cmnombreProveedor;
	}
	public void setCmnombreProveedor(String cmnombreProveedor) {
		this.cmnombreProveedor = cmnombreProveedor;
	}
	public String getCmestadoRepublica() {
		return cmestadoRepublica;
	}
	public void setCmestadoRepublica(String cmestadoRepublica) {
		this.cmestadoRepublica = cmestadoRepublica;
	}
	public String getCmnivelHospitalario() {
		return cmnivelHospitalario;
	}
	public void setCmnivelHospitalario(String cmnivelHospitalario) {
		this.cmnivelHospitalario = cmnivelHospitalario;
	}
	public String getCmfechaIngreso() {
		return cmfechaIngreso;
	}
	public void setCmfechaIngreso(String cmfechaIngreso) {
		this.cmfechaIngreso = cmfechaIngreso;
	}
	public String getCmurgencia() {
		return cmurgencia;
	}
	public void setCmurgencia(String cmurgencia) {
		this.cmurgencia = cmurgencia;
	}
	public String getCmhabitacionAsignada() {
		return cmhabitacionAsignada;
	}
	public void setCmhabitacionAsignada(String cmhabitacionAsignada) {
		this.cmhabitacionAsignada = cmhabitacionAsignada;
	}
	public String getCmnumeroPoliza() {
		return cmnumeroPoliza;
	}
	public void setCmnumeroPoliza(String cmnumeroPoliza) {
		this.cmnumeroPoliza = cmnumeroPoliza;
	}
	public String getCmramo() {
		return cmramo;
	}
	public void setCmramo(String cmramo) {
		this.cmramo = cmramo;
	}
	public String getCmpolizaPagadaHasta() {
		return cmpolizaPagadaHasta;
	}
	public void setCmpolizaPagadaHasta(String cmpolizaPagadaHasta) {
		this.cmpolizaPagadaHasta = cmpolizaPagadaHasta;
	}
	public String getCminicioVigencia() {
		return cminicioVigencia;
	}
	public void setCminicioVigencia(String cminicioVigencia) {
		this.cminicioVigencia = cminicioVigencia;
	}
	public String getCmfinVigencia() {
		return cmfinVigencia;
	}
	public void setCmfinVigencia(String cmfinVigencia) {
		this.cmfinVigencia = cmfinVigencia;
	}
	public String getCmpolProcesoEmision() {
		return cmpolProcesoEmision;
	}
	public void setCmpolProcesoEmision(String cmpolProcesoEmision) {
		this.cmpolProcesoEmision = cmpolProcesoEmision;
	}
	public String getCmnombreContratante() {
		return cmnombreContratante;
	}
	public void setCmnombreContratante(String cmnombreContratante) {
		this.cmnombreContratante = cmnombreContratante;
	}
	public String getCmrecienNacido() {
		return cmrecienNacido;
	}
	public void setCmrecienNacido(String cmrecienNacido) {
		this.cmrecienNacido = cmrecienNacido;
	}
	public String getCmapellidoPaternoPaciente() {
		return cmapellidoPaternoPaciente;
	}
	public void setCmapellidoPaternoPaciente(String cmapellidoPaternoPaciente) {
		this.cmapellidoPaternoPaciente = cmapellidoPaternoPaciente;
	}
	public String getCmapellidoMaternoPaciente() {
		return cmapellidoMaternoPaciente;
	}
	public void setCmapellidoMaternoPaciente(String cmapellidoMaternoPaciente) {
		this.cmapellidoMaternoPaciente = cmapellidoMaternoPaciente;
	}
	public String getCmprimerNombrePaciente() {
		return cmprimerNombrePaciente;
	}
	public void setCmprimerNombrePaciente(String cmprimerNombrePaciente) {
		this.cmprimerNombrePaciente = cmprimerNombrePaciente;
	}
	public String getCmsegundoNombrePaciente() {
		return cmsegundoNombrePaciente;
	}
	public void setCmsegundoNombrePaciente(String cmsegundoNombrePaciente) {
		this.cmsegundoNombrePaciente = cmsegundoNombrePaciente;
	}
	public String getCmnumeroRiesgo() {
		return cmnumeroRiesgo;
	}
	public void setCmnumeroRiesgo(String cmnumeroRiesgo) {
		this.cmnumeroRiesgo = cmnumeroRiesgo;
	}
	public String getCmfechaNacimientoPaciente() {
		return cmfechaNacimientoPaciente;
	}
	public void setCmfechaNacimientoPaciente(String cmfechaNacimientoPaciente) {
		this.cmfechaNacimientoPaciente = cmfechaNacimientoPaciente;
	}
	public String getCmgeneroPaciente() {
		return cmgeneroPaciente;
	}
	public void setCmgeneroPaciente(String cmgeneroPaciente) {
		this.cmgeneroPaciente = cmgeneroPaciente;
	}
	public String getCmtitularPoliza() {
		return cmtitularPoliza;
	}
	public void setCmtitularPoliza(String cmtitularPoliza) {
		this.cmtitularPoliza = cmtitularPoliza;
	}
	public String getCmmedicoRed() {
		return cmmedicoRed;
	}
	public void setCmmedicoRed(String cmmedicoRed) {
		this.cmmedicoRed = cmmedicoRed;
	}
	public String getCmnombreMedico() {
		return cmnombreMedico;
	}
	public void setCmnombreMedico(String cmnombreMedico) {
		this.cmnombreMedico = cmnombreMedico;
	}
	public String getCmespecialidadMedico() {
		return cmespecialidadMedico;
	}
	public void setCmespecialidadMedico(String cmespecialidadMedico) {
		this.cmespecialidadMedico = cmespecialidadMedico;
	}
	public String getCmredProveedor() {
		return cmredProveedor;
	}
	public void setCmredProveedor(String cmredProveedor) {
		this.cmredProveedor = cmredProveedor;
	}
	public String getCmsintomasDiagnostico() {
		return cmsintomasDiagnostico;
	}
	public void setCmsintomasDiagnostico(String cmsintomasDiagnostico) {
		this.cmsintomasDiagnostico = cmsintomasDiagnostico;
	}
	public String getCmfemiliarResponsable() {
		return cmfemiliarResponsable;
	}
	public void setCmfemiliarResponsable(String cmfemiliarResponsable) {
		this.cmfemiliarResponsable = cmfemiliarResponsable;
	}
	public String getCmtelFamiliarResponsable() {
		return cmtelFamiliarResponsable;
	}
	public void setCmtelFamiliarResponsable(String cmtelFamiliarResponsable) {
		this.cmtelFamiliarResponsable = cmtelFamiliarResponsable;
	}
	public String getCmnombreReportante() {
		return cmnombreReportante;
	}
	public void setCmnombreReportante(String cmnombreReportante) {
		this.cmnombreReportante = cmnombreReportante;
	}
	public String getCmtelefonoReportante() {
		return cmtelefonoReportante;
	}
	public void setCmtelefonoReportante(String cmtelefonoReportante) {
		this.cmtelefonoReportante = cmtelefonoReportante;
	}
	public String getCmemailReportante() {
		return cmemailReportante;
	}
	public void setCmemailReportante(String cmemailReportante) {
		this.cmemailReportante = cmemailReportante;
	}
	public String getCmobservacionesIngreso() {
		return cmobservacionesIngreso;
	}
	public void setCmobservacionesIngreso(String cmobservacionesIngreso) {
		this.cmobservacionesIngreso = cmobservacionesIngreso;
	}
	public String getCmnivelComplejidad() {
		return cmnivelComplejidad;
	}
	public void setCmnivelComplejidad(String cmnivelComplejidad) {
		this.cmnivelComplejidad = cmnivelComplejidad;
	}
	public String getCmusuarioAsignado() {
		return cmusuarioAsignado;
	}
	public void setCmusuarioAsignado(String cmusuarioAsignado) {
		this.cmusuarioAsignado = cmusuarioAsignado;
	}
	public String getCmtipoTramite() {
		return cmtipoTramite;
	}
	public void setCmtipoTramite(String cmtipoTramite) {
		this.cmtipoTramite = cmtipoTramite;
	}
	public String getCmterritorioAtencion() {
		return cmterritorioAtencion;
	}
	public void setCmterritorioAtencion(String cmterritorioAtencion) {
		this.cmterritorioAtencion = cmterritorioAtencion;
	}
	public String getCmtipoMoneda() {
		return cmtipoMoneda;
	}
	public void setCmtipoMoneda(String cmtipoMoneda) {
		this.cmtipoMoneda = cmtipoMoneda;
	}
	public String getCmfechaPrealtaHospitalaria() {
		return cmfechaPrealtaHospitalaria;
	}
	public void setCmfechaPrealtaHospitalaria(String cmfechaPrealtaHospitalaria) {
		this.cmfechaPrealtaHospitalaria = cmfechaPrealtaHospitalaria;
	}
	public String getCmfechaEgresoHospitalaria() {
		return cmfechaEgresoHospitalaria;
	}
	public void setCmfechaEgresoHospitalaria(String cmfechaEgresoHospitalaria) {
		this.cmfechaEgresoHospitalaria = cmfechaEgresoHospitalaria;
	}
	public String getCmtieneInsumoRecobro() {
		return cmtieneInsumoRecobro;
	}
	public void setCmtieneInsumoRecobro(String cmtieneInsumoRecobro) {
		this.cmtieneInsumoRecobro = cmtieneInsumoRecobro;
	}
	public String getCmimporteEdoCuentaSdesv() {
		return cmimporteEdoCuentaSdesv;
	}
	public void setCmimporteEdoCuentaSdesv(String cmimporteEdoCuentaSdesv) {
		this.cmimporteEdoCuentaSdesv = cmimporteEdoCuentaSdesv;
	}
	public String getCmdesviosEdoCuenta() {
		return cmdesviosEdoCuenta;
	}
	public void setCmdesviosEdoCuenta(String cmdesviosEdoCuenta) {
		this.cmdesviosEdoCuenta = cmdesviosEdoCuenta;
	}
	public String getCmbaseIndemnizacion() {
		return cmbaseIndemnizacion;
	}
	public void setCmbaseIndemnizacion(String cmbaseIndemnizacion) {
		this.cmbaseIndemnizacion = cmbaseIndemnizacion;
	}
	public String getCmmontoAutHospital() {
		return cmmontoAutHospital;
	}
	public void setCmmontoAutHospital(String cmmontoAutHospital) {
		this.cmmontoAutHospital = cmmontoAutHospital;
	}
	public String getCmmontoConIva() {
		return cmmontoConIva;
	}
	public void setCmmontoConIva(String cmmontoConIva) {
		this.cmmontoConIva = cmmontoConIva;
	}
	public String getSinnumeroSiniestro() {
		return sinnumeroSiniestro;
	}
	public void setSinnumeroSiniestro(String sinnumeroSiniestro) {
		this.sinnumeroSiniestro = sinnumeroSiniestro;
	}
	public String getSinestado() {
		return sinestado;
	}
	public void setSinestado(String sinestado) {
		this.sinestado = sinestado;
	}
	public String getSintipoSiniestro() {
		return sintipoSiniestro;
	}
	public void setSintipoSiniestro(String sintipoSiniestro) {
		this.sintipoSiniestro = sintipoSiniestro;
	}
	public String getSinporcentajeEdoCta() {
		return sinporcentajeEdoCta;
	}
	public void setSinporcentajeEdoCta(String sinporcentajeEdoCta) {
		this.sinporcentajeEdoCta = sinporcentajeEdoCta;
	}
	public String getSinmontoSiniestro() {
		return sinmontoSiniestro;
	}
	public void setSinmontoSiniestro(String sinmontoSiniestro) {
		this.sinmontoSiniestro = sinmontoSiniestro;
	}
	public String getSinfolioRam() {
		return sinfolioRam;
	}
	public void setSinfolioRam(String sinfolioRam) {
		this.sinfolioRam = sinfolioRam;
	}
	public String getSincodDiagnistico() {
		return sincodDiagnistico;
	}
	public void setSincodDiagnistico(String sincodDiagnistico) {
		this.sincodDiagnistico = sincodDiagnistico;
	}
	public String getSindescDiagnostico() {
		return sindescDiagnostico;
	}
	public void setSindescDiagnostico(String sindescDiagnostico) {
		this.sindescDiagnostico = sindescDiagnostico;
	}
	public String getSinfechaOcurrencia() {
		return sinfechaOcurrencia;
	}
	public void setSinfechaOcurrencia(String sinfechaOcurrencia) {
		this.sinfechaOcurrencia = sinfechaOcurrencia;
	}
	public String getSincausa() {
		return sincausa;
	}
	public void setSincausa(String sincausa) {
		this.sincausa = sincausa;
	}
	public String getSinconsecuencia() {
		return sinconsecuencia;
	}
	public void setSinconsecuencia(String sinconsecuencia) {
		this.sinconsecuencia = sinconsecuencia;
	}
	public String getSinfechaInicioSintomas() {
		return sinfechaInicioSintomas;
	}
	public void setSinfechaInicioSintomas(String sinfechaInicioSintomas) {
		this.sinfechaInicioSintomas = sinfechaInicioSintomas;
	}
	public String getSincoberturaAfectada() {
		return sincoberturaAfectada;
	}
	public void setSincoberturaAfectada(String sincoberturaAfectada) {
		this.sincoberturaAfectada = sincoberturaAfectada;
	}
	public String getSintipoPago() {
		return sintipoPago;
	}
	public void setSintipoPago(String sintipoPago) {
		this.sintipoPago = sintipoPago;
	}
	public String getSintipoReserva() {
		return sintipoReserva;
	}
	public void setSintipoReserva(String sintipoReserva) {
		this.sintipoReserva = sintipoReserva;
	}
	public String getCptclaveCpt() {
		return cptclaveCpt;
	}
	public void setCptclaveCpt(String cptclaveCpt) {
		this.cptclaveCpt = cptclaveCpt;
	}
	public String getCptdescripcionCpt() {
		return cptdescripcionCpt;
	}
	public void setCptdescripcionCpt(String cptdescripcionCpt) {
		this.cptdescripcionCpt = cptdescripcionCpt;
	}
	public String getSindeducibleContratado() {
		return sindeducibleContratado;
	}
	public void setSindeducibleContratado(String sindeducibleContratado) {
		this.sindeducibleContratado = sindeducibleContratado;
	}
	public String getSinreduccionDeducible() {
		return sinreduccionDeducible;
	}
	public void setSinreduccionDeducible(String sinreduccionDeducible) {
		this.sinreduccionDeducible = sinreduccionDeducible;
	}
	public String getSinincrementoDeducible() {
		return sinincrementoDeducible;
	}
	public void setSinincrementoDeducible(String sinincrementoDeducible) {
		this.sinincrementoDeducible = sinincrementoDeducible;
	}
	public String getSintotalDeducible() {
		return sintotalDeducible;
	}
	public void setSintotalDeducible(String sintotalDeducible) {
		this.sintotalDeducible = sintotalDeducible;
	}
	public String getSincoaseguroContratado() {
		return sincoaseguroContratado;
	}
	public void setSincoaseguroContratado(String sincoaseguroContratado) {
		this.sincoaseguroContratado = sincoaseguroContratado;
	}
	public String getSinredCoaSeguroHosp() {
		return sinredCoaSeguroHosp;
	}
	public void setSinredCoaSeguroHosp(String sinredCoaSeguroHosp) {
		this.sinredCoaSeguroHosp = sinredCoaSeguroHosp;
	}
	public String getSinincCoaseguroHosp() {
		return sinincCoaseguroHosp;
	}
	public void setSinincCoaseguroHosp(String sinincCoaseguroHosp) {
		this.sinincCoaseguroHosp = sinincCoaseguroHosp;
	}
	public String getSintopeCoaseguro() {
		return sintopeCoaseguro;
	}
	public void setSintopeCoaseguro(String sintopeCoaseguro) {
		this.sintopeCoaseguro = sintopeCoaseguro;
	}
	public String getSintipoTopeCoaseguro() {
		return sintipoTopeCoaseguro;
	}
	public void setSintipoTopeCoaseguro(String sintipoTopeCoaseguro) {
		this.sintipoTopeCoaseguro = sintipoTopeCoaseguro;
	}
	public String getSintotalCoaseguroHosp() {
		return sintotalCoaseguroHosp;
	}
	public void setSintotalCoaseguroHosp(String sintotalCoaseguroHosp) {
		this.sintotalCoaseguroHosp = sintotalCoaseguroHosp;
	}
	public String getHmedintegrante() {
		return hmedintegrante;
	}
	public void setHmedintegrante(String hmedintegrante) {
		this.hmedintegrante = hmedintegrante;
	}
	public String getHmednombreMedico() {
		return hmednombreMedico;
	}
	public void setHmednombreMedico(String hmednombreMedico) {
		this.hmednombreMedico = hmednombreMedico;
	}
	public String getHmedespecialidad() {
		return hmedespecialidad;
	}
	public void setHmedespecialidad(String hmedespecialidad) {
		this.hmedespecialidad = hmedespecialidad;
	}
	public String getHmedmontoAutorizado() {
		return hmedmontoAutorizado;
	}
	public void setHmedmontoAutorizado(String hmedmontoAutorizado) {
		this.hmedmontoAutorizado = hmedmontoAutorizado;
	}
	public String getHmedfolioRam() {
		return hmedfolioRam;
	}
	public void setHmedfolioRam(String hmedfolioRam) {
		this.hmedfolioRam = hmedfolioRam;
	}
	public String getHmedtipoPago() {
		return hmedtipoPago;
	}
	public void setHmedtipoPago(String hmedtipoPago) {
		this.hmedtipoPago = hmedtipoPago;
	}
	public String getHmedtipoReserva() {
		return hmedtipoReserva;
	}
	public void setHmedtipoReserva(String hmedtipoReserva) {
		this.hmedtipoReserva = hmedtipoReserva;
	}
	public String getSintotalAutorizadoHm() {
		return sintotalAutorizadoHm;
	}
	public void setSintotalAutorizadoHm(String sintotalAutorizadoHm) {
		this.sintotalAutorizadoHm = sintotalAutorizadoHm;
	}
	public String getSincoaseguroMedico() {
		return sincoaseguroMedico;
	}
	public void setSincoaseguroMedico(String sincoaseguroMedico) {
		this.sincoaseguroMedico = sincoaseguroMedico;
	}
	public String getSinredCoaseguroMed() {
		return sinredCoaseguroMed;
	}
	public void setSinredCoaseguroMed(String sinredCoaseguroMed) {
		this.sinredCoaseguroMed = sinredCoaseguroMed;
	}
	public String getSintotalCoaseguroMed() {
		return sintotalCoaseguroMed;
	}
	public void setSintotalCoaseguroMed(String sintotalCoaseguroMed) {
		this.sintotalCoaseguroMed = sintotalCoaseguroMed;
	}
	public String getCmcoaseguroMedico() {
		return cmcoaseguroMedico;
	}
	public void setCmcoaseguroMedico(String cmcoaseguroMedico) {
		this.cmcoaseguroMedico = cmcoaseguroMedico;
	}
	public String getCmtotalCargoPaciente() {
		return cmtotalCargoPaciente;
	}
	public void setCmtotalCargoPaciente(String cmtotalCargoPaciente) {
		this.cmtotalCargoPaciente = cmtotalCargoPaciente;
	}
	public String getMediproveedor() {
		return mediproveedor;
	}
	public void setMediproveedor(String mediproveedor) {
		this.mediproveedor = mediproveedor;
	}
	public String getMedidescripcionMedicamento() {
		return medidescripcionMedicamento;
	}
	public void setMedidescripcionMedicamento(String medidescripcionMedicamento) {
		this.medidescripcionMedicamento = medidescripcionMedicamento;
	}
	public String getMedicodigoMedicamento() {
		return medicodigoMedicamento;
	}
	public void setMedicodigoMedicamento(String medicodigoMedicamento) {
		this.medicodigoMedicamento = medicodigoMedicamento;
	}
	public String getMedicantidad() {
		return medicantidad;
	}
	public void setMedicantidad(String medicantidad) {
		this.medicantidad = medicantidad;
	}
	public String getMediprecioAutUnidad() {
		return mediprecioAutUnidad;
	}
	public void setMediprecioAutUnidad(String mediprecioAutUnidad) {
		this.mediprecioAutUnidad = mediprecioAutUnidad;
	}
	public String getSintotalAutorizadoMed() {
		return sintotalAutorizadoMed;
	}
	public void setSintotalAutorizadoMed(String sintotalAutorizadoMed) {
		this.sintotalAutorizadoMed = sintotalAutorizadoMed;
	}
	public String getSinfolioRamMed() {
		return sinfolioRamMed;
	}
	public void setSinfolioRamMed(String sinfolioRamMed) {
		this.sinfolioRamMed = sinfolioRamMed;
	}
	public String getSindeducibleMedicamentos() {
		return sindeducibleMedicamentos;
	}
	public void setSindeducibleMedicamentos(String sindeducibleMedicamentos) {
		this.sindeducibleMedicamentos = sindeducibleMedicamentos;
	}
	public String getSincoaseguroMedicamentos() {
		return sincoaseguroMedicamentos;
	}
	public void setSincoaseguroMedicamentos(String sincoaseguroMedicamentos) {
		this.sincoaseguroMedicamentos = sincoaseguroMedicamentos;
	}
	public String getSintotalMedicamentos() {
		return sintotalMedicamentos;
	}
	public void setSintotalMedicamentos(String sintotalMedicamentos) {
		this.sintotalMedicamentos = sintotalMedicamentos;
	}
	public String getServiciotipoServicio() {
		return serviciotipoServicio;
	}
	public void setServiciotipoServicio(String serviciotipoServicio) {
		this.serviciotipoServicio = serviciotipoServicio;
	}
	public String getServiciorazonSocial() {
		return serviciorazonSocial;
	}
	public void setServiciorazonSocial(String serviciorazonSocial) {
		this.serviciorazonSocial = serviciorazonSocial;
	}
	public String getServiciocantidad() {
		return serviciocantidad;
	}
	public void setServiciocantidad(String serviciocantidad) {
		this.serviciocantidad = serviciocantidad;
	}
	public String getServicioprecioAutUnidad() {
		return servicioprecioAutUnidad;
	}
	public void setServicioprecioAutUnidad(String servicioprecioAutUnidad) {
		this.servicioprecioAutUnidad = servicioprecioAutUnidad;
	}
	public String getSintotalAutorizadoServ() {
		return sintotalAutorizadoServ;
	}
	public void setSintotalAutorizadoServ(String sintotalAutorizadoServ) {
		this.sintotalAutorizadoServ = sintotalAutorizadoServ;
	}
	public String getSinfolioRamServ() {
		return sinfolioRamServ;
	}
	public void setSinfolioRamServ(String sinfolioRamServ) {
		this.sinfolioRamServ = sinfolioRamServ;
	}
	public String getSindeducibleServicios() {
		return sindeducibleServicios;
	}
	public void setSindeducibleServicios(String sindeducibleServicios) {
		this.sindeducibleServicios = sindeducibleServicios;
	}
	public String getSincoaseguroServicios() {
		return sincoaseguroServicios;
	}
	public void setSincoaseguroServicios(String sincoaseguroServicios) {
		this.sincoaseguroServicios = sincoaseguroServicios;
	}
	public String getSintotalServicios() {
		return sintotalServicios;
	}
	public void setSintotalServicios(String sintotalServicios) {
		this.sintotalServicios = sintotalServicios;
	}
	public String getCmbaseRechazo() {
		return cmbaseRechazo;
	}
	public void setCmbaseRechazo(String cmbaseRechazo) {
		this.cmbaseRechazo = cmbaseRechazo;
	}
	public String getValorMedicoTratante() {
		return valorMedicoTratante;
	}
	public void setValorMedicoTratante(String valorMedicoTratante) {
		this.valorMedicoTratante = valorMedicoTratante;
	}
	public String getValorEspecialidad() {
		return valorEspecialidad;
	}
	public void setValorEspecialidad(String valorEspecialidad) {
		this.valorEspecialidad = valorEspecialidad;
	}
	public String getValorMontoAutorizado() {
		return valorMontoAutorizado;
	}
	public void setValorMontoAutorizado(String valorMontoAutorizado) {
		this.valorMontoAutorizado = valorMontoAutorizado;
	}
	public String getValorTipoPago() {
		return valorTipoPago;
	}
	public void setValorTipoPago(String valorTipoPago) {
		this.valorTipoPago = valorTipoPago;
	}
	public String getValorTipoReserva() {
		return valorTipoReserva;
	}
	public void setValorTipoReserva(String valorTipoReserva) {
		this.valorTipoReserva = valorTipoReserva;
	}
	public String getDocTipoDocumento() {
		return docTipoDocumento;
	}
	public void setDocTipoDocumento(String docTipoDocumento) {
		this.docTipoDocumento = docTipoDocumento;
	}
	public Long getCmidSolicitud() {
		return cmidSolicitud;
	}
	public void setCmidSolicitud(Long cmidSolicitud) {
		this.cmidSolicitud = cmidSolicitud;
	}
	
	

}
