package com.indicador.mapfre.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.indicador.mapfre.entity.CMCpt;



public interface CMCptRepository extends PagingAndSortingRepository<CMCpt, Long>{

	@Query("SELECT cpt FROM CMCpt  cpt WHERE cpt.siniestro.idSiniestro = :id")
	List<CMCpt> findFirstElementBYIdSiniestro(Pageable limit,@Param("id") Long IdSolicitud);
}
