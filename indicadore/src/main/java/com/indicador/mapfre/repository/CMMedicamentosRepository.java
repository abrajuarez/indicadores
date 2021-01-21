package com.indicador.mapfre.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.indicador.mapfre.entity.CMMedicamentos;

@Repository
public interface CMMedicamentosRepository extends PagingAndSortingRepository<CMMedicamentos, Long>{

	@Query("SELECT medi FROM CMMedicamentos  medi WHERE medi.siniestro.idSiniestro = :id")
	List<CMMedicamentos> findFirstElementBYIdSiniestro(Pageable limit,@Param("id") Long IdSolicitud);
}
