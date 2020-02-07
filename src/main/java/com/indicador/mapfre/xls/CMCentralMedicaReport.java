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
import org.springframework.stereotype.Component;

import com.indicador.mapfre.entity.CMBitacora;
import com.indicador.mapfre.entity.CMCentralMedica;
import com.indicador.mapfre.entity.CMCpt;
import com.indicador.mapfre.entity.CMHonorariosMed;
import com.indicador.mapfre.entity.CMMedicamentos;
import com.indicador.mapfre.entity.CMRegProceso;
import com.indicador.mapfre.entity.CMSdaValoracion;
import com.indicador.mapfre.entity.CMServicios;
import com.indicador.mapfre.entity.CMSiniestros;
import com.indicador.mapfre.model.DateCMModel;
import com.indicador.mapfre.model.DateModel;
import com.indicador.mapfre.repository.CMCptRepository;
import com.indicador.mapfre.repository.CMHonorariosMedRepository;
import com.indicador.mapfre.repository.CMMedicamentosRepository;
import com.indicador.mapfre.repository.CMRegProcesoRepository;
import com.indicador.mapfre.repository.CMSdaValoracionRepository;
import com.indicador.mapfre.repository.CMServiciosRepository;
import com.indicador.mapfre.repository.CMSiniestrosRepository;
import com.indicador.mapfre.service.CMBitacoraService;
import com.indicador.mapfre.service.CMCentralMedicaService;
import com.indicador.mapfre.util.CMReportUtil;
import com.indicador.mapfre.util.StringUtil;
import com.indicador.mapfre.util.xls.CellStyleUtil;
import org.springframework.data.domain.Sort;

@Component
public class CMCentralMedicaReport {

	private static final Logger logger = LogManager.getLogger(CMCentralMedicaReport.class);

	@Autowired
	private CMCentralMedicaService cmservice;

	@Autowired
	private CMSiniestrosRepository sinRepository;

	@Autowired
	private CMCptRepository cptRepository;

	@Autowired
	private CMHonorariosMedRepository hmedRepository;

	@Autowired
	private CMMedicamentosRepository medicamentoRepository;

	@Autowired
	private CMServiciosRepository servicioRepository;

	@Autowired
	private CMBitacoraService bitacoraService;

	@Autowired
	private CMRegProcesoRepository procesoRepository;
	
	@Autowired
	private CMSdaValoracionRepository sdaRepository;

	public ByteArrayInputStream create(DateCMModel datesmodel) throws IOException {
		logger.info("methods create ");
		try (
				// Con esta version se puede xlsx
				Workbook workbook = WorkbookFactory.create(true);

				// Workbook workbook = new HSSFWorkbook();
				ByteArrayOutputStream out = new ByteArrayOutputStream();) {

			createSheetOne(workbook, datesmodel);
			workbook.write(out);
			return new ByteArrayInputStream(out.toByteArray());
		}
	}

	private void createSheetOne(Workbook workbook, DateCMModel dates) {
		logger.info("methods createSheetOne ");
		Sheet sheet = workbook.createSheet("central medica");
		String dateFinish = "30/01/20";
		List<CMCentralMedica> list = cmservice.findAllByCreationDate(dates.getDateStart(), dateFinish);
		CellStyleUtil style = new CellStyleUtil(workbook);
		cellTitle(sheet, style);
		cellBody(sheet, style, list);
	}

	private void cellTitle(Sheet sheet, CellStyleUtil style) {
		logger.info("methods cellTitle ");
		Row headerRow = sheet.createRow(3);
		Row rowIdex = sheet.createRow(2);
		List<String> title = CMReportUtil.title();
		// logger.info("methods cellTitle numColumnas = "+title.size());
		for (int col = 0; col < title.size(); col++) {
			Cell cellIndex = rowIdex.createCell(col);
			cellIndex.setCellValue(col + "");
			// logger.info("methods cellTitle columnas = " + col + " data = " +
			// title.get(col));
			Cell cell = headerRow.createCell(col);
			cell.setCellValue(title.get(col));
			cell.setCellStyle(style.title());
			sheet.autoSizeColumn(col);
		}
	}

	private void cellBody(Sheet sheet, CellStyleUtil style, List<CMCentralMedica> results) {
		logger.info("methos cellBody ");

		logger.info("methos cellBody estatus = " + results.size());
		int rowId = 4;
		for (int i = 0; i < results.size(); i++) {
			Row row = sheet.createRow(rowId++);
			CMCentralMedica cm = results.get(i);
			valueColumns(row, cm, style, sheet);
			// autoSizeColumns(sheet);
		}
	}

	private void valueColumns(Row row, CMCentralMedica cm, CellStyleUtil style, Sheet sheet) {
		Cell cellFechaCreacion = row.createCell(0);
		value(row, cellFechaCreacion, 0, StringUtil.getFecha(cm.getCreationDate()), style, sheet);

		Cell cellHoraCreacion = row.createCell(1);
		value(row, cellHoraCreacion, 1, StringUtil.getHora(cm.getCreationDate()), style, sheet);

		Cell cellSector = row.createCell(2);
		value(row, cellSector, 2, CMReportUtil.getSector(cm.getCodSector()), style, sheet);

		Cell cellTipoSolicitud = row.createCell(3);
		value(row, cellTipoSolicitud, 3, cm.getIdTipoSolicitud() + "", style, sheet);

		Cell cellFolioBpm = row.createCell(4);
		value(row, cellFolioBpm, 4, "no", style, sheet);

		Cell cellFolioCarta = row.createCell(5);
		value(row, cellFolioCarta, 5, cm.getFolioReapertura(), style, sheet);

		Cell cellFolioTramite = row.createCell(6);
		value(row, cellFolioTramite, 6, cm.getFolio(), style, sheet);

		Cell cellSubtipoTramite = row.createCell(7);
		value(row, cellSubtipoTramite, 7, cm.getSubTipoTramite(), style, sheet);

		Cell cellFolioPreautorizado = row.createCell(8);
		value(row, cellFolioPreautorizado, 8, cm.getTienePreautorizacion(), style, sheet);

		Cell cellNoFolioPreautorizado = row.createCell(9);
		value(row, cellNoFolioPreautorizado, 9, cm.getFolioPreautorizacion(), style, sheet);

		Cell cellProveedor = row.createCell(10);
		value(row, cellProveedor, 10, cm.getNombreProveedor(), style, sheet);

		Cell cellEstado = row.createCell(11);
		value(row, cellEstado, 11, cm.getEstadoRepublica(), style, sheet);

		Cell cellNivelHospitalario = row.createCell(12);
		value(row, cellNivelHospitalario, 12, cm.getNivelHospitalario(), style, sheet);

		Cell cellFechaIngreso = row.createCell(13);
		value(row, cellFechaIngreso, 13, StringUtil.getFecha(cm.getFechaIngreso()), style, sheet);

		Cell cellHoraIngreso = row.createCell(14);
		value(row, cellHoraIngreso, 14, StringUtil.getHora(cm.getFechaIngreso()), style, sheet);

		Cell cellUrgencias = row.createCell(15);
		value(row, cellUrgencias, 15, cm.getUrgencia(), style, sheet);

		Cell cellHabitacionAsignada = row.createCell(16);
		value(row, cellHabitacionAsignada, 16, cm.getHabitacionAsignada(), style, sheet);

		Cell cellPolizaAsignada = row.createCell(17);
		value(row, cellPolizaAsignada, 17, "no", style, sheet);

		Cell cellRamo = row.createCell(18);
		value(row, cellRamo, 18, cm.getRamo(), style, sheet);

		Cell cellPagadaHasta = row.createCell(19);
		value(row, cellPagadaHasta, 19, cm.getPolizaPagadaHasta(), style, sheet);

		Cell cellInicioVigencia = row.createCell(20);
		value(row, cellInicioVigencia, 20, cm.getInicioVigencia(), style, sheet);

		Cell cellFinVigencia = row.createCell(21);
		value(row, cellFinVigencia, 21, cm.getFinVigencia(), style, sheet);

		Cell cellPolEnProceso = row.createCell(22);
		value(row, cellPolEnProceso, 22, cm.getPolProcesoEmision(), style, sheet);

		Cell cellContratante = row.createCell(23);
		value(row, cellContratante, 23, cm.getNombreContratante(), style, sheet);

		Cell cellRecienNacido = row.createCell(24);
		value(row, cellRecienNacido, 24, cm.getRecienNacido(), style, sheet);

		Cell cellRiesgoApellido1 = row.createCell(25);
		value(row, cellRiesgoApellido1, 25, cm.getApellidoPaternoPaciente(), style, sheet);

		Cell cellRiesgoApellido2 = row.createCell(26);
		value(row, cellRiesgoApellido2, 26, cm.getApellidoMaternoPaciente(), style, sheet);

		Cell cellRiesgoNombre1 = row.createCell(27);
		value(row, cellRiesgoNombre1, 27, cm.getPrimerNombrePaciente(), style, sheet);

		Cell cellRiesgoNombre2 = row.createCell(28);
		value(row, cellRiesgoNombre2, 28, cm.getSegundoNombrePaciente(), style, sheet);

		Cell cellNumRiesgo = row.createCell(29);
		value(row, cellNumRiesgo, 29, cm.getNumeroRiesgo() + "", style, sheet);

		Cell cellRiesgoFechaNacimiento = row.createCell(30);
		value(row, cellRiesgoFechaNacimiento, 30, cm.getFechaNacimientoPaciente(), style, sheet);

		Cell cellRiesgoGenero = row.createCell(31);
		value(row, cellRiesgoGenero, 31, cm.getGeneroPaciente(), style, sheet);

		Cell cellRiesgoTitularPoliza = row.createCell(32);
		value(row, cellRiesgoTitularPoliza, 32, cm.getTitularPoliza(), style, sheet);

		Cell cellMedicoRed = row.createCell(33);
		value(row, cellMedicoRed, 33, cm.getMedicoRed(), style, sheet);

		Cell cellNombreMedicoTratante = row.createCell(34);
		value(row, cellNombreMedicoTratante, 34, cm.getNombreMedico(), style, sheet);

		Cell cellEspecialidadMedico = row.createCell(35);
		value(row, cellEspecialidadMedico, 35, cm.getEspecialidadMedico(), style, sheet);

		Cell cellTipoRedMedico = row.createCell(36);
		value(row, cellTipoRedMedico, 36, cm.getRedProveedor(), style, sheet);

		Cell cellSintomas = row.createCell(37);
		value(row, cellSintomas, 37, cm.getSintomasDiagnostico(), style, sheet);

		Cell cellFamiliarResponsable = row.createCell(38);
		value(row, cellFamiliarResponsable, 38, cm.getFemiliarResponsable(), style, sheet);

		Cell cellTelFamiliar = row.createCell(39);
		value(row, cellTelFamiliar, 39, cm.getTelFamiliarResponsable(), style, sheet);

		Cell cellReportante = row.createCell(40);
		value(row, cellReportante, 40, cm.getNombreReportante(), style, sheet);

		Cell cellTelefonoReportante = row.createCell(41);
		value(row, cellTelefonoReportante, 41, cm.getTelefonoReportante(), style, sheet);

		Cell cellCorreoReportante = row.createCell(42);
		value(row, cellCorreoReportante, 42, cm.getEmailReportante(), style, sheet);

		Cell cellObservacion = row.createCell(43);
		value(row, cellObservacion, 43, cm.getObservacionesIngreso(), style, sheet);

		/* bitacora 44, 45, 46, 49, 50, 51 */

		bitacora(row, cm, style, sheet);

		/* Bitacora */

		Cell cellNivelComplejidad = row.createCell(47);
		value(row, cellNivelComplejidad, 47, cm.getNivelComplejidad(), style, sheet);

		Cell cellUsuarioAsignado = row.createCell(48);
		value(row, cellUsuarioAsignado, 48, cm.getUsuarioAsignado(), style, sheet);
		Cell cellTipoTramite = row.createCell(52);
		value(row, cellTipoTramite, 52, cm.getTipoTramite(), style, sheet);

		Cell cellTipoTramite2 = row.createCell(53);
		value(row, cellTipoTramite2, 53, cm.getTipoTramite(), style, sheet);

		Cell cellTerritorio = row.createCell(54);
		value(row, cellTerritorio, 54, cm.getTerritorioAtencion(), style, sheet);

		Cell cellTipoMoneda = row.createCell(55);
		value(row, cellTipoMoneda, 55, cm.getTipoMoneda(), style, sheet);

		Cell cellFechaPreAlta = row.createCell(56);
		value(row, cellFechaPreAlta, 56, StringUtil.getFecha(cm.getFechaPrealtaHospitalaria()), style, sheet);

		Cell cellHoraPrealta = row.createCell(57);
		value(row, cellHoraPrealta, 57, StringUtil.getHora(cm.getFechaPrealtaHospitalaria()), style, sheet);

		Cell cellFechaEgreso = row.createCell(58);
		value(row, cellFechaEgreso, 58, StringUtil.getFecha(cm.getFechaEgresoHospitalaria()), style, sheet);

		Cell cellHoraEgreso = row.createCell(59);
		value(row, cellHoraEgreso, 59, StringUtil.getHora(cm.getFechaEgresoHospitalaria()), style, sheet);

		Cell cellInsumosRecobros = row.createCell(60);
		value(row, cellInsumosRecobros, 60, cm.getTieneInsumoRecobro(), style, sheet);

		Cell cellImporteEdoCuentaSinDesvios = row.createCell(61);
		value(row, cellImporteEdoCuentaSinDesvios, 61, cm.getImporteEdoCuentaSdesv(), style, sheet);

		Cell cellDesviosEdoCuenta = row.createCell(62);
		value(row, cellDesviosEdoCuenta, 62, cm.getDesviosEdoCuenta(), style, sheet);

		Cell cellBaseIndemnizacion = row.createCell(63);
		value(row, cellBaseIndemnizacion, 63, cm.getBaseIndemnizacion(), style, sheet);

		Cell cellMontoAutHospital = row.createCell(64);
		value(row, cellMontoAutHospital, 64, cm.getMontoAutHospital(), style, sheet);

		Cell cellMontoConIva = row.createCell(65);
		value(row, cellMontoConIva, 65, cm.getMontoConIva(), style, sheet);

		siniestro(row, cm, style, sheet);
		
		Cell cellGastoNoCubierto = row.createCell(178);
		value(row, cellGastoNoCubierto, 178, "no", style, sheet);

		Cell cellCoaseguroMedico = row.createCell(179);
		value(row, cellCoaseguroMedico, 179, cm.getCoaseguroMedico() + "", style, sheet);
		
		Cell cellTotalACargoPaciente = row.createCell(180);
		value(row, cellTotalACargoPaciente, 180, cm.getTotalCargoPaciente(), style, sheet);
		
		
		Cell cellRechazoBases = row.createCell(260);
		value(row, cellRechazoBases  , 260, cm.getBaseRechazo(), style, sheet);
		
		/*262*/
		documento(row, cm, style, sheet);
		
		/*263 - 267*/
		sdaValoracion(row, cm, style, sheet);

	}

	private void sdaValoracion(Row row, CMCentralMedica cm, CellStyleUtil style, Sheet sheet) {
		Pageable limit = PageRequest.of(0, 1, Sort.by("IdSdavaloracion"));
		List<CMSdaValoracion>  listSdaValoracion = sdaRepository.findFirstElementBYIdSolicitud(limit, cm.getIdSolicitud());
	
		
		if(listSdaValoracion.size() > 0) {
			CMSdaValoracion valoracion = listSdaValoracion.get(0);
			
			Cell cell2DaMedico = row.createCell(263);
			value(row, cell2DaMedico  , 263, valoracion.getMedicoTratante(), style, sheet);
			
			Cell cell2DaEspecialidad = row.createCell(264);
			value(row, cell2DaEspecialidad  , 264, valoracion.getEspecialidad(), style, sheet);
			
			Cell cell2DaMontoAuto = row.createCell(265);
			value(row, cell2DaMontoAuto  , 265, valoracion.getMontoAutorizado()+"", style, sheet);
			
			Cell cell2DaTipoPago = row.createCell(266);
			value(row, cell2DaTipoPago  , 266, valoracion.getTipoPago(), style, sheet);
			
			Cell cell2DaTipoPagoReserva = row.createCell(267);
			value(row, cell2DaTipoPagoReserva  , 267, valoracion.getTipoReserva(), style, sheet);
		}
	
	}
	
	private void bitacora(Row row, CMCentralMedica cm, CellStyleUtil style, Sheet sheet) {

		Pageable limit = PageRequest.of(0, 1, Sort.by("idRegProceso"));
		List<CMRegProceso> listProceso = procesoRepository.findFirstElementBYIdSolicitud(limit, cm.getIdSolicitud());
		if (listProceso.size() > 0) {
			Long idProceso = listProceso.get(0).getIdRegProceso();

			CMBitacora bitacora = bitacoraService.findByIdSolicitud(idProceso);
			if (bitacora != null) {
				Cell cellFechaCierreReporte = row.createCell(44);
				value(row, cellFechaCierreReporte, 44, StringUtil.getFecha(bitacora.getFechaFinActividad()), style,
						sheet);

				Cell cellHoraCierreReporte = row.createCell(45);
				value(row, cellHoraCierreReporte, 45, StringUtil.getHora(bitacora.getFechaFinActividad()), style,
						sheet);

				Cell cellUsuarioReporte = row.createCell(46);
				value(row, cellUsuarioReporte, 46, bitacora.getUsuarioEjecutivo(), style, sheet);

				/* bitacora */
				Cell cellFecha1Asignacion = row.createCell(49);
				value(row, cellFecha1Asignacion, 49, StringUtil.getFecha(bitacora.getFechaInicioActividad()), style,
						sheet);

				Cell cellHoraAsignacion = row.createCell(50);
				value(row, cellHoraAsignacion, 50, StringUtil.getHora(bitacora.getFechaInicioActividad()), style,
						sheet);

				Cell cellNombreAsignador = row.createCell(51);
				value(row, cellNombreAsignador, 51, bitacora.getUsuarioEjecutivo(), style, sheet);
				
				Cell cellNombreTramitador = row.createCell(268);
				value(row, cellNombreTramitador , 268, bitacora.getUsuarioEjecutivo(), style, sheet);
				
				Cell cellFechaFinTramite = row.createCell(269);
				value(row, cellFechaFinTramite, 269, StringUtil.getFecha(bitacora.getLastUpdateDate()), style, sheet);
				
				Cell cellHoraFinTramite = row.createCell(270);
				value(row, cellHoraFinTramite, 270, StringUtil.getHora(bitacora.getLastUpdateDate()), style, sheet);
			}
		}
	}
	
	private void documento(Row row, CMCentralMedica cm, CellStyleUtil style, Sheet sheet) {
		Cell cellSolTipoDoc = row.createCell(262);
		value(row, cellSolTipoDoc  ,262, "Documento", style, sheet);
	}

	private void siniestro(Row row, CMCentralMedica cm, CellStyleUtil style, Sheet sheet) {

		long id = cm.getIdSolicitud();
		Pageable paging = PageRequest.of(0, 1, Sort.by("idSiniestro"));
		List<CMSiniestros> list = sinRepository.findFirstElementBYIdSolicitud(paging, id);

		if (list.size() > 0) {
			CMSiniestros sin = list.get(0);
			Cell cellNoSiniestro1 = row.createCell(66);
			value(row, cellNoSiniestro1, 66, sin.getNumeroSiniestro() + "", style, sheet);

			Cell cellEstadoSiniestro1 = row.createCell(67);
			value(row, cellEstadoSiniestro1, 67, sin.getEstado() + "", style, sheet);

			Cell cellTipoSiniestro = row.createCell(68);
			value(row, cellTipoSiniestro, 68, sin.getTipoSiniestro(), style, sheet);

			Cell cellEdoCuenta1 = row.createCell(69);
			value(row, cellEdoCuenta1, 69, sin.getPorcentajeEdoCta() + "", style, sheet);

			Cell cellMontoSiniestro1 = row.createCell(70);
			value(row, cellMontoSiniestro1, 70, sin.getMontoSiniestro() + "", style, sheet);

			Cell cellRamHospSiniestro1 = row.createCell(71);
			value(row, cellRamHospSiniestro1, 71, sin.getFolioRam(), style, sheet);

			Cell cellNoIcd = row.createCell(72);
			value(row, cellNoIcd, 72, sin.getCodDiagnistico(), style, sheet);

			Cell cellDescripcionIcd = row.createCell(73);
			value(row, cellDescripcionIcd, 73, sin.getDescDiagnostico(), style, sheet);

			Cell cellFechaOcurrido = row.createCell(74);
			value(row, cellFechaOcurrido, 74, StringUtil.getFecha(sin.getFechaOcurrencia()), style, sheet);

			Cell cellCausa = row.createCell(75);
			value(row, cellCausa, 75, sin.getCausa(), style, sheet);

			Cell cellConsecuencia = row.createCell(76);
			value(row, cellConsecuencia, 76, sin.getConsecuencia(), style, sheet);

			Cell cellInicioSintomas = row.createCell(77);
			value(row, cellInicioSintomas, 77, sin.getFechaInicioSintomas() + "", style, sheet);

			Cell cellCoberturaAfectada = row.createCell(78);
			value(row, cellCoberturaAfectada, 78, sin.getCoberturaAfectada(), style, sheet);

			Cell cellTipoPago = row.createCell(79);
			value(row, cellTipoPago, 79, sin.getTipoPago(), style, sheet);

			Cell cellTipoReserva = row.createCell(80);
			value(row, cellTipoReserva, 80, sin.getTipoReserva(), style, sheet);

			Cell cellMontoReserva = row.createCell(81);
			value(row, cellMontoReserva, 81, sin.getTipoReserva(), style, sheet);

			cpt(row, sin, style, sheet);// 82 -91

			Cell cellDedContratatdo1 = row.createCell(92);
			value(row, cellDedContratatdo1, 92, sin.getDeducibleContratado() + "", style, sheet);

			Cell cellReduccionDed1 = row.createCell(93);
			value(row, cellReduccionDed1, 93, sin.getReduccionDeducible() + "", style, sheet);

			Cell cellIncrementoDed1 = row.createCell(94);
			value(row, cellIncrementoDed1, 94, sin.getIncrementoDeducible() + "", style, sheet);

			Cell cellTotalDed1 = row.createCell(95);
			value(row, cellTotalDed1, 95, sin.getTotalDeducible() + "", style, sheet);

			Cell cellCoa1HospContratado = row.createCell(96);
			value(row, cellCoa1HospContratado, 96, sin.getCoaseguroContratado() + "", style, sheet);

			Cell cellReduccionCoaaHosp = row.createCell(97);
			value(row, cellReduccionCoaaHosp, 97, sin.getRedCoaSeguroHosp() + "", style, sheet);

			Cell cellIncrementoCoa1Hosp = row.createCell(98);
			value(row, cellIncrementoCoa1Hosp, 98, sin.getIncCoaseguroHosp() + "", style, sheet);

			Cell cellTopeCoa1Hosp = row.createCell(99);
			value(row, cellTopeCoa1Hosp, 99, sin.getTopeCoaseguro() + "", style, sheet);

			Cell cellConTopeCoa1Hosp = row.createCell(100);
			value(row, cellConTopeCoa1Hosp, 100, sin.getTipoTopeCoaseguro(), style, sheet);

			Cell cellSinTopeCoa1Hosp = row.createCell(101);
			value(row, cellSinTopeCoa1Hosp, 101, sin.getTipoTopeCoaseguro(), style, sheet);

			Cell cellTopeAlcanzadoCoa1Hosp = row.createCell(102);
			value(row, cellTopeAlcanzadoCoa1Hosp, 102, sin.getTopeCoaseguro() + "", style, sheet);

			Cell cellTotalCoa1Hosp = row.createCell(103);
			value(row, cellTotalCoa1Hosp, 103, sin.getTotalCoaseguroHosp() + "", style, sheet);

			/* 104 173 */
			honorariosMedicos(row, sin, style, sheet);

			Cell cellTotalHonorarios = row.createCell(174);
			value(row, cellTotalHonorarios, 174, sin.getTotalAutorizadoHm()+"", style, sheet);

			Cell cellCoa1Med = row.createCell(175);
			value(row, cellCoa1Med, 175, sin.getCoaseguroMedico()+"", style, sheet);

			Cell cellRedCoa1 = row.createCell(176);
			value(row, cellRedCoa1, 176, sin.getRedCoaseguroMed() + "", style, sheet);

			Cell cellTotalMedCoa1 = row.createCell(177);
			value(row, cellTotalMedCoa1, 177, sin.getTotalCoaseguroMed() + "", style, sheet);
             /*178, 179, 180 central medica*/

			/* 181 - 230 */
			medicamentos(row, sin, style, sheet);

			Cell cellTotalAutMedicamento = row.createCell(231);
			value(row, cellTotalAutMedicamento, 231, sin.getTotalAutorizadoMed()+"", style, sheet);

			Cell cellFolioRamMedicamento = row.createCell(232);
			value(row, cellFolioRamMedicamento, 232, "no", style, sheet);

			Cell cellDedMedicamento = row.createCell(233);
			value(row, cellDedMedicamento, 233, sin.getDeducibleMedicamentos(), style, sheet);

			Cell cellCoaMedicamento = row.createCell(234);
			value(row, cellCoaMedicamento, 234, sin.getCoaseguroMedicamentos(), style, sheet);

			Cell cellMedicamentoMontoACargoPaciente = row.createCell(235);
			value(row, cellMedicamentoMontoACargoPaciente, 235, "no", style, sheet);
			
			/* 236 - 255 */
			servicios(row, sin, style, sheet);
			
			Cell cellOtrosTotalAutorizado = row.createCell(256);
			value(row, cellOtrosTotalAutorizado , 256, sin.getTotalAutorizadoServ(), style, sheet);
			
			Cell cellOtrosRam = row.createCell(257);
			value(row, cellOtrosRam  , 257, sin.getFolioRamServ(), style, sheet);
			
			Cell cellOtrosDed= row.createCell(258);
			value(row, cellOtrosDed  , 258, sin.getDeducibleServicios(), style, sheet);
			
			Cell cellOtrosCoa = row.createCell(259);
			value(row, cellOtrosCoa  , 259, sin.getCoaseguroServicios(), style, sheet);

			Cell cellOtrosMontoACargpPac = row.createCell(260);
			value(row, cellOtrosMontoACargpPac  , 260, sin.getTotalServicios(), style, sheet);
			
			//261 es central medica
			
		

		}
		
	}
	

	
 /*revisar*/
	private void servicios(Row row, CMSiniestros sin, CellStyleUtil style, Sheet sheet) {
		long id = sin.getIdSiniestro();
		Pageable paging = PageRequest.of(0, 5, Sort.by("idServicio"));
		List<CMServicios> listServicio = servicioRepository.findFirstElementBYIdSiniestro(paging, id);
		int numColumna = 235;
		for (int index = 0; index < listServicio.size(); index++) {
			CMServicios servicio = listServicio.get(index);
			numColumna++;// 236,240
			value(row, numColumna, servicio.getTipoServicio(), style, sheet);
			numColumna++;// 237, 241
			value(row, numColumna, servicio.getRazonSocial(), style, sheet);
			numColumna++;// 238,242
			value(row, numColumna, servicio.getCantidad()+"", style, sheet);
			numColumna++;// 239 243 255
			value(row, numColumna, servicio.getPrecioAutUnidad()+"", style, sheet);
			
		}
	}

	private void medicamentos(Row row, CMSiniestros sin, CellStyleUtil style, Sheet sheet) {
		long id = sin.getIdSiniestro();
		Pageable paging = PageRequest.of(0, 10, Sort.by("idMedicamento"));
		List<CMMedicamentos> listMedicamentos = medicamentoRepository.findFirstElementBYIdSiniestro(paging, id);

		int numColumna = 180;
		for (int index = 0; index < listMedicamentos.size(); index++) {
			CMMedicamentos medi = listMedicamentos.get(index);

			numColumna++;// 181 -186, 191
			value(row, numColumna, medi.getProveedor(), style, sheet);
			numColumna++;// 182 187
			value(row, numColumna, medi.getDescripcionMedicamento(), style, sheet);
			numColumna++;// 183, 188
			value(row, numColumna, medi.getCodigoMedicamento(), style, sheet);
			numColumna++;// 184,189
			value(row, numColumna, medi.getCantidad() + "", style, sheet);
			numColumna++;// 185,190
			value(row, numColumna, medi.getPrecioAutUnidad() + "", style, sheet);

		}

	}

	private void honorariosMedicos(Row row, CMSiniestros sin, CellStyleUtil style, Sheet sheet) {
		long id = sin.getIdSiniestro();
		Pageable paging = PageRequest.of(0, 10, Sort.by("idHonorarioMedico"));
		List<CMHonorariosMed> listHonorarios = hmedRepository.findFirstElementBYIdSiniestro(paging, id);

		// List<CMHonorariosMed> listHonorarios = sin.getListHonorarios();
		int numColumna = 103;

		for (int index = 0; index < listHonorarios.size(); index++) {
			CMHonorariosMed hmed = listHonorarios.get(index);

			numColumna++;// 104, 111
			value(row, numColumna, hmed.getIntegrante(), style, sheet);

			numColumna++;// 105
			value(row, numColumna, hmed.getNombreMedico(), style, sheet);

			numColumna++;// 106
			value(row, numColumna, hmed.getEspecialidad(), style, sheet);

			numColumna++;// 107
			value(row, numColumna, hmed.getMontoAutorizado() + "", style, sheet);

			numColumna++;// 108
			value(row, numColumna, hmed.getFolioRam(), style, sheet);

			numColumna++;// 109
			value(row, numColumna, hmed.getTipoPago(), style, sheet);

			numColumna++;// 110
			value(row, numColumna, hmed.getTipoReserva(), style, sheet);

		}
	}

	private void value(Row row, int index, String value, CellStyleUtil style, Sheet sheet) {
		Cell cell = row.createCell(index);
		Optional<String> opt = Optional.ofNullable(value);
		String values = opt.orElse("");
		cell.setCellValue(values);
		//cell.setCellValue(values.toUpperCase());
		// cell.setCellStyle(style.body());
		sheet.autoSizeColumn(index);
	}

	private void cpt(Row row, CMSiniestros sin, CellStyleUtil style, Sheet sheet) {
		long id = sin.getIdSiniestro();
		Pageable paging = PageRequest.of(0, 5, Sort.by("idCpt"));
		List<CMCpt> listCpt = cptRepository.findFirstElementBYIdSiniestro(paging, id);
		// List<CMCpt> listCpt = sin.getListCpt();

		if (listCpt.size() > 0) {
			for (int index = 0; index < listCpt.size(); index++) {
				CMCpt cpt = listCpt.get(index);
				if (index == 0) {
					Cell cellNoCpt1 = row.createCell(82);
					value(row, cellNoCpt1, 82, cpt.getClaveCpt(), style, sheet);
					Cell cellDescripcionCpt1 = row.createCell(83);
					value(row, cellDescripcionCpt1, 83, cpt.getDescripcionCpt(), style, sheet);
				}
				if (index == 1) {
					Cell cellNoCpt2 = row.createCell(84);
					value(row, cellNoCpt2, 84, cpt.getClaveCpt(), style, sheet);
					Cell cellDescripcionCpt2 = row.createCell(85);
					value(row, cellDescripcionCpt2, 85, cpt.getDescripcionCpt(), style, sheet);
				}
				if (index == 2) {
					Cell cellNoCpt2 = row.createCell(86);
					value(row, cellNoCpt2, 86, cpt.getClaveCpt(), style, sheet);
					Cell cellDescripcionCpt2 = row.createCell(87);
					value(row, cellDescripcionCpt2, 87, cpt.getDescripcionCpt(), style, sheet);
				}
				if (index == 3) {
					Cell cellNoCpt2 = row.createCell(88);
					value(row, cellNoCpt2, 88, cpt.getClaveCpt(), style, sheet);
					Cell cellDescripcionCpt2 = row.createCell(89);
					value(row, cellDescripcionCpt2, 89, cpt.getDescripcionCpt(), style, sheet);
				}
				if (index == 4) {
					Cell cellNoCpt2 = row.createCell(90);
					value(row, cellNoCpt2, 90, cpt.getClaveCpt(), style, sheet);
					Cell cellDescripcionCpt2 = row.createCell(91);
					value(row, cellDescripcionCpt2, 91, cpt.getDescripcionCpt(), style, sheet);
				}

			}
		}


	}

	

	private void value(Row row, Cell cell, int index, String value, CellStyleUtil style, Sheet sheet) {
		Optional<String> opt = Optional.ofNullable(value);
		String values = opt.orElse("");
		cell.setCellValue(values);
		//cell.setCellValue(values.toUpperCase());

		// cell.setCellStyle(style.body());
		sheet.autoSizeColumn(index);
	}

}
