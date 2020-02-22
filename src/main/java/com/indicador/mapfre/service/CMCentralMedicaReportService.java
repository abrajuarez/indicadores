package com.indicador.mapfre.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.indicador.mapfre.model.ReportCentralMedicaModel;

@Service

public interface CMCentralMedicaReportService {

	List<ReportCentralMedicaModel> findByCreationDate(String fechaInicial, String fechaFinal);
}
