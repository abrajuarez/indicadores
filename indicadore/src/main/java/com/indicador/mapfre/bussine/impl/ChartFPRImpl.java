package com.indicador.mapfre.bussine.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indicador.mapfre.bussine.ChartFPR;
import com.indicador.mapfre.entity.XxmpfBpmIndEmision;
import com.indicador.mapfre.model.DateModel;
import com.indicador.mapfre.model.FPRModel;
import com.indicador.mapfre.repository.FPRRepository;
import com.indicador.mapfre.service.FPRService;
import com.indicador.mapfre.util.CalendarUtil;
import com.indicador.mapfre.util.StringUtil;

@Service
public class ChartFPRImpl implements ChartFPR {

	private static final Logger logger = LogManager.getLogger(ChartFPRImpl.class);

	private String[] rangoHoras = { "08:00 - 08:59", "09:00 - 09:59", "10:00 - 10:59", "11:00 - 11:59", "12:00 - 12:59",
			"13:00 - 13:59", "14:00 - 14:59", "15:00 - 15:59", "16:00 - 16:59", "17:00 - 18:00", };

	private int[] horario = { 8, 9, 10, 11, 12, 13, 14, 15, 16, 17 };

	@Autowired
	private FPRService fprService;

	@Autowired
	private FPRRepository fPRRepository;
	
	@Autowired
	CalendarUtil calendarUtil;

	@Override
	public List<FPRModel> create(DateModel date) {
		logger.info("method-: create ");
		List<FPRModel> listTable = new ArrayList<FPRModel>();
		List<String> listSectores = fprService.getSectores();
		List<XxmpfBpmIndEmision> listRecibidos = fPRRepository.allFolioRecibidoByFechaInicio(calendarUtil.covertStringToCalendar(date.getDateStart()),
				calendarUtil.covertStringToCalendar(date.getDateFinish()));
		List<XxmpfBpmIndEmision> listAtendidos = fPRRepository.allFolioAtendidoByFechaFin(calendarUtil.covertStringToCalendar(date.getDateStart()),
				calendarUtil.covertStringToCalendar(date.getDateFinish()));
		logger.info("method-: create 2");
		for (int j = 0; j < listSectores.size(); j++) {
			for (int i = 0; i < rangoHoras.length; i++) {
				String sector = listSectores.get(j);
				String hora = rangoHoras[i];
				logger.info("Method: create  hora = " + hora + " sector = " + sector);
				int recibidos = count(listRecibidos, horario[i], sector);
				int atendido = count(listAtendidos, horario[i], sector);
				logger.info("method-: create add [ sector = " + sector + " hora = " + hora + " recibidos = " + recibidos
						+ " atendidos = " + atendido);
				listTable.add(new FPRModel(sector, hora, recibidos, atendido));
				sector = "";
				hora = "";
			}
		}
		return listTable;
	}

	private int count(List<XxmpfBpmIndEmision> folios, int hora, String sector) {
		logger.info("method: count param [ hora = " + hora + ", sector = " + sector);
		Long counts = folios.stream().filter(folio -> StringUtil.getHoraByFecha(folio.getFechaFin()) == hora
				&& folio.getFechaFin() != null && folio.getSector().equals(sector)).count();
		logger.info("method: count return [ hora = "+hora+", count =" + counts +" sector = "+sector);
		return counts.intValue();
	}

}
