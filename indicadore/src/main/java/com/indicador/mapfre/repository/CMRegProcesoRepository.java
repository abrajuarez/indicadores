package com.indicador.mapfre.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.indicador.mapfre.entity.CMRegProceso;



@Repository
public interface CMRegProcesoRepository extends PagingAndSortingRepository<CMRegProceso, Long>{
	
	@Query("SELECT proceso FROM CMRegProceso  proceso WHERE proceso.idSolicitud = :id")
	List<CMRegProceso> findFirstElementBYIdSolicitud(Pageable limit,@Param("id") Long IdSolicitud);

}
