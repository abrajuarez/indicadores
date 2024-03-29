package com.indicador.mapfre.util;

public class ScriptReportCentralMedica {

	public static  String REPORTQUERY = "SELECT cm.idSolicitud,cm.codSector, cm.idTipoSolicitud, cm.folio, cm.folioReapertura, cm.tipoTramite "+
			                   ",cm.subTipoTramite, cm.tienePreautorizacion, cm.folioPreautorizacion,cm.nombreProveedor,cm.estadoRepublica " + 
			                   ",cm.nivelHospitalario,cm.fechaIngreso,cm.urgencia,cm.habitacionAsignada,cm.numeroPoliza,cm.ramo,cm.polizaPagadaHasta " + 
			                   ",cm.inicioVigencia,cm.finVigencia,cm.polProcesoEmision,cm.nombreContratante,cm.razonSocialContratante " + 
			                   ",cm.categoriaAsegurado,cm.recienNacido,cm.primerNombrePaciente,cm.segundoNombrePaciente " + 
			                   ",cm.apellidoPaternoPaciente,cm.apellidoMaternoPaciente,cm.fechaNacimientoPaciente, cm.numeroRiesgo,cm.generoPaciente " + 
			                   ",cm.titularPoliza,cm.medicoRed,cm.nombreMedico,cm.especialidadMedico,cm.redProveedor " + 
			                   ",cm.sintomasDiagnostico,cm.femiliarResponsable,cm.telFamiliarResponsable,cm.nombreReportante " + 
			                   ",cm.telefonoReportante,cm.emailReportante,cm.observacionesIngreso,cm.estatusTramite,cm.tienePrefacturas " + 
			                   ",cm.tieneHonMed,cm.tieneMedicamentos,cm.tieneServicios,cm.territorioAtencion,cm.tipoMoneda " + 
			                   ",cm.fechaEgresoHospitalaria,cm.tieneInsumoRecobro,cm.montoAutProg,cm.importeEdoCuentaSdesv " + 
			                   ",cm.desviosEdoCuenta,cm.baseIndemnizacion,cm.montoAutHospital,cm.montoConIva,cm.deducibleConGastosNocub " + 
			                   ",cm.coaseguroMedico,cm.totalCargoPaciente,cm.baseRechazo,cm.subespecialidad,cm.domicilioProveedor,cm.montoAutorizadoSdava " + 
			                   ",cm.folioRamSgaval,cm.telefonoUnoSdaval,cm.telefonodosSdaval,cm.emailUnoSdaval,cm.observqacionesExternas " + 
			                   ",cm.observacionesInternas,cm.usuarioActual,cm.usuarioReporte,cm.correoReporte,cm.usuarioAsignado " + 
			                   ",cm.correoAsignado,cm.usuarioDictaminador,cm.correoDictaminador,cm.taskIdTomaReporte,cm.taskIdAsignacion " + 
			                   ",cm.taskIdDictaminacion,cm.taskIdActual,cm.creationDate,cm.createBy,cm.lastupdateDate,cm.lastUpdateBy " + 
			                   ",cm.tipoAsignacion, cm.nivelComplejidad, cm.tipoPagoSdaval, cm.tipoReservaSdal,cm.subespecialidadSdaval " + 
			                   ",cm.domicilioProveedorSdaval,cm.ciudadSdaval,cm.municipioSdaval,cm.tieneCartaPrefactura,cm.tramitadorReasignado "+
			                   ",sin.estado, sin.numeroSiniestro, sin.tipoSiniestro, sin.porcentajeEdoCta, sin.montoSiniestro, sin.folioRam " + 
			                   ",sin.descDiagnostico, sin.codDiagnistico, sin.fechaOcurrencia, sin.causa, sin.consecuencia, sin.fechaInicioSintomas " + 
			                   ",sin.coberturaAfectada, sin.tipoPago, sin.tipoReserva, sin.montoReserva, sin.remanenteSumaAseg, sin.totalAutorizadoHm, sin.folioRamMed " + 
			                   ",sin.ciudadEntrega, sin.codigoPostalEntrega, sin.direccionEntrega, sin.telContactoaseg, sin.correoNotifAseg, sin.totalAutorizadoMed " + 
			                   ",sin.folioRamServ, sin.totalAutorizadoServ, sin.deducibleContratado, sin.reduccionDeducible, sin.incrementoDeducible, sin.totalDeducible, sin.coaseguroContratado " + 
			                   ",sin.redCoaSeguroHosp, sin.incCoaseguroHosp, sin.topeCoaseguro, sin.tipoTopeCoaseguro, sin.totalCoaseguroHosp, sin.redCoaseguroMed, sin.totalCoaseguroMed " + 
			                   ",sin.reduccionCoaseguroMed, sin.topeIndemnizacion, sin.totalDeducibleMonto, sin.deducibleMedicamentos, sin.coaseguroMedicamentos " + 
			                   ",sin.totalMedicamentos, sin.deducibleServicios, sin.coaseguroServicios, sin.totalServicios "+
			                   ",doc.tipoDocumento, doc.observaciones, doc.notificado, doc.recibido, doc.indiceProvider "+
			                   ",valoracion.integrante, valoracion.especialidad, valoracion.medicoTratante, valoracion.montoAutorizado, valoracion.folioRam, valoracion.tipoPago, valoracion.tipoReserva, valoracion.indiceProvider "+
			                   ",honorariosmd.integrante, honorariosmd.nombreMedico, honorariosmd.especialidad, honorariosmd.montoAutorizado, honorariosmd.folioRam, honorariosmd.tipoPago, honorariosmd.tipoReserva, honorariosmd.indiceProvider "+
			                   ",medicamento.proveedor, medicamento.codigoMedicamento, medicamento.descripcionMedicamento, medicamento.cantidad, medicamento.precioAutUnidad, medicamento.totalAutorizado, medicamento.indiceProvider "+
			                   ",servicio.razonSocial, servicio.tipoServicio, servicio.subtipoServicio, servicio.cantidad, servicio.precioAutUnidad, servicio.totalAutorizado, servicio.indiceProvider "+
			                   ",cpt.descripcionCpt, cpt.claveCpt, proceso.codSector, proceso.codProceso "+
			                   ",bitacora.codSector, bitacora.nombreProceso, bitacora.nombreActividad, bitacora.fechaInicioActividad, bitacora.fechaFinActividad, bitacora.claveEstatus, bitacora.secuencia, bitacora.usuarioEjecutivo "
            + " FROM CMCentralMedica cm,"
            + " CMSiniestros sin,"
            + " CMDocumentos doc,"
            + " CMSdaValoracion valoracion,"
            + " CMHonorariosMed honorariosmd,"
            + " CMMedicamentos medicamento,"
            + " CMServicios servicio,"
            + " CMCpt cpt,"
            + " CMRegProceso proceso,"
            + " CMBitacora bitacora"
            + " WHERE cm.idSolicitud = sin.centralMedica"
            + " AND cm.idSolicitud = doc.centralMedica"
            + " AND cm.idSolicitud = valoracion.centralMedica "
            + " AND sin.idSiniestro = honorariosmd.siniestro"
            + " AND sin.idSiniestro = medicamento.siniestro"
            + " AND sin.idSiniestro = servicio.siniestro"
            + " AND sin.idSiniestro = cpt.siniestro"
            + " AND cm.idSolicitud = proceso.idSolicitud"
            + " AND  proceso.idRegProceso = bitacora.regProceso";
           /* + " AND cm.creationDate >= :dateStart"
            + " AND cm.creationDate <= :dateFinish";*/
	
	
	public static String QUERY = "SELECT cm,sin"
            + " FROM CMCentralMedica cm,"
            + " CMSiniestros sin,"
            + " CMDocumentos doc,"
            + " CMSdaValoracion valoracion,"
            + " CMHonorariosMed honorariosmd,"
            + " CMMedicamentos medicamento,"
            + " CMServicios servicio,"
            + " CMCpt cpt "
            + " WHERE cm.idSolicitud = sin.centralMedica"
            + " AND cm.idSolicitud = doc.centralMedica"
            + " AND cm.idSolicitud = valoracion.centralMedica "
            + " AND sin.idSiniestro = honorariosmd.siniestro"
            + " AND sin.idSiniestro = medicamento.siniestro"
            + " AND sin.idSiniestro = servicio.siniestro"
            + " AND sin.idSiniestro = cpt.siniestro"
            + " AND cm.creationDate >= :dateStart"
            + " AND cm.creationDate <= :dateFinish";
	
	
	public static  String REPORT = "SELECT cm.creationDate, cm.codSector, cm.idTipoSolicitud, cm.folioReapertura, cm.folio, cm.subTipoTramite, cm.tienePreautorizacion, cm.folioPreautorizacion, cm.nombreProveedor,"
			                     + " cm.estadoRepublica, cm.nivelHospitalario, cm.fechaIngreso, cm.urgencia, cm.habitacionAsignada, cm.numeroPoliza, cm.ramo, cm.polizaPagadaHasta,cm.inicioVigencia,"
			                     + " cm.finVigencia, cm.polProcesoEmision, cm.nombreContratante, cm.recienNacido, cm.apellidoPaternoPaciente, cm.apellidoMaternoPaciente, cm.primerNombrePaciente,cm.segundoNombrePaciente, cm.numeroRiesgo, cm.fechaNacimientoPaciente,"
			                     + " cm.generoPaciente, cm.titularPoliza, cm.medicoRed, cm.nombreMedico, cm.especialidadMedico, cm.redProveedor, cm.sintomasDiagnostico, cm.femiliarResponsable, cm.telFamiliarResponsable, cm.nombreReportante,"
			                     + " cm.telefonoReportante, cm.emailReportante, cm.observacionesIngreso, cm.nivelComplejidad, cm.usuarioAsignado,"// bitacora44,45,46, 48, 49 , 50, 51
			                     + " cm.tipoTramite, cm.territorioAtencion, cm.tipoMoneda, cm.fechaPrealtaHospitalaria, cm.fechaEgresoHospitalaria, cm.tieneInsumoRecobro,"
			                     + " cm.importeEdoCuentaSdesv, cm.desviosEdoCuenta, cm.baseIndemnizacion, cm.montoAutHospital, cm.montoConIva, sin.numeroSiniestro, sin.estado, sin.tipoSiniestro, sin.porcentajeEdoCta, sin.montoSiniestro," //65 cm
			                     + " sin.folioRam, sin.codDiagnistico, sin.descDiagnostico, sin.fechaOcurrencia, sin.causa, sin.consecuencia, sin.fechaInicioSintomas, sin.coberturaAfectada, sin.tipoPago, sin.tipoReserva,"
			                     + " cpt.claveCpt, cpt.descripcionCpt, sin.deducibleContratado, sin.reduccionDeducible, sin.incrementoDeducible, sin.totalDeducible, sin.coaseguroContratado, sin.redCoaSeguroHosp, sin.incCoaseguroHosp,"//sin 81, 84->  cpt 82, 83
			                     + " sin.topeCoaseguro, sin.tipoTopeCoaseguro, sin.totalCoaseguroHosp, hmed.integrante, hmed.nombreMedico, hmed.especialidad, hmed.montoAutorizado, hmed.folioRam, hmed.tipoPago," //93 ->tipoTopeCoaseguro 94 -> totalCoaseguroHosp , hmed.integrante = 95			                     + " FROM CMCentralMedica cm,"
	                             + " hmed.tipoReserva, sin.totalAutorizadoHm, sin.coaseguroMedico, sin.redCoaseguroMed, sin.totalCoaseguroMed, cm.coaseguroMedico, cm.totalCargoPaciente, medi.proveedor, medi.descripcionMedicamento,"// falta gastos no cubiertos
			                     + " medi.codigoMedicamento, medi.cantidad, medi.precioAutUnidad, sin.totalAutorizadoMed, sin.folioRamMed, sin.deducibleMedicamentos, sin.coaseguroMedicamentos, sin.totalMedicamentos, servicio.tipoServicio, servicio.razonSocial,"
	                             + " servicio.cantidad, servicio.precioAutUnidad, sin.totalAutorizadoServ, sin.folioRamServ, sin.deducibleServicios, sin.coaseguroServicios, sin.totalServicios, cm.baseRechazo, valoracion.medicoTratante,"
			                     + " valoracion.especialidad, valoracion.montoAutorizado, valoracion.tipoPago, valoracion.tipoReserva, doc.tipoDocumento, cm.idSolicitud"
			                     + " FROM CMCentralMedica cm,"
			                     + " CMSiniestros sin,"
	            + " CMDocumentos doc,"
	            + " CMSdaValoracion valoracion,"
	            + " CMHonorariosMed hmed,"
	            + " CMMedicamentos medi,"
	            + " CMServicios servicio,"
	            + " CMCpt cpt"
	            + " WHERE cm.idSolicitud = sin.centralMedica"
	            + " AND cm.idSolicitud = doc.centralMedica"
	            + " AND cm.idSolicitud = valoracion.centralMedica "
	            + " AND sin.idSiniestro = hmed.siniestro"
	            + " AND sin.idSiniestro = medi.siniestro"
	            + " AND sin.idSiniestro = servicio.siniestro"
	            + " AND sin.idSiniestro = cpt.siniestro";
}
