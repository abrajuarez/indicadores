package com.indicador.mapfre.util;

import java.util.List;

import org.springframework.stereotype.Component;

import com.indicador.mapfre.model.ChartModel;
import com.indicador.mapfre.model.CotizacionModel;

@Component
public class ChartUtil {

	/*public List<Object> chart(List<String> listObject){
		
		String status = "";
		for (int i = 0; i < listObject.size(); i++) {

			String statu = listObject.get(i);
			if (statu == null) {
				status = "PENDIENTE";
			} else {

				status = cotizacionUtil.convertEstatus(statu);
			}
			int numEstatus = cotizacion.countRegistreByEstatus(statu);
			String porcentaj = porcentaje.porcentaje(totalRegistres, numEstatus);
			lisCotizacion.add(new CotizacionModel(status, numEstatus, porcentaj));
		}
	}*/
}
