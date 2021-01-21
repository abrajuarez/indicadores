package com.indicador.mapfre.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.indicador.mapfre.entity.CMSiniestros;

@Repository
public interface CMSiniestrosRepository extends PagingAndSortingRepository<CMSiniestros, Long>{

	@Query("SELECT sin FROM CMSiniestros  sin WHERE sin.centralMedica.idSolicitud = :id")
	List<CMSiniestros> findFirstElementBYIdSolicitud(Pageable limit,@Param("id") Long IdSolicitud);
	
	//List<X> xValues = xRepository.findFirstElement(new PageRequest(0, 1));
}
