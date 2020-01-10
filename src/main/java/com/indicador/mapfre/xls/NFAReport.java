package com.indicador.mapfre.xls;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.indicador.mapfre.model.DateModel;
import com.indicador.mapfre.service.NFAService;
import com.indicador.mapfre.util.StringUtil;

@Service
public class NFAReport {

	@Autowired
	NFAService nfaService;

	private String[] columTitle = { "N�mero de folio", "�	Sector (ramo)", "Tipo de solicitud", "�	Divisional",
			"Regional", "�	Oficina comercial", "�	Agente", "�	Estatus",
			"�	Motivo (en caso de devoluciones y rechazos)", "�	Usuario analista", "�	Usuario emisor",
			"�	Usuario suscriptor", "�Fecha y hora en la que el folio fue atendido" };

	public ByteArrayInputStream create(DateModel dateModel) throws IOException {
		try (Workbook workbook = new HSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
			CreationHelper createHelper = workbook.getCreationHelper();
			createSheetTable(workbook, dateModel);
			workbook.write(out);
			return new ByteArrayInputStream(out.toByteArray());
		}
	}

	private void createSheetTable(Workbook workbook, DateModel dateModel) {
		Sheet sheet = workbook.createSheet("Folios");
		Font fontBlues = fontBlue(workbook);
		CellStyle cellStyle = cellStyleTitles(workbook, fontBlues);
		createDate(sheet, dateModel);

		// Row for Header
		Row headerRow = sheet.createRow(3);
		for (int col = 0; col < columTitle.length; col++) {
			Cell cell = headerRow.createCell(col);

			cell.setCellValue(columTitle[col]);
			cell.setCellStyle(cellStyle);
			sheet.autoSizeColumn(col);
		}
		createRegistre(workbook, sheet, dateModel);
	}

	private void createRegistre(Workbook workbook, Sheet sheet, DateModel dateModel) {
		List<Object[]> results = nfaService.allEmisionAndDetalleByFechaFin(dateModel.getDateStart(),
				dateModel.getDateFinish());
		Font fontBlues = fontBlue(workbook);
		CellStyle cellStyle = cellStyle(workbook, fontBlues);
		int rowId = 4;
		
		for (Object[] emision : results) {
			Row row = sheet.createRow(rowId++);
			valueColumns(row, emision, cellStyle); 	
			autoSizeColumns(sheet);
		}
	}
	
	private void valueColumns(Row row, Object[]results, CellStyle cellStyle) {
		for (int i = 0; i < results.length; i++) {
			Cell cellFecha = row.createCell(i);
			cellFecha.setCellValue(StringUtil.containNull(results[i] + ""));
			cellFecha.setCellStyle(cellStyle);
		}
	}
	
	private void autoSizeColumns(Sheet sheet) {
		for (int i = 0; i < columTitle.length; i++) {
			sheet.autoSizeColumn(i);
		}
	}

	private void createDate(Sheet sheet, DateModel dateModel) {

		Row rowFechaInicio = sheet.createRow(0);
		Cell cell = rowFechaInicio.createCell(0);
		cell.setCellValue("Fecha Inicio:");
		Cell celldateStart = rowFechaInicio.createCell(1);
		celldateStart.setCellValue(dateModel.getDateStart());

		Row rowFechaFin = sheet.createRow(1);
		Cell cellFechaFin = rowFechaFin.createCell(0);
		cellFechaFin.setCellValue("Fecha Final:");
		Cell celldateFinish = rowFechaFin.createCell(1);
		celldateFinish.setCellValue(dateModel.getDateFinish());
	}

	private CellStyle cellStyleTitles(Workbook workbook, Font font) {
		CellStyle cell = cellStyle(workbook, font);
		cell.setFillBackgroundColor((short) 12);
		cell.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		Font headerFont = workbook.createFont();
		headerFont.setBold(true);
		headerFont.setColor(IndexedColors.WHITE.getIndex());
		cell.setFont(headerFont);
		return cell;
	}

	private CellStyle cellStyle(Workbook workbook, Font font) {
		CellStyle headerCellStyle = workbook.createCellStyle();
		headerCellStyle.setFont(font);
		headerCellStyle.setAlignment(HorizontalAlignment.JUSTIFY);
		headerCellStyle.setBorderBottom(BorderStyle.THIN);
		headerCellStyle.setBorderLeft(BorderStyle.THIN);
		headerCellStyle.setBorderRight(BorderStyle.THIN);
		headerCellStyle.setBorderTop(BorderStyle.THIN);
		return headerCellStyle;
	}

	private Font fontBlue(Workbook workbook) {
		Font headerFont = workbook.createFont();
		headerFont.setBold(true);
		headerFont.setColor(IndexedColors.BLACK.getIndex());
		return headerFont;
	}
}
