package com.indicador.mapfre.bussine;

import java.util.List;

import org.springframework.stereotype.Service;

import com.indicador.mapfre.model.DateModel;
import com.indicador.mapfre.model.FPRModel;

@Service
public interface ChartFPR {

	List<FPRModel> create(DateModel date);
}
