package com.indicador.mapfre.bussine;

import java.util.List;

import org.springframework.stereotype.Service;

import com.indicador.mapfre.model.ChartColumModel;

@Service
public interface ChartFPPT {

	List<ChartColumModel>create();
}
