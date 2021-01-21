package com.indicador.mapfre.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.indicador.mapfre.entity.CMHonorariosMed;

public interface CMHonorariosMedRepository extends PagingAndSortingRepository<CMHonorariosMed, Long>{
	
	@Query("SELECT hmed FROM CMHonorariosMed  hmed WHERE hmed.siniestro.idSiniestro = :id")
	List<CMHonorariosMed> findFirstElementBYIdSiniestro(Pageable limit,@Param("id") Long IdSolicitud);

}
