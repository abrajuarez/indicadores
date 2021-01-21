package com.indicador.mapfre.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.indicador.mapfre.entity.XxmpfBpmIndEmision;;

@Service
public interface FPPTService {

	List<Object []> allByEstatus();
    Integer countBySector(List<Object[]> listEmision, String sector);
    List<String> listSector();
}
