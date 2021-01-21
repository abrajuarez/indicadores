package com.indicador.mapfre.bussine;

import org.springframework.stereotype.Service;

import com.indicador.mapfre.model.ChartBarraPorcentajeModel;

@Service
public interface ChartTPE {

	ChartBarraPorcentajeModel create();
}
