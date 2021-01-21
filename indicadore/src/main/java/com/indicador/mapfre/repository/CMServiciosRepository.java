package com.indicador.mapfre.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.indicador.mapfre.entity.CMServicios;

@Repository
public interface CMServiciosRepository extends PagingAndSortingRepository<CMServicios, Long>{
	
	@Query("SELECT servicio FROM CMServicios  servicio WHERE servicio.siniestro.idSiniestro = :id")
	List<CMServicios> findFirstElementBYIdSiniestro(Pageable limit,@Param("id") Long IdSolicitud);

}
