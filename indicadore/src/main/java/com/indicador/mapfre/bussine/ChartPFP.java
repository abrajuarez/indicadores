package com.indicador.mapfre.bussine;

import java.util.List;

import org.springframework.stereotype.Service;

import com.indicador.mapfre.model.ChartModel;

@Service
public interface ChartPFP {

	public List<ChartModel> chart();
}
