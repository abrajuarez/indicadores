package com.indicador.mapfre.pdf;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.indicador.mapfre.model.ChartBarraPorcentajeModel;
import com.indicador.mapfre.model.DateModel;
import com.indicador.mapfre.util.JFreeChartUtil;
import com.indicador.mapfre.util.PdfUtil;
import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;

@Service
public class NSEPdf {

private static final Logger logger = LogManager.getLogger(NSEPdf.class);
	

	public ByteArrayInputStream create(DateModel datesmodel,List<ChartBarraPorcentajeModel>listGrafica) {
		PdfWriter writer = null;
		Document document = new Document(PageSize.A4, 36, 36, 90, 36);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		
		try {
			writer = PdfWriter.getInstance(document, out);
			document.open();
			PdfUtil.addHeader(writer, "Reporte de Numero de Nivel de servicio de emision", "fecha: "+datesmodel.getDateStart()+" al "+datesmodel.getDateFinish());
			
			BufferedImage bufferedImage = JFreeChartUtil.barChartHorizontalByListChartBarraPorcentajeModel(listGrafica, "Nivel de servicio de emision", "", "").createBufferedImage(500, 300);
			 Image image = Image.getInstance(bufferedImage, null);
			 document.add(image);
			document.close();
		}catch(Exception e) {
			logger.error("Method create error -- "+e);
		}
		
		return new ByteArrayInputStream(out.toByteArray());
	}
	
}
