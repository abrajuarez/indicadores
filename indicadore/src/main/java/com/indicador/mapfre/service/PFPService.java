package com.indicador.mapfre.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface PFPService {
	
	public List<Object []> allFoliosPendiente();
	
	public List<String> distinctSector();
	
	public Integer countSector( List<Object[]> listEmision, String sector);
	
}
