package com.indicador.mapfre.pdf;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.indicador.mapfre.model.ChartBarraPorcentajeModel;
import com.indicador.mapfre.util.JFreeChartUtil;
import com.indicador.mapfre.util.PdfUtil;
import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;

@Service
public class TPEPdf {

private static final Logger logger = LogManager.getLogger(TPEPdf.class);
	
	public ByteArrayInputStream create(ChartBarraPorcentajeModel listGrafica) {
		PdfWriter writer = null;
		Document document = new Document(PageSize.A4, 36, 36, 90, 36);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		
		try {
			writer = PdfWriter.getInstance(document, out);
			document.open();
			PdfUtil.addHeader(writer, "Reporte de Tiempo promedio realizado por los emisores", " ");
			
			BufferedImage bufferedImage = JFreeChartUtil.barChartHorizontalByChartBarraPorcentajeModel(listGrafica, "Tiempo promedio realizado por los emisores", "", "").createBufferedImage(500, 300);
			 Image image = Image.getInstance(bufferedImage, null);
			 document.add(image);
			document.close();
		}catch(Exception e) {
			logger.error("Method create error -- "+e);
		}
		
		return new ByteArrayInputStream(out.toByteArray());
	}
	
}
