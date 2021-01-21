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
	
	@Query("SELECT bita FROM CMBitacora  bita, CMRegProceso proceso WHERE bita.regProceso.idRegProceso = proceso.idRegProceso AND proceso.idSolicitud = :idSolicitud  AND bita.nombreActividad = :actividad")
	List<CMBitacora> findFirstElementBYIdRegProcesoAndNombreActividad(@Param("idSolicitud") Long idSolicitud,Pageable limit,@Param("actividad")String actividad);
	
	@Query("SELECT bita FROM CMBitacora  bita, CMRegProceso proceso WHERE bita.regProceso.idRegProceso = proceso.idRegProceso AND proceso.idSolicitud = :idSolicitud  AND bita.nombreActividad = :actividad ORDER BY bita.idBitacora desc")
	List<CMBitacora> findLastElementBYIdRegProcesoAndNombreActividad(@Param("idSolicitud") Long idSolicitud, @Param("actividad")String actividad);

	
}
