package com.indicador.mapfre.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.indicador.mapfre.entity.XxmpfBpmIndCotizacion;;

@Repository("xxmpfBpmIndCotizacionRepository")
public interface XxmpfBpmIndCotizacionRepository extends JpaRepository<XxmpfBpmIndCotizacion, String>{


	@Query("SELECT DISTINCT cot.agente FROM XxmpfBpmIndCotizacion cot WHERE cot.fechaInicio > :dateStart and cot.fechaInicio < :dateFinish AND cot.recotizaciones > 0")
	 List<String> distinctAgenteByRecotizacionAndFechaInicio(@Param("dateStart")LocalDateTime dateStart,@Param("dateFinish")LocalDateTime dateFinish);
	
	@Query("SELECT  COUNT(*) FROM XxmpfBpmIndCotizacion cot where cot.fechaInicio > :dateStart and cot.fechaInicio < :dateFinish AND cot.recotizaciones > 0 AND cot.agente = :agente")
	 Integer countRetrabajoRecotizacionAgenteBySectorAndFechaInicio(@Param("dateStart")LocalDateTime dateStart,@Param("dateFinish")LocalDateTime dateFinish,@Param("agente") String agente);
	
	@Query("SELECT DISTINCT cot.agente FROM XxmpfBpmIndCotizacion cot WHERE cot.fechaInicio > :dateStart and cot.fechaInicio < :dateFinish AND cot.devoluciones > 0")
	 List<String> distinctAgenteByDevolucionesAndFechaInicio(@Param("dateStart")LocalDateTime dateStart,@Param("dateFinish")LocalDateTime dateFinish);
	
	@Query("SELECT  COUNT(*) FROM XxmpfBpmIndCotizacion cot where cot.fechaInicio > :dateStart and cot.fechaInicio < :dateFinish AND cot.devoluciones > 0 AND cot.agente = :agente")
	 Integer countRetrabajoDevolucionAgenteBySectorAndFechaInicio(@Param("dateStart")LocalDateTime dateStart,@Param("dateFinish")LocalDateTime dateFinish, @Param("agente")String agente);
	
	@Query("SELECT DISTINCT cot.sector FROM XxmpfBpmIndCotizacion cot WHERE cot.fechaInicio > :dateStart and cot.fechaInicio < :dateFinish AND cot.recotizaciones > 0")
	 List<String> distinctSectorByRecotizacionAndFechaInicio(@Param("dateStart")LocalDateTime dateStart,@Param("dateFinish")LocalDateTime dateFinish);
	
	@Query("SELECT  COUNT(*) FROM XxmpfBpmIndCotizacion cot where cot.fechaInicio > :dateStart and cot.fechaInicio < :dateFinish AND cot.recotizaciones > 0 AND cot.sector = :sector")
	 Integer countRetrabajoRecotizacionBySectorAndFechaInicio(@Param("dateStart")LocalDateTime dateStart,@Param("dateFinish")LocalDateTime dateFinish, @Param("sector")String sector);
	
	@Query("SELECT DISTINCT cot.sector FROM XxmpfBpmIndCotizacion cot WHERE cot.fechaInicio > :dateStart and cot.fechaInicio < :dateFinish AND cot.devoluciones > 0")
	 List<String> distinctSectorByDevolucionesAndFechaInicio(@Param("dateStart")LocalDateTime dateStart,@Param("dateFinish")LocalDateTime dateFinish);
	
	@Query("SELECT  COUNT(*) FROM XxmpfBpmIndCotizacion cot where cot.fechaInicio > :dateStart and cot.fechaInicio < :dateFinish AND cot.devoluciones > 0 AND cot.sector = :sector")
	 Integer countRetrabajoDevolucionBySectorAndFechaInicio(@Param("dateStart")LocalDateTime dateStart,@Param("dateFinish")LocalDateTime dateFinish, @Param("sector")String sector);
	
	@Query("SELECT DISTINCT cot.agente FROM XxmpfBpmIndCotizacion cot WHERE cot.fechaInicio > :dateStart and cot.fechaInicio < :dateFinish AND cot.status = :status")
	 List<String> findDistinctAgenteByFechaInicio(@Param("dateStart")LocalDateTime dateStart,@Param("dateFinish")LocalDateTime dateFinish,@Param("status") String status);
	
	@Query("SELECT  COUNT(*) FROM XxmpfBpmIndCotizacion cot WHERE cot.fechaInicio > :dateStart and cot.fechaInicio < :dateFinish AND cot.status =:status AND cot.agente = :agente")
	Integer countAgenteByFechaInicioBetween(@Param("dateStart")LocalDateTime dateStart,@Param("dateFinish")LocalDateTime dateFinish,@Param("status")String status,@Param("agente") String agente );
	
	@Query("SELECT DISTINCT cot.sector FROM XxmpfBpmIndCotizacion cot WHERE cot.fechaInicio > :dateStart and cot.fechaInicio < :dateFinish AND cot.status =:status")
	 List<String> findDistinctSectorByFechaInicio(@Param("dateStart")LocalDateTime dateStart,@Param("dateFinish")LocalDateTime dateFinish, @Param("status")String status);
	
	@Query("SELECT  COUNT(*) FROM XxmpfBpmIndCotizacion cot WHERE cot.fechaInicio > :dateStart and cot.fechaInicio < :dateFinish AND cot.status = :status AND cot.sector = :sector")
	Integer countSectorByFechaInicioBetween(@Param("dateStart")LocalDateTime dateStart,@Param("dateFinish")LocalDateTime dateFinish,@Param("status")String status,@Param("sector") String sector );
	
	@Query("SELECT DISTINCT cot.motivo FROM XxmpfBpmIndCotizacion cot WHERE cot.fechaInicio > :dateStart and cot.fechaInicio < :dateFinish AND status LIKE :status%")
	 List<String> findDistinctMotivoByFechaInicio(@Param("dateStart")LocalDateTime dateStart,@Param("dateFinish")LocalDateTime dateFinish,@Param("status") String status);
	
	@Query("SELECT  COUNT(*) FROM XxmpfBpmIndCotizacion cot WHERE cot.fechaInicio > :dateStart and cot.fechaInicio < :dateFinish AND cot.motivo = :motivo  AND cot.status LIKE :status%")
	 Integer countMotivosByFechaInicioBetween(@Param("dateStart")LocalDateTime dateStart,@Param("dateFinish")LocalDateTime dateFinish,@Param("motivo")String motivo, @Param("status")String status );
	
	@Query("SELECT  COUNT(*) FROM XxmpfBpmIndCotizacion cot WHERE cot.fechaInicio > :dateStart and cot.fechaInicio < :dateFinish AND cot.status LIKE :status%")
	Integer totalMotivosByFechaInicioBetween(@Param("dateStart")LocalDateTime dateStart,@Param("dateFinish")LocalDateTime dateFinish,@Param("status")String status );
	
	@Query("SELECT DISTINCT status FROM XxmpfBpmIndCotizacion")
	 List<String> findDistinctEstatus();
	
	@Query("SELECT count(*) FROM XxmpfBpmIndCotizacion")
	 Integer countRegistreCotizacion();
	
	
	List<XxmpfBpmIndCotizacion> findAllByStatus(String status);
	
	 Integer countByStatus(String status);
	
	@Query("SELECT DISTINCT cot.status FROM XxmpfBpmIndCotizacion cot where cot.fechaInicio >= :dateStart and cot.fechaInicio <= :dateFinish")
	 List<String> findDistinctEstatusByBetween(@Param("dateStart")LocalDateTime dateStart,@Param("dateFinish")LocalDateTime dateFinish );
	
	@Query("SELECT  COUNT(*) FROM XxmpfBpmIndCotizacion cot where cot.fechaInicio > :dateStart and cot.fechaInicio < :dateFinish and cot.status = :status")
	 Integer countEstatusByFechaInicioBetween(@Param("dateStart")LocalDateTime dateStart,@Param("dateFinish")LocalDateTime dateFinish,@Param("status")String status );
	
	@Query("SELECT  COUNT(*) FROM XxmpfBpmIndCotizacion cot where cot.fechaInicio > :dateStart and cot.fechaInicio < :dateFinish and cot.status is null")
	 Integer countEstatusIsNullFechaInicioBetween(@Param("dateStart")LocalDateTime dateStart,@Param("dateFinish")LocalDateTime dateFinish );
	
	@Query("SELECT  COUNT(*) FROM XxmpfBpmIndCotizacion cot where cot.fechaInicio > :dateStart and cot.fechaInicio < :dateFinish")
	 Integer countEstatusByFechaInicioBetween(@Param("dateStart")LocalDateTime dateStart,@Param("dateFinish")LocalDateTime dateFinish );
	
	@Query("SELECT  COUNT(*) FROM XxmpfBpmIndCotizacion cot where cot.fechaInicio > :dateStart and cot.fechaInicio < :dateFinish and cot.recotizaciones > 0")
	 Integer countRecotizacionByFechaInicioBetween(@Param("dateStart")LocalDateTime dateStart,@Param("dateFinish")LocalDateTime dateFinish);
	
	
	
	@Query("SELECT  COUNT(*) FROM XxmpfBpmIndCotizacion cot where cot.fechaInicio > :dateStart and cot.fechaInicio < :dateFinish  and cot.devoluciones > 0")
	 Integer countDevolucionByFechaInicioBetween(@Param("dateStart")LocalDateTime dateStart,@Param("dateFinish")LocalDateTime dateFinish);
	
	@Query("SELECT cot FROM XxmpfBpmIndCotizacion cot where cot.fechaInicio > :dateStart and cot.fechaInicio < :dateFinish")
	 List<XxmpfBpmIndCotizacion> findAllByFechaInicio(@Param("dateStart")LocalDateTime dateStart,@Param("dateFinish")LocalDateTime dateFinish);
	
	@Query("SELECT AVG(cot.tiempoDias) FROM XxmpfBpmIndCotizacion cot where cot.fechaInicio > :dateStart and cot.fechaInicio < :dateFinish")
	 Integer findAVGTiempoDiasByFechaInicio(@Param("dateStart")LocalDateTime dateStart,@Param("dateFinish")LocalDateTime dateFinish);
	


}