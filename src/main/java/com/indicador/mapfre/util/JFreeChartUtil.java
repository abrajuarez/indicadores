package com.indicador.mapfre.util;

import java.math.BigDecimal;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import com.indicador.mapfre.model.ChartBarraModel;
import com.indicador.mapfre.model.ChartBarraPorcentajeModel;
import com.indicador.mapfre.model.ChartColumModel;
import com.indicador.mapfre.model.ChartCombinationModel;
import com.indicador.mapfre.model.ChartModel;
import com.indicador.mapfre.model.DateModel;
import com.indicador.mapfre.pdf.NSEPdf;

public class JFreeChartUtil {
	
	private static final Logger logger = LogManager.getLogger(JFreeChartUtil.class);
	
	public  static  JFreeChart verticalBarChartByListChartCombinationModel(List<ChartCombinationModel> listGrafica, String title,String CategoriesAxis,String valueAxis) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		logger.info("Method: verticalBarChartByListChartCombinationModel size = "+listGrafica.size());
		   for(int i = 0; i<listGrafica.size(); i++) {
			   List<String>listCategoria = listGrafica.get(i).getCategories();
			   List<Integer>listData =listGrafica.get(i).getData();
			   logger.info("Method: verticalBarChartByListChartCombinationModel listdata size = "+listData.size()+"categoriesm size = "+listCategoria.size()+", name= "+listGrafica.get(i).getName()+", type= "+listGrafica.get(i).getType());
			   for(int j = 0; j < listCategoria.size(); j++) {
				   dataset.setValue(listData.get(j),listCategoria.get(j),"");
				   logger.info("Method: verticalBarChartByListChartCombinationModel add [data = "+listData.get(j)+", categoria = "+listCategoria.get(j));
			    }
		    }
		      
		    return generateBarChartVertical(dataset, title,CategoriesAxis,valueAxis);
		
	}
	public  static  JFreeChart simpleBarChartByListChartColumModel(List<ChartColumModel> listGrafica, String title,String CategoriesAxis,String valueAxis) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		   for(int i = 0; i<listGrafica.size(); i++) {
			   List<String>listCategoria = listGrafica.get(i).getCategorias();
			   List<Integer>listData =listGrafica.get(i).getData();
			   for(int j = 0; j < listCategoria.size(); j++) {
				   dataset.setValue(listData.get(j),listCategoria.get(j),"");
			    }
		    }
		    
		    return generateBarChartVertical(dataset, title,CategoriesAxis,valueAxis);
		
	}
	
	public  static  JFreeChart generateBarChartVertical(CategoryDataset dataSet, String title,String CategoriesAxis,String valueAxis) {
		return ChartFactory.createBarChart(title,
				                           CategoriesAxis,
				                           valueAxis, 
				                           dataSet,
				                           PlotOrientation.VERTICAL,
				                           true, true, false);
		
	}
	
	public static  JFreeChart simplePieChartByListChartModel(List<ChartModel> listGrafica,String title) {
		DefaultPieDataset dataSet = new DefaultPieDataset();
		
		for(ChartModel grafica: listGrafica) {
			logger.info("Method simplePieChartByListChartModel add[ name ="+grafica.getName()+", y= "+grafica.getY()+"]");
			dataSet.setValue(grafica.getName(), grafica.getY());
		}
		return generatePieChart(dataSet, title);
	}
	

	public  static  JFreeChart generatePieChart(DefaultPieDataset dataSet, String title) {
		return ChartFactory.createPieChart(title, dataSet, true, true, false);
	}
	
	
	public static JFreeChart barChartHorizontalByChartBarraPorcentajeModel(ChartBarraPorcentajeModel grafica, String title,String CategoriesAxis,String valueAxis) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		List<String> categoria =grafica.getCategoria();
		List<BigDecimal> data = grafica.getData();
	    for(int j = 0; j<categoria.size(); j++) {
	    	
	    	dataset.addValue(data.get(j),categoria.get(j),"");
	    }
	    return generateBarChartHorizontal(dataset, title,CategoriesAxis,valueAxis);
	}
	    
	public static JFreeChart barChartHorizontalByListChartBarraPorcentajeModel(List<ChartBarraPorcentajeModel> listGrafica, String title,String CategoriesAxis,String valueAxis) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		
	    for(int j = 0; j<listGrafica.size(); j++) {
	    	List<BigDecimal>listData = listGrafica.get(j).getData();
	    	List<String>listCategoria =listGrafica.get(j).getCategoria();
	    	for(int i = 0; i<listData.size(); i++) {
	    		logger.info("Method barChartHorizontalByListChartBarraPorcentajeModel add[ data ="+listData.get(i)+", name = "+listGrafica.get(j).getName()+",categoria = "+listCategoria.get(i)+"]");
	    		dataset.addValue(listData.get(i),listGrafica.get(j).getName(),listCategoria.get(i));
	    	}
	    	//dataset.addValue(listGrafica.get(i).getData()[0],listGrafica.get(i).getName(),"");
	    }
	    
	    return generateBarChartHorizontal(dataset, title,CategoriesAxis,valueAxis);
	}
	
	public static JFreeChart simpleBarChartHorizontalByListChartColumModel(List<ChartColumModel> listGrafica, String title,String CategoriesAxis,String valueAxis) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		   for(int i = 0; i<listGrafica.size(); i++) {
			   List<String>listCategoria = listGrafica.get(i).getCategorias();
			   List<Integer>listData =listGrafica.get(i).getData();
			   for(int j = 0; j < listCategoria.size(); j++) {
				   dataset.setValue(listData.get(j),listCategoria.get(j),"");
			    }
		    }
	    
	    return generateBarChartHorizontal(dataset, title,CategoriesAxis,valueAxis);
	}
	
	public static JFreeChart simpleBarChartHorizontalByChartBarraModel(List<ChartBarraModel> listGrafica, String title,String CategoriesAxis,String valueAxis) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		
	    for(int i = 0; i<listGrafica.size(); i++) {
	    	logger.info("Method simpleBarChartHorizontalByChartBarraModel add[ data ="+listGrafica.get(i).getData()[0]+", name ="+listGrafica.get(i).getName());
	    	dataset.addValue(listGrafica.get(i).getData()[0],listGrafica.get(i).getName(),"");
	    }
	    
	    return generateBarChartHorizontal(dataset, title,CategoriesAxis,valueAxis);
	}
	
	public  static  JFreeChart generateBarChartHorizontal(CategoryDataset dataSet, String title,String CategoriesAxis,String valueAxis) {
		return ChartFactory.createBarChart(title,
				                           CategoriesAxis,
				                           valueAxis, 
				                           dataSet,
				                           PlotOrientation.HORIZONTAL,
				                           true, true, false);
		
	}
	
}
