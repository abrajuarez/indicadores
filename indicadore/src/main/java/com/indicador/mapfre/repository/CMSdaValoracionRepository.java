package com.indicador.mapfre.repository;


import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.indicador.mapfre.entity.CMSdaValoracion;

@Repository
public interface CMSdaValoracionRepository extends PagingAndSortingRepository<CMSdaValoracion, Long>{
	
	@Query("SELECT sda FROM CMSdaValoracion  sda WHERE sda.centralMedica.idSolicitud = :id")
	List<CMSdaValoracion> findFirstElementBYIdSolicitud(Pageable limit,@Param("id") Long IdSolicitud);

}
