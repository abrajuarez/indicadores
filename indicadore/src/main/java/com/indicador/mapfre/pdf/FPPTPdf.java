package com.indicador.mapfre.pdf;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;


import com.indicador.mapfre.model.ChartColumModel;

import com.indicador.mapfre.util.JFreeChartUtil;
import com.indicador.mapfre.util.PdfUtil;
import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;

@Service
public class FPPTPdf {

private static final Logger logger = LogManager.getLogger(NFAPdf.class);
	
	public ByteArrayInputStream create(List<ChartColumModel> listGrafica) {
		PdfWriter writer = null;
		Document document = new Document(PageSize.A4, 36, 36, 90, 36);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		
		try {
			writer = PdfWriter.getInstance(document, out);
			document.open();
			PdfUtil.addHeader(writer, "Reporte de Folios pendientes por tipo de solicitud", "");
			
			BufferedImage bufferedImage = JFreeChartUtil.simpleBarChartHorizontalByListChartColumModel(listGrafica, "Folios pendientes por tipo de solicitud", "", "").createBufferedImage(500, 300);
			 Image image = Image.getInstance(bufferedImage, null);
			 document.add(image);
			document.close();
		}catch(Exception e) {
			logger.error("Method create error -- "+e);
		}
		
		return new ByteArrayInputStream(out.toByteArray());
	}
	
}
