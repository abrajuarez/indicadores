package com.indicador.mapfre.bussine;

import java.util.List;

import org.springframework.stereotype.Service;

import com.indicador.mapfre.model.ChartBarraPorcentajeModel;

@Service
public interface ChartTPM {

	List<ChartBarraPorcentajeModel> create();
}
