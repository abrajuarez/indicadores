package com.indicador.mapfre.xls;

import java.io.ByteArrayInputStream;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.indicador.mapfre.entity.CMBitacora;
import com.indicador.mapfre.entity.CMCentralMedica;
import com.indicador.mapfre.model.DateCMModel;
import com.indicador.mapfre.model.ReportCentralMedicaModel;
import com.indicador.mapfre.repository.CMBitacoraRepository;
import com.indicador.mapfre.service.CMBitacoraService;
import com.indicador.mapfre.service.CMCentralMedicaReportService;
import com.indicador.mapfre.service.CMCentralMedicaService;
import com.indicador.mapfre.util.CMReportUtil;
import com.indicador.mapfre.util.ConvertUtil;
import com.indicador.mapfre.util.DateUtil;
import com.indicador.mapfre.util.StringUtil;
import com.indicador.mapfre.util.xls.CellStyleUtil;

@Service
public class CmCentralReporte {
	
	private static final Logger logger = LogManager.getLogger(CmCentralReporte.class);
	
	@Autowired
	private CMCentralMedicaService cmservice;
	
	@Autowired
	private CMCentralMedicaReportService reportService;
	
	@Autowired
	private CMBitacoraService bitaService;

	public ByteArrayInputStream create(DateCMModel datesmodel) throws IOException {
		logger.info("methods create ");
		try (
				// Con esta version se puede xlsx
				Workbook workbook = WorkbookFactory.create(true);
				ByteArrayOutputStream out = new ByteArrayOutputStream();) {

			createSheetOne(workbook, datesmodel);
			workbook.write(out);
			return new ByteArrayInputStream(out.toByteArray());
		}
	}
	
	private void createSheetOne(Workbook workbook, DateCMModel dates) {
		
		Sheet sheet = workbook.createSheet("central medica");
		String dateFinish = DateUtil.plusDayToUUU(dates.getDateStart(), 8l);//"30/01/20";
		CellStyleUtil style = new CellStyleUtil(workbook);
		titleTable(sheet, style,dates.getDateStart(),dateFinish);
		//List<ReportCentralMedicaModel> list = reportService.findByCreationDate(dates.getDateStart(), dateFinish);
		List<ReportCentralMedicaModel> list = reportService.findByCreationDate(dates.getDateStart(), dateFinish);
		bodyTable(sheet, style, list);
	}
	
	private void titleTable(Sheet sheet, CellStyleUtil style,String fechaInicio, String fechaFinal) {
		logger.info("methods cellTitle ");
		Row rowFechaInicial= sheet.createRow(0);
		Cell cellFechaInicial = rowFechaInicial.createCell(0);
		cellFechaInicial.setCellValue("Fecha Inicial:");
		Cell cellInicial = rowFechaInicial.createCell(1);
		cellInicial.setCellValue(fechaInicio);
		
		Row rowFechaFinal= sheet.createRow(1);
		Cell cellFechaFinal = rowFechaFinal.createCell(0);
		cellFechaFinal.setCellValue("Fecha Final:");
		Cell cellFinal = rowFechaFinal.createCell(1);
		cellFinal.setCellValue(fechaFinal);
		
		Row headerRow = sheet.createRow(3);
		//Row rowIdex = sheet.createRow(2);
		List<String> title = CMReportUtil.titleReport();
		for (int col = 0; col < title.size(); col++) {
			//Cell cellIndex = rowIdex.createCell(col);
			//cellIndex.setCellValue(col + "");
			Cell cell = headerRow.createCell(col);
			cell.setCellValue(title.get(col));
			cell.setCellStyle(style.title());
			sheet.autoSizeColumn(col);
		}
		title = null;
	}
	
	private void bodyTable(Sheet sheet,CellStyleUtil style, List<ReportCentralMedicaModel>  list) {
		int rowId = 4;
		Long idSolicitudAnterior = 0l;
		CMBitacora bitaTomaReporte = null;
		CMBitacora bitaDictaminacion = null;
		CMBitacora bitaAsignacion = null;
		for (int index = 0; index < list.size(); index++) {
			Row row = sheet.createRow(rowId++);
			ReportCentralMedicaModel cm = list.get(index);
			
			Cell cellFechaCreacion = row.createCell(0);
			value(row, cellFechaCreacion, 0, StringUtil.getFecha(cm.getCmcreationDate()), style, sheet);

			Cell cellHoraCreacion = row.createCell(1);
			value(row, cellHoraCreacion, 1, StringUtil.getHora(cm.getCmcreationDate()), style, sheet);

			Cell cellSector = row.createCell(2);
			value(row, cellSector, 2, CMReportUtil.getSector(ConvertUtil.StringToLong((cm.getCmcodSector()))), style, sheet);

			Cell cellTipoSolicitud = row.createCell(3);
			value(row, cellTipoSolicitud, 3, CMReportUtil.tipoSolicitud(cm.getCmidTipoSolicitud()), style, sheet);

			Cell cellFolioBpm = row.createCell(4);
			value(row, cellFolioBpm, 4, CMReportUtil.containFolio(cm.getCmfolioReapertura()), style, sheet);

			Cell cellFolioCarta = row.createCell(5);
			value(row, cellFolioCarta, 5, cm.getCmfolioReapertura(), style, sheet);

			Cell cellFolioTramite = row.createCell(6);
			value(row, cellFolioTramite, 6, cm.getCmfolio(), style, sheet);

			Cell cellSubtipoTramite = row.createCell(7);
			value(row, cellSubtipoTramite, 7, cm.getCmSubTipoTramite(), style, sheet);

			Cell cellFolioPreautorizado = row.createCell(8);
			value(row, cellFolioPreautorizado, 8, cm.getCmtienePreautorizacion(), style, sheet);

			Cell cellNoFolioPreautorizado = row.createCell(9);
			value(row, cellNoFolioPreautorizado, 9, cm.getCmfolioPreautorizacion(), style, sheet);

			Cell cellProveedor = row.createCell(10);
			value(row, cellProveedor, 10, cm.getCmnombreProveedor(), style, sheet);

			Cell cellEstado = row.createCell(11);
			value(row, cellEstado, 11, cm.getCmestadoRepublica(), style, sheet);

			Cell cellNivelHospitalario = row.createCell(12);
			value(row, cellNivelHospitalario, 12, cm.getCmnivelHospitalario(), style, sheet);

			Cell cellFechaIngreso = row.createCell(13);
			value(row, cellFechaIngreso, 13, StringUtil.getFecha(cm.getCmfechaIngreso()), style, sheet);

			Cell cellHoraIngreso = row.createCell(14);
			value(row, cellHoraIngreso, 14, StringUtil.getHora(cm.getCmfechaIngreso()), style, sheet);

			Cell cellUrgencias = row.createCell(15);
			value(row, cellUrgencias, 15, cm.getCmurgencia(), style, sheet);

			Cell cellHabitacionAsignada = row.createCell(16);
			value(row, cellHabitacionAsignada, 16, cm.getCmhabitacionAsignada(), style, sheet);

			Cell cellPolizaAsignada = row.createCell(17);
			value(row, cellPolizaAsignada, 17, cm.getCmnumeroPoliza(), style, sheet);

			Cell cellRamo = row.createCell(18);
			value(row, cellRamo, 18, cm.getCmramo(), style, sheet);

			Cell cellPagadaHasta = row.createCell(19);
			value(row, cellPagadaHasta, 19, cm.getCmpolizaPagadaHasta(), style, sheet);

			Cell cellInicioVigencia = row.createCell(20);
			value(row, cellInicioVigencia, 20, StringUtil.getFecha(cm.getCminicioVigencia()), style, sheet);

			Cell cellFinVigencia = row.createCell(21);
			value(row, cellFinVigencia, 21, StringUtil.getFecha(cm.getCmfinVigencia()), style, sheet);

			Cell cellPolEnProceso = row.createCell(22);
			value(row, cellPolEnProceso, 22, cm.getCmpolProcesoEmision(), style, sheet);

			Cell cellContratante = row.createCell(23);
			value(row, cellContratante, 23, cm.getCmnombreContratante(), style, sheet);

			Cell cellRecienNacido = row.createCell(24);
			value(row, cellRecienNacido, 24, cm.getCmrecienNacido(), style, sheet);

			Cell cellRiesgoApellido1 = row.createCell(25);
			value(row, cellRiesgoApellido1, 25, cm.getCmapellidoPaternoPaciente(), style, sheet);

			Cell cellRiesgoApellido2 = row.createCell(26);
			value(row, cellRiesgoApellido2, 26, cm.getCmapellidoMaternoPaciente(), style, sheet);

			Cell cellRiesgoNombre1 = row.createCell(27);
			value(row, cellRiesgoNombre1, 27, cm.getCmprimerNombrePaciente(), style, sheet);

			Cell cellRiesgoNombre2 = row.createCell(28);
			value(row, cellRiesgoNombre2, 28, cm.getCmsegundoNombrePaciente(), style, sheet);

			Cell cellNumRiesgo = row.createCell(29);
			value(row, cellNumRiesgo, 29, cm.getCmnumeroRiesgo() , style, sheet);

			Cell cellRiesgoFechaNacimiento = row.createCell(30);
			value(row, cellRiesgoFechaNacimiento, 30, StringUtil.getFecha(cm.getCmfechaNacimientoPaciente()), style, sheet);

			Cell cellRiesgoGenero = row.createCell(31);
			value(row, cellRiesgoGenero, 31, cm.getCmgeneroPaciente(), style, sheet);

			Cell cellRiesgoTitularPoliza = row.createCell(32);
			value(row, cellRiesgoTitularPoliza, 32, cm.getCmtitularPoliza(), style, sheet);

			Cell cellMedicoRed = row.createCell(33);
			value(row, cellMedicoRed, 33, cm.getCmmedicoRed(), style, sheet);

			Cell cellNombreMedicoTratante = row.createCell(34);
			value(row, cellNombreMedicoTratante, 34, cm.getCmnombreMedico(), style, sheet);

			Cell cellEspecialidadMedico = row.createCell(35);
			value(row, cellEspecialidadMedico, 35, cm.getCmespecialidadMedico(), style, sheet);

			Cell cellTipoRedMedico = row.createCell(36);
			value(row, cellTipoRedMedico, 36, cm.getCmredProveedor(), style, sheet);

			Cell cellSintomas = row.createCell(37);
			value(row, cellSintomas, 37, cm.getCmsintomasDiagnostico(), style, sheet);

			Cell cellFamiliarResponsable = row.createCell(38);
			value(row, cellFamiliarResponsable, 38, cm.getCmfemiliarResponsable(), style, sheet);

			Cell cellTelFamiliar = row.createCell(39);
			value(row, cellTelFamiliar, 39, cm.getCmtelFamiliarResponsable(), style, sheet);

			Cell cellReportante = row.createCell(40);
			value(row, cellReportante, 40, cm.getCmnombreReportante(), style, sheet);

			Cell cellTelefonoReportante = row.createCell(41);
			value(row, cellTelefonoReportante, 41, cm.getCmtelefonoReportante(), style, sheet);

			Cell cellCorreoReportante = row.createCell(42);
			value(row, cellCorreoReportante, 42, cm.getCmemailReportante(), style, sheet);

			Cell cellObservacion = row.createCell(43);
			value(row, cellObservacion, 43, cm.getCmobservacionesIngreso(), style, sheet);
			
	
			Long idSolicitud = cm.getCmidSolicitud();
			if(idSolicitudAnterior != idSolicitud ) {
				idSolicitudAnterior = idSolicitud;
				/*toma de reporte*/
				 bitaTomaReporte = bitaService.findFirstElementBYIdRegProcesoAndNombreActividad(idSolicitud, 1,"idBitacora", "Toma de reporte");
				
				Cell cellFechaCierreReporte = row.createCell(44);
				value(row, cellFechaCierreReporte, 44, StringUtil.getFecha(bitaTomaReporte.getFechaFinActividad()), style,
						sheet);

				Cell cellHoraCierreReporte = row.createCell(45);
				value(row, cellHoraCierreReporte, 45, StringUtil.getHora(bitaTomaReporte.getFechaFinActividad()), style,
						sheet);

				Cell cellUsuarioReporte = row.createCell(46);
				value(row, cellUsuarioReporte, 46, bitaTomaReporte.getUsuarioEjecutivo(), style, sheet);
				/*toma de dictaminacion*/
				bitaDictaminacion = bitaService.findLastElementBYIdRegProcesoAndNombreActividad(idSolicitud, "Dictaminación");
				Cell cellUsuarioAsignado = row.createCell(48);
				value(row, cellUsuarioAsignado, 48, bitaDictaminacion.getUsuarioEjecutivo(), style, sheet);
		
				
				Cell cellFecha1Asignacion = row.createCell(49);
				value(row, cellFecha1Asignacion, 49,StringUtil.getFecha(bitaDictaminacion.getFechaInicioActividad()) , style,
						sheet);

				Cell cellHoraAsignacion = row.createCell(50);
				value(row, cellHoraAsignacion, 50, StringUtil.getHora(bitaDictaminacion.getFechaInicioActividad()), style,
						sheet);
				Cell cellNombreTramitador = row.createCell(133);
				value(row, cellNombreTramitador , 133, bitaDictaminacion.getUsuarioEjecutivo(), style, sheet);
				
				Cell cellFechaFinTramite = row.createCell(134);
				value(row, cellFechaFinTramite, 134,StringUtil.getFecha( bitaDictaminacion.getLastUpdateDate()), style, sheet);
				
				Cell cellHoraFinTramite = row.createCell(135);
				value(row, cellHoraFinTramite, 135, StringUtil.getHora(bitaDictaminacion.getLastUpdateDate()), style, sheet);
				
				/*Asignacion*/
				 bitaAsignacion = bitaService.findLastElementBYIdRegProcesoAndNombreActividad(idSolicitud, "Asignación");
				Cell cellNombreAsignador = row.createCell(51);
				value(row, cellNombreAsignador, 51, bitaAsignacion.getUsuarioEjecutivo(), style, sheet);
				
			logger.info("methods bodyTable is diferent idSolicitud =  "+ idSolicitud + " index = "+index);
			}else {
				/*toma de reporte*/
				Cell cellFechaCierreReporte = row.createCell(44);
				value(row, cellFechaCierreReporte, 44, StringUtil.getFecha(bitaTomaReporte.getFechaFinActividad()), style,
						sheet);

				Cell cellHoraCierreReporte = row.createCell(45);
				value(row, cellHoraCierreReporte, 45, StringUtil.getHora(bitaTomaReporte.getFechaFinActividad()), style,
						sheet);

				Cell cellUsuarioReporte = row.createCell(46);
				value(row, cellUsuarioReporte, 46, bitaTomaReporte.getUsuarioEjecutivo(), style, sheet);
				
                      /*dictminacion*/
				Cell cellUsuarioAsignado = row.createCell(48);
				value(row, cellUsuarioAsignado, 48, bitaDictaminacion.getUsuarioEjecutivo(), style, sheet);
		
				
				Cell cellFecha1Asignacion = row.createCell(49);
				value(row, cellFecha1Asignacion, 49,StringUtil.getFecha(bitaDictaminacion.getFechaInicioActividad()) , style,
						sheet);

				Cell cellHoraAsignacion = row.createCell(50);
				value(row, cellHoraAsignacion, 50, StringUtil.getHora(bitaDictaminacion.getFechaInicioActividad()), style,
						sheet);
				
				Cell cellNombreTramitador = row.createCell(133);
				value(row, cellNombreTramitador , 133, bitaDictaminacion.getUsuarioEjecutivo(), style, sheet);
				
				Cell cellFechaFinTramite = row.createCell(134);
				value(row, cellFechaFinTramite, 134,StringUtil.getFecha( bitaDictaminacion.getLastUpdateDate()), style, sheet);
				
				Cell cellHoraFinTramite = row.createCell(135);
				value(row, cellHoraFinTramite, 135, StringUtil.getHora(bitaDictaminacion.getLastUpdateDate()), style, sheet);
				
				
				/*Asignacion*/
				Cell cellNombreAsignador = row.createCell(51);
				value(row, cellNombreAsignador, 51, bitaAsignacion.getUsuarioEjecutivo(), style, sheet);
				logger.info("methods bodyTable is equal  idSolicitud  ");
			}
			
			
			Cell cellNivelComplejidad = row.createCell(47);
			value(row, cellNivelComplejidad, 47, cm.getCmnivelComplejidad(), style, sheet);

			

			
			
			Cell cellTipoTramite = row.createCell(52);
			value(row, cellTipoTramite, 52, cm.getCmtipoTramite(), style, sheet);

			/*Cell cellTipoTramite2 = row.createCell(53);
			value(row, cellTipoTramite2, 53, "no", style, sheet);*/

			Cell cellTerritorio = row.createCell(53);
			value(row, cellTerritorio, 53, cm.getCmterritorioAtencion(), style, sheet);

			Cell cellTipoMoneda = row.createCell(54);
			value(row, cellTipoMoneda, 54, cm.getCmtipoMoneda(), style, sheet);

			Cell cellFechaPreAlta = row.createCell(55);
			value(row, cellFechaPreAlta, 55, StringUtil.getFecha(cm.getCmfechaPrealtaHospitalaria()), style, sheet);

			Cell cellHoraPrealta = row.createCell(56);
			value(row, cellHoraPrealta, 56, StringUtil.getHora(cm.getCmfechaPrealtaHospitalaria()), style, sheet);

			Cell cellFechaEgreso = row.createCell(57);
			value(row, cellFechaEgreso, 57, StringUtil.getFecha(cm.getCmfechaEgresoHospitalaria()), style, sheet);

			Cell cellHoraEgreso = row.createCell(58);
			value(row, cellHoraEgreso, 58, StringUtil.getHora(cm.getCmfechaEgresoHospitalaria()), style, sheet);

			Cell cellInsumosRecobros = row.createCell(59);
			value(row, cellInsumosRecobros, 59, cm.getCmtieneInsumoRecobro(), style, sheet);

			Cell cellImporteEdoCuentaSinDesvios = row.createCell(60);
			value(row, cellImporteEdoCuentaSinDesvios, 60, cm.getCmimporteEdoCuentaSdesv(), style, sheet);

			Cell cellDesviosEdoCuenta = row.createCell(61);
			value(row, cellDesviosEdoCuenta, 61, cm.getCmdesviosEdoCuenta(), style, sheet);

			Cell cellBaseIndemnizacion = row.createCell(62);
			value(row, cellBaseIndemnizacion, 62, cm.getCmbaseIndemnizacion(), style, sheet);

			Cell cellMontoAutHospital = row.createCell(63);
			value(row, cellMontoAutHospital, 63, cm.getCmmontoAutHospital(), style, sheet);

			Cell cellMontoConIva = row.createCell(64);
			value(row, cellMontoConIva, 64, cm.getCmmontoConIva(), style, sheet);
			
			Cell cellNoSiniestro1 = row.createCell(65);
			value(row, cellNoSiniestro1, 65, cm.getSinnumeroSiniestro() , style, sheet);

			Cell cellEstadoSiniestro1 = row.createCell(66);
			value(row, cellEstadoSiniestro1, 66, cm.getSinestado(), style, sheet);

			Cell cellTipoSiniestro = row.createCell(67);
			value(row, cellTipoSiniestro, 67, cm.getSintipoSiniestro(), style, sheet);

			Cell cellEdoCuenta1 = row.createCell(68);
			value(row, cellEdoCuenta1, 68, cm.getSinporcentajeEdoCta(), style, sheet);

			Cell cellMontoSiniestro1 = row.createCell(69);
			value(row, cellMontoSiniestro1, 69, cm.getSinmontoSiniestro() , style, sheet);

			Cell cellRamHospSiniestro1 = row.createCell(70);
			value(row, cellRamHospSiniestro1, 70, cm.getSinfolioRam(), style, sheet);

			Cell cellNoIcd = row.createCell(71);
			value(row, cellNoIcd, 71, cm.getSincodDiagnistico(), style, sheet);

			Cell cellDescripcionIcd = row.createCell(72);
			value(row, cellDescripcionIcd, 72, cm.getSindescDiagnostico(), style, sheet);

			Cell cellFechaOcurrido = row.createCell(73);
			value(row, cellFechaOcurrido, 73, StringUtil.getFecha(cm.getSinfechaOcurrencia()), style, sheet);

			Cell cellCausa = row.createCell(74);
			value(row, cellCausa, 74, cm.getSincausa(), style, sheet);

			Cell cellConsecuencia = row.createCell(75);
			value(row, cellConsecuencia, 75, cm.getSinconsecuencia(), style, sheet);

			Cell cellInicioSintomas = row.createCell(76);
			value(row, cellInicioSintomas, 76, cm.getSinfechaInicioSintomas() , style, sheet);

			Cell cellCoberturaAfectada = row.createCell(77);
			value(row, cellCoberturaAfectada, 77, cm.getSincoberturaAfectada(), style, sheet);

			Cell cellTipoPago = row.createCell(78);
			value(row, cellTipoPago, 78, cm.getSintipoPago(), style, sheet);

			Cell cellTipoReserva = row.createCell(79);
			value(row, cellTipoReserva, 79, cm.getSintipoReserva(), style, sheet);

			Cell cellMontoReserva = row.createCell(80);
			value(row, cellMontoReserva, 80, cm.getSintipoReserva(), style, sheet);
			
			Cell cellNoCpt1 = row.createCell(81);
			value(row, cellNoCpt1, 81, cm.getCptclaveCpt(), style, sheet);
			
			Cell cellDescripcionCpt1 = row.createCell(82);
			value(row, cellDescripcionCpt1, 82, cm.getCptdescripcionCpt(), style, sheet);
			
			
			Cell cellDedContratatdo1 = row.createCell(83);
			value(row, cellDedContratatdo1, 83, cm.getSindeducibleContratado(), style, sheet);

			Cell cellReduccionDed1 = row.createCell(84);
			value(row, cellReduccionDed1, 84, cm.getSinreduccionDeducible() , style, sheet);

			Cell cellIncrementoDed1 = row.createCell(85);
			value(row, cellIncrementoDed1, 85, cm.getSinincrementoDeducible() , style, sheet);

			Cell cellTotalDed1 = row.createCell(86);
			value(row, cellTotalDed1, 86, cm.getSintotalDeducible(), style, sheet);

			Cell cellCoa1HospContratado = row.createCell(87);
			value(row, cellCoa1HospContratado, 87, cm.getSincoaseguroContratado(), style, sheet);

			Cell cellReduccionCoaaHosp = row.createCell(88);
			value(row, cellReduccionCoaaHosp, 88, cm.getSinredCoaSeguroHosp(), style, sheet);

			Cell cellIncrementoCoa1Hosp = row.createCell(89);
			value(row, cellIncrementoCoa1Hosp, 89, cm.getSinincCoaseguroHosp(), style, sheet);

			Cell cellTopeCoa1Hosp = row.createCell(90);
			value(row, cellTopeCoa1Hosp, 90, cm.getSintopeCoaseguro() , style, sheet);

			Cell cellConTopeCoa1Hosp = row.createCell(91);
			value(row, cellConTopeCoa1Hosp, 91, cm.getSintipoTopeCoaseguro(), style, sheet);


			/*Cell cellTopeAlcanzadoCoa1Hosp = row.createCell(92);
			value(row, cellTopeAlcanzadoCoa1Hosp, 92,  "no", style, sheet);*/

			Cell cellTotalCoa1Hosp = row.createCell(92);
			value(row, cellTotalCoa1Hosp, 92, cm.getSintotalCoaseguroHosp(), style, sheet);
			
			Cell cellIntegrante = row.createCell(93);
			value(row,cellIntegrante, 93, cm.getHmedintegrante(), style, sheet);

			Cell cellNombreMedico = row.createCell(94);
			value(row, cellNombreMedico, 94, cm.getHmednombreMedico(), style, sheet);

			Cell cellEspecialidad = row.createCell(95);
			value(row, cellEspecialidad, 95, cm.getHmedespecialidad(), style, sheet);

			Cell cellMontoAutorizado = row.createCell(96);
			value(row,cellMontoAutorizado, 96, cm.getHmedmontoAutorizado() , style, sheet);

			Cell cellFolioRam = row.createCell(97);
			value(row,cellFolioRam, 97, cm.getHmedfolioRam(), style, sheet);

			Cell cellHmedTipoPago= row.createCell(98);
			value(row, cellHmedTipoPago, 98, cm.getHmedtipoPago(), style, sheet);

			Cell cellHmedTipoReserva= row.createCell(99);
			value(row, cellHmedTipoReserva, 99, cm.getHmedtipoReserva(), style, sheet);
			
			Cell cellTotalHonorarios = row.createCell(100);
			value(row, cellTotalHonorarios, 100, cm.getSintotalAutorizadoHm(), style, sheet);

			Cell cellCoa1Med = row.createCell(101);
			value(row, cellCoa1Med, 101, cm.getSincoaseguroMedico(), style, sheet);

			Cell cellRedCoa1 = row.createCell(102);
			value(row, cellRedCoa1, 102, cm.getSinredCoaseguroMed() , style, sheet);

			Cell cellTotalMedCoa1 = row.createCell(103);
			value(row, cellTotalMedCoa1, 103, cm.getSintotalCoaseguroMed() , style, sheet);
			
			Cell cellGastoNoCubierto = row.createCell(104);
			value(row, cellGastoNoCubierto, 104, "no", style, sheet);

			Cell cellCoaseguroMedico = row.createCell(105);
			value(row, cellCoaseguroMedico, 105, cm.getCmcoaseguroMedico() , style, sheet);
			
			Cell cellTotalACargoPaciente = row.createCell(106);
			value(row, cellTotalACargoPaciente, 106, cm.getCmtotalCargoPaciente(), style, sheet);
			
			Cell cellMedicamentoRs = row.createCell(107);
			value(row, cellMedicamentoRs, 107, cm.getMediproveedor(), style, sheet);
			
			Cell cellMedicamentoNombre = row.createCell(108);
			value(row, cellMedicamentoNombre, 108, cm.getMedidescripcionMedicamento(), style, sheet);
			
			Cell cellMedicamentoCodigo = row.createCell(109);
			value(row, cellMedicamentoCodigo, 109, cm.getMedicodigoMedicamento(), style, sheet);
			
			Cell cellCantidad = row.createCell(110);
			value(row, cellCantidad, 110, cm.getMedicantidad() , style, sheet);
			
			Cell cellPrecio = row.createCell(111);
			value(row, cellPrecio, 111, cm.getMediprecioAutUnidad() , style, sheet);
			
			Cell cellTotalAutMedicamento = row.createCell(112);
			value(row, cellTotalAutMedicamento, 112, cm.getSintotalAutorizadoMed(), style, sheet);
			
			Cell cellFolioRamMedicamento = row.createCell(113);
			value(row, cellFolioRamMedicamento, 113, cm.getSinfolioRamMed(), style, sheet);

			Cell cellDedMedicamento = row.createCell(114);
			value(row, cellDedMedicamento, 114, cm.getSindeducibleMedicamentos(), style, sheet);

			Cell cellCoaMedicamento = row.createCell(115);
			value(row, cellCoaMedicamento, 115, cm.getSincoaseguroMedicamentos(), style, sheet);

			Cell cellMedicamentoMontoACargoPaciente = row.createCell(116);
			value(row, cellMedicamentoMontoACargoPaciente, 116, cm.getSintotalMedicamentos(), style, sheet);
			
			Cell cellOtrosTipoServicio = row.createCell(117);
			value(row, cellOtrosTipoServicio, 117, cm.getServiciotipoServicio(), style, sheet);
			
			Cell cellOtros1Rs = row.createCell(118);
			value(row, cellOtros1Rs, 118, cm.getServiciorazonSocial(), style, sheet);
			
			Cell cellOtrosCantidad = row.createCell(119);
			value(row, cellOtrosCantidad, 119, cm.getServiciocantidad(), style, sheet);
			
			Cell cellOtrosPrecio = row.createCell(120);
			value(row,cellOtrosPrecio,  120, cm.getServicioprecioAutUnidad(), style, sheet);
			
			Cell cellOtrosTotalAutorizado = row.createCell(121);
			value(row, cellOtrosTotalAutorizado , 121, cm.getSintotalAutorizadoServ(), style, sheet);
			
			Cell cellOtrosRam = row.createCell(122);
			value(row, cellOtrosRam  , 122, cm.getSinfolioRamServ(), style, sheet);
			
			Cell cellOtrosDed= row.createCell(123);
			value(row, cellOtrosDed  , 123, cm.getSindeducibleServicios(), style, sheet);
			
			Cell cellOtrosCoa = row.createCell(124);
			value(row, cellOtrosCoa  , 124, cm.getSincoaseguroServicios(), style, sheet);

			Cell cellOtrosMontoACargpPac = row.createCell(125);
			value(row, cellOtrosMontoACargpPac  , 125, cm.getSintotalServicios(), style, sheet);
			
			Cell cellRechazoBases = row.createCell(126);
			value(row, cellRechazoBases  , 126, cm.getCmbaseRechazo(), style, sheet);
			
			Cell cellSolTipoDoc = row.createCell(127);
			value(row, cellSolTipoDoc  ,127, cm.getDocTipoDocumento(), style, sheet);
			
			Cell cell2DaMedico = row.createCell(128);
			value(row, cell2DaMedico  , 128, cm.getValorMedicoTratante(), style, sheet);
			
			Cell cell2DaEspecialidad = row.createCell(129);
			value(row, cell2DaEspecialidad  , 129, cm.getValorEspecialidad(), style, sheet);
			
			Cell cell2DaMontoAuto = row.createCell(130);
			value(row, cell2DaMontoAuto  , 130, cm.getValorMontoAutorizado(), style, sheet);
			
			Cell cell2DaTipoPago = row.createCell(131);
			value(row, cell2DaTipoPago  , 131, cm.getValorTipoPago(), style, sheet);
			
			Cell cell2DaTipoPagoReserva = row.createCell(132);
			value(row, cell2DaTipoPagoReserva  , 132, cm.getValorTipoReserva(), style, sheet);
			
			
		}
		list = null;
	}
	
	
	
	private void value(Row row, Cell cell, int index, String value, CellStyleUtil style, Sheet sheet) {
		Optional<String> opt = Optional.ofNullable(value);
		String values = opt.orElse("");
		//cell.setCellValue(values);
		cell.setCellValue(values.toUpperCase());

		// cell.setCellStyle(style.body());
		sheet.autoSizeColumn(index);
	}
}
