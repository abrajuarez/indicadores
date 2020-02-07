package com.indicador.mapfre.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.indicador.mapfre.entity.CMBitacora;



@Repository
public interface CMBitacoraRepository extends PagingAndSortingRepository<CMBitacora, Long>{
	
	@Query("SELECT bita FROM CMBitacora  bita WHERE bita.regProceso.idRegProceso = :id")
	List<CMBitacora> findFirstElementBYIdRegProceso(Pageable limit,@Param("id") Long IdRegProceso);

}
