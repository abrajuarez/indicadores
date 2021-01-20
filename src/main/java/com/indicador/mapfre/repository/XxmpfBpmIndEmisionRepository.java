package com.indicador.mapfre.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.indicador.mapfre.entity.XxmpfBpmIndEmision;;

@Repository("xxmpfBpmIndEmisionRepository")
public interface XxmpfBpmIndEmisionRepository extends JpaRepository<XxmpfBpmIndEmision, String>{
	
	//TO_DATE(?1, 'DD/MM/YY') and cot.fechaInicio < TO_DATE(?2, 'DD/MM/YY')
	//TO_DATE(:dateStart, 'DD/MM/YY') AND emision.fechaFin < TO_DATE(:dateFinish, 'DD/MM/YY')



	@Query("SELECT DISTINCT emision.estatus FROM XxmpfBpmIndEmision emision WHERE emision.fechaFin > :dateStart AND emision.fechaFin < :dateFinish AND emision.sector = :sector")
	 List<String> distinctStatusByFechaFinAndSector(@Param("dateStart") LocalDateTime dateStart, @Param("dateFinish")  LocalDateTime dateFinish, @Param("sector")  String sector );
	
	
	@Query("SELECT DISTINCT emision.sector FROM XxmpfBpmIndEmision emision WHERE emision.fechaFin > :dateStart AND emision.fechaFin < :dateFinish")
	 List<String> distinctSectorByFechaFin(@Param("dateStart") LocalDateTime dateStart, @Param("dateFinish")  LocalDateTime dateFinish );
	
	@Query("SELECT DISTINCT emision.sector FROM XxmpfBpmIndEmision emision WHERE emision.fechaInicio > :dateStart and emision.fechaInicio < :dateFinish")
	 List<String> distinctSectorByFechaInicio(@Param("dateStart")LocalDateTime dateStart,@Param("dateFinish")LocalDateTime dateFinish );
	
	@Query("SELECT DISTINCT emision.sector FROM XxmpfBpmIndEmision emision")
	 List<String> distinctSector( );
	
	@Query("SELECT emision FROM XxmpfBpmIndEmision emision WHERE emision.fechaFin > :dateStart AND emision.fechaFin < :dateFinish")
	List<XxmpfBpmIndEmision> findAllEmisionByFechaFin(@Param("dateStart") LocalDateTime dateStart, @Param("dateFinish")  LocalDateTime dateFinish);
	
	@Query("SELECT emision FROM XxmpfBpmIndEmision emision, XxmpfBpmIndEmiDetalle detalle WHERE emision.idEmision = detalle.idEmisionFK  AND detalle.area = 'Emisión' AND emision.fechaFin > :dateStart AND emision.fechaFin < :dateFinish")
	List<XxmpfBpmIndEmision> findAllByAreaAndFechaFin(@Param("dateStart") LocalDateTime dateStart, @Param("dateFinish")  LocalDateTime dateFinish);
	
	@Query("SELECT emision FROM XxmpfBpmIndEmision emision, XxmpfBpmIndEmiDetalle detalle WHERE emision.idEmision = detalle.idEmisionFK  AND detalle.area = 'Emisión' AND emision.estatus = 'Emitido' AND detalle.estatus = 'Emitido' AND emision.fechaFin > :dateStart AND emision.fechaFin < :dateFinish")
	List<XxmpfBpmIndEmision> findAllByAreaAndEstatusAndFechaFin(@Param("dateStart") LocalDateTime dateStart, @Param("dateFinish")  LocalDateTime dateFinish);
	
	@Query("SELECT emision FROM XxmpfBpmIndEmision emision, XxmpfBpmIndEmiDetalle detalle WHERE emision.idEmision = detalle.idEmisionFK  AND detalle.area = 'Emisión' AND detalle.actividadATiempo = 1 AND emision.fechaFin > :dateStart AND emision.fechaFin < :dateFinish")
	List<XxmpfBpmIndEmision> findAllByAreaAndFechaFinAndAtiempo(@Param("dateStart") LocalDateTime dateStart, @Param("dateFinish")  LocalDateTime dateFinish);
	
	//@Query(value ="SELECT * FROM xxmpf_Bpm_Ind_Emision  em WHERE em.fecha_Inicio > :dateStart AND em.fecha_Inicio < :dateFinish" , nativeQuery=true)
	@Query("SELECT emision FROM XxmpfBpmIndEmision emision WHERE emision.fechaInicio > :dateStart AND emision.fechaFin < :dateFinish")
	List<XxmpfBpmIndEmision> findAllEmisionByFechaInicio(@Param("dateStart") LocalDateTime dateStart, @Param("dateFinish")  LocalDateTime dateFinish);
	
	//@Query("SELECT emision FROM XxmpfBpmIndEmision emision ,  XxmpfBpmIndEmiDetalle det WHERE emision.idEmision = det.idEmisionFK AND det.area='Emisión'  AND emision.fechaFin < :dateFinish")
	@Query("SELECT emision FROM XxmpfBpmIndEmision emision ,  XxmpfBpmIndEmiDetalle det WHERE emision.idEmision = det.idEmisionFK AND emision.fechaFin >= :dateStart AND emision.fechaFin < :dateFinish AND det.area='Emisión'")
	List<XxmpfBpmIndEmision> findAllByFechaFinAndEstatusEmision(@Param("dateStart") LocalDateTime dateStart, @Param("dateFinish")  LocalDateTime dateFinish);
	
	@Query("SELECT emision FROM XxmpfBpmIndEmision emision, XxmpfBpmIndEmiDetalle detalle WHERE emision.idEmision = detalle.idEmisionFK  AND detalle.area = 'Emisión' AND emision.fechaInicio > :dateStart AND emision.fechaFin < :dateFinish")
	List<XxmpfBpmIndEmision> findAllByAreaAndFechaInicio(@Param("dateStart") LocalDateTime dateStart, @Param("dateFinish")  LocalDateTime dateFinish);
	
	@Query("SELECT emision.fechaInicio FROM XxmpfBpmIndEmision emision")
	List<LocalDateTime> findAllDate();
	
	@Query("SELECT emision.fechaInicio FROM XxmpfBpmIndEmision emision where emision.fechaInicio > :dateStart")
	List<LocalDateTime> findAllDates(@Param("dateStart") LocalDateTime local);
	
}