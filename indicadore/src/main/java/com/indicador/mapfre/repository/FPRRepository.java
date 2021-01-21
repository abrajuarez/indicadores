package com.indicador.mapfre.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.indicador.mapfre.entity.XxmpfBpmIndEmision;

@Repository
public interface FPRRepository extends JpaRepository<XxmpfBpmIndEmision, String>{
                                                                                                                                                                  //TO_DATE(?1, 'DD/MM/YY') and cot.fechaInicio < TO_DATE(?2, 'DD/MM/YY')

	@Query("SELECT emision FROM XxmpfBpmIndEmision emision INNER JOIN XxmpfBpmIndEmiDetalle detalle ON emision.idEmision = detalle.idEmisionFK WHERE detalle.area = 'Emisión' AND  emision.estatus != 'En Procesos' AND detalle.estatus != 'En Proceso' AND emision.fechaInicio > :dateStart  AND emision.fechaInicio < :dateFinish")
	List<XxmpfBpmIndEmision> allFolioRecibidoByFechaInicio(@Param("dateStart") LocalDateTime dateStart, @Param("dateFinish")  LocalDateTime dateFinish);

	@Query("SELECT emision FROM XxmpfBpmIndEmision emision INNER JOIN XxmpfBpmIndEmiDetalle detalle ON emision.idEmision = detalle.idEmisionFK WHERE detalle.area = 'Emisión' AND  emision.estatus != 'En Procesos' AND detalle.estatus != 'En Proceso' AND emision.fechaFin > :dateStart AND emision.fechaFin < :dateFinish")
	List<XxmpfBpmIndEmision> allFolioAtendidoByFechaFin(@Param("dateStart") LocalDateTime dateStart, @Param("dateFinish")  LocalDateTime dateFinish);
}

