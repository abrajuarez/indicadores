package com.indicador.mapfre.bussine;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import com.indicador.mapfre.model.CotizacionModel;

public interface CreateXls {

	public ByteArrayInputStream  create(List<CotizacionModel> cotizacion)throws IOException;
}
