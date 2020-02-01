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
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.indicador.mapfre.model.CMCentralMedicaModel;
import com.indicador.mapfre.model.DateModel;
import com.indicador.mapfre.service.CMCentralMedicaService;
import com.indicador.mapfre.util.CMReportUtil;
import com.indicador.mapfre.util.xls.CellStyleUtil;


@Component
public class CMCentralMedicaReport {
	

	private static final Logger logger = LogManager.getLogger(CMCentralMedicaReport.class);
	
	@Autowired
	private CMCentralMedicaService cmservice;

	
	public ByteArrayInputStream create(DateModel datesmodel) throws IOException {
		logger.info("methods create ");
		try (
				//Con esta version se puede xlsx
				Workbook workbook = WorkbookFactory.create(true);
				
				//Workbook workbook = new HSSFWorkbook();
				ByteArrayOutputStream out = new ByteArrayOutputStream();) {
			
			createSheetOne(workbook, datesmodel);
			workbook.write(out);
			return new ByteArrayInputStream(out.toByteArray());
		}
	}
	
	private void createSheetOne(Workbook workbook, DateModel datesmodel) {
		logger.info("methods createSheetOne ");
		Sheet sheet = workbook.createSheet("FP (Folios pendientes)");
		//XSSFSheet sheets = workbook.createSheet("FP (Folios pendientes)");
		CellStyleUtil style = new CellStyleUtil(workbook);
		cellTitle(sheet, style);
		//cellBody(sheet, style, list);
	}
	
	private void cellTitle(Sheet sheet, CellStyleUtil style) {
		logger.info("methods cellTitle ");
		Row headerRow = sheet.createRow(3);
		List<String > title = CMReportUtil.title();
		logger.info("methods cellTitle numColumnas = "+title.size());
		for (int col = 0; col < title.size(); col++) {
			logger.info("methods cellTitle columnas = "+col);
			Cell cell = headerRow.createCell(col);
			cell.setCellValue(title.get(col));
			cell.setCellStyle(style.title());
			sheet.autoSizeColumn(col);
		}
	}
	
	/*private void cellBody(Sheet sheet, CellStyleUtil style, List<Object[]> results) {
		logger.info("methos cellBody ");
		
		logger.info("methos cellBody estatus = "+results.size());
		int rowId = 4;
		for (Object[] emision : results) {
			Row row = sheet.createRow(rowId++);
			valueColumns(row, emision, style); 	
			autoSizeColumns(sheet);
		}
	}*/

}
