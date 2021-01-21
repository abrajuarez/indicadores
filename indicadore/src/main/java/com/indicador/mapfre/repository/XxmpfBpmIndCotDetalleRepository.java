package com.indicador.mapfre.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.indicador.mapfre.entity.XxmpfBpmIndCotDetalle;;

@Repository("xxmpfBpmIndCotDetalleRepository")
public interface XxmpfBpmIndCotDetalleRepository extends JpaRepository<XxmpfBpmIndCotDetalle, String >{
	
	//TO_DATE(?1, 'DD/MM/YY') and cot.fechaInicio < TO_DATE(?2, 'DD/MM/YY')

	@Query("SELECT AVG(cot.tiempoDias) FROM XxmpfBpmIndCotDetalle cot where cot.fechaInicio > :dateStart  and cot.fechaInicio < :dateFinish  and cot.area= :area")
	 Integer findAVGTiempoDiasByFechaInicio(@Param("dateStart")LocalDateTime dateStart,@Param("dateFinish")LocalDateTime dateFinish, @Param("area")String area);
	
	@Query("SELECT DISTINCT cot.area FROM XxmpfBpmIndCotDetalle cot where cot.fechaInicio > :dateStart  and cot.fechaInicio < :dateFinish ")
	 List<String> findDistinctAreaByBetween(@Param("dateStart")LocalDateTime dateStart,@Param("dateFinish")LocalDateTime dateFinish );
	
	@Query("SELECT  COUNT(*) FROM XxmpfBpmIndCotDetalle cot where cot.fechaInicio > :dateStart  and cot.fechaInicio < :dateFinish  and cot.area= :area")
	Integer countAreaByFechaInicioBetween(@Param("dateStart")LocalDateTime dateStart,@Param("dateFinish")LocalDateTime dateFinish,@Param("area")String area );
}
