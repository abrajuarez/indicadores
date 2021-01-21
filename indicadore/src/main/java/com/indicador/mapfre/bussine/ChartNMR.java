package com.indicador.mapfre.bussine;

import java.util.List;

import org.springframework.stereotype.Service;

import com.indicador.mapfre.model.ChartColumModel;
import com.indicador.mapfre.model.DateModel;

@Service
public interface ChartNMR {

	List<ChartColumModel>chart(DateModel date);
	
}
