package com.indicador.mapfre.xls;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indicador.mapfre.entity.XxmpfBpmIndEmision;
import com.indicador.mapfre.model.DateModel;
import com.indicador.mapfre.repository.FPRRepository;
import com.indicador.mapfre.service.FPRService;
import com.indicador.mapfre.util.StringUtil;
import com.indicador.mapfre.util.xls.CellStyleUtil;

@Service
public class FPRReport {

	private static final Logger logger = LogManager.getLogger(FPRReport.class);

	private String[] columTitle = { "SECTOR", "RANGO DE HORARIO", "FOLIOS RECIBIDOS", "FOLIOS ATENDIDOS" };

	private String[] rangoHoras = { "08:00 - 08:59", "09:00 - 09:59", "10:00 - 10:59", "11:00 - 11:59", "12:00 - 12:59",
			"13:00 - 13:59", "14:00 - 14:59", "15:00 - 15:59", "16:00 - 16:59", "17:00 - 18:00", };

	private int[] horario = { 8, 9, 10, 11, 12, 13, 14, 15, 16, 17 };

	private String[] title = { "  FECHA  ", "  SECTOR  ", " HORA ", "FOLIO RECIBIDO" };

	@Autowired
	private FPRService fprService;

	@Autowired
	private FPRRepository fPRRepository;

	public ByteArrayInputStream create(DateModel datesmodel) throws IOException {
		try (Workbook workbook = new HSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {

			List<String> listSectores = fprService.getSectores();
			List<XxmpfBpmIndEmision> listRecibidos = fPRRepository
					.allFolioRecibidoByFechaInicio(datesmodel.getDateStart(), datesmodel.getDateFinish());
			List<XxmpfBpmIndEmision> listAtendidos = fPRRepository.allFolioAtendidoByFechaFin(datesmodel.getDateStart(),
					datesmodel.getDateFinish());
			CellStyleUtil style = new CellStyleUtil(workbook);
			createSheetOne(workbook, style, listSectores, listRecibidos, listAtendidos);
			createSheetRecibidos(workbook, style, "Detalle de Folios Recibidos", listRecibidos);
			createSheetRecibidos(workbook,style,"Detalle de Folios Atendidos ", listAtendidos);
			workbook.write(out);
			return new ByteArrayInputStream(out.toByteArray());
		}
	}

	private void createSheetRecibidos(Workbook workbook, CellStyleUtil style, String nameSheet,
			List<XxmpfBpmIndEmision> listRecibidos) {
		Sheet sheet = workbook.createSheet(nameSheet);
		int rowId = 4;
		cellRecibidoAndAtendido(sheet, style);
		for (int i = 0; i < listRecibidos.size(); i++) {
			Row row = sheet.createRow(rowId++);
			XxmpfBpmIndEmision emision = listRecibidos.get(i);
			valueColumns(row, emision, style);
			// autoSizeColumns(sheet);
		}
	}

	private void valueColumns(Row row, XxmpfBpmIndEmision results, CellStyleUtil style) {
		Cell cellFecha = row.createCell(0);
		cellFecha.setCellValue(StringUtil.getFecha(results.getFechaFin()));
		
		Cell cellSector = row.createCell(1);
		cellSector.setCellValue(results.getSector());
		
		Cell cellHora = row.createCell(2);
        cellHora.setCellValue(StringUtil.getHora(results.getFechaFin()));
		cellHora.setCellStyle(style.body());
		
		Cell cellFolio = row.createCell(3);
		cellFolio.setCellValue(results.getFolio());
		

	}

	private void cellRecibidoAndAtendido(Sheet sheet, CellStyleUtil style) {
		Row headerRow = sheet.createRow(3);
		for (int col = 0; col < title.length; col++) {
			Cell cell = headerRow.createCell(col);
			cell.setCellValue(title[col]);
			cell.setCellStyle(style.title());
			sheet.autoSizeColumn(col);
		}
	}

	private void createSheetOne(Workbook workbook, CellStyleUtil style, List<String> listSectores,
			List<XxmpfBpmIndEmision> listRecibidos, List<XxmpfBpmIndEmision> listAtendidos) {
		Sheet sheet = workbook.createSheet("FPR (Folios atendidos y recibidos)");
		cellTitle(sheet, style);
		cellBody(sheet, style, listSectores, listRecibidos, listAtendidos);
	}

	private void cellBody(Sheet sheet, CellStyleUtil style, List<String> listSectores,
			List<XxmpfBpmIndEmision> listRecibidos, List<XxmpfBpmIndEmision> listAtendidos) {
		for (int j = 0; j < listSectores.size(); j++) {
			String sector = listSectores.get(j);
			int numRow = rangoHoras.length * j;
			valueColumns(sheet, style, sector, listRecibidos, listAtendidos, numRow);
			// autoSizeColumns(sheet);
		}
	}

	private void valueColumns(Sheet sheet, CellStyleUtil style, String sector, List<XxmpfBpmIndEmision> listRecibidos,
			List<XxmpfBpmIndEmision> listAtendidos, int numRow) {
		int rowId = 4 + numRow;
		for (int i = 0; i < rangoHoras.length; i++) {
			Row row = sheet.createRow(rowId++);
			Cell cellSector = row.createCell(0);
			cellSector.setCellValue(sector);
			cellSector.setCellStyle(style.body());

			String hora = rangoHoras[i];
			Cell cellHora = row.createCell(1);
			cellHora.setCellValue(hora);
			cellHora.setCellStyle(style.body());

			Cell cellRecibido = row.createCell(2);
			cellRecibido.setCellValue(count(listRecibidos, horario[i], sector) + "");
			cellRecibido.setCellStyle(style.body());

			Cell cellAtendido = row.createCell(3);
			cellAtendido.setCellValue(count(listAtendidos, horario[i], sector) + "");
			cellAtendido.setCellStyle(style.body());
		}
	}

	private int count(List<XxmpfBpmIndEmision> folios, int hora, String sector) {
		logger.info("method: count param [ hora = " + hora + ", sector = " + sector);
		Long counts = folios.stream().filter(folio -> StringUtil.getHoraByFecha(folio.getFechaFin()) == hora
				&& folio.getFechaFin() != null && folio.getSector().equals(sector)).count();
		logger.info("method: count return [ hora = " + hora + ", count =" + counts + " sector = " + sector);
		return counts.intValue();
	}

	private void cellTitle(Sheet sheet, CellStyleUtil style) {
		Row headerRow = sheet.createRow(3);
		for (int col = 0; col < columTitle.length; col++) {
			Cell cell = headerRow.createCell(col);
			cell.setCellValue(columTitle[col]);
			cell.setCellStyle(style.title());
			sheet.autoSizeColumn(col);
		}
	}
}
